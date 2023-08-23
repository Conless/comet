package dev.conless.comet.backend.asm;

import dev.conless.comet.backend.asm.entity.ASMPhysicalReg;
import dev.conless.comet.backend.asm.entity.ASMReg;
import dev.conless.comet.backend.asm.node.ASMNode;
import dev.conless.comet.backend.asm.node.stmt.ASMStmtsNode;

public interface RegAllocator extends ASMVisitor<ASMNode> {
  public ASMPhysicalReg getRValueReg(ASMReg reg, ASMStmtsNode nodes);
  public ASMPhysicalReg getLValueReg(ASMReg reg);
  public void evictReg(ASMStmtsNode nodes, ASMPhysicalReg... dirtyRegs);
}
