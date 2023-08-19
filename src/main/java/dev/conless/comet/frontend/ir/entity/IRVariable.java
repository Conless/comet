package dev.conless.comet.frontend.ir.entity;

import dev.conless.comet.frontend.ir.IRVisitor;
import dev.conless.comet.frontend.ir.type.IRType;
import dev.conless.comet.utils.error.BaseError;
import dev.conless.comet.utils.error.RuntimeError;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = true)
public final class IRVariable extends IREntity {
  public IRVariable(IRType type, String value) {
    super(type, value);
    if (!value.contains("@") && !value.contains("%")) {
      throw new RuntimeError("Variable name must start with @ or %");
    }
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
