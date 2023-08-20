package dev.conless.comet.backend.asm.node.inst;

import dev.conless.comet.backend.asm.entity.ASMRegister;
import dev.conless.comet.backend.asm.node.ASMNode;

@lombok.Value
@lombok.EqualsAndHashCode(callSuper = true)
public class ASMArithNode extends ASMNode {
  private String op;
  private ASMRegister lhs, rhs;

  public ASMArithNode(String op, ASMRegister lhs, ASMRegister rhs) {
    this.op = op;
    this.lhs = lhs;
    this.rhs = rhs;
  }

  @Override
  public String toString() {
    return String.format("%-6s", op) + lhs + ", " + rhs;
  }
}
