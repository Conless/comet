package dev.conless.comet.frontend.ir.node.global;

import dev.conless.comet.frontend.ir.IRVisitor;
import dev.conless.comet.frontend.ir.node.IRNode;
import dev.conless.comet.frontend.ir.node.utils.IRCustomNode;
import dev.conless.comet.frontend.utils.scope.GlobalScope;
import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.error.BaseError;
import lombok.*;

@Getter
@Setter
public class IRProgramNode extends IRNode {
  private Array<IRGlobalDefNode> defs;
  private Array<IRFuncDefNode> funcs;

  public IRProgramNode() {
    defs = new Array<>();
    funcs = new Array<>();
  }

  public void addDef(IRGlobalDefNode def) {
    defs.add(def);
  }

  public void addFunc(IRFuncDefNode func) {
    funcs.add(func);
  }

  @Override
  public String toString() {
    String str = defs.toString("\n");
    str += "\n\n";
    str += GlobalScope.irBuiltInFuncs.toString("\n");
    str += "\n";
    str += new IRCustomNode("declare ptr @__array_alloca(i32, i32, i32, ...)\n");
    str += "\n";
    str += funcs.toString("\n\n");
    str += "\n";
    return str;
  }
  
  @Override
  public <T> T accept(IRVisitor<T> visitor) throws BaseError {
    return visitor.visit(this);
  }
}
