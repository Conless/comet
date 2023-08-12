package dev.conless.comet.frontend.ir.node.module;

import dev.conless.comet.frontend.ir.entity.IRVariable;
import dev.conless.comet.frontend.ir.node.IRBlockNode;
import dev.conless.comet.frontend.ir.node.IRModuleNode;
import dev.conless.comet.frontend.ir.type.IRStructNode;
import dev.conless.comet.frontend.ir.type.IRType;
import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.error.RuntimeError;
import lombok.Getter;

@Getter
public class IRClassDefNode extends IRModuleNode {
  private String name;
  private Array<IRVariable> vars;
  private Array<IRFuncNode> funcs;

  public IRClassDefNode(String name, Array<IRVariable> vars, Array<IRFuncNode> funcs) {
    this.name = "class." + name;
    this.vars = vars;
    this.funcs = funcs;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public IRBlockNode getBlock(String name) {
    throw new RuntimeError("GlobalDef has no block");
  }

  @Override
  public String toString() {
    String str = "; The definition of class " + name.replace("class.", "") + "\n";
    str += "type " + name + " = { ";
    boolean first = true;
    for (var var : vars) {
      if (first) {
        first = false;
      } else {
        str += ", ";
      }
      str += var.getType().toString();
    }
    str += " }\n";
    str += funcs.toString("\n");
    return str;
  }
}
