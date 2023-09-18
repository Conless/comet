package dev.conless.comet.backend.asm.node.inst;

import dev.conless.comet.backend.asm.ASMVisitor;
import dev.conless.comet.backend.asm.entity.ASMReg;
import dev.conless.comet.backend.asm.entity.ASMVirtualReg;
import dev.conless.comet.utils.container.Array;

@lombok.Getter
@lombok.Setter
public final class ASMUnaryNode extends ASMInstNode {
  private String op;
  private ASMReg dest, operand;
  private Integer imm;

  public ASMUnaryNode(String op, ASMReg dest, ASMReg operand) {
    this.op = op;
    this.dest = dest;
    this.operand = operand;
    this.imm = null;
  }

  public ASMUnaryNode(String op, ASMReg dest, ASMReg operand, Integer imm) {
    this.op = op;
    this.dest = dest;
    this.operand = operand;
    this.imm = imm;
  }

  @Override
  public String toString() {
    return String.format("%-6s", op) + dest + ", " + operand + (imm == null ? "" : ", " + imm);
  }

  @Override
  public <T> T accept(ASMVisitor<T> visitor) {
    return visitor.visit(this);
  }

  @Override
  public ASMVirtualReg getDef() {
    if (dest instanceof ASMVirtualReg) {
      return (ASMVirtualReg) dest;
    }
    return null;
  }

  @Override
  public Array<ASMVirtualReg> getUses() {
    var ret = new Array<ASMVirtualReg>();
    if (operand instanceof ASMVirtualReg) {
      ret.add((ASMVirtualReg) operand);
    }
    return ret;
  }
}
