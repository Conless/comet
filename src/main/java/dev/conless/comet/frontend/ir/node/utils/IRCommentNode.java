package dev.conless.comet.frontend.ir.node.utils;

import dev.conless.comet.frontend.ir.IRVisitor;
import dev.conless.comet.frontend.ir.node.IRNode;
import dev.conless.comet.utils.error.BaseError;

@lombok.Value
@lombok.EqualsAndHashCode(callSuper = false)
public final class IRCommentNode extends IRNode {
  private final String comment;

  public IRCommentNode(String comment) {
    this.comment = comment;
  }

  @Override
  public String toString() {
    return "; " + comment;
  }

  @Override
  public <T> T accept(IRVisitor<T> visitor) throws BaseError {
    return visitor.visit(this);
  }
}
