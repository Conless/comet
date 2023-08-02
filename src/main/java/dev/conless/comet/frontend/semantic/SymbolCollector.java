package dev.conless.comet.frontend.semantic;

import dev.conless.comet.frontend.ast.*;
import dev.conless.comet.frontend.ast.def.*;
import dev.conless.comet.frontend.ast.expr.*;
import dev.conless.comet.frontend.ast.stmt.*;
import dev.conless.comet.frontend.ast.type.*;
import dev.conless.comet.utils.metadata.FuncInfo;
import dev.conless.comet.utils.metadata.TypeInfo;
import dev.conless.comet.utils.metadata.ClassInfo;
import dev.conless.comet.utils.metadata.VarInfo;

public class SymbolCollector extends ScopeManager implements ASTVisitor {
  public void visit(ASTNode node) throws Exception {
    throw new Exception("SymbolCollector.visit(ASTNode) should not be called");
  }

  public void visit(ProgramNode node) throws Exception {
    node.addScope(null);
    enterScope(node.getScope());
    for (var def : node.getDefs()) {
      if (def instanceof ClassDefNode) {
        if (currentScope.get(def.getName()) != null) {
          throw new Exception("Type " + def.getName() + " is already defined");
        } else {
          currentScope.declare(def.info());
        }
      }
    }
    for (var def : node.getDefs()) {
      if (def instanceof FuncDefNode) {
        if (currentScope.get(def.getName()) != null) {
          throw new Exception("Function " + def.getName() + " is already defined");
        } else {
          currentScope.declare(def.info());
        }
      }
    }
    for (var def : node.getDefs()) {
      if (def instanceof ClassDefNode || def instanceof FuncDefNode) {
        def.accept(this);
        currentScope.declare(def.info());
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
    if (node.getName() == "main") {
      if (node.getReturnType().equals(new TypeInfo("int", 0))) {
        throw new Exception("main function should not have a return type");
      }
      if (node.getParams().size() != 0) {
        throw new Exception("main function should not have any parameters");
      }
    }
    TypeInfo returnType = node.getReturnType();
    if (!returnType.isBuiltIn && globalScope.get(returnType.name(), "class") == null) {
      throw new Exception("Type " + returnType.name() + " is not defined");
    }
    for (var param : node.getParams()) {
      TypeInfo type = (TypeInfo) param.info();
      if (!type.isBuiltIn && globalScope.get(type.name(), "class") == null) {
        throw new Exception("Type " + type.name() + " is not defined");
      }
      if (currentScope.get(param.getName()) != null) {
        throw new Exception(param.getName() + " is already defined");
      } else {
        currentScope.declare(new VarInfo(param.getName(), (TypeInfo) param.info()));
        ((FuncInfo) node.info()).params.add((TypeInfo) param.info());
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
      if (currentScope.get(def.info.name()) != null) {
        throw new Exception("Function " + def.info.name() + " is already defined");
      } else {
        def.accept(this);
        ((ClassInfo) node.info).addFunc((FuncInfo) def.info);
        currentScope.declare(def.info);
      }
    }
    for (var def : node.varDefs) {
      TypeInfo type = (TypeInfo) def.info();
      if (!type.isBuiltIn && globalScope.get(type.name(), "class") == null) {
        throw new Exception("Type " + type.name() + " is not defined");
      }
      for (var variable : def.vars) {
        if (currentScope.get(variable.a) != null) {
          throw new Exception(variable.a + " is already defined");
        } else {
          ((ClassInfo) node.info).addVar(new VarInfo(variable.a, (TypeInfo) def.info));
          currentScope.declare(new VarInfo(variable.a, (TypeInfo) def.info));
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

  public void visit(ClassDefStmtNode node) {
    throw new RuntimeException("SymbolCollector.visit(VarDefStmtNode) should not be called");
  }

  public void visit(EmptyStmtNode node) {
    throw new RuntimeException("SymbolCollector.visit(VarDefStmtNode) should not be called");
  }
}
