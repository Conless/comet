package dev.conless.comet.frontend.ir.node.stmt;

import dev.conless.comet.frontend.ir.entity.IREntity;
import dev.conless.comet.frontend.ir.entity.IRVariable;
import dev.conless.comet.frontend.ir.node.IRNode;
import dev.conless.comet.utils.container.Array;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
    nodes.add(node);
  }

  public void appendNodes(IRStmtNode nodes) {
    this.nodes.addAll(nodes.getNodes());
  }

  @Override
  public String toString() {
    return nodes.toString(" ", "\n");
  }
}
