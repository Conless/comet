package dev.conless.comet.backend.asm.node.inst;

import dev.conless.comet.backend.asm.ASMVisitor;
import dev.conless.comet.backend.asm.entity.ASMReg;

@lombok.Getter
@lombok.Setter
public final class ASMBeqzNode extends ASMInstNode {
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

  @Override
  public <T> T accept(ASMVisitor<T> visitor) {
    return visitor.visit(this);
  }
}
