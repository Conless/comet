package dev.conless.comet.frontend.semantic;

import dev.conless.comet.frontend.ast.*;
import dev.conless.comet.frontend.ast.def.*;
import dev.conless.comet.frontend.ast.expr.*;
import dev.conless.comet.frontend.ast.stmt.*;
import dev.conless.comet.frontend.ast.type.*;
import dev.conless.comet.utils.scope.*;

public class SymbolCollector implements ASTVisitor {
  private GlobalScope global;

  public void visit(ASTNode node) throws Exception {
    throw new Exception("SymbolCollector.visit(ASTNode) should not be called");
  }

  public void visit(ProgramNode node) throws Exception {
    for (var def : node.defs) {
      if (def instanceof ClassDefNode || def instanceof FuncDefNode) {
        if (global.checkDeclared(def.info.name())) {
          throw new Exception(def.info.name() + " is already defined");
        } else {
          global.declare(def.info);
        }
      }
    }
  }

  public void visit(FuncDefNode node) {}

  public void visit(ClassDefNode node) {
    for (var def : node.funcDefs) {
      
    }
  }
  public void visit(VarDefNode node) {}
  
  public void visit(TypeNameNode node) {}

  public void visit(ExprNode node) {}
  public void visit(NewExprNode node) {}
  public void visit(MemberExprNode node) {}
  public void visit(CallExprNode node) {}
  public void visit(IndexExprNode node) {}
  public void visit(PostUnaryExprNode node) {}
  public void visit(PreUnaryExprNode node) {}
  public void visit(BinaryExprNode node) {}
  public void visit(ConditionalExprNode node) {}
  public void visit(AssignExprNode node) {}
  public void visit(AtomExprNode node) {}

  public void visit(StmtNode node) {}
  public void visit(BlockStmtNode node) {}
  public void visit(IfStmtNode node) {}
  public void visit(ForStmtNode node) {}
  public void visit(WhileStmtNode node) {}
  public void visit(ContinueStmtNode node) {}
  public void visit(BreakStmtNode node) {}
  public void visit(ReturnStmtNode node) {}
  public void visit(ExprStmtNode node) {}
  public void visit(VarDefStmtNode node) {}
  public void visit(ClassDefStmtNode node) {}
  public void visit(EmptyStmtNode node) {}
}
