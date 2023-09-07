package dev.conless.comet.frontend.ir.node.inst;

import dev.conless.comet.frontend.ir.IRVisitor;
import dev.conless.comet.frontend.ir.entity.IREntity;
import dev.conless.comet.frontend.ir.entity.IRVariable;
import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.error.BaseError;

@lombok.Setter
@lombok.Getter
public final class IRJumpNode extends IRInstNode {
  private String label;

  public IRJumpNode(String label) {
    this.label = label;
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
  public void replaceUse(IREntity old, IREntity newEntity) {
    // do nothing
  }

  @Override
  public String toString() {
    return "br label %" + label;
  }

  @Override
  public <T> T accept(IRVisitor<T> visitor) throws BaseError {
    return visitor.visit(this);
  }
}
