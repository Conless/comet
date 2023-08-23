package dev.conless.comet.backend.asm.node.inst;

import dev.conless.comet.backend.asm.entity.ASMReg;
import dev.conless.comet.backend.asm.node.ASMNode;

@lombok.Value
@lombok.EqualsAndHashCode(callSuper = true)
public final class ASMBeqzNode extends ASMNode {
  private ASMReg entity;
  private String label;

  public ASMBeqzNode(ASMReg entity, String label) {
    this.entity = entity;
    this.label = label;
  }

  @Override
  public String toString() {
    return String.format("%-6s", "bnez") + entity.getName() + ", " + label;
  }
}
