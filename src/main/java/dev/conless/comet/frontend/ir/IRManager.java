package dev.conless.comet.frontend.ir;

import dev.conless.comet.frontend.ast.node.ASTNode;
import dev.conless.comet.frontend.ast.node.global.ScopedNode;
import dev.conless.comet.frontend.ast.node.stmt.IfStmtNode;
import dev.conless.comet.frontend.ir.entity.IREntity;
import dev.conless.comet.frontend.ir.entity.IRLiteral;
import dev.conless.comet.frontend.ir.entity.IRVariable;
import dev.conless.comet.frontend.ir.node.global.IRFuncDefNode;
import dev.conless.comet.frontend.ir.node.global.IRProgramNode;
import dev.conless.comet.frontend.ir.node.inst.*;
import dev.conless.comet.frontend.ir.node.utils.IRCommentNode;
import dev.conless.comet.frontend.ir.node.utils.IRExprNode;
import dev.conless.comet.frontend.ir.node.utils.IRTagNode;
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

  protected IRProgramNode programNode;
  protected IRFuncDefNode initNode;

  protected IRCounter counter;

  protected IRManager() {
    counter = new IRCounter();
    name2Size = new Map<>();
    name2Size.put("i32", 4);
    name2Size.put("ptr", 4);
    name2Size.put("i1", 1);
  }

  protected void enterASTNode(ASTNode node) {
    if (node instanceof ScopedNode) {
      var scope = ((ScopedNode) node).getScope();
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
      var scope = ((ScopedNode) node).getScope();
      if (scope != null) {
        currentScope = scope.getParent();
      }
    }
  }

  protected void exitASTNode(IfStmtNode node, String name) {
    if (name.equals("then")) {
      currentScope = node.getThenScope().getParent();
    } else if (name.equals("else")) {
      currentScope = node.getElseScope().getParent();
    } else {
      throw new RuntimeError("Invalid if stmt node name");
    }
  }

  protected String getVarName(String name) {
    if (name.equals("this")) {
      return "%" + name;
    }
    var scope = currentScope;
    while (!(scope instanceof GlobalScope)) {
      if (scope.get(name, "var") != null) {
        return "%" + name + scope.getSuffix();
      }
      scope = scope.getParent();
    }
    if (globalScope.get(name, "var") != null) {
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
      var allocaVar = new IRVariable(GlobalScope.irPtrType, "%.alloca." + String.valueOf(counter.allocaCount++));
      var alloca = new IRAllocaNode(allocaVar, new IRType(typeInfo, true));
      instList.addNode(alloca);
      if (!typeInfo.getIsBuiltIn()) {
        instList.addNode(new IRCallNode(String.format("__class.%s", typeInfo.getName(), typeInfo.getName()), lengths)); 
      }
      instList.setDest(allocaVar);
    } else if (lengths.size() > 0) {
      var length = lengths.get(0);
      lengths.remove(0);
      typeInfo.setDepth(typeInfo.getDepth() - 1);
      var allocaVar = new IRVariable(GlobalScope.irPtrType, "%.alloca." + String.valueOf(counter.allocaCount++));
      instList.addNode(new IRCommentNode(String.format("%s = alloca %s%s[%s]", allocaVar.getValue(), typeInfo.getName(),
          "*".repeat(typeInfo.getDepth()), length.getValue())));
      instList.addNode(new IRCallNode(allocaVar, GlobalScope.irPtrType, "__array_alloca",
          new Array<>(new IRLiteral(GlobalScope.irIntType, name2Size.get(new IRType(typeInfo, true).getTypeName())),
              length)));
      if (lengths.size() > 0) {
        counter.loopCount++;
        var condTag = new IRTagNode("loop." + String.valueOf(counter.loopCount) + ".cond");
        var updateTag = new IRTagNode("loop." + String.valueOf(counter.loopCount) + ".update");
        var bodyTag = new IRTagNode("loop." + String.valueOf(counter.loopCount) + ".body");
        var endTag = new IRTagNode("loop." + String.valueOf(counter.loopCount) + ".end");
        var forVar = new IRVariable(GlobalScope.irPtrType, "%.for." + String.valueOf(counter.loopCount) + ".0");
        instList.addNode(new IRCommentNode("for " + forVar.getValue() + " in range (0, " + length.getValue() + ")"));
        instList.addNode(new IRAllocaNode(forVar, GlobalScope.irIntType));
        instList.addNode(new IRStoreNode(forVar, new IRLiteral(GlobalScope.irIntType, 0)));
        instList.addNode(new IRJumpNode(condTag.getName()));
        instList.addNode(condTag);
        var forVarLoadedCmp = new IRVariable(GlobalScope.irIntType,
            "%.for." + String.valueOf(counter.loopCount) + ".1");
        var condVar = new IRVariable(GlobalScope.irBoolType, "%.for." + String.valueOf(counter.loopCount) + ".2");
        instList.addNode(new IRLoadNode(forVarLoadedCmp, forVar, GlobalScope.irIntType));
        instList.addNode(new IRArithNode(condVar, forVarLoadedCmp, length, "slt"));
        instList.addNode(new IRBranchNode(condVar, bodyTag.getName(), endTag.getName()));
        instList.addNode(updateTag);
        var forVarLoadedUpd = new IRVariable(GlobalScope.irIntType,
            "%.for." + String.valueOf(counter.loopCount) + ".3");
        instList.addNode(new IRLoadNode(forVarLoadedUpd, forVar, GlobalScope.irIntType));
        var forVarAfterUpd = new IRVariable(GlobalScope.irIntType,
            "%.for." + String.valueOf(counter.loopCount) + ".4");
        instList
            .addNode(new IRArithNode(forVarAfterUpd, forVarLoadedUpd, new IRLiteral(GlobalScope.irIntType, 1), "add"));
        instList.addNode(new IRStoreNode(forVar, forVarAfterUpd));
        instList.addNode(new IRJumpNode(condTag.getName()));
        instList.addNode(bodyTag);
        var allocaEle = allocaHelper(typeInfo, lengths);
        instList.appendNodes(allocaEle);
        var index = new IRVariable(GlobalScope.irIntType,
            "%.for." + String.valueOf(counter.loopCount) + ".5");
        instList.addNode(new IRLoadNode(index, forVar, GlobalScope.irIntType));
        var addrToFill = new IRVariable(GlobalScope.irPtrType, "%.element." + String.valueOf(++counter.elementCount));
        instList
            .addNode(
                new IRGetElementPtrNode(addrToFill, allocaVar, typeInfo, new Array<>(index)));
        instList.addNode(new IRStoreNode(addrToFill, allocaEle.getDest()));
        instList.addNode(new IRJumpNode(updateTag.getName()));
        instList.addNode(endTag);
      }
      instList.setDest(allocaVar);
    }
    return instList;
  }

  void initSize(String name, Array<IRType> types) {
    var totalSize = 0;
    for (var type : types) {
      totalSize += name2Size.get(type.getTypeName());
    }
    name2Size.put(name, totalSize);
  }
}
