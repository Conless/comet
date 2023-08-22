package dev.conless.comet.frontend.ast;

import dev.conless.comet.frontend.ast.node.ASTNode;
import dev.conless.comet.frontend.ast.node.ASTRoot;
import dev.conless.comet.frontend.ast.node.def.*;
import dev.conless.comet.frontend.ast.node.expr.*;
import dev.conless.comet.frontend.ast.node.stmt.*;
import dev.conless.comet.utils.error.BaseError;

public interface ASTVisitor<T> {
  public T visit(ASTNode node) throws BaseError;
  public T visit(ASTRoot node) throws BaseError;

  public T visit(ASTFuncDefNode node) throws BaseError;
  public T visit(ASTClassDefNode node) throws BaseError;
  public T visit(ASTVarDefNode node) throws BaseError;
  
  public T visit(ASTNewExprNode node) throws BaseError;
  public T visit(ASTMemberExprNode node) throws BaseError;
  public T visit(ASTCallExprNode node) throws BaseError;
  public T visit(ASTArrayExprNode node) throws BaseError;
  public T visit(ASTPostUnaryExprNode node) throws BaseError;
  public T visit(ASTPreUnaryExprNode node) throws BaseError;
  public T visit(ASTBinaryExprNode node) throws BaseError;
  public T visit(ASTConditionalExprNode node) throws BaseError;
  public T visit(ASTAssignExprNode node) throws BaseError;
  public T visit(ASTAtomExprNode node) throws BaseError;

  public T visit(ASTBlockStmtNode node) throws BaseError;
  public T visit(ASTIfStmtNode node) throws BaseError;
  public T visit(ASTForStmtNode node) throws BaseError;
  public T visit(ASTWhileStmtNode node) throws BaseError;
  public T visit(ASTContinueStmtNode node) throws BaseError;
  public T visit(ASTBreakStmtNode node) throws BaseError;
  public T visit(ASTReturnStmtNode node) throws BaseError;
  public T visit(ASTExprStmtNode node) throws BaseError;
  public T visit(ASTVarDefStmtNode node) throws BaseError;
  public T visit(ASTEmptyStmtNode node) throws BaseError;
}
