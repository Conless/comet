package dev.conless.comet.frontend.ir.node.inst;

import dev.conless.comet.frontend.ir.IRVisitor;
import dev.conless.comet.frontend.ir.entity.IREntity;
import dev.conless.comet.frontend.ir.node.IRNode;
import dev.conless.comet.utils.error.BaseError;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = true)
public final class IRBranchNode extends IRNode {
  private IREntity condition;
  private String trueLabel, falseLabel;

  public IRBranchNode(IREntity condition, String trueLabel, String falseLabel) {
    this.condition = condition;
    this.trueLabel = trueLabel;
    this.falseLabel = falseLabel;
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
