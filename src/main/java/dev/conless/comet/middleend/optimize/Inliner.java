package dev.conless.comet.middleend.optimize;

import dev.conless.comet.frontend.ir.entity.IREntity;
import dev.conless.comet.frontend.ir.entity.IRFunc;
import dev.conless.comet.frontend.ir.entity.IRVariable;
import dev.conless.comet.frontend.ir.node.IRRoot;
import dev.conless.comet.frontend.ir.node.def.IRFuncDefNode;
import dev.conless.comet.frontend.ir.node.inst.IRAllocaNode;
import dev.conless.comet.frontend.ir.node.inst.IRArithNode;
import dev.conless.comet.frontend.ir.node.inst.IRBranchNode;
import dev.conless.comet.frontend.ir.node.inst.IRCallNode;
import dev.conless.comet.frontend.ir.node.inst.IRGetElementPtrNode;
import dev.conless.comet.frontend.ir.node.inst.IRInstNode;
import dev.conless.comet.frontend.ir.node.inst.IRJumpNode;
import dev.conless.comet.frontend.ir.node.inst.IRLoadNode;
import dev.conless.comet.frontend.ir.node.inst.IRPhiNode;
import dev.conless.comet.frontend.ir.node.inst.IRReturnNode;
import dev.conless.comet.frontend.ir.node.inst.IRStoreNode;
import dev.conless.comet.frontend.ir.node.stmt.IRBlockStmtNode;
import dev.conless.comet.frontend.ir.node.utils.IRCommentNode;
import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.container.Map;
import dev.conless.comet.utils.container.Pair;

public class Inliner {
  private Map<String, Integer> calledTimes;
  private Map<String, Integer> callingTimes;
  private Map<String, IREntity> param2value;
  private Map<String, IRFuncDefNode> func2def;
  private IRPhiNode returnPhi;
  private int inlineCount;
  private String blockName;

  public void visit(IRRoot node) {
    calledTimes = new Map<>();
    callingTimes = new Map<>();
    func2def = new Map<>();
    for (var func : node.getFuncs()) {
      prepare(func);
    }
    for (var func : node.getFuncs()) {
      visit(func);
    }
  }

  private void prepare(IRFuncDefNode node) {
    int count = 0;
    for (var block : node.getBlocks()) {
      for (var inst : block.getInsts()) {
        if (inst instanceof IRCallNode) {
          var call = (IRCallNode) inst;
          var funcName = call.getFuncName();
          if (calledTimes.containsKey(funcName)) {
            calledTimes.put(funcName, calledTimes.get(funcName) + 1);
          } else {
            calledTimes.put(funcName, 1);
          }
          count++;
        }
      }
    }
    callingTimes.put(node.getName(), count);
    func2def.put(node.getName(), node);
  }

  private int getCalledTimes(String funcName) {
    return calledTimes.get(funcName);
  }

  private int getCallingTimes(String funcName) {
    return callingTimes.get(funcName);
  }

  private void visit(IRFuncDefNode node) {
    inlineCount = 0;
    for (var i = 0; i < node.getBlocks().size(); i++) {
      var block = node.getBlocks().get(i);
      int inlineInst = -1;
      for (var j = 0; j < block.getInsts().size(); j++) {
        var inst = block.getInsts().get(j);
        if (inst instanceof IRCallNode callInst
            && func2def.get(callInst.getFuncName()) != null 
            && (getCalledTimes(callInst.getFuncName()) <= 3 || getCallingTimes(callInst.getFuncName()) == 0)) {
          inlineInst = j;
          break;
        }
      }
      if (inlineInst == -1) {
        continue;
      }
      var prevInsts = new Array<IRInstNode>(block.getInsts().subList(0, inlineInst));
      var succInsts = new Array<IRInstNode>(block.getInsts().subList(inlineInst + 1, block.getInsts().size()));
      var callInst = (IRCallNode) block.getInsts().get(inlineInst);
      inlineCount++;
      var returnValue = callInst.getDest();
      if (returnValue != null) {
        returnPhi = new IRPhiNode(returnValue, callInst.getType(), new Array<>());
      }
      var inlineBlocks = inline(func2def.get(callInst.getFuncName()), callInst);
      block.setInsts(prevInsts);
      block.setExitInst(new IRJumpNode(inlineBlocks.get(0).getLabelName()));
      var succBlock = new IRBlockStmtNode("inline." + inlineCount);
      succBlock.setExitInst(block.getExitInst());
      succBlock.setInsts(succInsts);
      succBlock.addFront(returnPhi);
      inlineBlocks.add(succBlock);
      node.getBlocks().addAll(i + 1, inlineBlocks);
    }
  }

