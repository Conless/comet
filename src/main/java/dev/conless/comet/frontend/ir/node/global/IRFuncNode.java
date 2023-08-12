package dev.conless.comet.frontend.ir.node.global;

import dev.conless.comet.frontend.ir.entity.IRVariable;
import dev.conless.comet.frontend.ir.node.IRNode;
import dev.conless.comet.frontend.ir.node.inst.IRAllocaNode;
import dev.conless.comet.frontend.ir.node.inst.IRCallNode;
import dev.conless.comet.frontend.ir.node.inst.IRInstNode;
import dev.conless.comet.frontend.ir.node.inst.IRJumpNode;
import dev.conless.comet.frontend.ir.node.inst.IRStoreNode;
import dev.conless.comet.frontend.ir.node.utils.IRCommentNode;
import dev.conless.comet.frontend.ir.node.utils.IRExprNode;
import dev.conless.comet.frontend.ir.node.utils.IRTagNode;
import dev.conless.comet.frontend.ir.type.IRType;
import dev.conless.comet.frontend.utils.scope.GlobalScope;
import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.container.Map;
import dev.conless.comet.utils.error.RuntimeError;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IRFuncNode extends IRNode {
  private String name;
  private Array<IRVariable> params;
  private IRType returnType;
  private IRExprNode nodes;

  public IRFuncNode(String name, Array<IRVariable> params, IRType returnType) {
    this.name = name;
    this.params = params;
    this.returnType = returnType;
    this.nodes = new IRExprNode();

    addNode(new IRCommentNode("The definition of function " + name));
    addNode(new IRTagNode("entry"));
    if (name.equals("main")) {
      addNode(new IRCallNode(GlobalScope.irVoidType, "__global_var_init", new Array<>()));
    }
    for (var param : params) {
      if (!param.getName().endsWith(".param")) {
        throw new RuntimeError("Invalid parameter name: " + param.getName());
      }
      var paramPtr = new IRVariable(GlobalScope.irPtrType, param.getValue().replace(".param", ""), false);
      addNode(new IRAllocaNode(paramPtr, param.getType()));
      addNode(new IRStoreNode(new IRVariable(param.getType(), param.getValue(), false), paramPtr));
    }
  }

  public void addNode(IRNode node) {
    nodes.addNode(node);
  }
  @Override
  public String toString() {
    String str = "define " + returnType.toString() + " @" + name + "(";
    str += params.toString(".param, ") + ") {\n";
    for (var node : nodes.getNodes()) {
      if (node instanceof IRInstNode) {
        str += "  ";
      }
      str += node.toString() + "\n";
    }
    str += "}";
    return str;
  }
}
