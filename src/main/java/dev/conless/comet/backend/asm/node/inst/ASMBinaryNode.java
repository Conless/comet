package dev.conless.comet.backend.asm.node.inst;

import dev.conless.comet.backend.asm.ASMVisitor;
import dev.conless.comet.backend.asm.entity.ASMReg;
import dev.conless.comet.backend.asm.entity.ASMVirtualReg;
import dev.conless.comet.utils.container.Array;

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
    if (lhs instanceof ASMVirtualReg) {
      ret.add((ASMVirtualReg) lhs);
    }
    if (rhs instanceof ASMVirtualReg) {
      ret.add((ASMVirtualReg) rhs);
    }
    return ret;
  }
}
