package dev.conless.comet.frontend.ir;

import dev.conless.comet.frontend.ast.node.ASTNode;
import dev.conless.comet.frontend.ast.node.global.ScopedNode;
import dev.conless.comet.frontend.ast.node.stmt.IfStmtNode;
import dev.conless.comet.frontend.ir.entity.IREntity;
import dev.conless.comet.frontend.ir.entity.IRLiteral;
import dev.conless.comet.frontend.ir.entity.IRVariable;
import dev.conless.comet.frontend.ir.node.global.IRFuncNode;
import dev.conless.comet.frontend.ir.node.global.IRProgramNode;
import dev.conless.comet.frontend.ir.node.inst.*;
import dev.conless.comet.frontend.ir.node.utils.IRExprNode;
import dev.conless.comet.frontend.ir.type.IRType;
import dev.conless.comet.frontend.ir.type.IRType.Case;
import dev.conless.comet.frontend.utils.metadata.TypeInfo;
import dev.conless.comet.frontend.utils.scope.BaseScope;
import dev.conless.comet.frontend.utils.scope.GlobalScope;
import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.error.*;

public class IRManager {
  protected GlobalScope globalScope;
  protected BaseScope currentScope;
  protected IRProgramNode programNode;
  protected IRFuncNode initNode;
  protected IRCounter counter;

  protected void enterASTNode(ASTNode node) {
    if (node instanceof ScopedNode) {
      currentScope = ((ScopedNode) node).getScope();
      if (globalScope == null) {
        if (!(currentScope instanceof GlobalScope)) {
          throw new RuntimeError("Global scope not found");
        }
        globalScope = (GlobalScope) currentScope;
      }
    }
  }

  protected void enterASTNode(IfStmtNode node, String name) {
    if (name.equals("then")) {
      currentScope = node.getThenScope();
    } else if (name.equals("else")) {
      currentScope = node.getElseScope();
    } else {
      throw new RuntimeError("Invalid if stmt node name");
    }
  }

  protected void exitASTNode(ASTNode node) {
    if (node instanceof ScopedNode) {
      currentScope = ((ScopedNode) node).getScope().getParent();
    }
  }

  protected void exitASTNode(IfStmtNode node, String name) {
    if (name.equals("then")) {
      currentScope = node.getScope();
    } else if (name.equals("else")) {
      currentScope = node.getScope();
    } else {
      throw new RuntimeError("Invalid if stmt node name");
    }
  }

  protected String getVarName(String name) {
    if (name.equals("this")) {
      return "%" + name;
    }
    while (!(currentScope instanceof GlobalScope)) {
      if (currentScope.get(name, "var") != null) {
        return "%" + name + currentScope.getSuffix();
      }
      currentScope = currentScope.getParent();
    }
    if (currentScope.get(name, "var") != null) {
      return "@" + name;
    }
    throw new RuntimeError("Variable " + name + " not found");
  }

  protected void resetCounter() {
    counter = new IRCounter();
  }

  protected IRExprNode allocaHelper(TypeInfo typeInfo, Array<IREntity> lengths) {
    var instList = new IRExprNode();
    if (typeInfo.getDepth().equals(0)) {
      var allocaVar = new IRVariable(GlobalScope.irPtrType, "%alloca" + String.valueOf(counter.allocaCount++));
      var alloca = new IRAllocaNode(allocaVar, new IRType(typeInfo, Case.USE));
      instList.addNode(alloca);
      instList.setDest(allocaVar);
      instList.setDestAddr(allocaVar);
    } else if (lengths.size() > 0) {
      var length = lengths.get(0);
      lengths.remove(0);
      typeInfo.setDepth(typeInfo.getDepth() - 1);
      var allocaVar = new IRVariable(GlobalScope.irPtrType, "%alloca" + String.valueOf(counter.allocaCount++));
      instList.addNode(new IRCallNode(allocaVar, GlobalScope.irPtrType, "__builtIn_alloc_array",
          new Array<>(new IRLiteral(GlobalScope.irIntType, new IRType(typeInfo, Case.CTOR).getTypeSize()), length)));
      instList.setDest(allocaVar);
      instList.setDestAddr(allocaVar);
    }
    return instList;
  }
}
