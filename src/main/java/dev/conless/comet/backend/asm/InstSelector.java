package dev.conless.comet.backend.asm;

import dev.conless.comet.backend.asm.entity.ASMAddress;
import dev.conless.comet.backend.asm.entity.ASMVirtualReg;
import dev.conless.comet.backend.asm.node.*;
import dev.conless.comet.backend.asm.node.global.ASMFuncDefNode;
import dev.conless.comet.backend.asm.node.global.ASMStrDefNode;
import dev.conless.comet.backend.asm.node.global.ASMVarDefNode;
import dev.conless.comet.backend.asm.node.inst.*;
import dev.conless.comet.backend.asm.node.stmt.*;
import dev.conless.comet.backend.asm.node.utils.ASMCommentNode;
import dev.conless.comet.backend.asm.node.utils.ASMLabelNode;
import dev.conless.comet.backend.asm.utils.ASMCounter;
import dev.conless.comet.backend.asm.utils.ASMManager;
import dev.conless.comet.frontend.ir.*;
import dev.conless.comet.frontend.ir.entity.IREntity;
import dev.conless.comet.frontend.ir.entity.IRLiteral;
import dev.conless.comet.frontend.ir.entity.IRVariable;
import dev.conless.comet.frontend.ir.node.*;
import dev.conless.comet.frontend.ir.node.def.*;
import dev.conless.comet.frontend.ir.node.inst.*;
import dev.conless.comet.frontend.ir.node.utils.*;
import dev.conless.comet.frontend.ir.type.IRStructType;
import dev.conless.comet.utils.container.Pair;
import dev.conless.comet.utils.error.*;

public class InstSelector extends ASMManager implements IRVisitor<ASMNode> {
  @Override
  public ASMNode visit(IRNode node) throws BaseError {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'visit'");
  }

  @Override
  public ASMNode visit(IRRoot node) throws BaseError {
    var root = new ASMRoot();
    for (var def : node.getDefs()) {
      if (def instanceof IRStrDefNode) {
        root.getStrs().add((ASMStrDefNode) def.accept(this));
      } else {
        var varDef = (ASMVarDefNode) def.accept(this);
        if (varDef != null) {
          root.getVars().add(varDef);
        }
      }
    }
    for (var func : node.getFuncs()) {
      root.getFuncs().add((ASMFuncDefNode) func.accept(this));
    }
    return root;
  }

  @Override
  public ASMNode visit(IRFuncDefNode node) throws BaseError {
    var func = new ASMFuncDefNode(node.getName());
    counter = new ASMCounter();
    var paramCount = 0;
    var paramSum = node.getParams().size();
    for (var param : node.getParams()) {
      if (paramCount < 8) {
        counter.param2Addr.put(param.getValue(), new ASMAddress(regs.getArgRegs().get(paramCount), 0));
      } else {
        counter.param2Addr.put(param.getValue(), new ASMAddress(regs.getS0(), 4 * (paramSum - paramCount + 1)));
      }
    }
    ASMVirtualReg.resetCount();
    for (var inst : node.getBody().getNodes()) {
      var instList = (ASMStmtsNode) inst.accept(this);
      func.getBody().appendNodes(instList);
    }
    func.setMemUsed(new Pair<>(counter.allocaCount, ASMVirtualReg.getCount()));
    return func;
  }

  @Override
  public ASMNode visit(IRGlobalDefNode node) throws BaseError {
    if (node.getVar().getType() instanceof IRStructType) {
      return null;
    }
    return new ASMVarDefNode(node.getVar().getValue().substring(1), 0);
  }

  @Override
  public ASMNode visit(IRStrDefNode node) throws BaseError {
    var str = node.getOrgValue()
      .replace("\\", "\\\\")
      .replace("\n", "\\n")
      .replace("\0", "")
      .replace("\t", "\\t")
      .replace("\"", "\\\"");
    return new ASMStrDefNode(node.getVar().getValue().substring(1), str);
  }

  @Override
  public ASMNode visit(IRAllocaNode node) throws BaseError {
    var instList = new ASMStmtsNode();
    instList.addNode(new ASMCommentNode(node.toString()));
    var destInst = (ASMStmtsNode) node.getDest().accept(this);
    instList.addNode(new ASMUnaryNode("addi", destInst.getDest(), regs.getSp(), 4 * (counter.allocaCount++)));
    return instList;
  }

