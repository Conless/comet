package dev.conless.comet.backend.asm.node.stmt;

import dev.conless.comet.backend.asm.entity.ASMAddress;
import dev.conless.comet.backend.asm.entity.ASMRegister;
import dev.conless.comet.backend.asm.node.ASMNode;
import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.error.RuntimeError;

@lombok.Getter
@lombok.Setter
public class ASMStmtsNode extends ASMNode {
  private Array<ASMNode> nodes;
  private ASMRegister dest;
  private ASMAddress destAddr;

  public void addNode(ASMNode node) {
    nodes.add(node);
  }

  public void appendNodes(ASMStmtsNode nodes) {
    this.nodes.addAll(nodes.nodes);
  }
  
  @Override
  public String toString() {
    throw new RuntimeError("ASMStmtsNode.toString() is not implemented");
  }
}
