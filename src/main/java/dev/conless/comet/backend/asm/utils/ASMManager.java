package dev.conless.comet.backend.asm.utils;

import dev.conless.comet.backend.asm.entity.ASMPhysicalReg;
import dev.conless.comet.backend.asm.node.stmt.ASMBlockStmtNode;
import dev.conless.comet.utils.container.Map;
import dev.conless.comet.utils.container.Set;

public class ASMManager {
  protected ASMCounter counter; // for instruction selection
  protected BuiltInRegs regs;
  protected Map<String, ASMBlockStmtNode> name2Block;

  protected ASMManager() {
    this.counter = new ASMCounter();
    this.regs = new BuiltInRegs();
    this.name2Block = new Map<>();
  }

  protected String getLabelName(String str) {
    return String.format(".Lfunc%d.%s", ASMCounter.funcCount, str);
  }
}
