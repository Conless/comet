package dev.conless.comet.backend.asm.node.inst;

import dev.conless.comet.backend.asm.entity.ASMRegister;
import dev.conless.comet.backend.asm.node.ASMNode;

@lombok.Value
@lombok.EqualsAndHashCode(callSuper = true)
public class ASMLoadImmNode extends ASMNode {
  private ASMRegister dest;
  private int value;

  public ASMLoadImmNode(ASMRegister dest, int value) {
    this.dest = dest;
    this.value = value;
  }

  @Override
  public String toString() {
    return String.format("%-6s", "li") + dest + ", " + value;
  }
}
