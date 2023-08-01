package dev.conless.comet.frontend.ast;

import dev.conless.comet.frontend.ast.def.*;
import dev.conless.comet.frontend.ast.expr.*;
import dev.conless.comet.frontend.ast.stmt.*;
import dev.conless.comet.frontend.ast.type.*;

public interface ASTVisitor {
  public void visit(ProgramNode node);

  public void visit(FuncDefNode node);
  public void visit(ClassDefNode node);
  public void visit(VarDefNode node);
  
  public void visit(TypeNode node);
  public void visit(TypeNameNode node);

  public void visit(ExprNode node);
  public void visit(NewExprNode node);
  public void visit(MemberExprNode node);
  public void visit(CallExprNode node);
  public void visit(IndexExprNode node);
  public void visit(PostUnaryExprNode node);
  public void visit(PreUnaryExprNode node);
  public void visit(BinaryExprNode node);
  public void visit(ConditionalExprNode node);
  public void visit(AssignExprNode node);
  public void visit(AtomExprNode node);

  public void visit(StmtNode node);
  public void visit(BlockStmtNode node);
  public void visit(IfStmtNode node);
  public void visit(ForStmtNode node);
  public void visit(WhileStmtNode node);
  public void visit(ContinueStmtNode node);
  public void visit(BreakStmtNode node);
  public void visit(ReturnStmtNode node);
  public void visit(ExprStmtNode node);
  public void visit(VarDefStmtNode node);
  public void visit(ClassDefStmtNode node);
  public void visit(EmptyStmtNode node);
}
