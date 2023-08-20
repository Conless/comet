package dev.conless.comet.frontend.ir.entity;

import dev.conless.comet.frontend.ir.IRVisitor;
import dev.conless.comet.frontend.ir.type.IRType;
import dev.conless.comet.frontend.utils.scope.GlobalScope;
import dev.conless.comet.utils.error.BaseError;

@lombok.Value
@lombok.EqualsAndHashCode(callSuper = true)
public final class IRLiteral extends IREntity {
  public IRLiteral(IRType type, int value) {
    super(type, (type.equals(GlobalScope.irPtrType) && value == 0) ? "null" : String.valueOf(value));
  }

  @Override
  public String toString() {
    return getType().toString() + " " + getValue();
  }

  @Override
  public <T> T accept(IRVisitor<T> visitor) throws BaseError {
    return visitor.visit(this);
  }
}
