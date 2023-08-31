package dev.conless.comet.middleend.optimize;

import dev.conless.comet.frontend.ir.node.IRRoot;
import dev.conless.comet.frontend.ir.node.def.IRFuncDefNode;
import dev.conless.comet.frontend.ir.node.stmt.IRBlockStmtNode;
import dev.conless.comet.utils.container.Set;

public class LivenessAnalyzer {
  public void visit(IRRoot root) {
    for (var func : root.getFuncs()) {
      visit(func);
    }
  }

  public void visit(IRFuncDefNode node) {
    for (var block : node.getBody()) {
      init(block);
    }
    boolean changed = true;
    while (changed) {
      changed = false;
      for (var block : node.getBody()) {
        if (visit(block)) {
          changed = true;
        }
      }
    }
  }

  public void init(IRBlockStmtNode node) {
    node.setDefs(new Set<>());
    node.setUses(new Set<>());
    for (var inst : node.getNodes()) {
      var uses = inst.getUses();
      for (var use : uses) {
        if (!node.getDefs().contains(use)) {
          node.getUses().add(use);
        }
      }
      var def = inst.getDef();
      if (def != null) {
        node.getDefs().add(def);
      }
    }
  }

  public boolean visit(IRBlockStmtNode node) {
    var oldIn = node.getLiveIn();
    var oldOut = node.getLiveOut();
    node.setLiveIn(new Set<>());
    node.setLiveOut(new Set<>());
    for (var succ : node.getSuccessors()) {
      node.getLiveOut().addAll(succ.getLiveIn());
    }
    node.getLiveIn().addAll(node.getUses());
    node.getLiveIn().addAll(node.getLiveOut());
    node.getLiveIn().removeAll(node.getDefs());
    node.getLiveOut().removeAll(node.getDefs());
    return !node.getLiveIn().equals(oldIn) || !node.getLiveOut().equals(oldOut);
  }
}
