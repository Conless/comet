package dev.conless.comet.frontend.ir.entity;

import dev.conless.comet.frontend.ir.type.IRType;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = true)
public final class IRLiteral extends IREntity {
  public IRLiteral(IRType type, Integer value) {
    super(type, value.toString());
  }

  @Override
  public String toString() {
    if (getType().toString().equals("ptr") && getValue().equals("0")) {
      return "ptr null";
    }
    return getType().toString() + " " + getValue();
  }
}
