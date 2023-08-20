package dev.conless.comet.backend.asm;

import dev.conless.comet.backend.asm.node.*;
import dev.conless.comet.backend.asm.node.inst.ASMJumpNode;
import dev.conless.comet.backend.asm.node.stmt.ASMStmtsNode;
import dev.conless.comet.frontend.ir.*;
import dev.conless.comet.frontend.ir.entity.IREntity;
import dev.conless.comet.frontend.ir.entity.IRLiteral;
import dev.conless.comet.frontend.ir.entity.IRVariable;
import dev.conless.comet.frontend.ir.node.*;
import dev.conless.comet.frontend.ir.node.global.*;
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
  public ASMNode visit(IRProgramNode node) throws BaseError {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'visit'");
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
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'visit'");
  }

  @Override
  public ASMNode visit(IRArithNode node) throws BaseError {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'visit'");
  }

  @Override
  public ASMNode visit(IRBranchNode node) throws BaseError { // notice that the first label of IRBranchNode would be the next node of it
    var condInst = (ASMStmtsNode) node.getCondition().accept(this);
    var condReg = condInst.getDest();
  }

  @Override
  public ASMNode visit(IRCallNode node) throws BaseError {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'visit'");
  }

  @Override
  public ASMNode visit(IRGetElementPtrNode node) throws BaseError {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'visit'");
  }

  @Override
  public ASMNode visit(IRJumpNode node) throws BaseError {
    return new ASMJumpNode(".func" + String.valueOf(funcCount) + "." + node.getLabel());
  }

  @Override
  public ASMNode visit(IRLoadNode node) throws BaseError {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'visit'");
  }

  @Override
  public ASMNode visit(IRPhiNode node) throws BaseError {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'visit'");
  }

  @Override
  public ASMNode visit(IRReturnNode node) throws BaseError {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'visit'");
  }

  @Override
  public ASMNode visit(IRStoreNode node) throws BaseError {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'visit'");
  }

  @Override
  public ASMNode visit(IRCommentNode node) throws BaseError {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'visit'");
  }

  @Override
  public ASMNode visit(IRCustomNode node) throws BaseError {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'visit'");
  }

  @Override
  public ASMNode visit(IRLabelNode node) throws BaseError {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'visit'");
  }

  @Override
  public ASMNode visit(IREntity node) throws BaseError {
    throw new RuntimeError("ASMBuilder.visit(IREntity) should not be called");
  }

  @Override
  public ASMNode visit(IRVariable node) throws BaseError {
    
  }

  @Override
  public ASMNode visit(IRLiteral node) throws BaseError {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'visit'");
  }
}
