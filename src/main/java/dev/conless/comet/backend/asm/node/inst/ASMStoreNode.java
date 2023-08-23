package dev.conless.comet.backend.asm.node.inst;

import dev.conless.comet.backend.asm.entity.ASMAddress;
import dev.conless.comet.backend.asm.entity.ASMReg;
import dev.conless.comet.backend.asm.node.ASMNode;

@lombok.Value
@lombok.EqualsAndHashCode(callSuper = true)
public class ASMStoreNode extends ASMNode {
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
}
