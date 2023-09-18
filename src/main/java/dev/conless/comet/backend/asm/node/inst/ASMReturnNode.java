package dev.conless.comet.backend.asm.node.inst;

import dev.conless.comet.backend.asm.ASMVisitor;
import dev.conless.comet.backend.asm.entity.ASMVirtualReg;
import dev.conless.comet.utils.container.Array;

public final class ASMReturnNode extends ASMInstNode {
  @Override
  public String toString() {
    return "ret";
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
