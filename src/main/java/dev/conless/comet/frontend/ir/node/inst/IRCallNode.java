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
public final class IRCallNode extends IRInstNode {
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
  public IRVariable getDef() {
    return dest;
  }

  @Override
  public Array<IRVariable> getUses() {
    var uses = new Array<IRVariable>();
    for (var arg : args) {
      if (arg instanceof IRVariable) {
        uses.add((IRVariable) arg);
      }
    }
    return uses;
  }

  @Override
  public String toString() {
    String str = (dest == null ? "" : dest.getValue() + " = ") + "call " + type.toString();
    if (funcName.equals("__array_alloca")) {
      str += " (i32, i32, i32, ...)";
    }
    str += " @" + funcName + "(" + args.toString(", ") + ")";
    return str;
  }

  @Override
  public <T> T accept(IRVisitor<T> visitor) throws BaseError {
    return visitor.visit(this);
  }
}
