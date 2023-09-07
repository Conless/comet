package dev.conless.comet.frontend.ir.node.utils;

import dev.conless.comet.frontend.ir.IRVisitor;
import dev.conless.comet.frontend.ir.entity.IREntity;
import dev.conless.comet.frontend.ir.entity.IRVariable;
import dev.conless.comet.frontend.ir.node.inst.IRInstNode;
import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.error.BaseError;

@lombok.Value
@lombok.EqualsAndHashCode(callSuper = false)
public final class IRLabelNode extends IRInstNode {
  private final String name;

  public IRLabelNode(String name) {
    this.name = name;
  }

  @Override
  public IRVariable getDef() {
    return null;
  }

  @Override
  public Array<IRVariable> getUses() {
    return new Array<>();
  }

  @Override
  public String toString() {
    return this.name + ":";
  }

  @Override
  public <T> T accept(IRVisitor<T> visitor) throws BaseError {
    return visitor.visit(this);
  }

  @Override
  public void replaceUse(IREntity old, IREntity newEntity) {
    // do nothing
  }
}
