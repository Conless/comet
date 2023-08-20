package dev.conless.comet.backend.asm.node.inst;

import dev.conless.comet.backend.asm.node.ASMNode;

@lombok.Value
@lombok.EqualsAndHashCode(callSuper = true)
public final class ASMJumpNode extends ASMNode {
  private String label;

  public ASMJumpNode(String label) {
    this.label = label;
  }

  @Override
  public String toString() {
    return String.format("%-6s", "j") + label;
  }
}
