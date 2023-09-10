package dev.conless.comet.middleend.optimize;

import dev.conless.comet.frontend.ir.node.IRRoot;

public class IROptimizer {
  public void visit(IRRoot root) {
    new CFGBuilder().visit(root);
    new Mem2Reg().visit(root);
    // new LivenessAnalyzer().visit(root);
  }
}
