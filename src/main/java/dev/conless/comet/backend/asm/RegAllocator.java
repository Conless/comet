package dev.conless.comet.backend.asm;

import dev.conless.comet.backend.asm.entity.ASMPhysicalReg;
import dev.conless.comet.backend.asm.entity.ASMVirtualReg;
import dev.conless.comet.backend.asm.node.ASMNode;
import dev.conless.comet.backend.asm.node.stmt.ASMStmtsNode;

public interface RegAllocator extends ASMVisitor<ASMNode> {
  public ASMPhysicalReg getRValueReg(ASMVirtualReg reg, ASMStmtsNode nodes);
  public ASMPhysicalReg getLValueReg(ASMVirtualReg reg);
  public void evictReg(ASMStmtsNode nodes, ASMPhysicalReg... dirtyRegs);
}
