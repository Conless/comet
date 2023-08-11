package dev.conless.comet.frontend.ir.node.inst;

import dev.conless.comet.frontend.ir.entity.IREntity;
import dev.conless.comet.frontend.ir.entity.IRVariable;
import dev.conless.comet.frontend.ir.node.IRInstNode;
import dev.conless.comet.frontend.ir.type.IRType;
import dev.conless.comet.utils.container.Array;

import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = true)
public final class IRCallNode extends IRInstNode {
  private IRVariable dest;
  private IRType type;
  private String funcName;
  private Array<IREntity> args;

  public IRCallNode(IRType type, String funcName, Array<IREntity> args) {
    this.type = type;
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
    return (dest == null ? "" : dest.getValue() + " = ") + "call " + type.toString() + " @" + funcName + "(" + args.toString() + ")";
  }
}
