package dev.conless.comet.frontend.ir.node.inst;

import dev.conless.comet.frontend.ir.entity.IREntity;
import dev.conless.comet.frontend.ir.type.IRType;
import dev.conless.comet.frontend.utils.scope.GlobalScope;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = true)
public final class IRReturnNode extends IRInstNode {
  private IRType type;
  private IREntity value;

  public IRReturnNode() {
    this.type = GlobalScope.irVoidType;
    this.value = null;
  }

  public IRReturnNode(IREntity value) {
    this.type = value.getType();
    this.value = value;
  }

  @Override
  public String toString() {
    return "ret " + type.toString() + (this.value != null ? (" " + value.getValue()) : "");
  }
}
