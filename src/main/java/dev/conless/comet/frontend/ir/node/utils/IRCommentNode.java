package dev.conless.comet.frontend.ir.node.utils;

import dev.conless.comet.frontend.ir.node.IRNode;

public class IRCommentNode extends IRNode {
  private String comment;

  public IRCommentNode(String comment) {
    this.comment = comment;
  }

  @Override
  public String toString() {
    return "; " + comment;
  }
}
