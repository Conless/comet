package dev.conless.comet.middleend.optimize;

import dev.conless.comet.utils.container.Set;

import dev.conless.comet.frontend.ir.node.IRRoot;
import dev.conless.comet.frontend.ir.node.def.IRFuncDefNode;
import dev.conless.comet.frontend.ir.node.inst.*;
import dev.conless.comet.frontend.ir.node.stmt.IRBlockStmtNode;
import dev.conless.comet.utils.container.Map;
import dev.conless.comet.utils.error.RuntimeError;

public class CFGBuilder {
  private Map<String, IRBlockStmtNode> label2Block;

  public void visit(IRRoot node) {
    for (var func : node.getFuncs()) {
      visit(func);
    }
  }

  private void visit(IRFuncDefNode node) {
    var blocks = node.getBody();
    label2Block = new Map<>();
    for (var block : blocks) {
      label2Block.put(block.getLabelName(), block);
    }
    for (var block : blocks) {
      visit(block);
    }
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

  private void visit(IRBlockStmtNode node) {
    for (var inst : node.getNodes()) {
      if (inst instanceof IRLoadNode) {
        var loadInst = (IRLoadNode) inst;
        if (!(loadInst.getSrc()).isGlobal()) {
          node.getUses().put(loadInst.getSrc(), null);
        }
        node.getUses().put(((IRLoadNode) inst).getSrc(), null);
      } else if (inst instanceof IRStoreNode) {
        var storeInst = (IRStoreNode) inst;
        if (!(storeInst.getDest()).isGlobal()) {
          node.getUses().put(storeInst.getDest(), null);
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
    var labelName = node.getLabelName();
    if (labelName.startsWith("if.") && (labelName.endsWith(".body") || labelName.endsWith(".else"))) {
      var endLabelName = labelName.replace(".body", ".end").replace(".else", ".end");
      var target = label2Block.get(endLabelName);
      var targetAdded = false;
      for (var added : node.getSuccessors()) {
        if (target == added) {
          targetAdded = true;
          break;
        }
      }
      if (!targetAdded) {
        node.addNext(target);
        target.addPrev(node);
      }
    }
  }
}
