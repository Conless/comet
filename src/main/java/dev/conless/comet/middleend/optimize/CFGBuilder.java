package dev.conless.comet.middleend.optimize;

import dev.conless.comet.utils.container.Set;
import dev.conless.comet.frontend.ir.entity.IRVariable;
import dev.conless.comet.frontend.ir.node.IRRoot;
import dev.conless.comet.frontend.ir.node.def.IRFuncDefNode;
import dev.conless.comet.frontend.ir.node.inst.*;
import dev.conless.comet.frontend.ir.node.stmt.IRBlockStmtNode;
import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.container.Map;
import dev.conless.comet.utils.error.RuntimeError;

public class CFGBuilder {
  private Map<String, IRBlockStmtNode> label2Block;
  private Set<IRBlockStmtNode> visited = new Set<>();
  private IRFuncDefNode currentFunc;

  public void visit(IRRoot node) {
    for (var func : node.getFuncs()) {
      visit(func);
    }
  }

  private void visit(IRFuncDefNode node) {
    var blocks = node.getBlocks();
    label2Block = new Map<>();
    for (var block : blocks) {
      label2Block.put(block.getLabelName(), block);
    }
    for (var block : blocks) {
      visit(block);
    }
    var deadBlock = new Set<IRBlockStmtNode>();
    for (var block : blocks) {
      if (block.getLabelName().equals("entry")) {
        continue;
      }
      if (block.getPredecessors().size() == 0) {
        deadBlock.add(block);
        for (var next : block.getSuccessors()) {
          next.getPredecessors().remove(block);
        }
      }
    }
    for (var block : deadBlock) {
      blocks.remove(block);
    }
    currentFunc = node;
    calcRpo(node.getBlocks().get(0));

    // for (var block : blocks) {
    //   var str = "succ: ";
    //   for (var next : block.getSuccessors()) {
    //     str += next.getLabelName() + " ";
    //   }
    //   System.out.println(block.getLabelName() + " " + str);
    //   str = "pred: ";
    //   for (var prev : block.getPredecessors()) {
    //     str += prev.getLabelName() + " ";
    //   }
    //   System.out.println(block.getLabelName() + " " + str);
    // }
  }

  void calcRpo(IRBlockStmtNode block) {
    visited.add(block);
    for (var succ : block.getSuccessors()) {
      if (!visited.contains(succ)) {
        calcRpo(succ);
      }
    }
    currentFunc.getBlock2order().put(block, currentFunc.getBlock2order().size());
    currentFunc.getOrder2block().add(0, block);
  }

  private void visit(IRBlockStmtNode node) {
    for (var inst : node.getInsts()) {
      if (inst instanceof IRStoreNode storeInst) {
        if (storeInst.getDest().isVar()) {
          node.getDefs().put(storeInst.getDest(), storeInst.getSrc());
        }
      } else if (inst instanceof IRCallNode callInst && callInst.getFuncName().equals("__string_copy")) {
        if (((IRVariable) callInst.getArgs().get(0)).isVar()) {
          node.getDefs().put((IRVariable) callInst.getArgs().get(0), callInst.getArgs().get(1));
        }
      }
    }
    var inst = node.getExitInst();
    if (inst instanceof IRJumpNode) {
      var target = label2Block.get(((IRJumpNode) inst).getLabel());
      node.addNext(target);
      target.addPrev(node);
    } else if (inst instanceof IRBranchNode) {
      var target = label2Block.get(((IRBranchNode) inst).getTrueLabel());
      node.addNext(target);
      target.addPrev(node);
      target = label2Block.get(((IRBranchNode) inst).getFalseLabel());
      node.addNext(target);
      target.addPrev(node);
    } else if (inst instanceof IRReturnNode) {
      // do nothing
    } else {
      throw new RuntimeError("Unknown exit instruction type");
    }
  }
}
