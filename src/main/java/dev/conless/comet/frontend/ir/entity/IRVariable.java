package dev.conless.comet.frontend.ir.entity;

import dev.conless.comet.frontend.ir.type.IRType;
import dev.conless.comet.utils.error.RuntimeError;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = true)
public final class IRVariable extends IREntity {
  private boolean isGlobal;

  public IRVariable(IRType type, String value, boolean isGlobal) {
    super(type, value);
    if (value.contains("%") || value.contains("@")) {
      throw new RuntimeError("Variable name cannot contain '%' or '@'");
    }
    this.isGlobal = isGlobal;
  }

  @Override
  public String toString() {
    return getType().toString() + " " + (isGlobal ? "@" : "%") + getValue();
  }

  public String getName() {
    return (isGlobal ? "@" : "%") + getValue();
  }
}
