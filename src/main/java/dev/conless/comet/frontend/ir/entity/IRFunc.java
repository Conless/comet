package dev.conless.comet.frontend.ir.entity;

import dev.conless.comet.frontend.ir.type.IRType;

public class IRFunc extends IREntity {
  public IRFunc(String name) {
    super(new IRType("function", 0), name);
  }

  @Override
  public String toString() {
    return "%" + getValue();
  }
}
