package dev.conless.comet.backend.asm.node.inst;

@lombok.Value
@lombok.EqualsAndHashCode(callSuper = true)
public class ASMCallNode extends ASMInstNode {
  private String label;

  public ASMCallNode(String label) {
    this.label = label;
  }

  @Override
  public String toString() {
    return String.format("%-6s", "call") + label;
  }
}
