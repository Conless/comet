package dev.conless.comet.middleend.optimize;

import dev.conless.comet.utils.container.Map;
import dev.conless.comet.utils.container.Set;

import dev.conless.comet.frontend.ir.entity.IREntity;
import dev.conless.comet.frontend.ir.entity.IRLiteral;
import dev.conless.comet.frontend.ir.entity.IRVariable;
import dev.conless.comet.frontend.ir.node.IRRoot;
import dev.conless.comet.frontend.ir.node.def.IRFuncDefNode;
import dev.conless.comet.frontend.ir.node.inst.IRAllocaNode;
import dev.conless.comet.frontend.ir.node.inst.IRInstNode;
import dev.conless.comet.frontend.ir.node.inst.IRLoadNode;
import dev.conless.comet.frontend.ir.node.inst.IRPhiNode;
import dev.conless.comet.frontend.ir.node.inst.IRReturnNode;
import dev.conless.comet.frontend.ir.node.inst.IRStoreNode;
import dev.conless.comet.frontend.ir.node.stmt.IRBlockStmtNode;
import dev.conless.comet.frontend.ir.node.stmt.IRStmtNode;
import dev.conless.comet.frontend.ir.type.IRType;
import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.container.Map;
import dev.conless.comet.utils.container.Pair;
import dev.conless.comet.utils.container.Set;
import dev.conless.comet.utils.error.RuntimeError;

public class Mem2Reg {
  public void visit(IRRoot node) {
    for (var func : node.getFuncs()) {
      visit(func);
    }
  }

  void visit(IRFuncDefNode node) {
    calcRpo(node.getBody().get(0));
    buildDomTree(node);
    insertPhi(node);
    rename(node);
  }

  Set<IRBlockStmtNode> visited = new Set<>();
  Map<IRBlockStmtNode, Integer> block2order = new Map<>();
  Array<IRBlockStmtNode> order = new Array<>();

  void calcRpo(IRBlockStmtNode block) {
    visited.add(block);
    for (var succ : block.getSuccessors()) {
      if (!visited.contains(succ)) {
        calcRpo(succ);
      }
    }
    block2order.put(block, order.size());
    order.add(0, block);
  }

  void buildDomTree(IRFuncDefNode func) {
    boolean changed = true;
    var entryBlock = func.getBody().get(0);
    entryBlock.setIdom(entryBlock);
    while (changed) {
      changed = false;
      for (var block : order) {
        if (block == entryBlock) {
          continue;
        }
        changed |= calcIdom(block);
      }
    }

    // for (var block : func.getBody()) {
    //   System.out.println(block.getLabelName() + " " + block.getIdom().getLabelName());
    // }

    for (var block : func.getBody()) {
      if (block.getIdom() != block) {
        block.getIdom().getChildren().add(block);
      }
      calcDf(block);
    }

    // for (var block : func.getBody()) {
    //   var str = block.getLabelName() + ":";
    //   for (var df : block.getDf()) {
    //     str += " " + df.getLabelName();
    //   }
    //   System.out.println(str);
    // }
  }

  boolean calcIdom(IRBlockStmtNode block) {
    IRBlockStmtNode newIdom = null;
    for (var pred : block.getPredecessors()) {
      if (newIdom == null) {
        newIdom = pred;
      } else if (pred.getIdom() != null) {
        newIdom = intersect(pred, newIdom);
      }
    }
    if (newIdom != block.getIdom()) {
      block.setIdom(newIdom);
      return true;
    }
    return false;
  }

  void calcDf(IRBlockStmtNode block) {
    if (block.getPredecessors().size() < 2) {
      return;
    }
    for (var pred : block.getPredecessors()) {
      var runner = pred;
      while (runner != block.getIdom()) {
        runner.getDf().add(block);
        runner = runner.getIdom();
      }
    }
  }

  IRBlockStmtNode intersect(IRBlockStmtNode x, IRBlockStmtNode y) {
    while (x != y) {
      // System.out.println(x.getLabelName() + " " + y.getLabelName());
      while (block2order.get(x) < block2order.get(y)) {
        x = x.getIdom();
        // System.out.println(x.getLabelName() + " " + y.getLabelName());
      }
      while (block2order.get(y) < block2order.get(x)) {
        if (y.getIdom() == null) {
          throw new RuntimeError("Invalid block " + y.getLabelName());
        }
        y = y.getIdom();
        // System.out.println(x.getLabelName() + " " + y.getLabelName());
      }
    }
    // System.out.println("next");
    return x;
  }

