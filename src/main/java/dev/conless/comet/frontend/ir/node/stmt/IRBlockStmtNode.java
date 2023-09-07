package dev.conless.comet.frontend.ir.node.stmt;

import java.util.HashMap;
import java.util.HashSet;

import javax.print.DocFlavor.STRING;

import dev.conless.comet.frontend.ir.IRVisitor;
import dev.conless.comet.frontend.ir.entity.IREntity;
import dev.conless.comet.frontend.ir.entity.IRVariable;
import dev.conless.comet.frontend.ir.node.inst.IRInstNode;
import dev.conless.comet.frontend.ir.node.inst.IRPhiNode;
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
  private HashMap<IRVariable, IREntity> defs;
  private HashMap<IRVariable, IRVariable> uses;

  private IRBlockStmtNode idom;
  private HashSet<IRBlockStmtNode> children;
  private HashSet<IRBlockStmtNode> df;

  // For Phi
  private HashMap<String, IRPhiNode> phiMap;

  // For Liveness Analysis
  private Set<IRVariable> liveIn;
  private Set<IRVariable> liveOut;

  public IRBlockStmtNode(String labelName) {
    this.labelName = labelName;
    this.exitInst = null;
    this.predecessors = new Array<>();
    this.successors = new Array<>();
    this.defs = new HashMap<>();
    this.uses = new HashMap<>();
    this.children = new HashSet<>();
    this.df = new HashSet<>();
    this.phiMap = new HashMap<>();
  }

  public void addPrev(IRBlockStmtNode node) {
    predecessors.add(node);
  }

  public void addNext(IRBlockStmtNode node) {
    successors.add(node);
  }

  @Override
  public String toString() {
    var str = labelName + ":\n";
    for (var phi : phiMap.values()) {
      str += "  " + phi.toString() + "\n";
    }
    str += getNodes().toString("  ", "\n", "\n") + "  " + exitInst.toString();
    return str;
  }

  @Override
  public <T> T accept(IRVisitor<T> visitor) throws BaseError {
    return visitor.visit(this);
  }
}
