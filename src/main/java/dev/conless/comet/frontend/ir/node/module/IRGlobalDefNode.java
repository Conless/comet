package dev.conless.comet.frontend.ir.node.module;

import dev.conless.comet.frontend.ir.node.IRBlockNode;
import dev.conless.comet.frontend.ir.node.IRModuleNode;
import dev.conless.comet.frontend.ir.node.inst.IRGlobalNode;
import dev.conless.comet.frontend.ir.node.inst.IRInstNode;
import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.error.RuntimeError;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IRGlobalDefNode extends IRModuleNode {
  private Array<IRGlobalNode> globals;

  public IRGlobalDefNode() {
    globals = new Array<>();
  }

  public void addInst(IRInstNode inst) {
    globals.add((IRGlobalNode) inst);
  }

  @Override
  public String getName() {
    return "globalDef";
  }

  @Override
  public IRBlockNode getBlock(String name) {
    throw new RuntimeError("GlobalDef has no block");
  }

  @Override
  public String toString() {
    var builder = new StringBuilder();
    builder.append("; The definition of global variables\n");
    for (var global : globals) {
      builder.append(global.toString()).append("\n");
    }
    return builder.toString();
  }
}
