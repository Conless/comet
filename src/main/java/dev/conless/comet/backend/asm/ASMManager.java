package dev.conless.comet.backend.asm;

import dev.conless.comet.backend.asm.utils.RegisterManager;

public class ASMManager {
  protected ASMCounter counter;
  protected RegisterManager regs;

  protected ASMManager() {
    this.counter = new ASMCounter();
    
  }

  protected String getLabelName(String str) {
    return String.format(".Lfunc%d.%s", ASMCounter.funcCount, str);
  }
}
