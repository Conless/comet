package dev.conless.comet.backend.asm.utils;

public class ASMManager {
  protected ASMCounter counter;
  protected BuiltInRegs regs;

  protected ASMManager() {
    this.counter = new ASMCounter();
    this.regs = new BuiltInRegs();
  }

  protected String getLabelName(String str) {
    return String.format(".Lfunc%d.%s", ASMCounter.funcCount, str);
  }
}
