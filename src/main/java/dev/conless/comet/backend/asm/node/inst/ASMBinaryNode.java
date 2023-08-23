package dev.conless.comet.backend.asm.node.inst;

import dev.conless.comet.backend.asm.ASMVisitor;
import dev.conless.comet.backend.asm.entity.ASMReg;

@lombok.Getter
@lombok.Setter
public final class ASMBinaryNode extends ASMInstNode {
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

  @Override
  public <T> T accept(ASMVisitor<T> visitor) {
    return visitor.visit(this);
  }
}
