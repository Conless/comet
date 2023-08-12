package dev.conless.comet.frontend.ir.entity;

import dev.conless.comet.frontend.ir.type.IRType;
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
}
