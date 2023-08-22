package dev.conless.comet.frontend.ir.node.stmt;

import dev.conless.comet.frontend.ir.entity.IREntity;
import dev.conless.comet.frontend.ir.entity.IRVariable;
import dev.conless.comet.frontend.ir.node.IRNode;
import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.error.RuntimeError;

@lombok.Getter
@lombok.Setter
public class IRStmtsNode extends IRNode {
  private Array<IRNode> nodes;
  private IREntity dest;
  private IRVariable destAddr;

  public IRStmtsNode() {
    nodes = new Array<>();
  }

  public IRStmtsNode(IREntity dest) {
    this.dest = dest;
    nodes = new Array<>();
  }

  public IRStmtsNode(Array<IRNode> nodes) {
    this.nodes = nodes;
  }

  public void addNode(IRNode node) {
    if (node instanceof IRStmtsNode) {
      throw new RuntimeError("Cannot add IRStmtsNode in function");
    }
    nodes.add(node);
  }

  public void appendNodes(IRStmtsNode nodes) {
    this.nodes.addAll(nodes.getNodes());
  }

  @Override
  public String toString() {
    throw new RuntimeError("IRStmtsNode.toString() is not implemented");
  }
}
