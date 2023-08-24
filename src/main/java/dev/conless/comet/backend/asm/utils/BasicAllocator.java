package dev.conless.comet.backend.asm.utils;

import dev.conless.comet.backend.asm.RegAllocator;
import dev.conless.comet.backend.asm.entity.ASMAddress;
import dev.conless.comet.backend.asm.entity.ASMPhysicalReg;
import dev.conless.comet.backend.asm.entity.ASMReg;
import dev.conless.comet.backend.asm.entity.ASMVirtualReg;
import dev.conless.comet.backend.asm.node.*;
import dev.conless.comet.backend.asm.node.global.*;
import dev.conless.comet.backend.asm.node.inst.*;
import dev.conless.comet.backend.asm.node.stmt.ASMStmtsNode;
import dev.conless.comet.backend.asm.node.utils.*;
import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.container.Set;
import dev.conless.comet.utils.error.*;

public class BasicAllocator extends ASMManager implements RegAllocator {
  public Set<ASMPhysicalReg> cleanRegs;

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
    var body = new ASMStmtsNode();
    usedRegs = new Set<>();
    allocatedMem = node.getMemUsed().a;
    for (var stmt : node.getBody().getNodes()) {
      var newStmt = stmt.accept(this);
      if (newStmt instanceof ASMStmtsNode) {
        body.appendNodes((ASMStmtsNode) newStmt);
      } else {
        body.addNode((ASMInstNode) newStmt);
      }
    }
    allocatedMem += node.getMemUsed().b;
    var begin = new ASMStmtsNode();
    var end = new ASMStmtsNode();
    var totalMem = allocatedMem + usedRegs.size();
    if (totalMem != 0) {
      begin.addNode(new ASMMoveNode(regs.getSp(), regs.getS0()));
      begin.addNode(new ASMUnaryNode("addi", regs.getSp(), regs.getSp(), -4 * totalMem));
      var regsCount = 0;
      for (var reg : usedRegs) {
        begin.addNode(new ASMStoreNode(reg, new ASMAddress(regs.getSp(), 4 * (allocatedMem + regsCount))));
        end.addNode(new ASMLoadNode(reg, new ASMAddress(regs.getSp(), 4 * (allocatedMem + regsCount))));
        regsCount++;
      }
      end.addNode(new ASMUnaryNode("addi", regs.getSp(), regs.getSp(), 4 * totalMem));
    }
    node.setBody(body);
    node.setStRegs(begin);
    node.setLdRegs(end);
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
    var instList = new ASMStmtsNode();
    var reg = getRValueReg(node.getEntity(), instList);
    node.setEntity(reg);
    instList.addNode(node);
    evictReg(instList, reg);
    return instList;
  }

  @Override
  public ASMNode visit(ASMBinaryNode node) {
    var instList = new ASMStmtsNode();
    var lhs = getRValueReg(node.getLhs(), instList);
    var rhs = getRValueReg(node.getRhs(), instList);
    var dest = getLValueReg(node.getDest());
    node.setLhs(lhs);
    node.setRhs(rhs);
    node.setDest(dest);
    instList.addNode(node);
    evictReg(instList, lhs, rhs, dest);
    return instList;
  }

  @Override
  public ASMNode visit(ASMCallNode node) {
    return node;
  }

  @Override
  public ASMNode visit(ASMJumpNode node) {
    return node;
  }

  @Override
  public ASMNode visit(ASMLoadAddrNode node) {
    var instList = new ASMStmtsNode();
    var dest = getLValueReg(node.getDest());
    node.setDest(dest);
    instList.addNode(node);
    evictReg(instList, dest);
    return instList;
  }

  @Override
  public ASMNode visit(ASMLoadImmNode node) {
    var instList = new ASMStmtsNode();
    var dest = getLValueReg(node.getDest());
    node.setDest(dest);
    instList.addNode(node);
    evictReg(instList, dest);
    return instList;
  }

  @Override
  public ASMNode visit(ASMLoadNode node) {
    var instList = new ASMStmtsNode();
    var dest = getLValueReg(node.getDest());
    var addr = getRValueReg(node.getSrc().getBase(), instList);
    node.setDest(dest);
    node.setSrc(new ASMAddress(addr, node.getSrc().getOffset()));
    instList.addNode(node);
    evictReg(instList, dest, addr);
    return instList;
  }

  @Override
  public ASMNode visit(ASMMoveNode node) {
    var instList = new ASMStmtsNode();
    var src = getRValueReg(node.getSrc(), instList);
    var dest = getLValueReg(node.getDest());
    node.setSrc(src);
    node.setDest(dest);
    instList.addNode(node);
    evictReg(instList, src, dest);
    return instList;
  }

  @Override
  public ASMNode visit(ASMReturnNode node) {
    return node;
  }

  @Override
  public ASMNode visit(ASMStoreNode node) {
    var instList = new ASMStmtsNode();
    var src = getRValueReg(node.getSrc(), instList);
    var dest = getRValueReg(node.getDest().getBase(), instList);
    node.setSrc(src);
    node.setDest(new ASMAddress(dest, node.getDest().getOffset()));
    instList.addNode(node);
    evictReg(instList, src, dest);
    return instList;
  }

  @Override
  public ASMNode visit(ASMUnaryNode node) {
    var instList = new ASMStmtsNode();
    var src = getRValueReg(node.getOperand(), instList);
    var dest = getLValueReg(node.getDest());
    node.setOperand(src);
    node.setDest(dest);
    instList.addNode(node);
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

  @Override
  public ASMPhysicalReg getRValueReg(ASMReg reg, ASMStmtsNode nodes) {
    if (reg instanceof ASMPhysicalReg) {
      return (ASMPhysicalReg) reg;
    }
    var newReg = cleanRegs.pollFirst();
    if (newReg == null) {
      throw new RuntimeError("No more clean registers");
    }
    usedRegs.add(newReg);
    nodes.addNode(new ASMLoadNode(newReg, new ASMAddress(regs.getSp(), 4 * (allocatedMem + ((ASMVirtualReg) reg).getID()))));
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
    usedRegs.add(newReg);
    return newReg;
  }
  
  @Override
  public void evictReg(ASMStmtsNode nodes, ASMPhysicalReg... dirtyRegs) {
    for (var reg : dirtyRegs) {
      if (!reg.getName().startsWith("t")) {
        continue;
      }
      if (reg.isDirty()) {
        nodes.addNode(new ASMStoreNode(reg, new ASMAddress(regs.getSp(), 4 * (allocatedMem + reg.getVirtualID()))));
        reg.setDirty(false);
        reg.setVirtualID(-1);
      }
      cleanRegs.add(reg);
    }
  }
}
