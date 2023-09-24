package dev.conless.comet.backend.allocator;

import dev.conless.comet.backend.asm.ASMVisitor;
import dev.conless.comet.backend.asm.entity.ASMPhysicalReg;
import dev.conless.comet.backend.asm.entity.ASMReg;
import dev.conless.comet.backend.asm.node.ASMNode;
import dev.conless.comet.backend.asm.node.stmt.ASMStmtNode;

public interface RegAllocator extends ASMVisitor<ASMNode> {
  public ASMPhysicalReg getRValueReg(ASMReg reg, ASMStmtNode nodes);
  public ASMPhysicalReg getLValueReg(ASMReg reg);
  public void evictReg(ASMStmtNode nodes, ASMPhysicalReg... dirtyRegs);
}
