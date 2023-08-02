package dev.conless.comet.frontend.ast;

import dev.conless.comet.frontend.ast.def.*;
import dev.conless.comet.frontend.ast.expr.*;
import dev.conless.comet.frontend.ast.stmt.*;
import dev.conless.comet.frontend.ast.type.*;

public interface ASTVisitor {
  public void visit(ASTNode node) throws Exception;
  public void visit(ProgramNode node) throws Exception;

  public void visit(FuncDefNode node) throws Exception;
  public void visit(ClassDefNode node) throws Exception;
  public void visit(VarDefNode node) throws Exception;
  
  public void visit(TypeNameNode node) throws Exception;

  public void visit(ExprNode node) throws Exception;
  public void visit(NewExprNode node) throws Exception;
  public void visit(MemberExprNode node) throws Exception;
  public void visit(CallExprNode node) throws Exception;
  public void visit(IndexExprNode node) throws Exception;
  public void visit(PostUnaryExprNode node) throws Exception;
  public void visit(PreUnaryExprNode node) throws Exception;
  public void visit(BinaryExprNode node) throws Exception;
  public void visit(ConditionalExprNode node) throws Exception;
  public void visit(AssignExprNode node) throws Exception;
  public void visit(AtomExprNode node) throws Exception;

  public void visit(StmtNode node) throws Exception;
  public void visit(BlockStmtNode node) throws Exception;
  public void visit(IfStmtNode node) throws Exception;
  public void visit(ForStmtNode node) throws Exception;
  public void visit(WhileStmtNode node) throws Exception;
  public void visit(ContinueStmtNode node) throws Exception;
  public void visit(BreakStmtNode node) throws Exception;
  public void visit(ReturnStmtNode node) throws Exception;
  public void visit(ExprStmtNode node) throws Exception;
  public void visit(VarDefStmtNode node) throws Exception;
  public void visit(ClassDefStmtNode node) throws Exception;
  public void visit(EmptyStmtNode node) throws Exception;
}
