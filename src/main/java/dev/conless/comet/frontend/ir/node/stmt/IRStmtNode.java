package dev.conless.comet.frontend.ir.node.stmt;

import dev.conless.comet.frontend.ir.entity.IREntity;
import dev.conless.comet.frontend.ir.entity.IRVariable;
import dev.conless.comet.frontend.ir.node.IRNode;
import dev.conless.comet.frontend.ir.node.inst.IRInstNode;
import dev.conless.comet.frontend.ir.node.utils.IRLabelNode;
import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.error.RuntimeError;

@lombok.Getter
@lombok.Setter
public class IRStmtNode extends IRNode {
  private Array<IRInstNode> nodes;
  private IREntity dest;
  private IRVariable destAddr;

  public IRStmtNode() {
    nodes = new Array<>();
  }

  public IRStmtNode(IREntity dest) {
    this.dest = dest;
    nodes = new Array<>();
  }

  public IRStmtNode(Array<IRInstNode> nodes) {
    this.nodes = nodes;
  }

  public void addNode(IRInstNode node) {
    nodes.add(node);
  }

  public void addFront(IRInstNode node) {
    nodes.add(0, node);
  }

  public void appendNodes(IRStmtNode nodes) {
    this.nodes.addAll(nodes.getNodes());
  }

  public void appendFront(IRStmtNode nodes) {
    this.nodes.addAll(0, nodes.getNodes());
  }
  
  public String getLastLabel() {
    for (var i = nodes.size() - 1; i >= 0; --i) {
      if (nodes.get(i) instanceof IRLabelNode) {
        return ((IRLabelNode) nodes.get(i)).getName();
      }
    }
    return null;
  }

  @Override
  public String toString() {
    throw new RuntimeError("IRStmtsNode.toString() is not implemented");
  }
}
