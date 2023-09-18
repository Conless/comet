package dev.conless.comet.backend.asm.node.inst;

import dev.conless.comet.backend.asm.ASMVisitor;
import dev.conless.comet.backend.asm.entity.ASMAddress;
import dev.conless.comet.backend.asm.entity.ASMReg;
import dev.conless.comet.backend.asm.entity.ASMVirtualReg;
import dev.conless.comet.utils.container.Array;

@lombok.Getter
@lombok.Setter
public final class ASMStoreNode extends ASMInstNode {
  private ASMReg src;
  private ASMAddress dest;

  public ASMStoreNode(ASMReg src, ASMAddress dest) {
    this.src = src;
    this.dest = dest;
  }

  @Override
  public String toString() {
    return String.format("%-6s", "sw") + src + ", " + dest;
  }

  @Override
  public <T> T accept(ASMVisitor<T> visitor) {
    return visitor.visit(this);
  }

  @Override
  public ASMVirtualReg getDef() {
    return null;
  }

  @Override
  public Array<ASMVirtualReg> getUses() {
    var ret = new Array<ASMVirtualReg>();
    if (src instanceof ASMVirtualReg) {
      ret.add((ASMVirtualReg) src);
    }
    if (dest.getBase() instanceof ASMVirtualReg) {
      ret.add((ASMVirtualReg) dest.getBase());
    }
    return ret;
  }
}
