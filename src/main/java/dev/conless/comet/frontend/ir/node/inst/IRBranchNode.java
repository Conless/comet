package dev.conless.comet.frontend.ir.node.inst;

import dev.conless.comet.frontend.ir.IRVisitor;
import dev.conless.comet.frontend.ir.entity.IREntity;
import dev.conless.comet.frontend.ir.entity.IRVariable;
import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.error.BaseError;

@lombok.Value
@lombok.EqualsAndHashCode(callSuper = true)
public final class IRBranchNode extends IRInstNode {
  private IREntity condition;
  private String trueLabel, falseLabel;

  public IRBranchNode(IREntity condition, String trueLabel, String falseLabel) {
    this.condition = condition;
    this.trueLabel = trueLabel;
    this.falseLabel = falseLabel;
  }

  @Override
  public IRVariable getDef() {
    return null;
  }

  @Override
  public Array<IRVariable> getUses() {
    return condition instanceof IRVariable ? new Array<>((IRVariable) condition) : new Array<>();
  }

  @Override
  public String toString() {
    return "br " + condition.toString() + ", label %" + trueLabel + ", label %" + falseLabel;
  }

  @Override
  public <T> T accept(IRVisitor<T> visitor) throws BaseError {
    return visitor.visit(this);
  }
}
