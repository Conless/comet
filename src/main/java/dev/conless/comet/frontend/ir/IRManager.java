package dev.conless.comet.frontend.ir;

import dev.conless.comet.frontend.ast.node.ASTNode;
import dev.conless.comet.frontend.ast.node.global.ScopedNode;
import dev.conless.comet.frontend.ir.entity.IREntity;
import dev.conless.comet.frontend.ir.entity.IRLiteral;
import dev.conless.comet.frontend.ir.entity.IRVariable;
import dev.conless.comet.frontend.ir.node.*;
import dev.conless.comet.frontend.ir.node.global.*;
import dev.conless.comet.frontend.ir.node.inst.*;
import dev.conless.comet.frontend.ir.node.utils.IRExprNode;
import dev.conless.comet.frontend.ir.type.IRStructType;
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
  protected Map<String, IRStructType> structTypes;
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

  protected void exitASTNode(ASTNode node) {
    if (node instanceof ScopedNode) {
      currentScope = ((ScopedNode) node).getScope().getParent();
    }
  }

  protected String getVarName(String name) {
    if (name.equals("this")) {
      return name;
    }
    while (!(currentScope instanceof GlobalScope)) {
      if (currentScope.get(name, "var") != null) {
        return name + currentScope.getSuffix();
      }
      currentScope = currentScope.getParent();
    }
    if (currentScope.get(name, "var") != null) {
      return name;
    }
    throw new RuntimeError("Variable " + name + " not found");
  }

  protected void resetCounter() {
    counter = new IRCounter();
  }

  protected IRExprNode allocaHelper(TypeInfo typeInfo) {
    var instList = new IRExprNode();
    if (typeInfo.getDepth().equals(0)) {
      var allocaVar = new IRVariable(GlobalScope.irPtrType, "alloca" + String.valueOf(counter.allocaCount++), false);
      if (!typeInfo.getIsBuiltIn()) {
        var alloca = new IRAllocaNode(allocaVar, "class." + typeInfo.getName());
        instList.addNode(alloca);
      } else {
        var alloca = new IRAllocaNode(allocaVar, new IRType(typeInfo));
        instList.addNode(alloca);
      }
      instList.setDest(allocaVar);
    } else {
      throw new RuntimeError("IRBuilder.visit(NewExprNode) should not be called");
    }
    return instList;
  }
}
