package dev.conless.comet.frontend.ir.utils;

import dev.conless.comet.frontend.ast.node.ASTNode;
import dev.conless.comet.frontend.ast.node.stmt.ASTIfStmtNode;
import dev.conless.comet.frontend.ast.node.utils.ASTNodeWithScope;
import dev.conless.comet.frontend.ir.entity.IREntity;
import dev.conless.comet.frontend.ir.entity.IRLiteral;
import dev.conless.comet.frontend.ir.entity.IRVariable;
import dev.conless.comet.frontend.ir.node.IRRoot;
import dev.conless.comet.frontend.ir.node.def.IRFuncDefNode;
import dev.conless.comet.frontend.ir.node.def.IRStrDefNode;
import dev.conless.comet.frontend.ir.node.inst.*;
import dev.conless.comet.frontend.ir.node.stmt.IRStmtNode;
import dev.conless.comet.frontend.ir.type.IRType;
import dev.conless.comet.frontend.utils.metadata.TypeInfo;
import dev.conless.comet.frontend.utils.scope.BaseScope;
import dev.conless.comet.frontend.utils.scope.GlobalScope;
import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.container.Map;
import dev.conless.comet.utils.error.*;

public class IRManager {
  protected GlobalScope globalScope;
  protected BaseScope currentScope;

  protected Map<String, Integer> name2Size;
  protected Array<IRStrDefNode> strDefs;
  protected IRFuncDefNode initNode;
  protected IRCounter counter;

  protected IRManager() {
    counter = new IRCounter();
    initNode = new IRFuncDefNode("global.var.init", new Array<>(), GlobalScope.irVoidType);
    name2Size = new Map<>();
    strDefs = new Array<>();
    name2Size.put("i32", 4);
    name2Size.put("ptr", 4);
    name2Size.put("i1", 4);
  }

  protected void enterASTNode(ASTNode node) {
    if (node instanceof ASTNodeWithScope) {
      var scope = ((ASTNodeWithScope) node).getScope();
      if (scope == null) {
        return;
      }
      currentScope = scope;
      if (globalScope == null) {
        if (!(currentScope instanceof GlobalScope)) {
          throw new RuntimeError("Global scope not found");
        }
        globalScope = (GlobalScope) currentScope;
      }
    }
  }

  protected void enterASTNode(ASTIfStmtNode node, String name) {
    if (name.equals("then")) {
      currentScope = node.getThenScope();
    } else if (name.equals("else")) {
      currentScope = node.getElseScope();
    } else {
      throw new RuntimeError("Invalid if stmt node name");
    }
  }

  protected void exitASTNode(ASTNode node) {
    if (node instanceof ASTNodeWithScope) {
      var scope = ((ASTNodeWithScope) node).getScope();
      if (scope != null) {
        currentScope = scope.getParent();
      }
    }
  }

  protected void exitASTNode(ASTIfStmtNode node, String name) {
    if (name.equals("then")) {
      currentScope = node.getThenScope().getParent();
    } else if (name.equals("else")) {
      currentScope = node.getElseScope().getParent();
    } else {
      throw new RuntimeError("Invalid if stmt node name");
    }
  }

  protected String getVarName(String name, BaseScope scope) {
    if (name.equals("this")) {
      return "%" + name;
    }
    if (scope instanceof GlobalScope) {
      return "@" + name;
    }
    return "%" + name + scope.getSuffix();
  }

  protected void resetCounter() {
    counter = new IRCounter();
  }

  protected IRStmtNode allocaHelper(TypeInfo typeInfo, Array<IREntity> lengths) {
    if (typeInfo.getDepth() > 0) {
      throw new RuntimeError("Array type should be handled by malloc");
    }
    var instList = new IRStmtNode();
    var allocaVar = new IRVariable(GlobalScope.irPtrType, "%.alloca." + String.valueOf(counter.allocaCount++));
    var alloca = new IRCallNode(allocaVar, GlobalScope.irPtrType, "malloc",
        new Array<>(new IRLiteral(GlobalScope.irIntType, name2Size.get(new IRType(typeInfo, true).getTypeName()))));
    instList.addNode(alloca);
    if (!typeInfo.isBuiltIn()) {
      instList.addNode(
          new IRCallNode(String.format("__class.%s", typeInfo.getName(), typeInfo.getName()), new Array<>(allocaVar)));
    }
    instList.setDest(allocaVar);
    return instList;
  }

  protected void initSize(String name, Array<IRType> types) {
    var totalSize = 0;
    for (var type : types) {
      totalSize += name2Size.get(type.getTypeName());
    }
    name2Size.put(name, totalSize);
  }
}
