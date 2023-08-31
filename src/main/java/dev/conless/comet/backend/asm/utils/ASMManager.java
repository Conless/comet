package dev.conless.comet.backend.asm.utils;

import dev.conless.comet.backend.asm.entity.ASMPhysicalReg;
import dev.conless.comet.utils.container.Set;

public class ASMManager {
  protected ASMCounter counter; // for instruction selection
  protected BuiltInRegs regs;

  protected int allocatedMem; // for register allocation
  protected Set<ASMPhysicalReg> usedRegs;

  protected ASMManager() {
    this.counter = new ASMCounter();
    this.regs = new BuiltInRegs();
    
  }

  protected String getLabelName(String str) {
    return String.format(".Lfunc%d.%s", ASMCounter.funcCount, str);
  }
}
