package dev.conless.comet.frontend.ir.utils;

import dev.conless.comet.utils.container.Map;

import dev.conless.comet.frontend.ast.node.ASTNode;
import dev.conless.comet.frontend.ast.node.stmt.ASTIfStmtNode;
import dev.conless.comet.frontend.ast.node.utils.ASTNodeWithScope;
import dev.conless.comet.frontend.ir.entity.IREntity;
import dev.conless.comet.frontend.ir.entity.IRLiteral;
import dev.conless.comet.frontend.ir.entity.IRVariable;
import dev.conless.comet.frontend.ir.node.def.IRFuncDefNode;
import dev.conless.comet.frontend.ir.node.def.IRStrDefNode;
import dev.conless.comet.frontend.ir.node.inst.*;
import dev.conless.comet.frontend.ir.node.stmt.IRBlockStmtNode;
import dev.conless.comet.frontend.ir.node.stmt.IRStmtNode;
import dev.conless.comet.frontend.ir.node.utils.IRLabelNode;
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
    initNode = new IRFuncDefNode("global.var.init", new Array<>(), GlobalScope.irVoidType,
        new Array<>(new IRBlockStmtNode("entry")));
    name2Size = new Map<>();
    strDefs = new Array<>();
    name2Size.put("i32", 4);
    name2Size.put("ptr", 4);
    name2Size.put("i1", 4);
  }

  protected Array<IRBlockStmtNode> stmt2Block(IRStmtNode stmt, IRType type) {
    var blocks = new Array<IRBlockStmtNode>(new IRBlockStmtNode("start"));
    var entryBlock = new IRBlockStmtNode("entry");
    var startBlock = blocks.get(0);
    var globalSet = new Map<String, IRType>();
    for (var node : stmt.getInsts()) {
      if (node instanceof IRLabelNode) {
        if (blocks.getLast().getExitInst() == null) {
          throw new RuntimeError("Every block should end with an exit inst");
        }
        blocks.add(new IRBlockStmtNode(((IRLabelNode) node).getName()));
      } else {
        if (blocks.getLast().getExitInst() != null) {
          continue;
        }
        if (node instanceof IRStoreNode) {
          if (((IRStoreNode) node).getDest() instanceof IRVariable) {
            var dest = (IRVariable) ((IRStoreNode) node).getDest();
            if (dest.isGlobal()) {
              globalSet.put(dest.getValue(), ((IRStoreNode) node).getSrc().getType());
            }
          }
        } else if (node instanceof IRLoadNode) {
          if (((IRLoadNode) node).getSrc() instanceof IRVariable) {
            var src = (IRVariable) ((IRLoadNode) node).getSrc();
            if (src.isGlobal()) {
              globalSet.put(src.getValue(), ((IRLoadNode) node).getDest().getType());
            }
          }
        }
        if (node instanceof IRJumpNode || node instanceof IRBranchNode || node instanceof IRReturnNode) {
          blocks.getLast().setExitInst(node);
        } else if (node instanceof IRAllocaNode) {
          entryBlock.addInst(node);
        } else {
          blocks.getLast().addInst(node);
        }
      }
    }
    if (blocks.getLast().getExitInst() == null) {
      blocks.getLast().setExitInst(new IRReturnNode(type));
    }
    // for (var global : globalSet.entrySet()) {
    //   var newVar = new IRVariable(GlobalScope.irPtrType, global.getKey().replace("@", "%"));
    //   var tempVar = new IRVariable(global.getValue(), newVar.getValue() + ".temp.0");
    //   entryBlock.addInst(new IRLoadNode(tempVar, new IRVariable(GlobalScope.irPtrType, global.getKey())));
    //   entryBlock.addInst(new IRAllocaNode(newVar, global.getValue()));
    //   entryBlock.addInst(new IRStoreNode(newVar, tempVar));
    // }
    // var counter = 0;
    // for (var block : blocks) {
    //   if (!(block.getExitInst() instanceof IRReturnNode)) {
    //     continue;
    //   }
    //   var exitNodes = new IRStmtNode();
    //   for (var global : globalSet.entrySet()) {
    //     var newVar = new IRVariable(GlobalScope.irPtrType, global.getKey().replace("@", "%"));
    //     var tempVar = new IRVariable(global.getValue(), newVar.getValue() + ".temp." + ++counter);
    //     exitNodes.addInst(new IRLoadNode(tempVar, newVar));
    //     exitNodes.addInst(new IRStoreNode(new IRVariable(GlobalScope.irPtrType, global.getKey()), tempVar));
    //   }
    //   block.appendInsts(exitNodes);
    // }
    entryBlock.appendInsts(startBlock);
    entryBlock.setExitInst(startBlock.getExitInst());
    blocks.set(0, entryBlock);
    return blocks;
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
    instList.addInst(alloca);
    if (!typeInfo.isBuiltIn()) {
      instList.addInst(
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
