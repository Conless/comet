package dev.conless.comet.frontend.ir.node.inst;

import dev.conless.comet.frontend.ir.IRVisitor;
import dev.conless.comet.frontend.ir.entity.IRVariable;
import dev.conless.comet.frontend.ir.node.IRNode;
import dev.conless.comet.frontend.ir.type.IRType;
import dev.conless.comet.utils.error.BaseError;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = true)
public final class IRLoadNode extends IRNode {
  private IRVariable dest, src;
  private IRType type;

  public IRLoadNode(IRVariable dest, IRVariable src) {
    this.type = dest.getType();
    this.dest = dest;
    this.src = src;
  }

  @Override
  public String toString() {
    return dest.getValue() + " = load " + type.toString() + ", " + src.toString();
  }

  @Override
  public <T> T accept(IRVisitor<T> visitor) throws BaseError {
    return visitor.visit(this);
  }
}
