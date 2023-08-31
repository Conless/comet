package dev.conless.comet.middleend.optimize;

import dev.conless.comet.frontend.ir.node.IRRoot;
import dev.conless.comet.frontend.ir.node.def.IRFuncDefNode;
import dev.conless.comet.frontend.ir.node.inst.*;
import dev.conless.comet.frontend.ir.node.stmt.IRBlockStmtNode;
import dev.conless.comet.utils.container.Map;
import dev.conless.comet.utils.error.RuntimeError;

public class CFGBuilder {
  private Map<String, IRBlockStmtNode> label2Block;

  public void visit(IRRoot root) {
    for (var func : root.getFuncs()) {
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
  }

  private void visit(IRBlockStmtNode node) {
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
