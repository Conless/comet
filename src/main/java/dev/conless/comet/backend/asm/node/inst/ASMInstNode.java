package dev.conless.comet.backend.asm.node.inst;

import dev.conless.comet.backend.asm.ASMVisitor;
import dev.conless.comet.backend.asm.entity.ASMVirtualReg;
import dev.conless.comet.backend.asm.node.ASMNode;
import dev.conless.comet.utils.container.Array;

public abstract class ASMInstNode extends ASMNode {
  @Override
  public <T> T accept(ASMVisitor<T> visitor) {
    return visitor.visit(this);
  }

  public abstract ASMVirtualReg getDef();

  public abstract Array<ASMVirtualReg> getUses();
}
