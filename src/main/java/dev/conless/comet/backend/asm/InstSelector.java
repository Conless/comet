package dev.conless.comet.backend.asm;

import dev.conless.comet.backend.asm.entity.ASMAddress;
import dev.conless.comet.backend.asm.entity.ASMVirtualReg;
import dev.conless.comet.backend.asm.node.*;
import dev.conless.comet.backend.asm.node.inst.*;
import dev.conless.comet.backend.asm.node.stmt.*;
import dev.conless.comet.backend.asm.node.utils.ASMCommentNode;
import dev.conless.comet.backend.asm.node.utils.ASMLabelNode;
import dev.conless.comet.backend.asm.utils.ASMManager;
import dev.conless.comet.frontend.ir.*;
import dev.conless.comet.frontend.ir.entity.IREntity;
import dev.conless.comet.frontend.ir.entity.IRLiteral;
import dev.conless.comet.frontend.ir.entity.IRVariable;
import dev.conless.comet.frontend.ir.node.*;
import dev.conless.comet.frontend.ir.node.def.*;
import dev.conless.comet.frontend.ir.node.inst.*;
import dev.conless.comet.frontend.ir.node.utils.*;
import dev.conless.comet.utils.error.*;

public class InstSelector extends ASMManager implements IRVisitor<ASMNode> {
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
    var lhsInst = (ASMStmtsNode) node.getLhs().accept(this);
    instList.addNode(lhsInst);
    var lhsReg = lhsInst.getDest();
    var rhsInst = (ASMStmtsNode) node.getRhs().accept(this);
    instList.addNode(rhsInst);
    var rhsReg = rhsInst.getDest();
    var destInst = (ASMStmtsNode) node.getDest().accept(this);
    instList.addNode(destInst);
    var destReg = (ASMVirtualReg) destInst.getDest();
    var op = node.getOp();
    if (!node.isComparison()) {
      switch (op) {
        case "add" -> instList.addNode(new ASMBinaryNode("add", destReg, lhsReg, rhsReg));
        case "sub" -> instList.addNode(new ASMBinaryNode("sub", destReg, lhsReg, rhsReg));
        case "mul" -> instList.addNode(new ASMBinaryNode("mul", destReg, lhsReg, rhsReg));
        case "sdiv" -> instList.addNode(new ASMBinaryNode("div", destReg, lhsReg, rhsReg));
        case "srem" -> instList.addNode(new ASMBinaryNode("rem", destReg, lhsReg, rhsReg));
        case "shl" -> instList.addNode(new ASMBinaryNode("sll", destReg, lhsReg, rhsReg));
        case "ashr" -> instList.addNode(new ASMBinaryNode("sra", destReg, lhsReg, rhsReg));
        case "and" -> instList.addNode(new ASMBinaryNode("and", destReg, lhsReg, rhsReg));
        case "or" -> instList.addNode(new ASMBinaryNode("or", destReg, lhsReg, rhsReg));
        case "xor" -> instList.addNode(new ASMBinaryNode("xor", destReg, lhsReg, rhsReg));
        default -> throw new RuntimeError("Unknown arithmetic operation '" + op + "'");
      }
    } else {
      switch (op) {
        case "eq" -> {
          instList.addNode(new ASMBinaryNode("xor", destReg, lhsReg, rhsReg));
          instList.addNode(new ASMUnaryNode("seqz", destReg, destReg));
        }
        case "ne" -> {
          instList.addNode(new ASMBinaryNode("xor", destReg, lhsReg, rhsReg));
          instList.addNode(new ASMUnaryNode("snez", destReg, destReg));
        }
        case "slt" -> instList.addNode(new ASMBinaryNode("slt", destReg, lhsReg, rhsReg));
        case "sle" -> {
          instList.addNode(new ASMBinaryNode("slt", destReg, lhsReg, rhsReg));
          instList.addNode(new ASMUnaryNode("seqz", destReg, destReg));
        }
        case "sgt" -> {
          instList.addNode(new ASMBinaryNode("slt", destReg, lhsReg, rhsReg));
          instList.addNode(new ASMUnaryNode("seqz", destReg, destReg));
        }
        case "sge" -> instList.addNode(new ASMBinaryNode("slt", destReg, lhsReg, rhsReg));
        default -> throw new RuntimeError("Unknown comparison operation '" + op + "'");
      }
    }
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
    instList.addNode(new ASMBeqzNode(condReg, getLabelName(node.getFalseLabel())));
    return instList;
  }

  @Override
  public ASMNode visit(IRCallNode node) throws BaseError {
    var instList = new ASMStmtsNode();
    var funcName = node.getFuncName();
    var args = node.getArgs();
    var argCount = 0;
    var stackOffset = 0;
    for (var arg : args) {
      var argInst = (ASMStmtsNode) arg.accept(this); // regAddr can be freed immediately, reg can be freed after call
      instList.addNode(argInst);
      var argReg = argInst.getDest();
      if (argCount < 6) {
        instList.addNode(new ASMMoveNode(argReg, regs.getArgRegs().get(argCount++)));
      } else {
        instList.addNode(new ASMStoreNode(argReg, new ASMAddress(regs.getSp(), -4 * (++stackOffset))));
      }
    }
    instList.addNode(new ASMUnaryNode("addi", regs.getSp(), regs.getSp(), -4 * stackOffset));
    instList.addNode(new ASMCallNode(funcName));
    if (stackOffset > 0) {
      var sp = regs.getSp();
      instList.addNode(new ASMUnaryNode("addi", sp, sp, stackOffset * 4));
    }
    if (node.getDest() != null) {
      var destInst = (ASMStmtsNode) node.getDest().accept(this); // reg can be freed immediately, regAddr can be freed
                                                                 // after call
      instList.addNode(destInst);
      var destReg = destInst.getDest();
      var rv = regs.getA0();
      instList.addNode(new ASMMoveNode(rv, destReg));
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
    var destInst = (ASMStmtsNode) node.getDest().accept(this); // reg can be freed immediately, regAddr can be freed
                                                               // after storing
    instList.addNode(destInst);
    var destReg = destInst.getDest();
    instList.addNode(new ASMLoadNode(destReg, new ASMAddress(srcReg, 0)));
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
    instList.addNode(new ASMMoveNode(valueReg, regs.getA0()));
    instList.addNode(new ASMReturnNode());
    return instList;
  }

  @Override
  public ASMNode visit(IRStoreNode node) throws BaseError { // store "%"src, %dest -> sw %src, 0(%dest)
    var instList = new ASMStmtsNode();
    var srcInst = (ASMStmtsNode) node.getSrc().accept(this); // regAddr can be freed immediately, reg can be freed after
                                                             // storing
    instList.addNode(srcInst);
    var srcReg = srcInst.getDest();
    var destInst = (ASMStmtsNode) node.getDest().accept(this); // reg can be freed immediately, regAddr can be freed
                                                               // after storing
    instList.addNode(destInst);
    var dest = destInst.getDest();
    instList.addNode(new ASMStoreNode(srcReg, new ASMAddress(dest, 0)));
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
    var instList = new ASMStmtsNode();
    if (node.getValue().endsWith(".param") && !(counter.param2Addr.get(node.getValue()).getBase()).equals(regs.getSp())) {
      var addr = counter.param2Addr.get(node.getValue());
      instList.setDest(addr.getBase());
      return instList;
    }
    if (node.isGlobal()) {
      var destReg = new ASMVirtualReg();
      instList.addNode(new ASMLoadAddrNode(destReg, node.getValue().substring(1)));
      instList.addNode(new ASMLoadNode(destReg, new ASMAddress(destReg, 0)));
      instList.setDest(destReg);
    } else {
      var existReg = counter.name2reg.get(node.getValue());
      if (existReg != null) {
        instList.setDest(existReg);
        return instList;
      }
      var addr = new ASMAddress(regs.getSp(), 4 * (--counter.stackCount));
      var destReg = new ASMVirtualReg();
      instList.addNode(new ASMLoadNode(destReg, addr));
      instList.setDest(destReg);
    }
    return instList;
  }

  @Override
  public ASMNode visit(IRLiteral node) throws BaseError {
    var instList = new ASMStmtsNode();
    var destReg = new ASMVirtualReg();
    instList.addNode(new ASMLoadImmNode(destReg, Integer.valueOf(node.getValue())));
    instList.setDest(destReg);
    return instList;
  }
}
