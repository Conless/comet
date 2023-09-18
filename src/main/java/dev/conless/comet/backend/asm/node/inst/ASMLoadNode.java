package dev.conless.comet.backend.asm.node.inst;

import dev.conless.comet.backend.asm.ASMVisitor;
import dev.conless.comet.backend.asm.entity.ASMAddress;
import dev.conless.comet.backend.asm.entity.ASMReg;
import dev.conless.comet.backend.asm.entity.ASMVirtualReg;
import dev.conless.comet.utils.container.Array;

@lombok.Getter
@lombok.Setter
public final class ASMLoadNode extends ASMInstNode {
  public ASMReg dest;
  public ASMAddress src;

  public ASMLoadNode(ASMReg dest, ASMAddress src) {
    this.dest = dest;
    this.src = src;
  }

  @Override
  public String toString() {
    return String.format("%-6s", "lw") + dest + ", " + src;
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
    if (src.getBase() instanceof ASMVirtualReg) {
      ret.add((ASMVirtualReg) src.getBase());
    }
    return ret;
  }
}
