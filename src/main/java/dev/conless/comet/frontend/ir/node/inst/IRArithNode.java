package dev.conless.comet.frontend.ir.node.inst;

import dev.conless.comet.frontend.ir.entity.IRVariable;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = true)
public final class IRArithNode extends IRInstNode {
  private IRVariable dest, lhs, rhs;
  private String op;

  public IRArithNode(IRVariable dest, IRVariable lhs, IRVariable rhs, String op) {
    this.dest = dest;
    this.lhs = lhs;
    this.rhs = rhs;
    this.op = op;
  }

  @Override
  public String toString() {
    return dest.getName() + " = " + op.toString() + " " + lhs.toString() + ", " + rhs.toString();
  }
}
