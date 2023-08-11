package dev.conless.comet.frontend.ir.node.inst;

import dev.conless.comet.frontend.ir.entity.IRVariable;
import dev.conless.comet.frontend.ir.node.IRInstNode;
import dev.conless.comet.frontend.ir.type.IRType;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = true)
public final class IRIcmpNode extends IRInstNode {
  private IRVariable dest, lhs, rhs;
  private String op;
  private IRType type;

  public IRIcmpNode(IRVariable dest, IRVariable lhs, IRVariable rhs, String op, IRType type) {
    this.dest = dest;
    this.lhs = lhs;
    this.rhs = rhs;
    this.op = op;
    this.type = type;
  }

  @Override
  public String toString() {
    return dest.getValue() + " = icmp " + op.toString() + " " + type.toString() + " " + lhs.getValue() + ", " + rhs.getValue();
  }
}
