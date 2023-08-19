package dev.conless.comet.frontend.ast;

import dev.conless.comet.frontend.ast.node.ASTNode;
import dev.conless.comet.frontend.ast.node.def.*;
import dev.conless.comet.frontend.ast.node.expr.*;
import dev.conless.comet.frontend.ast.node.global.*;
import dev.conless.comet.frontend.ast.node.stmt.*;
import dev.conless.comet.utils.error.BaseError;

public interface ASTVisitor<T> {
  public T visit(ASTNode node) throws BaseError;
  public T visit(ProgramNode node) throws BaseError;

  public T visit(FuncDefNode node) throws BaseError;
  public T visit(ClassDefNode node) throws BaseError;
  public T visit(VarDefNode node) throws BaseError;
  
  public T visit(NewExprNode node) throws BaseError;
  public T visit(MemberExprNode node) throws BaseError;
  public T visit(CallExprNode node) throws BaseError;
  public T visit(ArrayExprNode node) throws BaseError;
  public T visit(PostUnaryExprNode node) throws BaseError;
  public T visit(PreUnaryExprNode node) throws BaseError;
  public T visit(BinaryExprNode node) throws BaseError;
  public T visit(ConditionalExprNode node) throws BaseError;
  public T visit(AssignExprNode node) throws BaseError;
  public T visit(AtomExprNode node) throws BaseError;

  public T visit(BlockStmtNode node) throws BaseError;
  public T visit(IfStmtNode node) throws BaseError;
  public T visit(ForStmtNode node) throws BaseError;
  public T visit(WhileStmtNode node) throws BaseError;
  public T visit(ContinueStmtNode node) throws BaseError;
  public T visit(BreakStmtNode node) throws BaseError;
  public T visit(ReturnStmtNode node) throws BaseError;
  public T visit(ExprStmtNode node) throws BaseError;
  public T visit(VarDefStmtNode node) throws BaseError;
  public T visit(EmptyStmtNode node) throws BaseError;
}
