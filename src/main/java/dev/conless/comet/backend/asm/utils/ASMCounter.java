package dev.conless.comet.backend.asm.utils;

import dev.conless.comet.backend.asm.entity.ASMAddress;
import dev.conless.comet.backend.asm.entity.ASMReg;
import dev.conless.comet.utils.container.Map;

public class ASMCounter {
  public static int funcCount = -1;
  public int allocaCount;
  public Map<String, ASMReg> name2reg;

  public ASMCounter() {
    funcCount++;
    this.allocaCount = 0;
    this.name2reg = new Map<>();
  }
}
