package dev.conless.comet.frontend.ir.node.utils;

import dev.conless.comet.frontend.ir.node.IRNode;

public final class IRCommentNode extends IRNode {
  private final String comment;

  public IRCommentNode(String comment) {
    this.comment = comment;
  }

  @Override
  public String toString() {
    return "; " + comment;
  }
}
