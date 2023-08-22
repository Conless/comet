package dev.conless.comet.backend.asm;

import dev.conless.comet.backend.asm.entity.ASMAddress;
import dev.conless.comet.backend.asm.node.*;
import dev.conless.comet.backend.asm.node.inst.*;
import dev.conless.comet.backend.asm.node.stmt.*;
import dev.conless.comet.backend.asm.node.utils.ASMCommentNode;
import dev.conless.comet.backend.asm.node.utils.ASMLabelNode;
import dev.conless.comet.frontend.ir.*;
import dev.conless.comet.frontend.ir.entity.IREntity;
import dev.conless.comet.frontend.ir.entity.IRLiteral;
import dev.conless.comet.frontend.ir.entity.IRVariable;
import dev.conless.comet.frontend.ir.node.*;
import dev.conless.comet.frontend.ir.node.def.*;
import dev.conless.comet.frontend.ir.node.inst.*;
import dev.conless.comet.frontend.ir.node.utils.*;
import dev.conless.comet.utils.error.*;

public class ASMBuilder extends ASMManager implements IRVisitor<ASMNode> {
  @Override
  public ASMNode visit(IRNode node) throws BaseError {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'visit'");
  }

  @Override
  public ASMNode visit(IRRoot node) throws BaseError {
    return null;
  }

  @Override
  public ASMNode visit(IRFuncDefNode node) throws BaseError {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'visit'");
  }

  @Override
  public ASMNode visit(IRGlobalDefNode node) throws BaseError {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'visit'");
  }

  @Override
  public ASMNode visit(IRStrDefNode node) throws BaseError {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'visit'");
  }

  @Override
  public ASMNode visit(IRAllocaNode node) throws BaseError {
    return new ASMStmtsNode();
  }

  @Override
  public ASMNode visit(IRArithNode node) throws BaseError {
    var instList = new ASMStmtsNode();
    var lhsInst = (ASMStmtsNode) node.getLhs().accept(this); // regAddr can be freed immediately, reg can be freed after
                                                             // operation
    instList.addNode(lhsInst);
    var lhsReg = lhsInst.getDest();
    if (lhsInst.getDestAddr() != null) {
      regs.evictReg(lhsInst.getDestAddr().getBase());
    }
    var rhsInst = (ASMStmtsNode) node.getRhs().accept(this); // regAddr can be freed immediately, reg can be freed after
                                                             // operation
    instList.addNode(rhsInst);
    var rhsReg = rhsInst.getDest();
    if (rhsInst.getDestAddr() != null) {
      regs.evictReg(rhsInst.getDestAddr().getBase());
    }
    var destInst = (ASMStmtsNode) node.getDest().accept(this); // reg can be freed immediately, regAddr can be freed
                                                               // after operation
    instList.addNode(destInst);
    var destRegAddr = destInst.getDestAddr();
    if (destInst.getDest() != null) {
      regs.evictReg(destInst.getDest());
    }
    var value = regs.getTempReg(); // freed after store
    var op = node.getOp();
    if (!node.isComparison()) {
      switch (op) {
        case "add" -> instList.addNode(new ASMBinaryNode("add", value, lhsReg, rhsReg));
        case "sub" -> instList.addNode(new ASMBinaryNode("sub", value, lhsReg, rhsReg));
        case "mul" -> instList.addNode(new ASMBinaryNode("mul", value, lhsReg, rhsReg));
        case "sdiv" -> instList.addNode(new ASMBinaryNode("div", value, lhsReg, rhsReg));
        case "srem" -> instList.addNode(new ASMBinaryNode("rem", value, lhsReg, rhsReg));
        case "shl" -> instList.addNode(new ASMBinaryNode("sll", value, lhsReg, rhsReg));
        case "ashr" -> instList.addNode(new ASMBinaryNode("sra", value, lhsReg, rhsReg));
        case "and" -> instList.addNode(new ASMBinaryNode("and", value, lhsReg, rhsReg));
        case "or" -> instList.addNode(new ASMBinaryNode("or", value, lhsReg, rhsReg));
        case "xor" -> instList.addNode(new ASMBinaryNode("xor", value, lhsReg, rhsReg));
        default -> throw new RuntimeError("Unknown arithmetic operation '" + op + "'");
      }
    } else {
      switch (op) {
        case "eq" -> {
          instList.addNode(new ASMBinaryNode("xor", value, lhsReg, rhsReg));
          instList.addNode(new ASMUnaryNode("seqz", value, value));
        }
        case "ne" -> {
          instList.addNode(new ASMBinaryNode("xor", value, lhsReg, rhsReg));
          instList.addNode(new ASMUnaryNode("snez", value, value));
        }
        case "slt" -> instList.addNode(new ASMBinaryNode("slt", value, lhsReg, rhsReg));
        case "sle" -> {
          instList.addNode(new ASMBinaryNode("slt", value, lhsReg, rhsReg));
          instList.addNode(new ASMUnaryNode("seqz", value, value));
        }
        case "sgt" -> {
          instList.addNode(new ASMBinaryNode("slt", value, lhsReg, rhsReg));
          instList.addNode(new ASMUnaryNode("seqz", value, value));
        }
        case "sge" -> instList.addNode(new ASMBinaryNode("slt", value, lhsReg, rhsReg));
        default -> throw new RuntimeError("Unknown comparison operation '" + op + "'");
      }
    }
    regs.evictReg(lhsReg, rhsReg);
    instList.addNode(new ASMStoreNode(value, destRegAddr));
    regs.evictReg(value, destRegAddr.getBase());
    return instList;
  }

