package dev.conless.comet.frontend.ir.node.global;

import dev.conless.comet.frontend.ir.node.IRNode;
import dev.conless.comet.frontend.utils.scope.GlobalScope;
import dev.conless.comet.utils.container.Array;

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
    str += "\n\n";
    str += funcs.toString("\n\n");
    str += "\n";
    return str;
  }
  
}
