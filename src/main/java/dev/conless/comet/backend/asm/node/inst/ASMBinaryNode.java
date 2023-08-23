package dev.conless.comet.backend.asm.node.inst;

import dev.conless.comet.backend.asm.entity.ASMReg;
import dev.conless.comet.backend.asm.node.ASMNode;

@lombok.Value
@lombok.EqualsAndHashCode(callSuper = true)
public class ASMBinaryNode extends ASMNode {
  private String op;
  private ASMReg dest, lhs, rhs;

  public ASMBinaryNode(String op, ASMReg dest, ASMReg lhs, ASMReg rhs) {
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
