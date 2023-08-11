package dev.conless.comet.frontend.ir.entity;

import dev.conless.comet.frontend.ir.type.IRType;

import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = true)
public final class IRLiteral extends IREntity {
  public IRLiteral(IRType type, String value) {
    super(type, value);
  }
}
