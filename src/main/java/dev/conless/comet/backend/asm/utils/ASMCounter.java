package dev.conless.comet.backend.asm.utils;

import dev.conless.comet.backend.asm.entity.ASMAddress;
import dev.conless.comet.backend.asm.entity.ASMReg;
import dev.conless.comet.utils.container.Map;

public class ASMCounter {
  public static int funcCount = 0;
  public int stackCount;
  public Map<String, ASMAddress> param2Addr;
  public Map<String, ASMReg> name2reg;

  public ASMCounter() {
    funcCount = 0;
    this.stackCount = 0;
    this.param2Addr = new Map<>();
    this.name2reg = new Map<>();
  }

  public ASMCounter(int stackCount) {
    funcCount++;
    this.stackCount = stackCount;
    this.param2Addr = new Map<>();
    this.name2reg = new Map<>();
  }
}
