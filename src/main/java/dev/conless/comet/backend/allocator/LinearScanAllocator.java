package dev.conless.comet.backend.allocator;

import java.util.function.Function;

import org.antlr.v4.runtime.misc.Pair;

import dev.conless.comet.backend.asm.entity.*;
import dev.conless.comet.backend.asm.node.ASMNode;
import dev.conless.comet.backend.asm.node.ASMRoot;
import dev.conless.comet.backend.asm.node.global.*;
import dev.conless.comet.backend.asm.node.inst.*;
import dev.conless.comet.backend.asm.node.stmt.*;
import dev.conless.comet.utils.container.*;
import dev.conless.comet.utils.error.*;

@lombok.Getter
@lombok.Setter
class LiveInterval {
  private ASMVirtualReg reg;
  private int begin;
  private int end;

  public LiveInterval(ASMVirtualReg reg, int begin, int end) {
    this.reg = reg;
    this.begin = begin;
    this.end = end;
  }

  public void updateBegin(int begin) {
    this.begin = Math.min(this.begin, begin);
  }

  public void updateEnd(int end) {
    this.end = Math.max(this.end, end);
  }
}

public class LinearScanAllocator extends RegAllocator {
  private Set<ASMPhysicalReg> cleanRegs;
  private Set<ASMPhysicalReg> freeRegs;
  private Map<ASMVirtualReg, ASMAddress> virtual2reg;
  private Map<ASMVirtualReg, LiveInterval> virtual2interval;
  private Map<ASMPhysicalReg, LiveInterval> reg2interval;
  private Array<LiveInterval> intervals;

  @Override
  public ASMNode visit(ASMNode node) {
    throw new RuntimeError("LinearScanAllocator.visit(ASMNode) should not be called");
  }

  @Override
  public ASMNode visit(ASMRoot node) {
    var funcs = new Array<ASMFuncDefNode>();
    for (var func : node.getFuncs()) {
      funcs.add((ASMFuncDefNode) func.accept(this));
    }
    node.setFuncs(funcs);
    return node;
  }

  @Override
  public ASMNode visit(ASMFuncDefNode node) {
    currentFunc = node;
    cleanRegs = new Set<>();
    freeRegs = new Set<>();
    for (var reg : regs.getTempRegs()) {
      cleanRegs.add(reg);
    }
    for (var reg : regs.getFreeRegs()) {
      freeRegs.add(reg);
    }
    virtual2reg = new Map<>();
    virtual2interval = new Map<>();
    reg2interval = new Map<>();
    intervals = new Array<>();
    collectInterval(node);
    int position = -1;
    for (var interval : intervals) {
      position = interval.getBegin();
      expireIntervals(position);
      if (freeRegs.isEmpty()) {
        evictInterval();
      }
      var reg = freeRegs.pollFirst();
      reg2interval.put(reg, interval);
      virtual2reg.put(interval.getReg(), new ASMAddress(reg, 0));
      currentFunc.getUsedRegs().add(reg);
    }
    var blocks = new Array<ASMBlockStmtNode>();
    for (var stmt : node.getBlocks()) {
      blocks.add((ASMBlockStmtNode) stmt.accept(this));
    }
    node.setBlocks(blocks);
    return node;
  }

