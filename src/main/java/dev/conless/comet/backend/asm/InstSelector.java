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
import dev.conless.comet.frontend.ir.node.stmt.IRBlockStmtNode;
import dev.conless.comet.frontend.ir.node.utils.*;
import dev.conless.comet.frontend.ir.type.IRStructType;
import dev.conless.comet.frontend.utils.scope.GlobalScope;
import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.container.Map;
import dev.conless.comet.utils.container.Pair;
import dev.conless.comet.utils.error.*;

public class InstSelector extends ASMManager implements IRVisitor<ASMNode> {
  @Override
  public ASMNode visit(IRNode node) throws BaseError {
    throw new RuntimeError("ASMBuilder.visit(IRNode) should not be called");
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
    var func = new ASMFuncDefNode(node.getName(), node.getParams().size());
    counter = new ASMCounter();
    name2Block = new Map<>();
    ASMVirtualReg.resetCount();
    var paramCount = 0;
    var paramSum = node.getParams().size();
    var initStmt = new ASMBlockStmtNode(new ASMLabelNode(node.getName()));
    for (var param : node.getParams()) {
      var paramInst = (ASMStmtNode) param.accept(this);
      var paramDest = paramInst.getDest();
      if (paramCount < 8) {
        initStmt.addInst(new ASMMoveNode(regs.getArgRegs().get(paramCount), paramDest));
      } else {
        initStmt.addInst(new ASMLoadNode(paramDest, new ASMAddress(regs.getT0(), 4 * (paramSum - paramCount + 1))));
      }
      paramCount++;
    }
    func.addBlock(initStmt);
    for (var block : node.getBlocks()) {
      func.addBlock((ASMBlockStmtNode) block.accept(this));
    }
    initStmt.getExitInst().addInst(new ASMJumpNode(func.getBlocks().get(1).getLabel().getLabel()));
    for (var block : node.getBlocks()) {
      for (var phi : block.getPhiMap().values()) {
        phi.accept(this);
      }
    }
    return func;
  }

  @Override
  public ASMNode visit(IRBlockStmtNode node) throws BaseError {
    var block = new ASMBlockStmtNode(new ASMLabelNode(getLabelName(node.getLabelName())));
    name2Block.put(node.getLabelName(), block);
    for (var inst : node.getInsts()) {
      block.appendInsts((ASMStmtNode) inst.accept(this));
    }
    block.setExitInst((ASMStmtNode) node.getExitInst().accept(this));
    return block;
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
    var instList = new ASMStmtNode();
    instList.addInst(new ASMCommentNode(node.toString()));
    var destInst = (ASMStmtNode) node.getDest().accept(this);
    instList.addInst(new ASMUnaryNode("addi", destInst.getDest(), regs.getSp(), 4 * (counter.allocaCount++)));
    return instList;
  }

