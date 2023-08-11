package dev.conless.comet.frontend.ir.node.module;

import dev.conless.comet.frontend.ir.node.IRBlockNode;
import dev.conless.comet.frontend.ir.node.IRInstNode;
import dev.conless.comet.frontend.ir.node.IRModuleNode;
import dev.conless.comet.frontend.ir.type.IRType;
import dev.conless.comet.utils.error.RuntimeError;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IRGlobalDefNode extends IRModuleNode {
  private IRType type;
  private String name;

  public IRBlockNode getBlock() {
    if (getBlocks().size() == 0) {
      throw new RuntimeError("No block in global def");
    }
    return getBlocks().get(0);
  }

  public void addInst(IRInstNode inst) {
    getBlock().addInst(inst);
  }
}
