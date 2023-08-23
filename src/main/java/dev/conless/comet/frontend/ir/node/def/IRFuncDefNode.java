package dev.conless.comet.frontend.ir.node.def;

import dev.conless.comet.frontend.ir.IRVisitor;
import dev.conless.comet.frontend.ir.entity.IRVariable;
import dev.conless.comet.frontend.ir.node.IRNode;
import dev.conless.comet.frontend.ir.node.inst.IRAllocaNode;
import dev.conless.comet.frontend.ir.node.inst.IRCallNode;
import dev.conless.comet.frontend.ir.node.inst.IRReturnNode;
import dev.conless.comet.frontend.ir.node.inst.IRStoreNode;
import dev.conless.comet.frontend.ir.node.stmt.IRStmtNode;
import dev.conless.comet.frontend.ir.node.utils.IRCommentNode;
import dev.conless.comet.frontend.ir.node.utils.IRLabelNode;
import dev.conless.comet.frontend.ir.type.IRType;
import dev.conless.comet.frontend.utils.scope.GlobalScope;
import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.error.BaseError;
import dev.conless.comet.utils.error.RuntimeError;

@lombok.Getter
@lombok.Setter
public class IRFuncDefNode extends IRNode {
  private String name;
  private Array<IRVariable> params;
  private IRType returnType;
  private IRStmtNode body;

  public IRFuncDefNode(String name, Array<IRVariable> params, IRType returnType) {
    this.name = name;
    this.params = params;
    this.returnType = returnType;
    this.body = new IRStmtNode();

    addNode(new IRCommentNode("The definition of function " + name));
    addNode(new IRLabelNode("entry"));
    if (name.equals("main")) {
      addNode(new IRCallNode("global.var.init", new Array<>()));
    }
    for (var param : params) {
      if (!param.getValue().endsWith(".param")) {
        throw new RuntimeError("Invalid parameter name: " + param.getValue());
      }
      var paramPtr = new IRVariable(GlobalScope.irPtrType, param.getValue().replace(".param", ""));
      addNode(new IRAllocaNode(paramPtr, param.getType()));
      addNode(new IRStoreNode(paramPtr, param));
    }
  }

  public void addNode(IRNode node) {
    body.addNode(node);
  }
  @Override
  public String toString() {
    String str = "define " + returnType.toString() + " @" + name + "(";
    str += params.toString(", ") + ") {\n";
    var endNode = body.getNodes().get(body.getNodes().size() - 1);
    if (!(endNode instanceof IRReturnNode)) {
      body.addNode(new IRReturnNode(returnType));
    }
    for (var node : body.getNodes()) {
      if (!(node instanceof IRLabelNode)) {
        str += "  ";
      }
      str += node.toString() + "\n";
    }
    str += "}";
    return str;
  }

  @Override
  public <T> T accept(IRVisitor<T> visitor) throws BaseError {
    return visitor.visit(this);
  }
}
