package dev.conless.comet.frontend.ir.node.def;

import dev.conless.comet.frontend.ir.node.IRNode;
import dev.conless.comet.frontend.ir.type.IRType;
import dev.conless.comet.utils.container.Array;

@lombok.Value
@lombok.EqualsAndHashCode(callSuper = true)
public class IRClassDefNode extends IRNode {
  private Array<IRType> vars;
  private Array<IRFuncDefNode> funcs;

  public IRClassDefNode(Array<IRType> vars, Array<IRFuncDefNode> funcs) {
    this.vars = vars;
    this.funcs = funcs;
  }

  @Override
  public String toString() {
    return null;
  }
}
