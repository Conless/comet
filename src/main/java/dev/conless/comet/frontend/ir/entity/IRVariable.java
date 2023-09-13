package dev.conless.comet.frontend.ir.entity;

import dev.conless.comet.frontend.ir.IRVisitor;
import dev.conless.comet.frontend.ir.type.IRType;
import dev.conless.comet.utils.error.BaseError;
import dev.conless.comet.utils.error.RuntimeError;

@lombok.Setter
@lombok.Getter
public final class IRVariable extends IREntity implements Comparable<IRVariable> {
  public IRVariable(IRType type, String value) {
    super(type, value);
    if (!value.contains("@") && !value.contains("%")) {
      throw new RuntimeError("Variable name must start with @ or %");
    }
  }

  public boolean isGlobal() {
    return getValue().startsWith("@");
  }

  public boolean isTemp() {
    return getValue().startsWith("%.");
  }

  public boolean isVar() {
    return !isGlobal() && !isTemp();
  }

  @Override
  public String toString() {
    return getType().toString() + " " + getValue();
  }

  @Override
  public <T> T accept(IRVisitor<T> visitor) throws BaseError {
    return visitor.visit(this);
  }

  @Override
  public int compareTo(IRVariable o) {
    return getValue().compareTo(((IRVariable) o).getValue());
  }
}
