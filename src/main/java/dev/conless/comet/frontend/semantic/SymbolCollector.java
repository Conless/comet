package dev.conless.comet.frontend.semantic;

import dev.conless.comet.frontend.ast.*;
import dev.conless.comet.frontend.ast.node.ASTNode;
import dev.conless.comet.frontend.ast.node.def.*;
import dev.conless.comet.frontend.ast.node.expr.*;
import dev.conless.comet.frontend.ast.node.global.ProgramNode;
import dev.conless.comet.frontend.ast.node.stmt.*;
import dev.conless.comet.frontend.utils.metadata.TypeInfo;
import dev.conless.comet.frontend.utils.metadata.VarInfo;
import dev.conless.comet.frontend.utils.scope.GlobalScope;
import dev.conless.comet.utils.error.*;
import dev.conless.comet.utils.msg.CompileMsg;

public class SymbolCollector extends ScopeManager implements ASTVisitor<CompileMsg> {
  public CompileMsg visit(ASTNode node) throws BaseError {
    throw new RuntimeError("SymbolCollector.visit(ASTNode) should not be called", node.getPosition());
  }

  public CompileMsg visit(ProgramNode node) throws BaseError {
    node.addScope(null);
    enterScope(node.getScope());
    var msg = new CompileMsg();
    for (var def : node.getDefs()) {
      if (def instanceof ClassDefNode || def instanceof FuncDefNode) {
        if (currentScope.get(def.getName()) != null) {
          return new CompileMsg("Type " + def.getName() + " is redefined", def.getPosition());
        } else {
          currentScope.declare(def.getInfo());
        }
      }
    }
    for (var def : node.getDefs()) {
      if (def instanceof ClassDefNode || def instanceof FuncDefNode) {
        msg.append(def.accept(this));
      }
    }
    if (node.getScope().get("main", "func") == null) {
      return new CompileMsg("Main function is not defined", node.getPosition());
    }
    exitScope();
    return msg;
  }

  public CompileMsg visit(FuncDefNode node) throws BaseError {
    node.addScope(currentScope);
    enterScope(node.getScope());
    if (node.getName().equals("main")) {
      if (!node.getReturnType().equals(GlobalScope.intType)) {
        return new CompileMsg("Main function should return int", node);
      }
      if (node.getParams().size() != 0) {
        return new CompileMsg("Main function should not have any parameters", node);
      }
    }
    TypeInfo returnType = node.getReturnType();
    if (!checkTypeValid(returnType) && !returnType.equals(GlobalScope.voidType)) {
      return new CompileMsg("Type " + returnType.getName() + " is not defined", node);
    }
    for (var param : node.getParams()) {
      TypeInfo type = ((VarInfo) param.getInfo()).getType();
      if (!checkTypeValid(type)) {
        return new CompileMsg("Type " + type.getName() + " is not defined", param);
      }
      if (currentScope.get(param.getName()) != null) {
        return new CompileMsg(param.getName() + " is already defined", param);
      } else {
        currentScope.declare(new VarInfo(param.getName(), param.getType()));
      }
    }
    exitScope();
    return new CompileMsg();
  }

  public CompileMsg visit(ClassDefNode node) throws BaseError {
    node.addScope(currentScope);
    enterScope(node.getScope());
    var msg = new CompileMsg();
    for (var def : node.getFuncDefs()) {
      if (currentScope.get(def.getInfo().getName()) != null) {
        return new CompileMsg("Function " + def.getInfo().getName() + " is redefined", def);
      } else {
        def.accept(this);
        currentScope.declare(def.getInfo());
      }
    }
    for (var var : node.getVarDefs()) {
      msg.append(var.accept(this));
    }
    exitScope();
    return msg;
  }

  public CompileMsg visit(VarDefNode node) {
    TypeInfo type = ((VarInfo) node.getInfo()).getType();
    if (!checkTypeValid(type)) {
      return new CompileMsg("Type " + type.getName() + " is not defined", node);
    }
    if (currentScope.get(node.getName()) != null) {
      return new CompileMsg(
          "Redefinition of " + node.getName(), node);
    } else {
      currentScope.declare(new VarInfo(node.getName(), type));
    }
    return new CompileMsg();
  }

  public CompileMsg visit(NewExprNode node) {
    throw new RuntimeError("SymbolCollector.visit(NewExprNode) should not be called", node.getPosition());
  }

  public CompileMsg visit(MemberExprNode node) {
    throw new RuntimeError("SymbolCollector.visit(MemberExprNode) should not be called", node.getPosition());
  }

  public CompileMsg visit(CallExprNode node) {
    throw new RuntimeError("SymbolCollector.visit(CallExprNode) should not be called", node.getPosition());
  }

  public CompileMsg visit(ArrayExprNode node) {
    throw new RuntimeError("SymbolCollector.visit(IndexExprNode) should not be called", node.getPosition());
  }

  public CompileMsg visit(PostUnaryExprNode node) {
    throw new RuntimeError("SymbolCollector.visit(PostUnaryExprNode) should not be called", node.getPosition());
  }

  public CompileMsg visit(PreUnaryExprNode node) {
    throw new RuntimeError("SymbolCollector.visit(PreUnaryExprNode) should not be called", node.getPosition());
  }

  public CompileMsg visit(BinaryExprNode node) {
    throw new RuntimeError("SymbolCollector.visit(BinaryExprNode) should not be called", node.getPosition());
  }

  public CompileMsg visit(ConditionalExprNode node) {
    throw new RuntimeError("SymbolCollector.visit(ConditionalExprNode) should not be called", node.getPosition());
  }

  public CompileMsg visit(AssignExprNode node) {
    throw new RuntimeError("SymbolCollector.visit(AssignExprNode) should not be called", node.getPosition());
  }

  public CompileMsg visit(AtomExprNode node) {
    throw new RuntimeError("SymbolCollector.visit(AtomExprNode) should not be called", node.getPosition());
  }

  public CompileMsg visit(BlockStmtNode node) {
    throw new RuntimeError("SymbolCollector.visit(BlockStmtNode) should not be called", node.getPosition());
  }

  public CompileMsg visit(IfStmtNode node) {
    throw new RuntimeError("SymbolCollector.visit(IfStmtNode) should not be called", node.getPosition());
  }

  public CompileMsg visit(ForStmtNode node) {
    throw new RuntimeError("SymbolCollector.visit(ForStmtNode) should not be called", node.getPosition());
  }

  public CompileMsg visit(WhileStmtNode node) {
    throw new RuntimeError("SymbolCollector.visit(WhileStmtNode) should not be called", node.getPosition());
  }

  public CompileMsg visit(ContinueStmtNode node) {
    throw new RuntimeError("SymbolCollector.visit(ContinueStmtNode) should not be called", node.getPosition());
  }

  public CompileMsg visit(BreakStmtNode node) {
    throw new RuntimeError("SymbolCollector.visit(BreakStmtNode) should not be called", node.getPosition());
  }

  public CompileMsg visit(ReturnStmtNode node) {
    throw new RuntimeError("SymbolCollector.visit(ReturnStmtNode) should not be called", node.getPosition());
  }

  public CompileMsg visit(ExprStmtNode node) {
    throw new RuntimeError("SymbolCollector.visit(ExprStmtNode) should not be called", node.getPosition());
  }

  public CompileMsg visit(VarDefStmtNode node) {
    throw new RuntimeError("SymbolCollector.visit(VarDefStmtNode) should not be called", node.getPosition());
  }

  public CompileMsg visit(EmptyStmtNode node) {
    throw new RuntimeError("SymbolCollector.visit(EmptyStmtNode) should not be called", node.getPosition());
  }
}
