package dev.conless.comet.middleend.optimize;

import dev.conless.comet.utils.container.Map;
import dev.conless.comet.utils.container.Set;

import java.util.LinkedList;

import dev.conless.comet.frontend.ir.entity.IREntity;
import dev.conless.comet.frontend.ir.entity.IRLiteral;
import dev.conless.comet.frontend.ir.entity.IRVariable;
import dev.conless.comet.frontend.ir.node.IRRoot;
import dev.conless.comet.frontend.ir.node.def.IRFuncDefNode;
import dev.conless.comet.frontend.ir.node.inst.IRAllocaNode;
import dev.conless.comet.frontend.ir.node.inst.IRCallNode;
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
  private Map<IRVariable, Pair<IRType, Set<IRBlockStmtNode>>> globalNames;
  private IRFuncDefNode currentFunc;

  public void visit(IRRoot node) {
    for (var func : node.getFuncs()) {
      visit(func);
    }
  }

  void visit(IRFuncDefNode node) {
    currentFunc = node;
    buildDomTree(node);
    insertPhi(node);
    rename(node);
  }


  void buildDomTree(IRFuncDefNode func) {
    boolean changed = true;
    var entryBlock = func.getBlocks().get(0);
    entryBlock.setIdom(entryBlock);
    while (changed) {
      changed = false;
      for (var block : func.getOrder2Block()) {
        if (block == entryBlock) {
          continue;
        }
        changed |= calcIdom(block);
      }
    }

    // for (var block : func.getBody()) {
    // System.out.println(block.getLabelName() + " " +
    // block.getIdom().getLabelName());
    // }

    for (var block : func.getBlocks()) {
      if (block.getIdom() != block) {
        block.getIdom().getChildren().add(block);
      }
      calcDf(block);
    }

    // for (var block : func.getBody()) {
    // var str = block.getLabelName() + ":";
    // for (var df : block.getDf()) {
    // str += " " + df.getLabelName();
    // }
    // System.out.println(str);
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
      while (currentFunc.getBlock2Order().get(x) < currentFunc.getBlock2Order().get(y)) {
        x = x.getIdom();
        // System.out.println(x.getLabelName() + " " + y.getLabelName());
      }
      while (currentFunc.getBlock2Order().get(y) < currentFunc.getBlock2Order().get(x)) {
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
    collectGlobalNames(node);
    for (var global : globalNames.entrySet()) {
      var blocks = global.getValue().b;
      var workList = new LinkedList<IRBlockStmtNode>();
      var inList = new Set<IRBlockStmtNode>();
      for (var block : blocks) {
        workList.add(block);
        inList.add(block);
      }
      while (!workList.isEmpty()) {
        var block = workList.poll();
        for (var df : block.getDf()) {
          if (df.getPhiMap().containsKey(global.getKey().getValue())) {
            continue;
          }
          var newVar = new IRVariable(global.getValue().a,
              global.getKey().getValue() + ".block." + currentFunc.getBlock2Order().get(df));
          var phi = new IRPhiNode(newVar, newVar.getType(), new Array<>());
          df.getPhiMap().put(global.getKey().getValue(), phi);
          if (!inList.contains(df)) {
            workList.add(df);
            inList.add(df);
          }
        }
      }
    }
  }

  void collectGlobalNames(IRFuncDefNode node) {
    globalNames = new Map<>();
    var entryBlock = node.getBlocks().get(0);
    for (var inst : entryBlock.getInsts()) {
      if (inst instanceof IRAllocaNode allocaInst) {
        var dest = allocaInst.getDest();
        if (!globalNames.containsKey(dest)) {
          globalNames.put(dest, new Pair<>(allocaInst.getType(), new Set<>()));
        }
      }
    }
    for (var block : node.getBlocks()) {
      for (var inst : block.getInsts()) {
        if (inst instanceof IRStoreNode storeInst) {
          var dest = storeInst.getDest();
          if (globalNames.containsKey(dest)) {
            globalNames.get(dest).b.add(block);
          }
        } else if (inst instanceof IRCallNode callInst && callInst.getFuncName().equals("__string_copy")) {
          var dest = (IRVariable) callInst.getArgs().get(0);
          if (globalNames.containsKey(dest)) {
            globalNames.get(dest).b.add(block);
          }
        }
      }
    }
  }

  void rename(IRFuncDefNode node) {
    var var2name = new Map<String, IREntity>();
    for (var inst : node.getBlocks().get(0).getInsts()) {
      if (inst instanceof IRAllocaNode) {
        var2name.put(((IRAllocaNode) inst).getDest().getValue(), null);
      }
    }
    renameBlock(node.getBlocks().get(0), var2name);
  }

  void renameBlock(IRBlockStmtNode node, Map<String, IREntity> var2name) {
    for (var phi : node.getPhiMap().entrySet()) {
      var2name.put(phi.getKey(), phi.getValue().getDest());
    }
    var reg2name = new Map<IRVariable, IREntity>();
    for (var inst : node.getInsts()) {
      if (inst instanceof IRLoadNode loadInst) {
        if (loadInst.getSrc().isVar()) {
          if (!var2name.containsKey(loadInst.getSrc().getValue())) {
            throw new RuntimeError("Variable not defined: " + loadInst.getSrc().getValue());
          }
          var name = var2name.get(loadInst.getSrc().getValue());
          if (name == null) {
            name = new IRLiteral(loadInst.getDest().getType(), 0);
          } else if (name instanceof IRVariable nameVar && reg2name.containsKey(nameVar)) {
            name = reg2name.get(nameVar);
          }
          reg2name.put(loadInst.getDest(), name);
        }
      } else if (inst instanceof IRStoreNode storeInst) {
        if (storeInst.getDest().isVar()) {
          if (!var2name.containsKey(storeInst.getDest().getValue())) {
            throw new RuntimeError("Variable not defined: " + storeInst.getDest().getValue());
          }
          var src = storeInst.getSrc();
          if (src instanceof IRVariable srcVar && reg2name.containsKey(srcVar)) {
            src = reg2name.get(srcVar);
          }
          var2name.put(storeInst.getDest().getValue(), src);
        }
      } else if (inst instanceof IRCallNode callInst && callInst.getFuncName().equals("__string_copy")) {
        var dest = (IRVariable) callInst.getArgs().get(0);
        var src = callInst.getArgs().get(1);
        if (dest.isVar()) {
          if (!var2name.containsKey(dest.getValue())) {
            throw new RuntimeError("Variable not defined: " + dest.getValue());
          }
          if (src instanceof IRVariable srcVar && reg2name.containsKey(srcVar)) {
            src = reg2name.get(srcVar);
          }
          var2name.put(dest.getValue(), src);
        }
      }
    }
    var newInsts = new Array<IRInstNode>();
    for (var inst : node.getInsts()) {
      if (inst instanceof IRAllocaNode) {
        continue;
      } else if (inst instanceof IRLoadNode) {
        if (((IRLoadNode) inst).getSrc().isVar()) {
          continue;
        }
      } else if (inst instanceof IRStoreNode) {
        if (((IRStoreNode) inst).getDest().isVar()) {
          continue;
        }
      } else if (inst instanceof IRCallNode callInst && callInst.getFuncName().equals("__string_copy")) {
        var dest = (IRVariable) callInst.getArgs().get(0);
        if (dest.isVar()) {
          continue;
        }
      }
      var useList = new Set<IRVariable>();
      for (var use : inst.getUses()) {
        if (reg2name.containsKey(use)) {
          useList.add(use);
        }
      }
      for (var use : useList) {
        inst.replaceUse(use, reg2name.get(use));
      }
      newInsts.add(inst);
    }
    node.setInsts(newInsts);
    for (var use : node.getExitInst().getUses()) {
      if (reg2name.containsKey(use)) {
        node.getExitInst().replaceUse(use, reg2name.get(use));
      }
    }
    for (var succ : node.getSuccessors()) {
      for (var phi : succ.getPhiMap().entrySet()) {
        var varName = var2name.get(phi.getKey());
        if (varName == null) {
          varName = new IRLiteral(phi.getValue().getDest().getType(), 0);
        }
        phi.getValue().getValues().add(new Pair<>(varName, node.getLabelName()));
      }
    }
    for (var child : node.getChildren()) {
      var backupVar2name = var2name.clone();
      renameBlock(child, backupVar2name);
    }
  }
}
