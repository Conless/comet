package dev.conless.comet.frontend.ir.node.inst;

import dev.conless.comet.frontend.ir.entity.IRVariable;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = true)
public final class IRBranchNode extends IRInstNode {
  private IRVariable condition;
  private String trueLabel, falseLabel;

  public IRBranchNode(IRVariable condition, String trueLabel, String falseLabel) {
    this.condition = condition;
    this.trueLabel = trueLabel;
    this.falseLabel = falseLabel;
  }

  @Override
  public String toString() {
    return "br " + condition.toString() + ", label %" + trueLabel + ", label %" + falseLabel;
  }
}
