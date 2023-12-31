package dev.conless.comet.frontend.ir.node.inst;

import dev.conless.comet.frontend.ir.IRVisitor;
import dev.conless.comet.frontend.ir.entity.IREntity;
import dev.conless.comet.frontend.ir.entity.IRVariable;
import dev.conless.comet.frontend.ir.type.IRType;
import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.error.BaseError;

@lombok.Value
@lombok.EqualsAndHashCode(callSuper = true)
public final class IRAllocaNode extends IRInstNode {
  private IRVariable dest;
  private IRType type;

  public IRAllocaNode(IRVariable dest, IRType type) {
    this.type = type;
    this.dest = dest;
  }

  @Override
  public IRVariable getDef() {
    return dest;
  }

  @Override
  public Array<IRVariable> getUses() {
    return new Array<>();
  }

  @Override
  public void replaceUse(IREntity old, IREntity newEntity) {
    // do nothing
  }

  @Override
  public String toString() {
    return dest.getValue() + " = alloca " + type.getTypeName();
  }

  @Override
  public <T> T accept(IRVisitor<T> visitor) throws BaseError {
    return visitor.visit(this);
  }
}
