package dev.conless.comet.backend.asm.node.utils;

import dev.conless.comet.backend.asm.ASMVisitor;
import dev.conless.comet.backend.asm.node.inst.ASMInstNode;

@lombok.Value
@lombok.EqualsAndHashCode(callSuper = true)
public class ASMLabelNode extends ASMInstNode {
  private String label;

  public ASMLabelNode(String label) {
    this.label = label;
  }

  @Override
  public String toString() {
    return label + ":";
  }

  @Override
  public <T> T accept(ASMVisitor<T> visitor) {
    return visitor.visit(this);
  }
}
