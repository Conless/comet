package dev.conless.comet.backend.asm.node.inst;

import dev.conless.comet.backend.asm.ASMVisitor;

@lombok.Value
@lombok.EqualsAndHashCode(callSuper = true)
public final class ASMCallNode extends ASMInstNode {
  private String label;

  public ASMCallNode(String label) {
    this.label = label;
  }

  @Override
  public String toString() {
    return String.format("%-6s", "call") + label;
  }

  @Override
  public <T> T accept(ASMVisitor<T> visitor) {
    return visitor.visit(this);
  }
}
