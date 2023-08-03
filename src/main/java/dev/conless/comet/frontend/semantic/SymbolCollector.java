package dev.conless.comet.frontend.semantic;

import dev.conless.comet.frontend.ast.*;
import dev.conless.comet.frontend.ast.def.*;
import dev.conless.comet.frontend.ast.expr.*;
import dev.conless.comet.frontend.ast.stmt.*;
import dev.conless.comet.frontend.ast.type.*;
import dev.conless.comet.utils.metadata.TypeInfo;
import dev.conless.comet.utils.metadata.VarInfo;

public class SymbolCollector extends ScopeManager implements ASTVisitor {
  public void visit(ASTNode node) throws Exception {
    throw new Exception("SymbolCollector.visit(ASTNode) should not be called");
  }

  public void visit(ProgramNode node) throws Exception {
    node.addScope(null);
    enterScope(node.getScope());
    for (var def : node.getDefs()) {
      if (def instanceof ClassDefNode || def instanceof FuncDefNode) {
        if (currentScope.get(def.getName()) != null) {
          throw new Exception("Type " + def.getName() + " is already defined");
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
      throw new Exception("main function is not defined");
    }
    exitScope();
  }

  public void visit(FuncDefNode node) throws Exception {
    node.addScope(currentScope);
    enterScope(node.getScope());
    if (node.getName().equals("main")) {
      if (!node.getReturnType().equals(new TypeInfo("int", 0))) {
        throw new Exception("main function should return int");
      }
      if (node.getParams().size() != 0) {
        throw new Exception("main function should not have any parameters");
      }
    }
    TypeInfo returnType = node.getReturnType();
    if (!checkTypeValid(returnType)) {
      throw new Exception("Type " + returnType.getName() + " is not defined");
    }
    for (var param : node.getParams()) {
      TypeInfo type = (TypeInfo) param.getInfo();
      if (!checkTypeValid(type)) {
        throw new Exception("Type " + type.getName() + " is not defined");
      }
      if (param.vars.size() != 1) {
        throw new Exception("Function parameter should only have one variable");
      }
      var p = param.vars.get(0);
      if (currentScope.get(p.a) != null) {
        throw new Exception(p.a + " is already defined");
      } else {
        currentScope.declare(new VarInfo(p.a, type));
      }
    }
    exitScope();
  }

  public void visit(ClassDefNode node) throws Exception {
    node.addScope(currentScope);
    enterScope(node.getScope());
    if (node.constructor == null || !node.constructor.getName().equals(node.getName())) {
      throw new Exception("Constructor of " + node.getName() + " is not correctly defined");
    }
    for (var def : node.funcDefs) {
      if (currentScope.get(def.info.getName()) != null) {
        throw new Exception("Function " + def.info.getName() + " is already defined");
      } else {
        def.accept(this);
        currentScope.declare(def.info);
      }
    }
    for (var def : node.varDefs) {
      TypeInfo type = (TypeInfo) def.getInfo();
      if (!checkTypeValid(type)) {
        throw new Exception("Type " + type.getName() + " is not defined");
      }
      for (var v : def.vars) {
        if (currentScope.get(v.a) != null) {
          throw new Exception("Redefinition of " + v.a + " at " + def.toString() + " " + def.position.toString());
        } else {
          if (v.b != null) {
            v.b.accept(this);
            TypeInfo initType = (TypeInfo) v.b.getInfo();
            if (!type.equals(initType)) {
              throw new Exception("Cannot assign " + v.b.toString() + " to " + v.a.toString() + " at " + node.toString() + " " + node.position.toString());
            }
          }
          currentScope.declare(new VarInfo(v.a, (TypeInfo) def.info));
        }
      }
    }
    exitScope();
  }

  public void visit(VarDefNode node) {
    throw new RuntimeException("SymbolCollector.visit(VarDefNode) should not be called");
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

  public void visit(IndexExprNode node) {
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
