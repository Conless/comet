package dev.conless.comet.backend.asm.node.inst;

import dev.conless.comet.backend.asm.ASMVisitor;
import dev.conless.comet.backend.asm.entity.ASMReg;

@lombok.Value
@lombok.EqualsAndHashCode(callSuper = true)
public class ASMLoadAddrNode extends ASMInstNode {
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
}
