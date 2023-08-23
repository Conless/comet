package dev.conless.comet.backend.asm.node.inst;

import dev.conless.comet.backend.asm.ASMVisitor;
import dev.conless.comet.backend.asm.entity.ASMReg;

@lombok.Value
@lombok.EqualsAndHashCode(callSuper = true)
public class ASMLoadImmNode extends ASMInstNode {
  private ASMReg dest;
  private int value;

  public ASMLoadImmNode(ASMReg dest, int value) {
    this.dest = dest;
    this.value = value;
  }

  @Override
  public String toString() {
    return String.format("%-6s", "li") + dest + ", " + value;
  }

  @Override
  public <T> T accept(ASMVisitor<T> visitor) {
    return visitor.visit(this);
  }
}