  @Override
  public ASMNode visit(IRArithNode node) throws BaseError {
    var instList = new ASMStmtNode();
    instList.addInst(new ASMCommentNode(node.toString()));
    var lhsInst = (ASMStmtNode) node.getLhs().accept(this);
    instList.appendInsts(lhsInst);
    var lhsReg = lhsInst.getDest();
    var rhsInst = (ASMStmtNode) node.getRhs().accept(this);
    instList.appendInsts(rhsInst);
    var rhsReg = rhsInst.getDest();
    var destInst = (ASMStmtNode) node.getDest().accept(this);
    instList.appendInsts(destInst);
    var destReg = (ASMVirtualReg) destInst.getDest();
    var op = node.getOp();
    if (!node.isComparison()) {
      switch (op) {
        case "add" -> instList.addInst(new ASMBinaryNode("add", destReg, lhsReg, rhsReg));
        case "sub" -> instList.addInst(new ASMBinaryNode("sub", destReg, lhsReg, rhsReg));
        case "mul" -> instList.addInst(new ASMBinaryNode("mul", destReg, lhsReg, rhsReg));
        case "sdiv" -> instList.addInst(new ASMBinaryNode("div", destReg, lhsReg, rhsReg));
        case "srem" -> instList.addInst(new ASMBinaryNode("rem", destReg, lhsReg, rhsReg));
        case "shl" -> instList.addInst(new ASMBinaryNode("sll", destReg, lhsReg, rhsReg));
        case "ashr" -> instList.addInst(new ASMBinaryNode("sra", destReg, lhsReg, rhsReg));
        case "and" -> instList.addInst(new ASMBinaryNode("and", destReg, lhsReg, rhsReg));
        case "or" -> instList.addInst(new ASMBinaryNode("or", destReg, lhsReg, rhsReg));
        case "xor" -> instList.addInst(new ASMBinaryNode("xor", destReg, lhsReg, rhsReg));
        default -> throw new RuntimeError("Unknown arithmetic operation '" + op + "'");
      }
    } else {
      switch (op) {
        case "eq" -> {
          instList.addInst(new ASMBinaryNode("xor", destReg, lhsReg, rhsReg));
          instList.addInst(new ASMUnaryNode("seqz", destReg, destReg));
        }
        case "ne" -> {
          instList.addInst(new ASMBinaryNode("xor", destReg, lhsReg, rhsReg));
          instList.addInst(new ASMUnaryNode("snez", destReg, destReg));
        }
        case "slt" -> instList.addInst(new ASMBinaryNode("slt", destReg, lhsReg, rhsReg));
        case "sle" -> {
          var ltReg = new ASMVirtualReg();
          var eqReg = new ASMVirtualReg();
          instList.addInst(new ASMBinaryNode("sub", ltReg, lhsReg, rhsReg));
          instList.addInst(new ASMUnaryNode("seqz", eqReg, ltReg));
          instList.addInst(new ASMBinaryNode("slt", ltReg, ltReg, regs.getZero()));
          instList.addInst(new ASMBinaryNode("or", destReg, ltReg, eqReg));
        }
        case "sge" -> {
          var gtReg = new ASMVirtualReg();
          var eqReg = new ASMVirtualReg();
          instList.addInst(new ASMBinaryNode("sub", gtReg, rhsReg, lhsReg));
          instList.addInst(new ASMUnaryNode("seqz", eqReg, gtReg));
          instList.addInst(new ASMBinaryNode("slt", gtReg, gtReg, regs.getZero()));
          instList.addInst(new ASMBinaryNode("or", destReg, gtReg, eqReg));
        }
        case "sgt" -> instList.addInst(new ASMBinaryNode("slt", destReg, rhsReg, lhsReg));
        default -> throw new RuntimeError("Unknown comparison operation '" + op + "'");
      }
    }
    return instList;
  }

  @Override
  public ASMNode visit(IRBranchNode node) throws BaseError { // notice that the first label of IRBranchNode would be the
                                                             // next node of it
    var instList = new ASMStmtNode();
    instList.addInst(new ASMCommentNode(node.toString()));
    var condInst = (ASMStmtNode) node.getCondition().accept(this); // regAddr can be freed immediately, reg can be
                                                                   // freed after branch
    instList.appendInsts(condInst);
    var condReg = condInst.getDest();
    instList.addInst(new ASMBeqzNode(condReg, getLabelName(node.getFalseLabel())));
    instList.addInst(new ASMJumpNode(getLabelName(node.getTrueLabel())));
    return instList;
  }

  @Override
  public ASMNode visit(IRCallNode node) throws BaseError {
    var instList = new ASMStmtNode();
    instList.addInst(new ASMCommentNode(node.toString()));
    var args = node.getArgs();
    var argCount = 0;
    var stackOffset = 0;
    var isVoid = node.getType().equals(GlobalScope.irVoidType);
    for (var arg : args) {
      var argInst = (ASMStmtNode) arg.accept(this); // regAddr can be freed immediately, reg can be freed after call
      instList.appendInsts(argInst);
      var argReg = argInst.getDest();
      if (argCount < 8) {
        instList.addInst(new ASMMoveNode(argReg, regs.getArgRegs().get(argCount++)));
      } else {
        instList.addInst(new ASMStoreNode(argReg, new ASMAddress(regs.getSp(), -4 * (++stackOffset))));
      }
    }
    if (stackOffset != 0) {
      instList.addInst(new ASMUnaryNode("addi", regs.getSp(), regs.getSp(), -4 * stackOffset));
    }
    instList.addInst(new ASMCallNode(node.getFuncName()));
    if (stackOffset != 0) {
      instList.addInst(new ASMUnaryNode("addi", regs.getSp(), regs.getSp(), stackOffset * 4));
    }
    if (node.getDest() != null) {
      var destInst = (ASMStmtNode) node.getDest().accept(this); // reg can be freed immediately, regAddr can be freed
                                                                // after call
      instList.appendInsts(destInst);
      var destReg = destInst.getDest();
      instList.addInst(new ASMMoveNode(regs.getA0(), destReg));
    }
    
    return instList;
  }

  @Override
  public ASMNode visit(IRGetElementPtrNode node) throws BaseError {
    var instList = new ASMStmtNode();
    instList.addInst(new ASMCommentNode(node.toString()));
    var srcInst = (ASMStmtNode) node.getSrc().accept(this);
    instList.appendInsts(srcInst);
    var srcReg = srcInst.getDest();
    var destInst = (ASMStmtNode) node.getDest().accept(this);
    instList.appendInsts(destInst);
    var destReg = destInst.getDest();
    var indexInst = (ASMStmtNode) node.getIndices().getLast().accept(this);
    instList.appendInsts(indexInst);
    var indexReg = indexInst.getDest();
    var memIndexReg = new ASMVirtualReg();
    instList.addInst(new ASMUnaryNode("slli", memIndexReg, indexReg, 2));
    instList.addInst(new ASMBinaryNode("add", destReg, srcReg, memIndexReg));
    return instList;
  }

