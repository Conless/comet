package dev.conless.comet.frontend.ir.node.def;

import dev.conless.comet.frontend.ir.IRVisitor;
import dev.conless.comet.frontend.ir.entity.IRLiteral;
import dev.conless.comet.frontend.ir.entity.IRVariable;
import dev.conless.comet.frontend.ir.node.IRNode;
import dev.conless.comet.frontend.ir.type.IRStructType;
import dev.conless.comet.frontend.utils.scope.GlobalScope;
import dev.conless.comet.utils.error.BaseError;

@lombok.Getter
public class IRGlobalDefNode extends IRNode {
  private IRVariable var;

  public IRGlobalDefNode(IRVariable var) {
    this.var = var;
  }

  @Override
  public String toString() {
    String str = var.getValue() + " = global ";
    if (var.getType().equals(GlobalScope.irIntType) || var.getType().equals(GlobalScope.irBoolType)) {
      str += new IRLiteral(var.getType(), 0).toString();
    } else if (var.getType() instanceof IRStructType) {
      str = var.getValue() + " = type " + var.getType().toString();
    } else {
      str += "ptr null";
    }
    return str;
  }

  @Override
  public <T> T accept(IRVisitor<T> visitor) throws BaseError {
    return visitor.visit(this);
  }
}
