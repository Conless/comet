package dev.conless.comet.frontend.ir.node.utils;

import dev.conless.comet.frontend.ir.entity.IREntity;
import dev.conless.comet.frontend.ir.node.IRNode;
import dev.conless.comet.utils.container.Array;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public final class IRExprNode extends IRNode {
  private Array<IRNode> nodes;
  private IREntity dest;

  public IRExprNode() {
    nodes = new Array<>();
  }

  public IRExprNode(Array<IRNode> nodes) {
    this.nodes = nodes;
  }

  public void addNode(IRNode node) {
    nodes.add(node);
  }

  public void appendNodes(IRExprNode nodes) {
    this.nodes.addAll(nodes.getNodes());
  }

  @Override
  public String toString() {
    return nodes.toString(" ", "\n");
  }
}
