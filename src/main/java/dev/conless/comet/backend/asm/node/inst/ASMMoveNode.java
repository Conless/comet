package dev.conless.comet.backend.asm.node.inst;

import dev.conless.comet.backend.asm.ASMVisitor;
import dev.conless.comet.backend.asm.entity.ASMReg;

@lombok.Getter
@lombok.Setter
public final class ASMMoveNode extends ASMInstNode {
  private ASMReg src, dest;

  public ASMMoveNode(ASMReg src, ASMReg dest) {
    this.src = src;
    this.dest = dest;
  }

  @Override
  public String toString() {
    return String.format("%-6s", "mv") + dest + ", " + src;
  }

  @Override
  public <T> T accept(ASMVisitor<T> visitor) {
    return visitor.visit(this);
  }
}
