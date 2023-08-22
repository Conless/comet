package dev.conless.comet.frontend.ir.node.utils;

import dev.conless.comet.frontend.ir.IRVisitor;
import dev.conless.comet.frontend.ir.node.IRNode;
import dev.conless.comet.utils.error.BaseError;

@lombok.Value
@lombok.EqualsAndHashCode(callSuper = false)
public final class IRLabelNode extends IRNode {
  private final String name;

  public IRLabelNode(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return this.name + ":";
  }

  @Override
  public <T> T accept(IRVisitor<T> visitor) throws BaseError {
    return visitor.visit(this);
  }
}
