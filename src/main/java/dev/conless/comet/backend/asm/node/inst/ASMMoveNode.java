package dev.conless.comet.backend.asm.node.inst;

import dev.conless.comet.backend.asm.entity.ASMRegister;
import dev.conless.comet.backend.asm.node.ASMNode;

@lombok.Value
@lombok.EqualsAndHashCode(callSuper = true)
public class ASMMoveNode extends ASMNode {
  private ASMRegister src, dest;

  public ASMMoveNode(ASMRegister src, ASMRegister dest) {
    this.src = src;
    this.dest = dest;
  }

  @Override
  public String toString() {
    return String.format("%-6s", "move") + dest + ", " + src;
  }
}
