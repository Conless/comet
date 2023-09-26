package dev.conless.comet.backend.asm.node.stmt;

import dev.conless.comet.backend.asm.ASMVisitor;
import dev.conless.comet.backend.asm.entity.ASMVirtualReg;
import dev.conless.comet.backend.asm.node.utils.ASMCommentNode;
import dev.conless.comet.backend.asm.node.utils.ASMLabelNode;
import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.container.Set;
import dev.conless.comet.utils.error.RuntimeError;

@lombok.Getter
@lombok.Setter
public class ASMBlockStmtNode extends ASMStmtNode implements Comparable<ASMBlockStmtNode> {
  private ASMLabelNode label;
  private ASMStmtNode exitInst;
  private Set<ASMVirtualReg> uses;
  private Set<ASMVirtualReg> defs;
  private Array<ASMBlockStmtNode> predecessors;
  private Array<ASMBlockStmtNode> successors;
  private Set<ASMVirtualReg> liveIn;
  private Set<ASMVirtualReg> liveOut;

  public ASMBlockStmtNode(ASMLabelNode label) {
    this.label = label;
    this.exitInst = new ASMStmtNode();
    this.uses = new Set<>();
    this.defs = new Set<>();
    this.predecessors = new Array<>();
    this.successors = new Array<>();
    this.liveIn = new Set<>();
    this.liveOut = new Set<>();
  }

  @Override
  public String toString() {
    var str = label.toString() + "\n";
    for (var node : getInsts()) {
      if (node instanceof ASMLabelNode) {
        throw new RuntimeError("ASMLabelNode should not appear in ASMBlockStmtNode");
      }
      if (node instanceof ASMCommentNode) {
        str += node.toString() + "\n";
      } else {
        str += "  " + node.toString() + "\n";
      }
    }
    for (var node : exitInst.getInsts()) {
      if (node instanceof ASMCommentNode) {
        str += node.toString() + "\n";
      } else {
        str += "  " + node.toString() + "\n";
      }
    }
    return str;
  }

  @Override
  public <T> T accept(ASMVisitor<T> visitor) {
    return visitor.visit(this);
  }

  @Override
  public int compareTo(ASMBlockStmtNode o) {
    return label.getLabel().compareTo(o.getLabel().getLabel());
  }
}
