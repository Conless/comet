package dev.conless.comet.backend.asm.node.inst;

import dev.conless.comet.backend.asm.entity.ASMRegister;
import dev.conless.comet.backend.asm.node.ASMNode;

@lombok.Value
@lombok.EqualsAndHashCode(callSuper = true)
public final class ASMBnezNode extends ASMNode {
  private ASMRegister entity;
  private String label;

  public ASMBnezNode(ASMRegister entity, String label) {
    this.entity = entity;
    this.label = label;
  }

  @Override
  public String toString() {
    return String.format("%-6s", "bnez") + entity.getName() + ", " + label;
  }
}
