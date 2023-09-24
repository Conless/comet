package dev.conless.comet.backend.allocator;

import dev.conless.comet.backend.asm.ASMVisitor;
import dev.conless.comet.backend.asm.entity.ASMAddress;
import dev.conless.comet.backend.asm.entity.ASMPhysicalReg;
import dev.conless.comet.backend.asm.entity.ASMReg;
import dev.conless.comet.backend.asm.entity.ASMVirtualReg;
import dev.conless.comet.backend.asm.node.*;
import dev.conless.comet.backend.asm.node.global.*;
import dev.conless.comet.backend.asm.node.inst.*;
import dev.conless.comet.backend.asm.node.stmt.ASMBlockStmtNode;
import dev.conless.comet.backend.asm.node.stmt.ASMStmtNode;
import dev.conless.comet.backend.asm.node.utils.*;
import dev.conless.comet.backend.asm.utils.ASMManager;
import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.container.Set;
import dev.conless.comet.utils.error.*;

public class BasicAllocator extends RegAllocator {
  private Set<ASMPhysicalReg> cleanRegs;

  public BasicAllocator() {
    cleanRegs = new Set<>();
    for (var reg : regs.getTempRegs()) {
      cleanRegs.add(reg);
    }
  }

  @Override
  public ASMNode visit(ASMNode node) {
    throw new RuntimeError("BasicAllocator.visit(ASMNode) should not be called");
  }

  @Override
  public ASMNode visit(ASMRoot node) {
    var funcs = new Array<ASMFuncDefNode>();
    for (var func : node.getFuncs()) {
      funcs.add((ASMFuncDefNode) func.accept(this));
    }
    node.setFuncs(funcs);
    return node;
  }

  @Override
  public ASMNode visit(ASMFuncDefNode node) {
    var blocks = new Array<ASMBlockStmtNode>();
    currentFunc = node;
    for (var stmt : node.getBlocks()) {
      blocks.add((ASMBlockStmtNode) stmt.accept(this));
    }
    node.setBlocks(blocks);
    return node;
  }

  @Override
  public ASMPhysicalReg getRValueReg(ASMReg reg, ASMStmtNode insts) {
    if (reg instanceof ASMPhysicalReg) {
      return (ASMPhysicalReg) reg;
    }
    var newReg = cleanRegs.pollFirst();
    if (newReg == null) {
      throw new RuntimeError("No more clean registers");
    }
    insts.addInst(
        new ASMLoadNode(newReg, new ASMAddress(regs.getSp(), 4 * ((ASMVirtualReg) reg).getID())));
    currentFunc.getUsedRegs().add(newReg);
    return newReg;
  }

  @Override
  public ASMPhysicalReg getLValueReg(ASMReg reg) {
    if (reg instanceof ASMPhysicalReg) {
      return (ASMPhysicalReg) reg;
    }
    var newReg = cleanRegs.pollFirst();
    if (newReg == null) {
      throw new RuntimeError("No more clean registers");
    }
    newReg.setDirty(true);
    newReg.setVirtualID(((ASMVirtualReg) reg).getID());
    currentFunc.getUsedRegs().add(newReg);
    currentFunc.setSpilled(Math.max(currentFunc.getSpilled(), ((ASMVirtualReg) reg).getID() + 1));
    return newReg;
  }

  @Override
  public void evictReg(ASMStmtNode insts, ASMPhysicalReg... dirtyRegs) {
    for (var reg : dirtyRegs) {
      if (!regs.getTempRegs().contains(reg)) {
        continue;
      }
      if (reg.isDirty()) {
        insts.addInst(new ASMStoreNode(reg, new ASMAddress(regs.getSp(), 4 * reg.getVirtualID())));
        reg.setDirty(false);
        reg.setVirtualID(-1);
      }
      cleanRegs.add(reg);
    }
  }
}
