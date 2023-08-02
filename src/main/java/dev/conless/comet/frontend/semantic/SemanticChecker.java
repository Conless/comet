package dev.conless.comet.frontend.semantic;

import dev.conless.comet.frontend.ast.*;
import dev.conless.comet.frontend.ast.def.*;
import dev.conless.comet.frontend.ast.expr.*;
import dev.conless.comet.frontend.ast.stmt.*;
import dev.conless.comet.frontend.ast.type.*;
import dev.conless.comet.utils.metadata.ClassInfo;
import dev.conless.comet.utils.metadata.TypeInfo;
import dev.conless.comet.utils.metadata.VarInfo;

public class SemanticChecker extends ScopeManager implements ASTVisitor {
  public void visit(ASTNode node) throws Exception {
    throw new Exception("SemanticChecker.visit(ASTNode) should not be called");
  }

  public void visit(ProgramNode node) throws Exception {
    for (var def : node.defs) {
      def.accept(this);
    }
  }

  public void visit(FuncDefNode node) throws Exception {
    node.addScope(currentScope);
    enterScope(node.getScope());
    for (var stmt : node.getBody()) {
      stmt.accept(this);
    }
    if (!node.getReturnType().equals(new TypeInfo("void", 0))) {
      if (!currentScope.isExited()) {
        throw new Exception("Function " + node.getName() + " should have a return statement");
      }
    }
    exitScope();
  }

  public void visit(ClassDefNode node) throws Exception {
    node.addScope(currentScope);
    enterScope(node.getScope());
    for (var funcDef : node.getFuncDefs()) {
      funcDef.accept(this);
    }
    exitScope();
  }

  public void visit(VarDefNode node) throws Exception {
    TypeInfo type = (TypeInfo) node.info();
    if (!type.isBuiltIn && globalScope.get(type.name(), "class") == null) {
      throw new Exception("Type " + type.name() + " is not defined");
    }
    for (var variable : node.vars) {
      if (currentScope.get(variable.a) != null) {
        throw new Exception(variable.a + " is already defined");
      } else {
        ((ClassInfo) node.info).addVar(new VarInfo(variable.a, (TypeInfo) node.info));
        currentScope.declare(new VarInfo(variable.a, (TypeInfo) node.info));
      }
    }
  }

  public void visit(TypeNameNode node) {
    throw new RuntimeException("SemanticChecker.visit(TypeNameNode) should not be called");
  }

  public void visit(ExprNode node) {
    throw new RuntimeException("SemanticChecker.visit(ExprNode) should not be called");
  }

  public void visit(NewExprNode node) {
    
  }

  public void visit(MemberExprNode node) {
  }

  public void visit(CallExprNode node) {
  }

  public void visit(IndexExprNode node) {
  }

  public void visit(PostUnaryExprNode node) {
  }

  public void visit(PreUnaryExprNode node) {
  }

  public void visit(BinaryExprNode node) {
  }

  public void visit(ConditionalExprNode node) {
  }

  public void visit(AssignExprNode node) {
  }

  public void visit(AtomExprNode node) {
  }

  public void visit(StmtNode node) {
  }

  public void visit(BlockStmtNode node) {
  }

  public void visit(IfStmtNode node) {
  }

  public void visit(ForStmtNode node) {
  }

  public void visit(WhileStmtNode node) {
  }

  public void visit(ContinueStmtNode node) {
  }

  public void visit(BreakStmtNode node) {
  }

  public void visit(ReturnStmtNode node) {
  }

  public void visit(ExprStmtNode node) {
  }

  public void visit(VarDefStmtNode node) {
  }

  public void visit(ClassDefStmtNode node) {
  }

  public void visit(EmptyStmtNode node) {
  }
}
