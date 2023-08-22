package dev.conless.comet.frontend.semantic;

import dev.conless.comet.frontend.ast.*;
import dev.conless.comet.frontend.ast.node.ASTNode;
import dev.conless.comet.frontend.ast.node.ASTRoot;
import dev.conless.comet.frontend.ast.node.def.*;
import dev.conless.comet.frontend.ast.node.expr.*;
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

  public CompileMsg visit(ASTRoot node) throws BaseError {
    node.addScope(null);
    enterScope(node.getScope());
    var msg = new CompileMsg();
    for (var def : node.getDefs()) {
      if (def instanceof ASTClassDefNode || def instanceof ASTFuncDefNode) {
        if (currentScope.get(def.getName()) != null) {
          return new CompileMsg("Type " + def.getName() + " is redefined", def.getPosition());
        } else {
          currentScope.declare(def.getInfo());
        }
      }
    }
    for (var def : node.getDefs()) {
      if (def instanceof ASTClassDefNode || def instanceof ASTFuncDefNode) {
        msg.append(def.accept(this));
      }
    }
    if (node.getScope().get("main", "func") == null) {
      return new CompileMsg("Main function is not defined", node.getPosition());
    }
    exitScope();
    return msg;
  }

  public CompileMsg visit(ASTFuncDefNode node) throws BaseError {
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

  public CompileMsg visit(ASTClassDefNode node) throws BaseError {
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

  public CompileMsg visit(ASTVarDefNode node) {
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

  public CompileMsg visit(ASTNewExprNode node) {
    throw new RuntimeError("SymbolCollector.visit(NewExprNode) should not be called", node.getPosition());
  }

  public CompileMsg visit(ASTMemberExprNode node) {
    throw new RuntimeError("SymbolCollector.visit(MemberExprNode) should not be called", node.getPosition());
  }

  public CompileMsg visit(ASTCallExprNode node) {
    throw new RuntimeError("SymbolCollector.visit(CallExprNode) should not be called", node.getPosition());
  }

  public CompileMsg visit(ASTArrayExprNode node) {
    throw new RuntimeError("SymbolCollector.visit(IndexExprNode) should not be called", node.getPosition());
  }

  public CompileMsg visit(ASTPostUnaryExprNode node) {
    throw new RuntimeError("SymbolCollector.visit(PostUnaryExprNode) should not be called", node.getPosition());
  }

  public CompileMsg visit(ASTPreUnaryExprNode node) {
    throw new RuntimeError("SymbolCollector.visit(PreUnaryExprNode) should not be called", node.getPosition());
  }

  public CompileMsg visit(ASTBinaryExprNode node) {
    throw new RuntimeError("SymbolCollector.visit(BinaryExprNode) should not be called", node.getPosition());
  }

  public CompileMsg visit(ASTConditionalExprNode node) {
    throw new RuntimeError("SymbolCollector.visit(ConditionalExprNode) should not be called", node.getPosition());
  }

  public CompileMsg visit(ASTAssignExprNode node) {
    throw new RuntimeError("SymbolCollector.visit(AssignExprNode) should not be called", node.getPosition());
  }

  public CompileMsg visit(ASTAtomExprNode node) {
    throw new RuntimeError("SymbolCollector.visit(AtomExprNode) should not be called", node.getPosition());
  }

  public CompileMsg visit(ASTBlockStmtNode node) {
    throw new RuntimeError("SymbolCollector.visit(BlockStmtNode) should not be called", node.getPosition());
  }

  public CompileMsg visit(ASTIfStmtNode node) {
    throw new RuntimeError("SymbolCollector.visit(IfStmtNode) should not be called", node.getPosition());
  }

  public CompileMsg visit(ASTForStmtNode node) {
    throw new RuntimeError("SymbolCollector.visit(ForStmtNode) should not be called", node.getPosition());
  }

  public CompileMsg visit(ASTWhileStmtNode node) {
    throw new RuntimeError("SymbolCollector.visit(WhileStmtNode) should not be called", node.getPosition());
  }

  public CompileMsg visit(ASTContinueStmtNode node) {
    throw new RuntimeError("SymbolCollector.visit(ContinueStmtNode) should not be called", node.getPosition());
  }

  public CompileMsg visit(ASTBreakStmtNode node) {
    throw new RuntimeError("SymbolCollector.visit(BreakStmtNode) should not be called", node.getPosition());
  }

  public CompileMsg visit(ASTReturnStmtNode node) {
    throw new RuntimeError("SymbolCollector.visit(ReturnStmtNode) should not be called", node.getPosition());
  }

  public CompileMsg visit(ASTExprStmtNode node) {
    throw new RuntimeError("SymbolCollector.visit(ExprStmtNode) should not be called", node.getPosition());
  }

  public CompileMsg visit(ASTVarDefStmtNode node) {
    throw new RuntimeError("SymbolCollector.visit(VarDefStmtNode) should not be called", node.getPosition());
  }

  public CompileMsg visit(ASTEmptyStmtNode node) {
    throw new RuntimeError("SymbolCollector.visit(EmptyStmtNode) should not be called", node.getPosition());
  }
}