  void insertPhi(IRFuncDefNode node) {
    for (var block : node.getBody()) {
      solveDef(block);
    }
  }

  void solveDef(IRBlockStmtNode block) {
    for (var df : block.getDf()) {
      for (var var : block.getDefs().entrySet()) {
        var newVar = new IRVariable(var.getValue().getType(),
            var.getKey().getValue() + ".block." + block2order.get(df));
        if (!df.getPhiMap().containsKey(newVar.getValue())) {
          var phi = new IRPhiNode(newVar, var.getValue().getType(),
              new Array<>(new Pair<>(var.getValue(), block.getLabelName())));
          df.getPhiMap().put(newVar.getValue(), phi);
        } else {
          df.getPhiMap().get(newVar.getValue()).getValues().add(new Pair<>(var.getValue(), block.getLabelName()));
        }
      }
    }
  }

  void rename(IRFuncDefNode node) {
    var var2name = new Map<String, IREntity>();
    for (var inst : node.getBody().get(0).getNodes()) {
      if (inst instanceof IRAllocaNode) {
        var2name.put(((IRAllocaNode) inst).getDest().getValue(), null);
      }
    }
    renameBlock(node.getBody().get(0), var2name);
  }

  void renameBlock(IRBlockStmtNode node, Map<String, IREntity> var2name) {
    for (var phi : node.getPhiMap().entrySet()) {
      if (phi.getValue().getValues().size() == 1) {
        var2name.put(phi.getKey(), phi.getValue().getValues().get(0).a);
        node.getPhiMap().remove(phi.getKey());
      } else {
        var2name.put(phi.getKey(), phi.getValue().getDest());
      }
    }
    var reg2name = new Map<IRVariable, IREntity>();
    for (var inst : node.getNodes()) {
      if (inst instanceof IRLoadNode) {
        var loadInst = (IRLoadNode) inst;
        if (!loadInst.getSrc().isGlobal()) {
          if (!var2name.containsKey(loadInst.getSrc().getValue())) {
            throw new RuntimeError("Variable not defined: " + loadInst.getSrc().getValue());
          }
          var name = var2name.get(loadInst.getSrc().getValue());
          if (name == null) {
            name = new IRLiteral(loadInst.getSrc().getType(), 0);
          }
          reg2name.put(loadInst.getDest(), name);
        }
      } else if (inst instanceof IRStoreNode) {
        var storeInst = (IRStoreNode) inst;
        if (!storeInst.getDest().isGlobal()) {
          if (!var2name.containsKey(storeInst.getDest().getValue())) {
            throw new RuntimeError("Variable not defined: " + storeInst.getDest().getValue());
          }
          var2name.put(storeInst.getDest().getValue(), storeInst.getSrc());
        }
      }
    }
    var newNodes = new Array<IRInstNode>();
    for (var inst : node.getNodes()) {
      if (inst instanceof IRLoadNode) {
        if (!((IRLoadNode) inst).getSrc().isGlobal()) {
          continue;
        }
      } else if (inst instanceof IRStoreNode) {
        if (!((IRStoreNode) inst).getDest().isGlobal()) {
          continue;
        }
      }
      for (var use : inst.getUses()) {
        if (reg2name.containsKey(use)) {
          inst.replaceUse(use, reg2name.get(use));
        }
      }
      newNodes.add(inst);
    }
    node.setNodes(newNodes);
    for (var use : node.getExitInst().getUses()) {
      if (reg2name.containsKey(use)) {
        node.getExitInst().replaceUse(use, reg2name.get(use));
      }
    }
    for (var succ : node.getSuccessors()) {
      for (var phi : succ.getPhiMap().entrySet()) {
        for (var value : phi.getValue().getValues()) {
          if (value.b.equals(node.getLabelName())) {
            phi.getValue().replaceUse(phi.getValue().getDest(), reg2name.get(phi.getValue().getDest()));
          }
        }
      }
    }
    var backupVar2name = var2name.clone();
    for (var child : node.getChildren()) {
      renameBlock(child, backupVar2name);
    }
  }
}
