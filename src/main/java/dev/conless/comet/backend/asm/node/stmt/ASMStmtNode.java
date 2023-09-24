package dev.conless.comet.backend.asm.node.stmt;

import dev.conless.comet.backend.asm.entity.ASMReg;
import dev.conless.comet.backend.asm.node.ASMNode;
import dev.conless.comet.backend.asm.node.inst.ASMInstNode;
import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.error.RuntimeError;

@lombok.Getter
@lombok.Setter
public class ASMStmtNode extends ASMNode {
  private Array<ASMInstNode> insts;
  private ASMReg dest;

  public ASMStmtNode() {
    insts = new Array<>();
  }

  public void addInst(ASMInstNode inst) {
    insts.add(inst);
  }

  public void appendInsts(ASMStmtNode nodes) {
    this.insts.addAll(nodes.insts);
  }
  
  @Override
  public String toString() {
    throw new RuntimeError("ASMStmtsNode.toString() is not implemented");
  }
}
