package dev.conless.comet.frontend.ir.node.inst;

import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = true)
public final class IRJumpNode extends IRInstNode {
  private String label;

  public IRJumpNode(String label) {
    this.label = label;
  }

  @Override
  public String toString() {
    return "br label %" + label;
  }
}
