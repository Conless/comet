package dev.conless.comet.frontend.ir.node.inst;

import dev.conless.comet.frontend.ir.entity.IRVariable;
import dev.conless.comet.frontend.ir.node.IRInstNode;
import dev.conless.comet.frontend.ir.type.IRType;

import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = true)

public final class IRAllocaNode extends IRInstNode {
  private IRVariable dest;
  private IRType type;

  public IRAllocaNode(IRVariable dest, IRType type) {
    this.type = type;
    this.dest = dest;
  }

  @Override
  public String toString() {
    return dest.getValue() + " = alloca " + type.toString();
  }
}
