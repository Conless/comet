package dev.conless.comet.backend.asm.node.inst;

import dev.conless.comet.backend.asm.entity.ASMReg;
import dev.conless.comet.backend.asm.node.ASMNode;

@lombok.Value
@lombok.EqualsAndHashCode(callSuper = true)
public class ASMMoveNode extends ASMNode {
  private ASMReg src, dest;

  public ASMMoveNode(ASMReg src, ASMReg dest) {
    this.src = src;
    this.dest = dest;
  }

  @Override
  public String toString() {
    return String.format("%-6s", "move") + dest + ", " + src;
  }
}
