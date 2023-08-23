package dev.conless.comet.backend.asm.node.stmt;

import dev.conless.comet.backend.asm.entity.ASMReg;
import dev.conless.comet.backend.asm.node.ASMNode;
import dev.conless.comet.backend.asm.node.inst.ASMInstNode;
import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.error.RuntimeError;

@lombok.Getter
@lombok.Setter
public class ASMStmtsNode extends ASMNode {
  private Array<ASMInstNode> nodes;
  private ASMReg dest;

  public ASMStmtsNode() {
    nodes = new Array<>();
  }

  public void addNode(ASMInstNode node) {
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