  @Override
  public ASMNode visit(IRBranchNode node) throws BaseError { // notice that the first label of IRBranchNode would be the
                                                             // next node of it
    var instList = new ASMStmtsNode();
    var condInst = (ASMStmtsNode) node.getCondition().accept(this); // regAddr can be freed immediately, reg can be
                                                                    // freed after branch
    instList.addNode(condInst);
    var condReg = condInst.getDest();
    if (condInst.getDestAddr() != null) {
      regs.evictReg(condInst.getDestAddr().getBase());
    }
    instList.addNode(new ASMBeqzNode(condReg, getLabelName(node.getFalseLabel())));
    regs.evictReg(condReg);
    return instList;
  }

  @Override
  public ASMNode visit(IRCallNode node) throws BaseError {
    var instList = new ASMStmtsNode();
    var funcName = node.getFuncName();
    var args = node.getArgs();
    var stackOffset = 0;
    for (var arg : args) {
      var argInst = (ASMStmtsNode) arg.accept(this); // regAddr can be freed immediately, reg can be freed after call
      instList.addNode(argInst);
      var argReg = argInst.getDest();
      if (argInst.getDestAddr() != null) {
        regs.evictReg(argInst.getDestAddr().getBase());
      }
      try {
        var reg = regs.getArgReg();
        instList.addNode(new ASMMoveNode(reg, argReg));
      } catch (RuntimeError e) {
        instList.addNode(new ASMStoreNode(argReg, new ASMAddress(regs.getSp(), -4 * (++stackOffset))));
        regs.evictReg(argReg);
      }
    }
    instList.addNode(new ASMUnaryNode("addi", regs.getSp(), regs.getSp(), -4 * stackOffset));
    instList.addNode(new ASMCallNode(funcName));
    regs.resetArgRegs();
    if (stackOffset > 0) {
      var sp = regs.getSp();
      instList.addNode(new ASMUnaryNode("addi", sp, sp, stackOffset * 4));
    }
    if (node.getDest() != null) {
      var destInst = (ASMStmtsNode) node.getDest().accept(this); // reg can be freed immediately, regAddr can be freed
                                                                 // after call
      instList.addNode(destInst);
      var destRegAddr = destInst.getDestAddr();
      if (destInst.getDest() != null) {
        regs.evictReg(destInst.getDest());
      }
      var rv = regs.getRv();
      instList.addNode(new ASMStoreNode(rv, destRegAddr));
      regs.evictReg(rv);
    }
    return instList;
  }

  @Override
  public ASMNode visit(IRGetElementPtrNode node) throws BaseError {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'visit'");
  }

  @Override
  public ASMNode visit(IRJumpNode node) throws BaseError {
    var instList = new ASMStmtsNode();
    instList.addNode(new ASMJumpNode(getLabelName(node.getLabel())));
    return instList;
  }

  @Override
  public ASMNode visit(IRLoadNode node) throws BaseError { // %dest = load type, %src -> lw %dest, 0(%src)
    var instList = new ASMStmtsNode();
    var srcInst = (ASMStmtsNode) node.getSrc().accept(this); // regAddr can be freed immediately, reg can be freed after
                                                             // loading
    instList.addNode(srcInst);
    var srcReg = srcInst.getDest();
    if (srcInst.getDestAddr() != null) {
      regs.evictReg(srcInst.getDestAddr().getBase());
    }
    var destInst = (ASMStmtsNode) node.getDest().accept(this); // reg can be freed immediately, regAddr can be freed
                                                               // after storing
    instList.addNode(destInst);
    var destAddr = destInst.getDestAddr();
    if (destInst.getDest() != null) {
      regs.evictReg(destInst.getDest());
    }
    var valueReg = regs.getTempReg(); // intermidiate reg, freed after storing
    instList.addNode(new ASMLoadNode(valueReg, new ASMAddress(srcReg, 0)));
    regs.evictReg(srcReg);
    instList.addNode(new ASMStoreNode(valueReg, destAddr));
    regs.evictReg(valueReg, destAddr.getBase());
    return instList;
  }

