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
import dev.conless.comet.frontend.ir.node.utils.IRTagNode;
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
      var allocaVar = new IRVariable(GlobalScope.irPtrType, "%alloca." + String.valueOf(counter.allocaCount++));
      var alloca = new IRAllocaNode(allocaVar, new IRType(typeInfo, Case.USE));
      instList.addNode(alloca);
      instList.setDest(allocaVar);
      instList.setDestAddr(allocaVar);
    } else if (lengths.size() > 0) {
      var length = lengths.get(0);
      lengths.remove(0);
      typeInfo.setDepth(typeInfo.getDepth() - 1);
      var allocaVar = new IRVariable(GlobalScope.irPtrType, "%alloca." + String.valueOf(counter.allocaCount++));
      instList.addNode(new IRCallNode(allocaVar, GlobalScope.irPtrType, "__builtIn_alloc_array",
          new Array<>(new IRLiteral(GlobalScope.irIntType, new IRType(typeInfo, Case.USE).getTypeSize()), length)));
      if (lengths.size() > 0) {
        counter.forCount++;
        var initTag = new IRTagNode("for." + String.valueOf(counter.forCount) + ".init");
        var condTag = new IRTagNode("for." + String.valueOf(counter.forCount) + ".cond");
        var updateTag = new IRTagNode("for." + String.valueOf(counter.forCount) + ".update");
        var bodyTag = new IRTagNode("for." + String.valueOf(counter.forCount) + ".body");
        var endTag = new IRTagNode("for." + String.valueOf(counter.forCount) + ".end");
        var forVar = new IRVariable(GlobalScope.irPtrType, "%for." + String.valueOf(counter.forCount) + ".var.0");
        instList.addNode(initTag);
        instList.addNode(new IRAllocaNode(forVar, GlobalScope.irIntType));
        instList.addNode(new IRStoreNode(forVar, new IRLiteral(GlobalScope.irIntType, 0)));
        instList.addNode(new IRJumpNode(bodyTag.getName()));
        instList.addNode(condTag);
        var forVarLoadedCmp = new IRVariable(GlobalScope.irIntType, "%for." + String.valueOf(counter.forCount) + ".var.1");
        var condVar = new IRVariable(GlobalScope.irBoolType, "%for." + String.valueOf(counter.forCount) + ".var.2");
        instList.addNode(new IRLoadNode(forVarLoadedCmp, forVar, GlobalScope.irIntType));
        instList.addNode(new IRIcmpNode(condVar, forVarLoadedCmp, length, "slt", GlobalScope.irIntType));
        instList.addNode(new IRBranchNode(condVar, bodyTag.getName(), endTag.getName()));
        instList.addNode(updateTag);
        var forVarLoadedUpd = new IRVariable(GlobalScope.irIntType,
            "%for." + String.valueOf(counter.forCount) + ".var.3");
        instList.addNode(new IRLoadNode(forVarLoadedUpd, forVar, GlobalScope.irIntType));
        var forVarAfterUpd = new IRVariable(GlobalScope.irIntType,
            "%for." + String.valueOf(counter.forCount) + ".var.4");
        instList.addNode(new IRArithNode(forVarAfterUpd, GlobalScope.irIntType, forVarLoadedUpd,
            new IRLiteral(GlobalScope.irIntType, 1), "add"));
        instList.addNode(new IRStoreNode(forVar, forVarAfterUpd));
        instList.addNode(new IRJumpNode(condTag.getName()));
        instList.addNode(bodyTag);
        var allocaEle = allocaHelper(typeInfo, lengths);
        instList.addNode(allocaEle);
        var index = new IRVariable(GlobalScope.irIntType,
            "%for." + String.valueOf(counter.forCount) + ".var.5");
        instList.addNode(new IRLoadNode(index, forVar, GlobalScope.irIntType));
        var addrToFill = new IRVariable(GlobalScope.irPtrType, "%__element_" + String.valueOf(++counter.elementCount));
        instList
            .addNode(new IRGetElementPtrNode(addrToFill, allocaVar, new IRType(typeInfo, Case.USE), new Array<>(index)));
        instList.addNode(new IRStoreNode(addrToFill, allocaEle.getDest()));
        instList.addNode(new IRJumpNode(updateTag.getName()));
        instList.addNode(endTag);

      }
      instList.setDest(allocaVar);
      instList.setDestAddr(allocaVar);
    }
    return instList;
  }
}
