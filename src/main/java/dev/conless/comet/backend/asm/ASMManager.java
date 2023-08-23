package dev.conless.comet.backend.asm;

import dev.conless.comet.backend.asm.utils.BuiltInRegs;

public class ASMManager {
  protected ASMCounter counter;
  protected BuiltInRegs regs;

  protected ASMManager() {
    this.counter = new ASMCounter(0);
    this.regs = new BuiltInRegs();
  }

  protected String getLabelName(String str) {
    return String.format(".Lfunc%d.%s", ASMCounter.funcCount, str);
  }
}
