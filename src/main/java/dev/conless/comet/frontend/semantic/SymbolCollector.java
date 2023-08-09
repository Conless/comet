package dev.conless.comet.frontend.semantic;

import dev.conless.comet.frontend.ast.*;
import dev.conless.comet.frontend.ast.node.ASTNode;
import dev.conless.comet.frontend.ast.node.ProgramNode;
import dev.conless.comet.frontend.ast.node.def.*;
import dev.conless.comet.frontend.ast.node.expr.*;
import dev.conless.comet.frontend.ast.node.stmt.*;
import dev.conless.comet.frontend.ast.node.type.*;
import dev.conless.comet.frontend.utils.metadata.TypeInfo;
import dev.conless.comet.frontend.utils.metadata.VarInfo;
import dev.conless.comet.frontend.utils.scope.GlobalScope;
import dev.conless.comet.frontend.utils.scope.ScopeManager;
import dev.conless.comet.utils.error.*;

public class SymbolCollector extends ScopeManager implements ASTVisitor {
  public void visit(ASTNode node) throws BaseError {
    throw new RuntimeError("SymbolCollector.visit(ASTNode) should not be called", node.getPosition());
  }

  public void visit(ProgramNode node) throws BaseError {
    node.addScope(null);
    enterScope(node.getScope());
    for (var def : node.getDefs()) {
      if (def instanceof ClassDefNode || def instanceof FuncDefNode) {
        if (currentScope.get(def.getName()) != null) {
          throw new CompileError("Type " + def.getName() + " is redefined", def.getPosition());
        } else {
          currentScope.declare(def.getInfo());
        }
      }
    }
    for (var def : node.getDefs()) {
      if (def instanceof ClassDefNode || def instanceof FuncDefNode) {
        def.accept(this);
      }
    }
    if (node.getScope().get("main", "func") == null) {
      throw new CompileError("Main function is not defined", node.getPosition());
    }
    exitScope();
  }

  public void visit(FuncDefNode node) throws BaseError {
    node.addScope(currentScope);
    enterScope(node.getScope());
    if (node.getName().equals("main")) {
      if (!node.getReturnType().equals(GlobalScope.intType)) {
        throw new CompileError("Main function should return int", node);
      }
      if (node.getParams().size() != 0) {
        throw new CompileError("Main function should not have any parameters", node);
      }
    }
    TypeInfo returnType = node.getReturnType();
    if (!checkTypeValid(returnType) && !returnType.equals(GlobalScope.voidType)) {
      throw new CompileError("Type " + returnType.getName() + " is not defined", node);
    }
    for (var param : node.getParams()) {
      TypeInfo type = ((VarInfo) param.getInfo()).getType();
      if (!checkTypeValid(type)) {
        throw new CompileError("Type " + type.getName() + " is not defined", param);
      }
      if (currentScope.get(param.getName()) != null) {
        throw new CompileError(param.getName() + " is already defined", param);
      } else {
        currentScope.declare(new VarInfo(param.getName(), param.getType()));
      }
    }
    exitScope();
  }

  public void visit(ClassDefNode node) throws BaseError {
    node.addScope(currentScope);
    enterScope(node.getScope());
    for (var def : node.getFuncDefs()) {
      if (currentScope.get(def.getInfo().getName()) != null) {
        throw new CompileError("Function " + def.getInfo().getName() + " is redefined", def);
      } else {
        def.accept(this);
        currentScope.declare(def.getInfo());
      }
    }
    for (var var : node.getVarDefs()) {
      var.accept(this);
    }
    exitScope();
  }

  public void visit(VarDefNode node) {
    TypeInfo type = ((VarInfo) node.getInfo()).getType();
    if (!checkTypeValid(type)) {
      throw new CompileError("Type " + type.getName() + " is not defined", node);
    }
    if (currentScope.get(node.getName()) != null) {
      throw new CompileError(
          "Redefinition of " + node.getName(), node);
    } else {
      currentScope.declare(new VarInfo(node.getName(), type));
    }
  }

  public void visit(TypeNameNode node) {
    throw new RuntimeException("SymbolCollector.visit(TypeNameNode) should not be called");
  }

  public void visit(ExprNode node) {
    throw new RuntimeException("SymbolCollector.visit(ExprNode) should not be called");
  }

  public void visit(NewExprNode node) {
    throw new RuntimeException("SymbolCollector.visit(NewExprNode) should not be called");
  }

  public void visit(MemberExprNode node) {
    throw new RuntimeException("SymbolCollector.visit(MemberExprNode) should not be called");
  }

  public void visit(CallExprNode node) {
    throw new RuntimeException("SymbolCollector.visit(CallExprNode) should not be called");
  }

  public void visit(ArrayExprNode node) {
    throw new RuntimeException("SymbolCollector.visit(IndexExprNode) should not be called");
  }

  public void visit(PostUnaryExprNode node) {
    throw new RuntimeException("SymbolCollector.visit(PostUnaryExprNode) should not be called");
  }

  public void visit(PreUnaryExprNode node) {
    throw new RuntimeException("SymbolCollector.visit(PreUnaryExprNode) should not be called");
  }

  public void visit(BinaryExprNode node) {
    throw new RuntimeException("SymbolCollector.visit(BinaryExprNode) should not be called");
  }

  public void visit(ConditionalExprNode node) {
    throw new RuntimeException("SymbolCollector.visit(ConditionalExprNode) should not be called");
  }

  public void visit(AssignExprNode node) {
    throw new RuntimeException("SymbolCollector.visit(AssignExprNode) should not be called");
  }

  public void visit(AtomExprNode node) {
    throw new RuntimeException("SymbolCollector.visit(AtomExprNode) should not be called");
  }

  public void visit(StmtNode node) {
    throw new RuntimeException("SymbolCollector.visit(StmtNode) should not be called");
  }

  public void visit(BlockStmtNode node) {
    throw new RuntimeException("SymbolCollector.visit(BlockStmtNode) should not be called");
  }

  public void visit(IfStmtNode node) {
    throw new RuntimeException("SymbolCollector.visit(IfStmtNode) should not be called");
  }

  public void visit(ForStmtNode node) {
    throw new RuntimeException("SymbolCollector.visit(ForStmtNode) should not be called");
  }

  public void visit(WhileStmtNode node) {
    throw new RuntimeException("SymbolCollector.visit(WhileStmtNode) should not be called");
  }

  public void visit(ContinueStmtNode node) {
    throw new RuntimeException("SymbolCollector.visit(ContinueStmtNode) should not be called");
  }

  public void visit(BreakStmtNode node) {
    throw new RuntimeException("SymbolCollector.visit(BreakStmtNode) should not be called");
  }

  public void visit(ReturnStmtNode node) {
    throw new RuntimeException("SymbolCollector.visit(ReturnStmtNode) should not be called");
  }

  public void visit(ExprStmtNode node) {
    throw new RuntimeException("SymbolCollector.visit(ExprStmtNode) should not be called");
  }

  public void visit(VarDefStmtNode node) {
    throw new RuntimeException("SymbolCollector.visit(VarDefStmtNode) should not be called");
  }

  public void visit(EmptyStmtNode node) {
    throw new RuntimeException("SymbolCollector.visit(EmptyStmtNode) should not be called");
  }
}
