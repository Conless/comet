package dev.conless.comet.frontend.ir.node.global;

import dev.conless.comet.frontend.ir.node.IRNode;
import dev.conless.comet.frontend.ir.type.IRType;
import dev.conless.comet.utils.container.Array;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IRFuncDeclareNode extends IRNode {
  private String name;
  private IRType returnType;
  private Array<IRType> params;

  public IRFuncDeclareNode(String name, IRType returnType, Array<IRType> params) {
    this.name = name;
    this.returnType = returnType;
    this.params = params;
  }

  @Override
  public String toString() {
    String str = "declare " + returnType.toString() + " @" + name + "(";
    for (int i = 0; i < params.size(); i++) {
      str += params.get(i);
      if (i != params.size() - 1) {
        str += ", ";
      }
    }
    str += ")";
    return str;
  }
}
