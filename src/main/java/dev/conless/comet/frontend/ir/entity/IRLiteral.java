package dev.conless.comet.frontend.ir.entity;

import dev.conless.comet.frontend.ir.type.IRType;
import dev.conless.comet.frontend.utils.scope.GlobalScope;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = true)
public final class IRLiteral extends IREntity {
  public IRLiteral(IRType type, Integer value) {
    super(type, (type.equals(GlobalScope.irPtrType) && value == 0) ? "null" : value.toString());
  }

  @Override
  public String toString() {
    return getType().toString() + " " + getValue();
  }
}
