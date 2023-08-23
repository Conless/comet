package dev.conless.comet.backend.asm.node.inst;

import dev.conless.comet.backend.asm.ASMVisitor;
import dev.conless.comet.backend.asm.entity.ASMAddress;
import dev.conless.comet.backend.asm.entity.ASMReg;

@lombok.Getter
@lombok.Setter
public final class ASMLoadNode extends ASMInstNode {
  public ASMReg dest;
  public ASMAddress src;

  public ASMLoadNode(ASMReg dest, ASMAddress src) {
    this.dest = dest;
    this.src = src;
  }

  @Override
  public String toString() {
    return String.format("%-6s", "lw") + dest + ", " + src;
  }

  @Override
  public <T> T accept(ASMVisitor<T> visitor) {
    return visitor.visit(this);
  }
}
