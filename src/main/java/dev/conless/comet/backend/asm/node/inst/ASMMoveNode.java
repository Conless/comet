package dev.conless.comet.backend.asm.node.inst;

import dev.conless.comet.backend.asm.entity.ASMReg;

@lombok.Value
@lombok.EqualsAndHashCode(callSuper = true)
public class ASMMoveNode extends ASMInstNode {
  private ASMReg src, dest;

  public ASMMoveNode(ASMReg src, ASMReg dest) {
    this.src = src;
    this.dest = dest;
  }

  @Override
  public String toString() {
    return String.format("%-6s", "mv") + dest + ", " + src;
  }
}
