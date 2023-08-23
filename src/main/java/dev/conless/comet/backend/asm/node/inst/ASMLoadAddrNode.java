package dev.conless.comet.backend.asm.node.inst;

import dev.conless.comet.backend.asm.entity.ASMReg;
import dev.conless.comet.backend.asm.node.ASMNode;

@lombok.Value
@lombok.EqualsAndHashCode(callSuper = true)
public class ASMLoadAddrNode extends ASMNode {
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
}