  @Override
  public ASMNode visit(IRArithNode node) throws BaseError {
    var instList = new ASMStmtsNode();
    instList.addNode(new ASMCommentNode(node.toString()));
    var lhsInst = (ASMStmtsNode) node.getLhs().accept(this);
    instList.appendNodes(lhsInst);
    var lhsReg = lhsInst.getDest();
    var rhsInst = (ASMStmtsNode) node.getRhs().accept(this);
    instList.appendNodes(rhsInst);
    var rhsReg = rhsInst.getDest();
    var destInst = (ASMStmtsNode) node.getDest().accept(this);
    instList.appendNodes(destInst);
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
          var ltReg = new ASMVirtualReg();
          var eqReg = new ASMVirtualReg();
          instList.addNode(new ASMBinaryNode("sub", ltReg, lhsReg, rhsReg));
          instList.addNode(new ASMUnaryNode("seqz", eqReg, ltReg));
          instList.addNode(new ASMBinaryNode("slt", ltReg, ltReg, regs.getZero()));
          instList.addNode(new ASMBinaryNode("or", destReg, ltReg, eqReg));
        }
        case "sge" -> {
          var gtReg = new ASMVirtualReg();
          var eqReg = new ASMVirtualReg();
          instList.addNode(new ASMBinaryNode("sub", gtReg, rhsReg, lhsReg));
          instList.addNode(new ASMUnaryNode("seqz", eqReg, gtReg));
          instList.addNode(new ASMBinaryNode("slt", gtReg, gtReg, regs.getZero()));
          instList.addNode(new ASMBinaryNode("or", destReg, gtReg, eqReg));
        }
        case "sgt" -> instList.addNode(new ASMBinaryNode("slt", destReg, lhsReg, rhsReg));
        default -> throw new RuntimeError("Unknown comparison operation '" + op + "'");
      }
    }
    return instList;
  }

  @Override
  public ASMNode visit(IRBranchNode node) throws BaseError { // notice that the first label of IRBranchNode would be the
                                                             // next node of it
    var instList = new ASMStmtsNode();
    instList.addNode(new ASMCommentNode(node.toString()));
    var condInst = (ASMStmtsNode) node.getCondition().accept(this); // regAddr can be freed immediately, reg can be
                                                                    // freed after branch
    instList.appendNodes(condInst);
    var condReg = condInst.getDest();
    instList.addNode(new ASMBeqzNode(condReg, getLabelName(node.getFalseLabel())));
    instList.addNode(new ASMJumpNode(getLabelName(node.getTrueLabel())));
    return instList;
  }

  @Override
  public ASMNode visit(IRCallNode node) throws BaseError {
    var instList = new ASMStmtsNode();
    instList.addNode(new ASMCommentNode(node.toString()));
    instList.addNode(new ASMStoreNode(regs.getRa(), new ASMAddress(regs.getSp(), -4)));
    var args = node.getArgs();
    var argCount = 0;
    var stackOffset = 1;
    for (var arg : args) {
      var argInst = (ASMStmtsNode) arg.accept(this); // regAddr can be freed immediately, reg can be freed after call
      instList.appendNodes(argInst);
      var argReg = argInst.getDest();
      if (argCount < 6) {
        instList.addNode(new ASMMoveNode(argReg, regs.getArgRegs().get(argCount++)));
      } else {
        instList.addNode(new ASMStoreNode(argReg, new ASMAddress(regs.getSp(), -4 * (++stackOffset))));
      }
    }
    instList.addNode(new ASMUnaryNode("addi", regs.getSp(), regs.getSp(), -4 * stackOffset));
    instList.addNode(new ASMCallNode(node.getFuncName()));
    instList.addNode(new ASMUnaryNode("addi", regs.getSp(), regs.getSp(), stackOffset * 4));
    if (node.getDest() != null) {
      var destInst = (ASMStmtsNode) node.getDest().accept(this); // reg can be freed immediately, regAddr can be freed
                                                                 // after call
      instList.appendNodes(destInst);
      var destReg = destInst.getDest();
      var rv = regs.getA0();
      instList.addNode(new ASMMoveNode(rv, destReg));
    }
    instList.addNode(new ASMLoadNode(regs.getRa(), new ASMAddress(regs.getSp(), -4)));
    return instList;
  }

  @Override
  public ASMNode visit(IRGetElementPtrNode node) throws BaseError {
    var instList = new ASMStmtsNode();
    instList.addNode(new ASMCommentNode(node.toString()));
    var srcInst = (ASMStmtsNode) node.getSrc().accept(this);
    instList.appendNodes(srcInst);
    var srcReg = srcInst.getDest();
    var dereference = false;
    for (var index : node.getIndices()) {
      if (dereference) {
        instList.addNode(new ASMLoadNode(srcReg, new ASMAddress(srcReg, 0)));
      } else {
        dereference = true;
      }
      var indexInst = (ASMStmtsNode) index.accept(this);
      instList.appendNodes(indexInst);
      var indexReg = indexInst.getDest();
      instList.addNode(new ASMUnaryNode("slli", indexReg, indexReg, 2));
      instList.addNode(new ASMBinaryNode("add", srcReg, srcReg, indexReg));
    }
    var destInst = (ASMStmtsNode) node.getDest().accept(this);
    instList.appendNodes(destInst);
    var destReg = destInst.getDest();
    instList.addNode(new ASMMoveNode(srcReg, destReg));
    return instList;
  }

  @Override
  public ASMNode visit(IRJumpNode node) throws BaseError {
    var instList = new ASMStmtsNode();
    instList.addNode(new ASMCommentNode(node.toString()));
    instList.addNode(new ASMJumpNode(getLabelName(node.getLabel())));
    return instList;
  }

  @Override
  public ASMNode visit(IRLoadNode node) throws BaseError { // %dest = load type, %src -> lw %dest, 0(%src)
    var instList = new ASMStmtsNode();
    instList.addNode(new ASMCommentNode(node.toString()));
    var srcInst = (ASMStmtsNode) node.getSrc().accept(this);
    instList.appendNodes(srcInst);
    var srcReg = srcInst.getDest();
    var destInst = (ASMStmtsNode) node.getDest().accept(this);
    instList.appendNodes(destInst);
    var destReg = destInst.getDest();
    instList.addNode(new ASMLoadNode(destReg, new ASMAddress(srcReg, 0)));
    return instList;
  }

  @Override
  public ASMNode visit(IRPhiNode node) throws BaseError {
    throw new RuntimeError("ASMBuilder.visit(IRPhiNode) should not be called");
  }

  @Override
  public ASMNode visit(IRReturnNode node) throws BaseError {
    var instList = new ASMStmtsNode();
    instList.addNode(new ASMCommentNode(node.toString()));
    if (node.getValue() != null) {
      var valueInst = (ASMStmtsNode) node.getValue().accept(this);
      instList.appendNodes(valueInst);
      var valueReg = valueInst.getDest();
      instList.addNode(new ASMMoveNode(valueReg, regs.getA0()));
    }
    instList.addNode(new ASMReturnNode());
    return instList;
  }

  @Override
  public ASMNode visit(IRStoreNode node) throws BaseError { // store "%"src, %dest -> sw %src, 0(%dest)
    var instList = new ASMStmtsNode();
    instList.addNode(new ASMCommentNode(node.toString()));
    var srcInst = (ASMStmtsNode) node.getSrc().accept(this);
    instList.appendNodes(srcInst);
    var srcReg = srcInst.getDest();
    var destInst = (ASMStmtsNode) node.getDest().accept(this); // reg can be freed immediately, regAddr can be freed
                                                               // after storing
    instList.appendNodes(destInst);
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
    throw new RuntimeError("ASMBuilder.visit(IRCustomNode) should not be called");
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
      instList.setDest(destReg);
    } else {
      var existReg = counter.name2reg.get(node.getValue());
      if (existReg != null) {
        instList.setDest(existReg);
        return instList;
      } else {
        var destReg = new ASMVirtualReg();
        counter.name2reg.put(node.getValue(), destReg);
        instList.setDest(destReg);
      }
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
