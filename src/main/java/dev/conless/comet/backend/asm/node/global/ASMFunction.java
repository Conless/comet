package dev.conless.comet.backend.asm.node.global;

import dev.conless.comet.backend.asm.node.ASMNode;
import dev.conless.comet.backend.asm.node.stmt.ASMStmtsNode;

@lombok.Getter
@lombok.Setter
public class ASMFunction extends ASMNode {
  private String name;
  private ASMStmtsNode body;
  private ASMStmtsNode stRegs, ldRegs;

  public ASMFunction(String name) {

  }

  @Override
  public String toString() {
    return null;
  }
}
