package dev.conless.comet.frontend.ir;

import dev.conless.comet.frontend.ast.node.ASTNode;
import dev.conless.comet.frontend.ast.node.special.ScopedNode;
import dev.conless.comet.frontend.ir.node.*;
import dev.conless.comet.frontend.ir.node.inst.*;
import dev.conless.comet.frontend.ir.node.module.*;
import dev.conless.comet.frontend.ir.type.IRType;
import dev.conless.comet.frontend.utils.scope.BaseScope;
import dev.conless.comet.frontend.utils.scope.GlobalScope;
import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.container.Map;
import dev.conless.comet.utils.error.*;

public class IRManager {
  protected IRProgramNode programNode;
  protected GlobalScope globalScope;
  protected BaseScope currentScope;

  protected IRManager() {
  }

  public IRProgramNode getProgram() {
    return programNode;
  }

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
    while (!(currentScope instanceof GlobalScope)) {
      if (currentScope.get(name, "var") != null) {
        return "mx_var_" + name + currentScope.getSuffix();
      }
      currentScope = currentScope.getParent();
    }
    if (currentScope.get(name, "var") != null) {
      return "mx_var_" + name;
    }
    throw new RuntimeError("Variable " + name + " not found");
  }

  protected IRBlockNode getFuncEntryBlock(IRFuncNode funcNode) {
    for (var param : funcNode.getParams()) {
      // funcNode.addInst(IRInstNode.builder()
      //     .op("store")
      //     .operands(new Array<>(new IRVarNode(param.getSecond(), new IRType(param.getFirst()))))
      //     .build());
    }
    return null;
  }
}