  @Override
  public ASMNode visit(IRJumpNode node) throws BaseError {
    var instList = new ASMStmtNode();
    instList.addInst(new ASMCommentNode(node.toString()));
    instList.addInst(new ASMJumpNode(getLabelName(node.getLabel())));
    return instList;
  }

  @Override
  public ASMNode visit(IRLoadNode node) throws BaseError { // %dest = load type, %src -> lw %dest, 0(%src)
    var instList = new ASMStmtNode();
    instList.addInst(new ASMCommentNode(node.toString()));
    var srcInst = (ASMStmtNode) node.getSrc().accept(this);
    instList.appendInsts(srcInst);
    var srcReg = srcInst.getDest();
    var destInst = (ASMStmtNode) node.getDest().accept(this);
    instList.appendInsts(destInst);
    var destReg = destInst.getDest();
    instList.addInst(new ASMLoadNode(destReg, new ASMAddress(srcReg, 0)));
    return instList;
  }

  @Override
  public ASMNode visit(IRPhiNode node) throws BaseError {
    var destInst = (ASMStmtNode) node.getDest().accept(this);
    var destReg = destInst.getDest();
    for (var pair : node.getValues()) {
      var srcInst = (ASMStmtNode) pair.a.accept(this);
      var targetBlock = name2Block.get(pair.b);
      targetBlock.addInst(new ASMCommentNode(node.toString()));
      targetBlock.appendInsts(srcInst);
      targetBlock.appendInsts(destInst);
      targetBlock.addInst(new ASMMoveNode(srcInst.getDest(), destReg));
    }
    return new ASMStmtNode();
  }

  @Override
  public ASMNode visit(IRReturnNode node) throws BaseError {
    var instList = new ASMStmtNode();
    instList.addInst(new ASMCommentNode(node.toString()));
    if (node.getValue() != null) {
      var valueInst = (ASMStmtNode) node.getValue().accept(this);
      instList.appendInsts(valueInst);
      var valueReg = valueInst.getDest();
      instList.addInst(new ASMMoveNode(valueReg, regs.getA0()));
    }
    instList.addInst(new ASMReturnNode());
    return instList;
  }

  @Override
  public ASMNode visit(IRStoreNode node) throws BaseError { // store "%"src, %dest -> sw %src, 0(%dest)
    var instList = new ASMStmtNode();
    instList.addInst(new ASMCommentNode(node.toString()));
    var srcInst = (ASMStmtNode) node.getSrc().accept(this);
    instList.appendInsts(srcInst);
    var srcReg = srcInst.getDest();
    var destInst = (ASMStmtNode) node.getDest().accept(this); // reg can be freed immediately, regAddr can be freed
                                                              // after storing
    instList.appendInsts(destInst);
    var dest = destInst.getDest();
    instList.addInst(new ASMStoreNode(srcReg, new ASMAddress(dest, 0)));
    return instList;
  }

  @Override
  public ASMNode visit(IRCommentNode node) throws BaseError {
    var instList = new ASMStmtNode();
    instList.addInst(new ASMCommentNode(node.getComment()));
    return instList;
  }

  @Override
  public ASMNode visit(IRCustomNode node) throws BaseError {
    throw new RuntimeError("ASMBuilder.visit(IRCustomNode) should not be called");
  }

  @Override
  public ASMNode visit(IRLabelNode node) throws BaseError {
    var instList = new ASMStmtNode();
    instList.addInst(new ASMLabelNode(getLabelName(node.getName())));
    return instList;
  }

  @Override
  public ASMNode visit(IREntity node) throws BaseError {
    throw new RuntimeError("ASMBuilder.visit(IREntity) should not be called");
  }

  @Override
  public ASMNode visit(IRVariable node) throws BaseError {
    var instList = new ASMStmtNode();
    if (node.isGlobal()) {
      var destReg = new ASMVirtualReg();
      instList.addInst(new ASMLoadAddrNode(destReg, node.getValue().substring(1)));
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
    var instList = new ASMStmtNode();
    var destReg = new ASMVirtualReg();
    instList
        .addInst(new ASMLoadImmNode(destReg, node.getValue().equals("null") ? 0 : Integer.valueOf(node.getValue())));
    instList.setDest(destReg);
    return instList;
  }
}
