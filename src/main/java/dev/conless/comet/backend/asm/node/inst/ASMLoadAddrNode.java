package dev.conless.comet.backend.asm.node.inst;

import dev.conless.comet.backend.asm.ASMVisitor;
import dev.conless.comet.backend.asm.entity.ASMReg;
import dev.conless.comet.backend.asm.entity.ASMVirtualReg;
import dev.conless.comet.utils.container.Array;

@lombok.Getter
@lombok.Setter
public final class ASMLoadAddrNode extends ASMInstNode {
  private ASMReg dest;
  private String label;

  public ASMLoadAddrNode(ASMReg dest, String label) {
    this.dest = dest;
    this.label = label;
  }

  @Override
  public String toString() {
    return String.format("%-6s", "la") + dest + ", " + label;
  }

  @Override
  public <T> T accept(ASMVisitor<T> visitor) {
    return visitor.visit(this);
  }

  @Override
  public ASMVirtualReg getDef() {
    if (dest instanceof ASMVirtualReg) {
      return (ASMVirtualReg) dest;
    }
    return null;
  }

  @Override
  public Array<ASMVirtualReg> getUses() {
    return new Array<>();
  }
}