  private Array<IRBlockStmtNode> inline(IRFuncDefNode func, IRCallNode callInst) {
    var newBlocks = new Array<IRBlockStmtNode>();
    param2value = new Map<String, IREntity>();
    for (var i = 0; i < callInst.getArgs().size(); i++) {
      param2value.put(func.getParams().get(i).getValue(), callInst.getArgs().get(i));
    }
    for (var block : func.getBlocks()) {
      var newBlock = new IRBlockStmtNode(block.getLabelName() + ".inline." + inlineCount);
      blockName = newBlock.getLabelName();
      for (var inst : block.getInsts()) {
        newBlock.addInst(replaceInst(inst));
      }
      newBlock.setExitInst(replaceInst(block.getExitInst()));
      newBlocks.add(newBlock);
    }
    return newBlocks;
  }

  private IRInstNode replaceInst(IRInstNode inst) {
    if (inst instanceof IRAllocaNode allocaInst) {
      var dest = (IRVariable) replaceEntity(allocaInst.getDest());
      return new IRAllocaNode(dest, allocaInst.getType());
    }
    if (inst instanceof IRArithNode arithInst) {
      var dest = (IRVariable) replaceEntity(arithInst.getDest());
      var lhs = replaceEntity(arithInst.getLhs());
      var rhs = replaceEntity(arithInst.getRhs());
      return new IRArithNode(dest, lhs, rhs, arithInst.getOp());
    }
    if (inst instanceof IRBranchNode branchInst) {
      var condition = replaceEntity(branchInst.getCondition());
      return new IRBranchNode(condition, branchInst.getTrueLabel() + ".inline." + inlineCount,
          branchInst.getFalseLabel() + ".inline." + inlineCount);
    }
    if (inst instanceof IRCallNode callInst) {
      var dest = callInst.getDest() == null ? null : (IRVariable) replaceEntity(callInst.getDest());
      var args = new Array<IREntity>();
      for (var arg : callInst.getArgs()) {
        args.add(replaceEntity(arg));
      }
      if (dest == null) {
        return new IRCallNode(callInst.getFuncName(), args);
      }
      return new IRCallNode(dest, callInst.getType(), callInst.getFuncName(), args);
    }
    if (inst instanceof IRGetElementPtrNode getInst) {
      var dest = (IRVariable) replaceEntity(getInst.getDest());
      var src = (IRVariable) replaceEntity(getInst.getSrc());
      var indices = new Array<IREntity>();
      for (var index : getInst.getIndices()) {
        indices.add(replaceEntity(index));
      }
      return new IRGetElementPtrNode(dest, src, getInst.getType(), indices);
    }
    if (inst instanceof IRJumpNode jumpInst) {
      return new IRJumpNode(jumpInst.getLabel() + ".inline." + inlineCount);
    }
    if (inst instanceof IRLoadNode loadInst) {
      var dest = (IRVariable) replaceEntity(loadInst.getDest());
      var src = (IRVariable) replaceEntity(loadInst.getSrc());
      return new IRLoadNode(dest, src);
    }
    if (inst instanceof IRPhiNode phiInst) {
      var dest = (IRVariable) replaceEntity(phiInst.getDest());
      var values = new Array<Pair<IREntity, String>>();
      for (var value : phiInst.getValues()) {
        values.add(new Pair<IREntity, String>(replaceEntity(value.a), value.b + ".inline." + inlineCount));
      }
      return new IRPhiNode(dest, phiInst.getType(), values);
    }
    if (inst instanceof IRReturnNode returnInst) {
      if (returnInst.getValue() != null) {
        returnPhi.getValues().add(new Pair<IREntity, String>(returnInst.getValue(), blockName));
      }
      return new IRJumpNode("inline." + inlineCount);
    }
    if (inst instanceof IRStoreNode storeInst) {
      var dest = (IRVariable) replaceEntity(storeInst.getDest());
      var src = replaceEntity(storeInst.getSrc());
      return new IRStoreNode(dest, src);
    }
    if (inst instanceof IRCommentNode) {
      return inst;
    }
    throw new RuntimeException("Unknown instruction: " + inst);
  }

  private IREntity replaceEntity(IREntity entity) {
    if (entity instanceof IRVariable variable && variable.isTemp()) {
      var name = variable.getValue();
      if (name.endsWith(".param")) {
        return param2value.get(name);
      }
      return new IRVariable(variable.getType(), name + ".inline." + inlineCount);
    }
    return entity;
  }

}
