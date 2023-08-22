package dev.conless.comet.backend.asm.node.inst;

import dev.conless.comet.backend.asm.entity.ASMRegister;
import dev.conless.comet.backend.asm.node.ASMNode;

@lombok.Value
@lombok.EqualsAndHashCode(callSuper = true)
public class ASMUnaryNode extends ASMNode {
  private String op;
  private ASMRegister dest, operand;
  private Integer imm;

  public ASMUnaryNode(String op, ASMRegister dest, ASMRegister operand) {
    this.op = op;
    this.dest = dest;
    this.operand = operand;
    this.imm = null;
  }

  public ASMUnaryNode(String op, ASMRegister dest, ASMRegister operand, Integer imm) {
    this.op = op;
    this.dest = dest;
    this.operand = operand;
    this.imm = imm;
  }

  @Override
  public String toString() {
    return String.format("%-6s", op) + dest + ", " + operand + (imm == null ? "" : ", " + imm);
  }
}
