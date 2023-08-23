package dev.conless.comet.backend.asm.node.utils;

import dev.conless.comet.backend.asm.ASMVisitor;
import dev.conless.comet.backend.asm.node.inst.ASMInstNode;

public class ASMCommentNode extends ASMInstNode {
  private String comment;

  public ASMCommentNode(String comment) {
    this.comment = comment;
  }

  @Override
  public String toString() {
    return "# " + comment;
  }

  @Override
  public <T> T accept(ASMVisitor<T> visitor) {
    return visitor.visit(this);
  }
}
