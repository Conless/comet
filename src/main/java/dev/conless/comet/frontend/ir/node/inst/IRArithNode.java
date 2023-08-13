package dev.conless.comet.frontend.ir.node.inst;

import dev.conless.comet.frontend.ir.entity.IREntity;
import dev.conless.comet.frontend.ir.entity.IRVariable;
import dev.conless.comet.frontend.ir.type.IRType;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = true)
public final class IRArithNode extends IRInstNode {
  private IRVariable dest;
  private IRType type;
  private IREntity lhs, rhs;
  private String op;

  public IRArithNode(IRVariable dest, IRType type, IREntity lhs, IREntity rhs, String op) {
    this.dest = dest;
    this.type = type;
    this.lhs = lhs;
    this.rhs = rhs;
    this.op = op;
  }

  @Override
  public String toString() {
    return dest.getValue() + " = " + op.toString() + " " + type.toString() + " " + lhs.getValue() + ", " + rhs.getValue();
  }
}
