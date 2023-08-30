package dev.conless.comet.frontend.ir.node.inst;

import dev.conless.comet.frontend.ir.IRVisitor;
import dev.conless.comet.frontend.ir.entity.IREntity;
import dev.conless.comet.frontend.ir.entity.IRVariable;
import dev.conless.comet.frontend.utils.scope.GlobalScope;
import dev.conless.comet.utils.error.BaseError;
import dev.conless.comet.utils.error.RuntimeError;

@lombok.Value
@lombok.EqualsAndHashCode(callSuper = true)
public final class IRArithNode extends IRInstNode {
  private IRVariable dest;
  private IREntity lhs, rhs;
  private String op;
  private boolean isComparison;

  public IRArithNode(IRVariable dest, IREntity lhs, IREntity rhs, String op) {
    if (!lhs.getType().equals(rhs.getType())) {
      throw new RuntimeError("Cannot perform arithmetic on two different types");
    }
    if (op.equals("eq") || op.equals("ne") || op.equals("sgt") || op.equals("sge") || op.equals("slt") || op.equals("sle")) {
      if (!dest.getType().equals(GlobalScope.irBoolType)) {
        throw new RuntimeError("Cannot perform comparison on non-boolean type");
      }
      isComparison = true;
    } else if (op.equals("add") || op.equals("sub") || op.equals("mul") || op.equals("sdiv") || op.equals("srem")
        || op.equals("shl") || op.equals("ashr") || op.equals("and") || op.equals("or") || op.equals("xor")) {
      if (!dest.getType().equals(lhs.getType())) {
        throw new RuntimeError("Cannot perform arithmetic on two different types");
      }
      isComparison = false;
    } else {
      throw new RuntimeError("Invalid arith op: " + op);
    }
    this.dest = dest;
    this.lhs = lhs;
    this.rhs = rhs;
    this.op = op;
  }

  @Override
  public String toString() {
    if (isComparison) {
      return dest.getValue() + " = icmp " + op + " " + lhs.getType().toString() + " " + lhs.getValue() + ", "
          + rhs.getValue();
    }
    return dest.getValue() + " = " + op + " " + lhs.getType().toString() + " " + lhs.getValue() + ", " + rhs.getValue();
  }
  
  @Override
  public <T> T accept(IRVisitor<T> visitor) throws BaseError {
    return visitor.visit(this);
  }
}