  @Override
  public ASMNode visit(IRPhiNode node) throws BaseError {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'visit'");
  }

  @Override
  public ASMNode visit(IRReturnNode node) throws BaseError {
    var instList = new ASMStmtsNode();
    var valueInst = (ASMStmtsNode) node.getValue().accept(this);
    instList.addNode(valueInst);
    var valueReg = valueInst.getDest();
    if (valueInst.getDestAddr() != null) {
      regs.evictReg(valueInst.getDestAddr().getBase());
    }
    instList.addNode(new ASMMoveNode(valueReg, regs.getRv()));
    regs.evictReg(valueReg);
    instList.addNode(new ASMReturnNode());
    return instList;
  }

  @Override
  public ASMNode visit(IRStoreNode node) throws BaseError { // store %src, %dest -> sw %src, 0(%dest)
    var instList = new ASMStmtsNode();
    var srcInst = (ASMStmtsNode) node.getSrc().accept(this); // regAddr can be freed immediately, reg can be freed after
                                                             // storing
    instList.addNode(srcInst);
    var srcReg = srcInst.getDest();
    if (srcInst.getDestAddr() != null) {
      regs.evictReg(srcInst.getDestAddr().getBase());
    }
    var destInst = (ASMStmtsNode) node.getDest().accept(this); // reg can be freed immediately, regAddr can be freed
                                                               // after storing
    instList.addNode(destInst);
    var destAddr = destInst.getDestAddr();
    if (destInst.getDest() != null) {
      regs.evictReg(destInst.getDest());
    }
    instList.addNode(new ASMStoreNode(srcReg, destAddr));
    regs.evictReg(srcReg, destAddr.getBase());
    return instList;

  }

  @Override
  public ASMNode visit(IRCommentNode node) throws BaseError {
    var instList = new ASMStmtsNode();
    instList.addNode(new ASMCommentNode(node.getComment()));
    return instList;
  }

  @Override
  public ASMNode visit(IRCustomNode node) throws BaseError {
    return null;
  }

  @Override
  public ASMNode visit(IRLabelNode node) throws BaseError {
    var instList = new ASMStmtsNode();
    instList.addNode(new ASMLabelNode(getLabelName(node.getName())));
    return instList;
  }

  @Override
  public ASMNode visit(IREntity node) throws BaseError {
    throw new RuntimeError("ASMBuilder.visit(IREntity) should not be called");
  }

  @Override
  public ASMNode visit(IRVariable node) throws BaseError {
    var addrReg = regs.getTempReg();
    var destReg = regs.getTempReg();
    var instList = new ASMStmtsNode();
    if (node.isGlobal()) {
      instList.addNode(new ASMLoadAddrNode(addrReg, node.getValue().substring(1)));
      instList.addNode(new ASMLoadNode(destReg, new ASMAddress(addrReg, 0)));
      instList.setDest(destReg);
      instList.setDestAddr(new ASMAddress(addrReg, 0));
    } else if (node.getValue().endsWith(".param")) {
      var addr = counter.offsetMap.get(node.getValue());
      if (!(addr.getBase()).equals(regs.getSp())) {
        instList.addNode(new ASMMoveNode(addrReg, addr.getBase()));
        instList.addNode(new ASMLoadNode(destReg, new ASMAddress(addrReg, addr.getOffset())));
        instList.setDest(destReg);
        instList.setDestAddr(new ASMAddress(addrReg, addr.getOffset()));
      } else {
        instList.addNode(new ASMLoadNode(destReg, addr));
        instList.setDest(destReg);
        instList.setDestAddr(addr);
      }
    } else {
      var addr = counter.offsetMap.get(node.getValue());
      instList.addNode(new ASMLoadNode(destReg, addr));
      instList.setDest(destReg);
      instList.setDestAddr(addr);
    }
    return instList;
  }

  @Override
  public ASMNode visit(IRLiteral node) throws BaseError {
    var destReg = regs.getTempReg();
    var instList = new ASMStmtsNode();
    instList.addNode(new ASMLoadImmNode(destReg, Integer.valueOf(node.getValue())));
    instList.setDest(destReg);
    return instList;
  }
}
