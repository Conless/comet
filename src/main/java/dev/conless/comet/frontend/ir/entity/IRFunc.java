package dev.conless.comet.frontend.ir.entity;

import dev.conless.comet.frontend.ir.type.IRType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IRFunc extends IREntity {
  private IRVariable caller;
  private IRType returnType;

  public IRFunc(String value, IRVariable caller, IRType returnType) {
    super(new IRType("function"), value);
    this.caller = caller;
    this.returnType = returnType;
  }

  @Override
  public String toString() {
    return "@" + getValue();
  }
}
