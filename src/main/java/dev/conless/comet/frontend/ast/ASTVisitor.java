package dev.conless.comet.frontend.ast;

import dev.conless.comet.frontend.ast.node.ASTNode;
import dev.conless.comet.frontend.ast.node.ProgramNode;
import dev.conless.comet.frontend.ast.node.def.*;
import dev.conless.comet.frontend.ast.node.expr.*;
import dev.conless.comet.frontend.ast.node.stmt.*;
import dev.conless.comet.frontend.ast.node.type.*;
import dev.conless.comet.utils.error.BaseError;

public interface ASTVisitor {
  public void visit(ASTNode node) throws BaseError;
  public void visit(ProgramNode node) throws BaseError;

  public void visit(FuncDefNode node) throws BaseError;
  public void visit(ClassDefNode node) throws BaseError;
  public void visit(VarDefNode node) throws BaseError;
  
  public void visit(TypeNameNode node) throws BaseError;

  public void visit(ExprNode node) throws BaseError;
  public void visit(NewExprNode node) throws BaseError;
  public void visit(MemberExprNode node) throws BaseError;
  public void visit(CallExprNode node) throws BaseError;
  public void visit(ArrayExprNode node) throws BaseError;
  public void visit(PostUnaryExprNode node) throws BaseError;
  public void visit(PreUnaryExprNode node) throws BaseError;
  public void visit(BinaryExprNode node) throws BaseError;
  public void visit(ConditionalExprNode node) throws BaseError;
  public void visit(AssignExprNode node) throws BaseError;
  public void visit(AtomExprNode node) throws BaseError;

  public void visit(StmtNode node) throws BaseError;
  public void visit(BlockStmtNode node) throws BaseError;
  public void visit(IfStmtNode node) throws BaseError;
  public void visit(ForStmtNode node) throws BaseError;
  public void visit(WhileStmtNode node) throws BaseError;
  public void visit(ContinueStmtNode node) throws BaseError;
  public void visit(BreakStmtNode node) throws BaseError;
  public void visit(ReturnStmtNode node) throws BaseError;
  public void visit(ExprStmtNode node) throws BaseError;
  public void visit(VarDefStmtNode node) throws BaseError;
  public void visit(EmptyStmtNode node) throws BaseError;
}
