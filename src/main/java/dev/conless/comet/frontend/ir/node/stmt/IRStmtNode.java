package dev.conless.comet.frontend.ir.node.stmt;

import dev.conless.comet.frontend.ir.entity.IREntity;
import dev.conless.comet.frontend.ir.entity.IRVariable;
import dev.conless.comet.frontend.ir.node.IRNode;
import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.error.RuntimeError;

@lombok.Getter
@lombok.Setter
public class IRStmtNode extends IRNode {
  private Array<IRNode> nodes;
  private IREntity dest;
  private IRVariable destAddr;

  public IRStmtNode() {
    nodes = new Array<>();
  }

  public IRStmtNode(IREntity dest) {
    this.dest = dest;
    nodes = new Array<>();
  }

  public IRStmtNode(Array<IRNode> nodes) {
    this.nodes = nodes;
  }

  public void addNode(IRNode node) {
    if (node instanceof IRStmtNode) {
      throw new RuntimeError("Cannot add IRStmtsNode in function");
    }
    nodes.add(node);
  }

  public void appendNodes(IRStmtNode nodes) {
    this.nodes.addAll(nodes.getNodes());
  }

  @Override
  public String toString() {
    throw new RuntimeError("IRStmtsNode.toString() is not implemented");
  }
}
