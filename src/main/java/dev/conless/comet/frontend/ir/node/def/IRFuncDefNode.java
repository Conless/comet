package dev.conless.comet.frontend.ir.node.def;

import dev.conless.comet.frontend.ir.IRVisitor;
import dev.conless.comet.frontend.ir.entity.IRVariable;
import dev.conless.comet.frontend.ir.node.IRNode;
import dev.conless.comet.frontend.ir.node.inst.IRAllocaNode;
import dev.conless.comet.frontend.ir.node.inst.IRCallNode;
import dev.conless.comet.frontend.ir.node.inst.IRInstNode;
import dev.conless.comet.frontend.ir.node.inst.IRReturnNode;
import dev.conless.comet.frontend.ir.node.inst.IRStoreNode;
import dev.conless.comet.frontend.ir.node.stmt.IRBlockStmtNode;
import dev.conless.comet.frontend.ir.node.stmt.IRStmtNode;
import dev.conless.comet.frontend.ir.node.utils.IRCommentNode;
import dev.conless.comet.frontend.ir.node.utils.IRLabelNode;
import dev.conless.comet.frontend.ir.type.IRType;
import dev.conless.comet.frontend.utils.scope.GlobalScope;
import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.container.Map;
import dev.conless.comet.utils.error.BaseError;
import dev.conless.comet.utils.error.RuntimeError;

@lombok.Getter
@lombok.Setter
public class IRFuncDefNode extends IRNode {
  private String name;
  private Array<IRVariable> params;
  private IRType returnType;
  private Array<IRBlockStmtNode> blocks;
  Map<IRBlockStmtNode, Integer> block2order = new Map<>();
  Array<IRBlockStmtNode> order2block = new Array<>();

  public IRFuncDefNode(String name, Array<IRVariable> params, IRType returnType, Array<IRBlockStmtNode> blocks) {
    this.name = name;
    this.params = params;
    this.returnType = returnType;
    this.blocks = blocks;

    var entryBlock = blocks.get(0);
    if (!entryBlock.getLabelName().equals("entry")) {
      throw new RuntimeError("First block must be entry");
    }
    if (params.size() > 0) {
      var instList = new IRStmtNode();
      for (var param : params) {
        if (!param.getValue().endsWith(".param")) {
          throw new RuntimeError("Invalid parameter name: " + param.getValue());
        }
        var paramPtr = new IRVariable(GlobalScope.irPtrType, param.getValue().replace(".param", ""));
        instList.addInst(new IRAllocaNode(paramPtr, param.getType()));
        instList.addInst(new IRStoreNode(paramPtr, param));
      }
      entryBlock.appendFront(instList);
    }
  }

  @Override
  public String toString() {
    String str = "define " + returnType.toString() + " @" + name + "(";
    str += params.toString(", ") + ") {\n";
    str += blocks.toString("\n");
    str += "\n}";
    return str;
  }

  @Override
  public <T> T accept(IRVisitor<T> visitor) throws BaseError {
    return visitor.visit(this);
  }
}
