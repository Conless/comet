package dev.conless.comet.frontend.ir.node.utils;

import dev.conless.comet.frontend.ir.IRVisitor;
import dev.conless.comet.frontend.ir.node.IRNode;
import dev.conless.comet.utils.error.BaseError;

@lombok.Value
@lombok.EqualsAndHashCode(callSuper = false)
public final class IRCustomNode extends IRNode {
  private String str;

  public IRCustomNode(String str) {
    this.str = str;
  }

  @Override
  public String toString() {
    return str;
  }

  @Override
  public <T> T accept(IRVisitor<T> visitor) throws BaseError {
    return visitor.visit(this);
  }
}
