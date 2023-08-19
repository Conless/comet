package dev.conless.comet.frontend.ir;

import dev.conless.comet.frontend.ir.node.global.*;
import dev.conless.comet.frontend.ir.node.inst.*;
import dev.conless.comet.frontend.ir.node.stmt.IRStmtNode;
import dev.conless.comet.frontend.ir.node.utils.*;
import dev.conless.comet.utils.error.*;

public interface IRVisitor<T> {
  public T visit(IRProgramNode node) throws BaseError;
  
  public T visit(IRFuncDefNode node) throws BaseError;
  public T visit(IRGlobalDefNode node) throws BaseError;
  public T visit(IRStrDefNode node) throws BaseError;

  public T visit(IRAllocaNode node) throws BaseError;
  public T visit(IRArithNode node) throws BaseError;
  public T visit(IRBranchNode node) throws BaseError;
  public T visit(IRCallNode node) throws BaseError;
  public T visit(IRGetElementPtrNode node) throws BaseError;
  public T visit(IRJumpNode node) throws BaseError;
  public T visit(IRLoadNode node) throws BaseError;
  public T visit(IRPhiNode node) throws BaseError;
  public T visit(IRReturnNode node) throws BaseError;
  public T visit(IRStoreNode node) throws BaseError;
  
  public T visit(IRCommentNode node) throws BaseError;
  public T visit(IRCustomNode node) throws BaseError;
  public T visit(IRStmtNode node) throws BaseError;
  public T visit(IRLabelNode node) throws BaseError;
}
