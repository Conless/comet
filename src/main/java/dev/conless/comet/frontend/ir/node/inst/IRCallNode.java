package dev.conless.comet.frontend.ir.node.inst;

import dev.conless.comet.frontend.ir.IRVisitor;
import dev.conless.comet.frontend.ir.entity.IREntity;
import dev.conless.comet.frontend.ir.entity.IRVariable;
import dev.conless.comet.frontend.ir.node.IRNode;
import dev.conless.comet.frontend.ir.type.IRType;
import dev.conless.comet.frontend.utils.scope.GlobalScope;
import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.error.BaseError;

@lombok.Value
@lombok.EqualsAndHashCode(callSuper = true)
public final class IRCallNode extends IRNode {
  private IRVariable dest;
  private IRType type;
  private String funcName;
  private Array<IREntity> args;

  public IRCallNode(String funcName, Array<IREntity> args) {
    this.type = GlobalScope.irVoidType;
    this.dest = null;
    this.funcName = funcName;
    this.args = args;
  }

  public IRCallNode(IRVariable dest, IRType type, String funcName, Array<IREntity> args) {
    this.type = type;
    this.dest = dest;
    this.funcName = funcName;
    this.args = args;
  }

  @Override
  public String toString() {
    return (dest == null ? "" : dest.getValue() + " = ") + "call " + type.toString() + " @" + funcName + "("
        + args.toString(", ") + ")";
  }
  
  @Override
  public <T> T accept(IRVisitor<T> visitor) throws BaseError {
    return visitor.visit(this);
  }
}
