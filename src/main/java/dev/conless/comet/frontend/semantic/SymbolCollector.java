package dev.conless.comet.frontend.semantic;

import dev.conless.comet.frontend.ast.*;
import dev.conless.comet.frontend.ast.def.*;
import dev.conless.comet.frontend.ast.expr.*;
import dev.conless.comet.frontend.ast.stmt.*;
import dev.conless.comet.frontend.ast.type.*;
import dev.conless.comet.utils.metadata.FuncInfo;
import dev.conless.comet.utils.metadata.TypeInfo;
import dev.conless.comet.utils.metadata.VarInfo;
import dev.conless.comet.utils.scope.BaseScope;

public class SymbolCollector implements ASTVisitor {
  public ProgramNode root;

  public SymbolCollector(ProgramNode root) {
    this.root = root;
  }

  public void collect() throws Exception {
    root.accept(this);
  }

  public void visit(ASTNode node) throws Exception {
    throw new Exception("SymbolCollector.visit(ASTNode) should not be called");
  }

  public void visit(ProgramNode node) throws Exception {
    node.addScope(null);
    root = node;
    for (var def : node.getDefs()) {
      if (def instanceof ClassDefNode) {
        if (node.get(def.getName()) != null) {
          throw new Exception("Type " + def.getName() + " is already defined");
        } else {
          node.declare(def.info());
        }
      }
    }
    for (var def : node.getDefs()) {
      if (def instanceof FuncDefNode) {
        if (node.get(def.getName()) != null) {
          throw new Exception("Function " + def.getName() + " is already defined");
        } else {
          node.declare(def.info());
        }
      }
    }
    for (var def : node.getDefs()) {
      if (def instanceof ClassDefNode || def instanceof FuncDefNode) {
        def.addScope((BaseScope) node.scope);
        def.accept(this);
        node.declare(def.info());
      }
    }
    if (node.get("main", "func") == null) {
      throw new Exception("main function is not defined");
    }
  }

  public void visit(FuncDefNode node) throws Exception {
    if (node.getName() == "main") {
      if (node.getReturnType().equals(new TypeInfo("int", 0))) {
        throw new Exception("main function should not have a return type");
      }
      if (node.getParams().size() != 0) {
        throw new Exception("main function should not have any parameters");
      }
    }
    for (var param : node.getParams()) {
      TypeInfo type = (TypeInfo) param.info();
      if (!type.isBuiltIn && root.get(type.name(), "class") == null) {
        throw new Exception("Type " + type.name() + " is not defined");
      }
      if (node.get(param.getName()) != null) {
        throw new Exception(param.getName() + " is already defined");
      } else {
        node.declare(new VarInfo(param.getName(), (TypeInfo) param.info()));
        ((FuncInfo)node.info()).params.add((TypeInfo) param.info());
      }
    }
  }

  public void visit(ClassDefNode node) throws Exception {
    if (node.constructor == null || !node.constructor.getName().equals(node.getName())) {
      throw new Exception("Constructor of " + node.getName() + " is not correctly defined");
    }
    for (var def : node.funcDefs) {
      if (node.get(def.info.name()) != null) {
        throw new Exception("Function " + def.info.name() + " is already defined");
      } else {
        node.declare(def.info);
      }
    }
    for (var def : node.varDefs) {
      TypeInfo type = (TypeInfo) def.info();
      if (!type.isBuiltIn && root.get(type.name(), "class") == null) {
        throw new Exception("Type " + type.name() + " is not defined");
      }
      for (var variable : def.vars) {
        if (node.get(variable.a) != null) {
          throw new Exception(variable.a + " is already defined");
        } else {
          node.declare(new VarInfo(variable.a, (TypeInfo) def.info));
        }
      }
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

