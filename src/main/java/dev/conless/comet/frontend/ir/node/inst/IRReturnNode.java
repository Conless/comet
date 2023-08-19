package dev.conless.comet.frontend.ir.node.inst;

import dev.conless.comet.frontend.ir.IRVisitor;
import dev.conless.comet.frontend.ir.entity.IREntity;
import dev.conless.comet.frontend.ir.entity.IRLiteral;
import dev.conless.comet.frontend.ir.node.IRNode;
import dev.conless.comet.frontend.ir.type.IRType;
import dev.conless.comet.frontend.utils.scope.GlobalScope;
import dev.conless.comet.utils.error.BaseError;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = true)
public final class IRReturnNode extends IRNode {
  private IRType type;
  private IREntity value;

  public IRReturnNode() {
    this.type = GlobalScope.irVoidType;
    this.value = null;
  }

  public IRReturnNode(IRType type) {
    if (type.equals(GlobalScope.irVoidType)) {
      this.type = GlobalScope.irVoidType;
      this.value = null;
    } else if (type.equals(GlobalScope.irPtrType)) {
      this.type = GlobalScope.irPtrType;
      this.value = new IRLiteral(GlobalScope.irPtrType, 0);
    } else {
      this.type = type;
      this.value = new IRLiteral(type, 0);
    }
  }

  public IRReturnNode(IREntity value) {
    this.type = value.getType();
    this.value = value;
  }

  @Override
  public String toString() {
    return "ret " + type.toString() + (this.value != null ? (" " + value.getValue()) : "");
  }

  @Override
  public <T> T accept(IRVisitor<T> visitor) throws BaseError {
    return visitor.visit(this);
  }
}
