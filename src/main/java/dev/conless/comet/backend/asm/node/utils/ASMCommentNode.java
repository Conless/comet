package dev.conless.comet.backend.asm.node.utils;

import dev.conless.comet.backend.asm.ASMVisitor;
import dev.conless.comet.backend.asm.entity.ASMVirtualReg;
import dev.conless.comet.backend.asm.node.inst.ASMInstNode;
import dev.conless.comet.utils.container.Array;

public final class ASMCommentNode extends ASMInstNode {
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

  @Override
  public ASMVirtualReg getDef() {
    return null;
  }

  @Override
  public Array<ASMVirtualReg> getUses() {
    return new Array<>();
  }
}
