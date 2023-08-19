package dev.conless.comet.frontend.ir.node;

import dev.conless.comet.frontend.ir.IRVisitor;
import dev.conless.comet.utils.error.BaseError;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class IRNode {
  public abstract String toString();
  
  public <T> T accept(IRVisitor<T> visitor) throws BaseError {
    return visitor.visit(this);
  }
}
