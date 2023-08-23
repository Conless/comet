package dev.conless.comet.backend.asm.utils;

import dev.conless.comet.backend.asm.RegAllocator;
import dev.conless.comet.backend.asm.entity.ASMAddress;
import dev.conless.comet.backend.asm.entity.ASMPhysicalReg;
import dev.conless.comet.backend.asm.entity.ASMVirtualReg;
import dev.conless.comet.backend.asm.node.*;
import dev.conless.comet.backend.asm.node.global.*;
import dev.conless.comet.backend.asm.node.inst.*;
import dev.conless.comet.backend.asm.node.stmt.ASMStmtsNode;
import dev.conless.comet.backend.asm.node.utils.*;
import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.container.Map;
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
    var begin = new ASMStmtsNode();
    var end = new ASMStmtsNode();
    var totalMem = node.getMemUsed().a + node.getMemUsed().b + usedRegs.size();
    begin.addNode(new ASMMoveNode(regs.getSp(), regs.getS0()));
    begin.addNode(new ASMUnaryNode("addi", regs.getSp(), regs.getSp(), -4 * totalMem));
    end.addNode(new ASMUnaryNode("addi", regs.getSp(), regs.getSp(), 4 * totalMem));
    var regsCount = 0;
    for (var reg : usedRegs) {
      begin.addNode(new ASMStoreNode(reg, new ASMAddress(reg, -4 * (totalMem + regsCount++))));
      end.addNode(new ASMLoadNode(reg, new ASMAddress(reg, -4 * (totalMem + regsCount++))));
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
    var reg = getRValueReg((ASMVirtualReg) node.getEntity(), instList);
    node.setEntity(reg);
    evictReg(instList, reg);
    instList.addNode(node);
    return instList;
  }

  @Override
  public ASMNode visit(ASMBinaryNode node) {
    var instList = new ASMStmtsNode();
    var lhs = getRValueReg((ASMVirtualReg) node.getLhs(), instList);
    var rhs = getRValueReg((ASMVirtualReg) node.getRhs(), instList);
    var dest = getLValueReg((ASMVirtualReg) node.getDest());
    node.setLhs(lhs);
    node.setRhs(rhs);
    node.setDest(dest);
    evictReg(instList, lhs, rhs, dest);
    instList.addNode(node);
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
    var dest = getLValueReg((ASMVirtualReg) node.getDest());
    node.setDest(dest);
    evictReg(instList, dest);
    return node;
  }

  @Override
  public ASMNode visit(ASMLoadImmNode node) {
    var instList = new ASMStmtsNode();
    var dest = getLValueReg((ASMVirtualReg) node.getDest());
    node.setDest(dest);
    evictReg(instList, dest);
    return node;
  }

  @Override
  public ASMNode visit(ASMLoadNode node) {
    var instList = new ASMStmtsNode();
    var dest = getLValueReg((ASMVirtualReg) node.getDest());
    var addr = getRValueReg((ASMVirtualReg) node.getSrc().getBase(), instList);
    node.setDest(dest);
    node.setSrc(new ASMAddress(addr, node.getSrc().getOffset()));
    evictReg(instList, dest, addr);
    instList.addNode(node);
    return instList;
  }

  @Override
  public ASMNode visit(ASMMoveNode node) {
    var instList = new ASMStmtsNode();
    var src = getRValueReg((ASMVirtualReg) node.getSrc(), instList);
    var dest = getLValueReg((ASMVirtualReg) node.getDest());
    node.setSrc(src);
    node.setDest(dest);
    evictReg(instList, src, dest);
    instList.addNode(node);
    return instList;
  }

  @Override
  public ASMNode visit(ASMReturnNode node) {
    return node;
  }

  @Override
  public ASMNode visit(ASMStoreNode node) {
    var instList = new ASMStmtsNode();
    var src = getRValueReg((ASMVirtualReg) node.getSrc(), instList);
    var dest = getRValueReg((ASMVirtualReg) node.getDest().getBase(), instList);
    node.setSrc(src);
    node.setDest(new ASMAddress(dest, node.getDest().getOffset()));
    evictReg(instList, src, dest);
    instList.addNode(node);
    return instList;
  }

  @Override
  public ASMNode visit(ASMUnaryNode node) {
    var instList = new ASMStmtsNode();
    var src = getRValueReg((ASMVirtualReg) node.getOperand(), instList);
    var dest = getLValueReg((ASMVirtualReg) node.getDest());
    node.setOperand(src);
    node.setDest(dest);
    evictReg(instList, src, dest);
    instList.addNode(node);
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
  public ASMPhysicalReg getRValueReg(ASMVirtualReg reg, ASMStmtsNode nodes) {
    var newReg = cleanRegs.pollFirst();
    if (newReg == null) {
      throw new RuntimeError("No more clean registers");
    }
    usedRegs.add(newReg);
    nodes.addNode(new ASMLoadNode(newReg, new ASMAddress(regs.getSp(), 4 * (allocatedMem + reg.getID()))));
    return newReg;
  }

  @Override
  public ASMPhysicalReg getLValueReg(ASMVirtualReg reg) {
    var newReg = cleanRegs.pollFirst();
    if (newReg == null) {
      throw new RuntimeError("No more clean registers");
    }
    newReg.setDirty(true);
    newReg.setVirtualID(reg.getID());
    usedRegs.add(newReg);
    return newReg;
  }
  
  @Override
  public void evictReg(ASMStmtsNode nodes, ASMPhysicalReg... dirtyRegs) {
    for (var reg : dirtyRegs) {
      if (reg.isDirty()) {
        nodes.addNode(new ASMStoreNode(reg, new ASMAddress(regs.getSp(), 4 * (allocatedMem + reg.getVirtualID()))));
        reg.setDirty(false);
        reg.setVirtualID(-1);
      }
      cleanRegs.add(reg);
    }
  }
}
