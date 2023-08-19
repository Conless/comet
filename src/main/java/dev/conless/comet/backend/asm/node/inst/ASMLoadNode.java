package dev.conless.comet.backend.asm.node.inst;

import dev.conless.comet.backend.asm.entity.ASMRegister;
import dev.conless.comet.backend.asm.node.ASMNode;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = true)
public class ASMLoadNode extends ASMNode {
  public ASMRegister dest, src;
  public int offset;

  public ASMLoadNode(ASMRegister dest, ASMRegister src, int offset) {
    this.dest = dest;
    this.src = src;
    this.offset = offset;
  }

  @Override
  public String toString() {
    return String.format("%-6s", "lw") + dest + ", " + offset + "(" + src + ")";
  }
}
