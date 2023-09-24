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
  private Array<IRInstNode> insts;
  private IREntity dest;
  private IRVariable destAddr;

  public IRStmtNode() {
    insts = new Array<>();
  }

  public IRStmtNode(IREntity dest) {
    this.dest = dest;
    insts = new Array<>();
  }

  public IRStmtNode(Array<IRInstNode> nodes) {
    this.insts = nodes;
  }

  public void addInst(IRInstNode node) {
    insts.add(node);
  }

  public void addFront(IRInstNode node) {
    insts.add(0, node);
  }

  public void appendInsts(IRStmtNode nodes) {
    this.insts.addAll(nodes.getInsts());
  }

  public void appendFront(IRStmtNode nodes) {
    this.insts.addAll(0, nodes.getInsts());
  }
  
  public String getLastLabel() {
    for (var i = insts.size() - 1; i >= 0; --i) {
      if (insts.get(i) instanceof IRLabelNode) {
        return ((IRLabelNode) insts.get(i)).getName();
      }
    }
    return null;
  }

  @Override
  public String toString() {
    throw new RuntimeError("IRStmtsNode.toString() is not implemented");
  }
}
