package dev.conless.comet.frontend.ir.node;

import dev.conless.comet.frontend.ir.IRVisitor;
import dev.conless.comet.utils.error.BaseError;

@lombok.Getter
@lombok.Setter
public abstract class IRNode {
  public abstract String toString();
  
  public <T> T accept(IRVisitor<T> visitor) throws BaseError {
    return visitor.visit(this);
  }
}
