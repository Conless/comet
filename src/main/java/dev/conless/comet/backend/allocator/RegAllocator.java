package dev.conless.comet.backend.allocator;

import dev.conless.comet.backend.asm.ASMVisitor;
import dev.conless.comet.backend.asm.entity.ASMAddress;
import dev.conless.comet.backend.asm.entity.ASMPhysicalReg;
import dev.conless.comet.backend.asm.entity.ASMReg;
import dev.conless.comet.backend.asm.node.ASMNode;
import dev.conless.comet.backend.asm.node.global.ASMStrDefNode;
import dev.conless.comet.backend.asm.node.global.ASMVarDefNode;
import dev.conless.comet.backend.asm.node.inst.ASMBeqzNode;
import dev.conless.comet.backend.asm.node.inst.ASMBinaryNode;
import dev.conless.comet.backend.asm.node.inst.ASMCallNode;
import dev.conless.comet.backend.asm.node.inst.ASMInstNode;
import dev.conless.comet.backend.asm.node.inst.ASMJumpNode;
import dev.conless.comet.backend.asm.node.inst.ASMLoadAddrNode;
import dev.conless.comet.backend.asm.node.inst.ASMLoadImmNode;
import dev.conless.comet.backend.asm.node.inst.ASMLoadNode;
import dev.conless.comet.backend.asm.node.inst.ASMMoveNode;
import dev.conless.comet.backend.asm.node.inst.ASMReturnNode;
import dev.conless.comet.backend.asm.node.inst.ASMStoreNode;
import dev.conless.comet.backend.asm.node.inst.ASMUnaryNode;
import dev.conless.comet.backend.asm.node.stmt.ASMBlockStmtNode;
import dev.conless.comet.backend.asm.node.stmt.ASMStmtNode;
import dev.conless.comet.backend.asm.node.utils.ASMCommentNode;
import dev.conless.comet.backend.asm.node.utils.ASMLabelNode;
import dev.conless.comet.backend.asm.utils.ASMManager;
import dev.conless.comet.utils.error.RuntimeError;

public abstract class RegAllocator extends ASMManager implements ASMVisitor<ASMNode> {
  @Override
  public ASMNode visit(ASMBlockStmtNode node) {
    var stmts = new ASMStmtNode();
    for (var inst : node.getInsts()) {
      var newStmt = inst.accept(this);
      if (newStmt instanceof ASMStmtNode newStmts) {
        stmts.appendInsts(newStmts);
      } else {
        stmts.addInst((ASMInstNode) newStmt);
      }
    }
    node.setInsts(stmts.getInsts());
    var exitInst = new ASMStmtNode();
    for (var inst : node.getExitInst().getInsts()) {
      var newStmt = inst.accept(this);
      if (newStmt instanceof ASMStmtNode newStmts) {
        exitInst.appendInsts(newStmts);
      } else {
        exitInst.addInst((ASMInstNode) newStmt);
      }
    }
    node.setExitInst(exitInst);
    return node;
  }

  @Override
  public ASMNode visit(ASMStrDefNode node) {
    throw new RuntimeError("BasicAllocator.visit(ASMStrDefNode) should not be called");
  }

  @Override
  public ASMNode visit(ASMVarDefNode node) {
    throw new RuntimeError("BasicAllocator.visit(ASMVarDefNode) should not be called");
  }

  @Override
  public ASMNode visit(ASMBeqzNode node) {
    var instList = new ASMStmtNode();
    var reg = getRValueReg(node.getEntity(), instList);
    node.setEntity(reg);
    instList.addInst(node);
    evictReg(instList, reg);
    return instList;
  }

  @Override
  public ASMNode visit(ASMBinaryNode node) {
    var instList = new ASMStmtNode();
    var lhs = getRValueReg(node.getLhs(), instList);
    var rhs = getRValueReg(node.getRhs(), instList);
    var dest = getLValueReg(node.getDest());
    node.setLhs(lhs);
    node.setRhs(rhs);
    node.setDest(dest);
    instList.addInst(node);
    evictReg(instList, lhs, rhs, dest);
    return instList;
  }

  @Override
  public ASMNode visit(ASMCallNode node) {
    currentFunc.getUsedRegs().add(regs.getRa());
    return node;
  }

  @Override
  public ASMNode visit(ASMJumpNode node) {
    return node;
  }

  @Override
  public ASMNode visit(ASMLoadAddrNode node) {
    var instList = new ASMStmtNode();
    var dest = getLValueReg(node.getDest());
    node.setDest(dest);
    instList.addInst(node);
    evictReg(instList, dest);
    return instList;
  }

  @Override
  public ASMNode visit(ASMLoadImmNode node) {
    var instList = new ASMStmtNode();
    var dest = getLValueReg(node.getDest());
    node.setDest(dest);
    instList.addInst(node);
    evictReg(instList, dest);
    return instList;
  }

  @Override
  public ASMNode visit(ASMLoadNode node) {
    var instList = new ASMStmtNode();
    var dest = getLValueReg(node.getDest());
    var addr = getRValueReg(node.getSrc().getBase(), instList);
    node.setDest(dest);
    node.setSrc(new ASMAddress(addr, node.getSrc().getOffset()));
    instList.addInst(node);
    evictReg(instList, dest, addr);
    return instList;
  }

  @Override
  public ASMNode visit(ASMMoveNode node) {
    var instList = new ASMStmtNode();
    var src = getRValueReg(node.getSrc(), instList);
    var dest = getLValueReg(node.getDest());
    node.setSrc(src);
    node.setDest(dest);
    instList.addInst(node);
    evictReg(instList, src, dest);
    return instList;
  }

  @Override
  public ASMNode visit(ASMReturnNode node) {
    return node;
  }

  @Override
  public ASMNode visit(ASMStoreNode node) {
    var instList = new ASMStmtNode();
    var src = getRValueReg(node.getSrc(), instList);
    var dest = getRValueReg(node.getDest().getBase(), instList);
    node.setSrc(src);
    node.setDest(new ASMAddress(dest, node.getDest().getOffset()));
    instList.addInst(node);
    evictReg(instList, src, dest);
    return instList;
  }

  @Override
  public ASMNode visit(ASMUnaryNode node) {
    var instList = new ASMStmtNode();
    var src = getRValueReg(node.getOperand(), instList);
    var dest = getLValueReg(node.getDest());
    node.setOperand(src);
    node.setDest(dest);
    instList.addInst(node);
    evictReg(instList, src, dest);
    return instList;
  }

  @Override
  public ASMNode visit(ASMCommentNode node) {
    return node;
  }

  @Override
  public ASMNode visit(ASMLabelNode node) {
    return node;
  }

  public abstract ASMPhysicalReg getRValueReg(ASMReg reg, ASMStmtNode nodes);

  public abstract ASMPhysicalReg getLValueReg(ASMReg reg);

  public abstract void evictReg(ASMStmtNode nodes, ASMPhysicalReg... dirtyRegs);
}
