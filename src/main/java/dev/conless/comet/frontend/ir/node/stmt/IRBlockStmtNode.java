package dev.conless.comet.frontend.ir.node.stmt;

import dev.conless.comet.frontend.ir.IRVisitor;
import dev.conless.comet.frontend.ir.entity.IRVariable;
import dev.conless.comet.frontend.ir.node.inst.IRInstNode;
import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.container.Set;
import dev.conless.comet.utils.error.BaseError;

@lombok.Getter
@lombok.Setter
public class IRBlockStmtNode extends IRStmtNode {
  private String labelName;
  private IRInstNode exitInst;

  // For CFG
  private Array<IRBlockStmtNode> predecessors;
  private Array<IRBlockStmtNode> successors;

  // For Liveness Analysis
  private Set<IRVariable> defs;
  private Set<IRVariable> uses;
  private Set<IRVariable> liveIn;
  private Set<IRVariable> liveOut;

  public IRBlockStmtNode(String labelName) {
    this.labelName = labelName;
    this.exitInst = null;
    this.predecessors = new Array<>();
    this.successors = new Array<>();
  }

  public void addPrev(IRBlockStmtNode node) {
    predecessors.add(node);
  }

  public void addNext(IRBlockStmtNode node) {
    successors.add(node);
  }

  @Override
  public String toString() {
    return labelName + ":\n" + getNodes().toString("  ", "\n", "\n") + "  " + exitInst.toString();
  }

  @Override
  public <T> T accept(IRVisitor<T> visitor) throws BaseError {
    return visitor.visit(this);
  }
}
