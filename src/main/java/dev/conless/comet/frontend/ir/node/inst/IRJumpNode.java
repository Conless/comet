package dev.conless.comet.frontend.ir.node.inst;

import dev.conless.comet.frontend.ir.IRVisitor;
import dev.conless.comet.frontend.ir.node.IRNode;
import dev.conless.comet.utils.error.BaseError;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = true)
public final class IRJumpNode extends IRNode {
  private String label;

  public IRJumpNode(String label) {
    this.label = label;
  }

  @Override
  public String toString() {
    return "br label %" + label;
  }

  @Override
  public <T> T accept(IRVisitor<T> visitor) throws BaseError {
    return visitor.visit(this);
  }
}
