package dev.conless.comet.backend.asm.node.inst;

import dev.conless.comet.backend.asm.ASMVisitor;
import dev.conless.comet.backend.asm.entity.ASMVirtualReg;
import dev.conless.comet.utils.container.Array;

@lombok.Value
@lombok.EqualsAndHashCode(callSuper = true)
public final class ASMJumpNode extends ASMInstNode {
  private String label;

  public ASMJumpNode(String label) {
    this.label = label;
  }

  @Override
  public String toString() {
    return String.format("%-6s", "j") + label;
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
