package dev.conless.comet.frontend.ir.node.inst;

import dev.conless.comet.frontend.ir.entity.IREntity;
import dev.conless.comet.frontend.ir.entity.IRVariable;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = true)
public final class IRSelectNode extends IRInstNode {
  private IRVariable dest;
  private IREntity condition, lhs, rhs;

  public IRSelectNode(IRVariable dest, IREntity condition, IREntity lhs, IREntity rhs) {
    this.dest = dest;
    this.condition = condition;
    this.lhs = lhs;
    this.rhs = rhs;
  }

  @Override
  public String toString() {
    return dest.getValue() + " = select " + condition.getType().toString() + " " + condition.toString() + ", " + lhs.getType().toString() + " " + lhs.toString() + ", " + rhs.getType().toString() + " " + rhs.toString();
  }
}
