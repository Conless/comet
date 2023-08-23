package dev.conless.comet.backend.asm.node.inst;

import dev.conless.comet.backend.asm.ASMVisitor;
import dev.conless.comet.backend.asm.entity.ASMAddress;
import dev.conless.comet.backend.asm.entity.ASMReg;

@lombok.Value
@lombok.EqualsAndHashCode(callSuper = true)
public class ASMStoreNode extends ASMInstNode {
  private ASMReg src;
  private ASMAddress dest;

  public ASMStoreNode(ASMReg src, ASMAddress dest) {
    this.src = src;
    this.dest = dest;
  }

  @Override
  public String toString() {
    return String.format("%-6s", "sw") + src + ", " + dest;
  }

  @Override
  public <T> T accept(ASMVisitor<T> visitor) {
    return visitor.visit(this);
  }
}
