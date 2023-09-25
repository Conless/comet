package dev.conless.comet.backend.allocator;

import java.util.function.Function;

import dev.conless.comet.backend.asm.entity.ASMVirtualReg;
import dev.conless.comet.backend.asm.node.ASMRoot;
import dev.conless.comet.backend.asm.node.global.ASMFuncDefNode;
import dev.conless.comet.backend.asm.node.inst.ASMBeqzNode;
import dev.conless.comet.backend.asm.node.inst.ASMInstNode;
import dev.conless.comet.backend.asm.node.inst.ASMJumpNode;
import dev.conless.comet.backend.asm.node.stmt.ASMBlockStmtNode;
import dev.conless.comet.frontend.ir.node.stmt.IRBlockStmtNode;
import dev.conless.comet.utils.container.Map;
import dev.conless.comet.utils.container.Set;

public class LivenessAnalyzer {
  private Map<String, ASMBlockStmtNode> label2Block;
  private Set<ASMBlockStmtNode> visited;
  private ASMFuncDefNode currentFunc;

  public void visit(ASMRoot root) {
    for (var func : root.getFuncs()) {
      visit(func);
    }
  }

  public void visit(ASMFuncDefNode node) {
    currentFunc = node;
    label2Block = new Map<>();
    visited = new Set<>();
    for (var block : node.getBlocks()) {
      label2Block.put(block.getLabel().getLabel(), block);
    }
    for (var block : node.getBlocks()) {
      init(block);
    }
    calcRpo(node.getBlocks().get(0));
    boolean changed = true;
    while (changed) {
      changed = false;
      for (var block : node.getOrder2Block()) {
        if (calc(block)) {
          changed = true;
        }
      }
    }
    for (var block : node.getBlocks()) {
      visit(block);
    }
  }

  void calcRpo(ASMBlockStmtNode block) {
    visited.add(block);
    for (var succ : block.getSuccessors()) {
      if (!visited.contains(succ)) {
        calcRpo(succ);
      }
    }
    currentFunc.getBlock2Order().put(block, currentFunc.getBlock2Order().size());
    currentFunc.getOrder2Block().add(0, block);
  }

  public void init(ASMBlockStmtNode node) {
    node.setDefs(new Set<>());
    node.setUses(new Set<>());
    for (var inst : node.getInsts()) {
      var uses = inst.getUses();
      for (var use : uses) {
        node.getUses().add(use);
      }
      var def = inst.getDef();
      if (def != null) {
        node.getDefs().add(def);
      }
    }
    for (var inst : node.getExitInst().getInsts()) {
      var uses = inst.getUses();
      for (var use : uses) {
        node.getUses().add(use);
      }
      var def = inst.getDef();
      if (def != null) {
        node.getDefs().add(def);
      }
      if (inst instanceof ASMJumpNode jumpInst) {
        var target = (ASMBlockStmtNode) label2Block.get(jumpInst.getLabel());
        node.getSuccessors().add(target);
        target.getPredecessors().add(node);
      } else if (inst instanceof ASMBeqzNode brInst) {
        var target = (ASMBlockStmtNode) label2Block.get(brInst.getLabel());
        node.getSuccessors().add(target);
        target.getPredecessors().add(node);
      }
    }
  }

  public boolean calc(ASMBlockStmtNode node) {
    var oldIn = node.getLiveIn();
    var oldOut = node.getLiveOut();
    node.setLiveIn(new Set<>());
    node.setLiveOut(new Set<>());
    for (var succ : node.getSuccessors()) {
      node.getLiveOut().addAll(succ.getLiveIn());
    }
    node.getLiveIn().addAll(node.getUses());
    node.getLiveIn().addAll(node.getLiveOut());
    node.getLiveIn().removeAll(node.getDefs());
    node.getLiveOut().removeAll(node.getDefs());
    return !node.getLiveIn().equals(oldIn) || !node.getLiveOut().equals(oldOut);
  }

  public void visit(ASMBlockStmtNode node) {
    System.out.println(node.getLabel().getLabel());
    var live = new Set<ASMVirtualReg>(node.getLiveOut());
    Function<ASMInstNode, Void> visitInst = (inst) -> {
      inst.setLiveOut(new Set<ASMVirtualReg>(live));
      live.addAll(inst.getUses());
      if (inst.getDef() != null) {
        live.remove(inst.getDef());
      }
      inst.setLiveIn(new Set<ASMVirtualReg>(live));
      return null;
    };
    for (var i = node.getExitInst().getInsts().size() - 1; i >= 0; i--) {
      visitInst.apply(node.getExitInst().getInsts().get(i));
    }
    for (var i = node.getInsts().size() - 1; i >= 0; i--) {
      visitInst.apply(node.getInsts().get(i));
    }
  }
}
