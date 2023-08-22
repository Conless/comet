package dev.conless.comet.backend.asm.node.utils;

import dev.conless.comet.backend.asm.node.ASMNode;

public class ASMCommentNode extends ASMNode {
  private String comment;

  public ASMCommentNode(String comment) {
    this.comment = comment;
  }

  @Override
  public String toString() {
    return "# " + comment;
  }
}
