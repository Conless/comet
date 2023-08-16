package dev.conless.comet.frontend.ir.node.global;

import dev.conless.comet.frontend.ir.entity.IRLiteral;
import dev.conless.comet.frontend.ir.entity.IRVariable;
import dev.conless.comet.frontend.ir.node.IRNode;
import dev.conless.comet.frontend.ir.type.IRStructType;
import dev.conless.comet.frontend.utils.scope.GlobalScope;
import lombok.Getter;

@Getter
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
}
