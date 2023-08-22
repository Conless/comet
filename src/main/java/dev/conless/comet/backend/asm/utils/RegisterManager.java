package dev.conless.comet.backend.asm.utils;

import dev.conless.comet.backend.asm.entity.ASMRegister;
import dev.conless.comet.utils.container.Set;

@lombok.Getter
public class RegisterManager {
  private final ASMRegister zero = new ASMRegister("zero");
  private final ASMRegister ra = new ASMRegister("ra");
  private final ASMRegister sp = new ASMRegister("sp");
  private final ASMRegister gp = new ASMRegister("gp");
  private final ASMRegister tp = new ASMRegister("tp");
  private final ASMRegister rv = new ASMRegister("a0");

  private Set<Integer> tempRegs, argRegs;

  public RegisterManager() {
    this.tempRegs = new Set<>();
    for (int i = 0; i < 7; i++) {
      this.tempRegs.add(i);
    }
    this.argRegs = new Set<>();
    for (int i = 2; i < 8; i++) {
      this.argRegs.add(i);
    }
  }

  public ASMRegister getTempReg() {
    if (this.tempRegs.size() == 0) {
      throw new RuntimeException("No more free temp registers");
    }
    return new ASMRegister("t" + String.valueOf(this.tempRegs.pollFirst()));
  }

  public ASMRegister getArgReg() {
    if (this.argRegs.size() == 0) {
      throw new RuntimeException("No more free arg registers");
    }
    return new ASMRegister("a" + String.valueOf(this.argRegs.pollFirst()));
  }

  public void resetArgRegs() {
    this.argRegs = new Set<>();
    for (int i = 2; i < 8; i++) {
      this.argRegs.add(i);
    }
  }

  private void evictSingleReg(ASMRegister reg) {
    if (reg.getName().startsWith("t")) {
      this.tempRegs.add(Integer.parseInt(reg.getName().substring(1)));
    } else if (reg.getName().startsWith("a")) {
      this.argRegs.add(Integer.parseInt(reg.getName().substring(1)));
    }
  }

  public void evictReg(ASMRegister... regs) {
    for (ASMRegister reg : regs) {
      this.evictSingleReg(reg);
    }
  }
}
