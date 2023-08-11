package dev.conless.comet.frontend.ir.node.inst;

import dev.conless.comet.frontend.ir.entity.IRVariable;
import dev.conless.comet.frontend.ir.node.IRInstNode;
import dev.conless.comet.frontend.ir.type.IRType;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = true)
public final class IRReturnNode extends IRInstNode {
  private IRType type;
  private IRVariable value;

  public IRReturnNode(IRType type, IRVariable value) {
    this.type = type;
    this.value = value;
  }

  @Override
  public String toString() {
    return "ret " + type.toString() + " " + value.getValue(); // TODO: void type
  }
}
