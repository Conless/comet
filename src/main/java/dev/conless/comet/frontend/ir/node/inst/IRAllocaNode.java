package dev.conless.comet.frontend.ir.node.inst;

import dev.conless.comet.frontend.ir.IRVisitor;
import dev.conless.comet.frontend.ir.entity.IRVariable;
import dev.conless.comet.frontend.ir.type.IRType;
import dev.conless.comet.utils.error.BaseError;

@lombok.Value
@lombok.EqualsAndHashCode(callSuper = true)
public final class IRAllocaNode extends IRInstNode {
  private IRVariable dest;
  private String type;

  public IRAllocaNode(IRVariable dest, IRType type) {
    this.type = type.getTypeName();
    this.dest = dest;
  }

  public IRAllocaNode(IRVariable dest, String type) {
    this.type = type;
    this.dest = dest;
  }

  @Override
  public String toString() {
    return dest.getValue() + " = alloca " + type;
  }

  @Override
  public <T> T accept(IRVisitor<T> visitor) throws BaseError {
    return visitor.visit(this);
  }
}
