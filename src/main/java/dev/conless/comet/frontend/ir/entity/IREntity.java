package dev.conless.comet.frontend.ir.entity;

import dev.conless.comet.frontend.ir.IRVisitor;
import dev.conless.comet.frontend.ir.type.IRType;
import dev.conless.comet.utils.error.BaseError;
import lombok.Getter;

@Getter
public abstract class IREntity {
  private IRType type;
  private String value;

  public IREntity(IRType type, String value) {
    this.type = type;
    this.value = value;
  }
  
  public abstract String toString();

  public <T> T accept(IRVisitor<T> visitor) throws BaseError {
    return visitor.visit(this);
  }
}
