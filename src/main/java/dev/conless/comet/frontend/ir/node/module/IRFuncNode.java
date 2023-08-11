package dev.conless.comet.frontend.ir.node.module;

import dev.conless.comet.frontend.ir.entity.IRVariable;
import dev.conless.comet.frontend.ir.node.IRBlockNode;
import dev.conless.comet.frontend.ir.node.IRModuleNode;
import dev.conless.comet.frontend.ir.node.inst.IRAllocaNode;
import dev.conless.comet.frontend.ir.node.inst.IRStoreNode;
import dev.conless.comet.frontend.ir.type.IRType;
import dev.conless.comet.frontend.utils.scope.GlobalScope;
import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.error.RuntimeError;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IRFuncNode extends IRModuleNode {
  private String name;
  private Array<IRVariable> params;
  private IRType returnType;

  public IRFuncNode(String name, Array<IRVariable> params, IRType returnType) {
    this.name = name;
    this.params = params;
    this.returnType = returnType;
    var entry = new IRBlockNode("entry");
    for (var param : params) {
      var paramPtr = new IRVariable(GlobalScope.irPtrType, param.getValue(), false);
      entry.addInst(new IRAllocaNode(paramPtr, returnType));
      entry.addInst(new IRStoreNode(new IRVariable(param.getType(), param.getValue() + ".param", false), paramPtr));
    }
    this.addBlock(entry);
  }

  public void generateEntry() {
    if (params == null) {
      throw new RuntimeError("No params in func");
    }
    
  }

  @Override
  public String toString() {
    String str = "define " + returnType.toString() + " @" + name + "(";
    str += params.toString(", ") + ") {\n";
    str += super.toString();
    str += "}\n";
    return str;
  }
}
