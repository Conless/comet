package dev.conless.comet.backend.asm.node.inst;

import dev.conless.comet.backend.asm.entity.ASMRegister;
import dev.conless.comet.backend.asm.node.ASMNode;

@lombok.Value
@lombok.EqualsAndHashCode(callSuper = true)
public class ASMStoreNode extends ASMNode {
  private ASMRegister dest, src;
  private int offset;

  public ASMStoreNode(ASMRegister dest, ASMRegister src, int offset) {
    this.dest = dest;
    this.src = src;
    this.offset = offset;
  }

  @Override
  public String toString() {
    return String.format("%-6s", "sw") + src + ", " + offset + "(" + dest + ")";
  }
}
