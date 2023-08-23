package dev.conless.comet.backend.asm.node.inst;

import dev.conless.comet.backend.asm.entity.ASMAddress;
import dev.conless.comet.backend.asm.entity.ASMReg;

@lombok.Value
@lombok.EqualsAndHashCode(callSuper = true)
public class ASMLoadNode extends ASMInstNode {
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
}