  public void collectInterval(ASMFuncDefNode node) {
    var position = 0;
    for (var block : node.getOrder2Block()) {
      if (block.getLabel().getLabel().endsWith("init")) {
        for (var def : block.getLiveOut()) {
          var interval = new LiveInterval(def, -1, -1);
          virtual2interval.put(def, interval);
        }
        continue;
      }
      Function<Pair<ASMInstNode, Integer>, Void> visitUses = (inst) -> {
        var uses = inst.a.getLiveOut();
        for (var use : uses) {
          var interval = virtual2interval.get(use);
          if (interval == null) {
            interval = new LiveInterval(use, inst.b, inst.b);
            virtual2interval.put(use, interval);
          } else {
            interval.updateEnd(inst.b);
          }
        }
        return null;
      };
      Function<Pair<ASMInstNode, Integer>, Void> visitDefs = (inst) -> {
        var defs = inst.a.getLiveIn();
        for (var def : defs) {
          var interval = virtual2interval.get(def);
          if (interval == null) {
            interval = new LiveInterval(def, inst.b, inst.b);
            virtual2interval.put(def, interval);
          } else {
            interval.updateBegin(inst.b);
          }
        }
        return null;
      };
      for (var inst : block.getInsts()) {
        visitUses.apply(new Pair<>(inst, ++position));
        visitDefs.apply(new Pair<>(inst, ++position));
      }
      for (var inst : block.getExitInst().getInsts()) {
        visitUses.apply(new Pair<>(inst, ++position));
        visitDefs.apply(new Pair<>(inst, ++position));
      }
    }
    intervals.addAll(virtual2interval.values());
    intervals.sort((a, b) -> {
      return a.getBegin() - b.getBegin();
    });
  }

  public void expireIntervals(int position) {
    var expired = new Array<ASMPhysicalReg>();
    for (var oldEntry : reg2interval.entrySet()) {
      if (oldEntry.getValue().getEnd() < position) {
        expired.add(oldEntry.getKey());
      }
    }
    for (var reg : expired) {
      reg2interval.remove(reg);
      freeRegs.add(reg);
    }
  }

  public void evictInterval() {
    var position = -1;
    var evicted = new Pair<ASMPhysicalReg, LiveInterval>(null, null);
    for (var oldEntry : reg2interval.entrySet()) {
      if (oldEntry.getValue().getEnd() > position) {
        position = oldEntry.getValue().getEnd();
        evicted = new Pair<ASMPhysicalReg, LiveInterval>(oldEntry.getKey(), oldEntry.getValue());
      }
    }
    if (evicted.a == null) {
      throw new RuntimeError("No interval to evict");
    }
    var reg = evicted.a;
    var interval = evicted.b;
    spillReg(interval.getReg());
    reg2interval.remove(reg);
    freeRegs.add(reg);
  }

  public void spillReg(ASMVirtualReg reg) {
    virtual2reg.put(reg, new ASMAddress(regs.getSp(), currentFunc.getSpilled() * 4));
    currentFunc.addSpilled();
  }

  @Override
  public ASMPhysicalReg getRValueReg(ASMReg reg, ASMStmtNode insts) {
    if (reg instanceof ASMPhysicalReg phyReg) {
      return phyReg;
    }
    var addr = virtual2reg.get(reg);
    if (addr == null) {
      throw new RuntimeError("No address for virtual register");
    }
    if (!addr.getBase().equals(regs.getSp())) {
      return (ASMPhysicalReg) addr.getBase();
    }
    var newReg = cleanRegs.pollFirst();
    insts.addInst(new ASMLoadNode(newReg, addr));
    newReg.setVirtualID(addr.getOffset());
    return newReg;
  }

  @Override
  public ASMPhysicalReg getLValueReg(ASMReg reg) {
    if (reg instanceof ASMPhysicalReg phyReg) {
      return phyReg;
    }
    var addr = virtual2reg.get(reg);
    if (addr == null) {
      throw new RuntimeError("No address for virtual register");
    }
    if (!addr.getBase().equals(regs.getSp())) {
      return (ASMPhysicalReg) addr.getBase();
    }
    var newReg = cleanRegs.pollFirst();
    newReg.setDirty(true);
    newReg.setVirtualID(addr.getOffset());
    return newReg;
  }

  @Override
  public void evictReg(ASMStmtNode insts, ASMPhysicalReg... dirtyRegs) {
    for (var reg : dirtyRegs) {
      if (!regs.getTempRegs().contains(reg)) {
        continue;
      }
      if (reg.isDirty()) {
        insts.addInst(new ASMStoreNode(reg, new ASMAddress(regs.getSp(), reg.getVirtualID())));
        reg.setDirty(false);
        reg.setVirtualID(-1);
      }
      cleanRegs.add(reg);
    }
  }
}
