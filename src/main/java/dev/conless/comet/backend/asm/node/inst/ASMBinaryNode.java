package dev.conless.comet.backend.asm.node.inst;

import dev.conless.comet.backend.asm.entity.ASMRegister;
import dev.conless.comet.backend.asm.node.ASMNode;

@lombok.Value
@lombok.EqualsAndHashCode(callSuper = true)
public class ASMBinaryNode extends ASMNode {
  private String op;
  private ASMRegister dest, lhs, rhs;

  public ASMBinaryNode(String op, ASMRegister dest, ASMRegister lhs, ASMRegister rhs) {
    this.op = op;
    this.dest = dest;
    this.lhs = lhs;
    this.rhs = rhs;
  }

  @Override
  public String toString() {
    return String.format("%-6s", op) + dest + ", " + lhs + ", " + rhs;
  }
}
