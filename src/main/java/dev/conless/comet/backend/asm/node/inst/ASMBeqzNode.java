package dev.conless.comet.backend.asm.node.inst;

import dev.conless.comet.backend.asm.ASMVisitor;
import dev.conless.comet.backend.asm.entity.ASMReg;
import dev.conless.comet.backend.asm.entity.ASMVirtualReg;
import dev.conless.comet.utils.container.Array;

@lombok.Getter
@lombok.Setter
public final class ASMBeqzNode extends ASMInstNode {
  private ASMReg entity;
  private String label;

  public ASMBeqzNode(ASMReg entity, String label) {
    this.entity = entity;
    this.label = label;
  }

  @Override
  public String toString() {
    return String.format("%-6s", "beqz") + entity + ", " + label;
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
    if (entity instanceof ASMVirtualReg) {
      ret.add((ASMVirtualReg) entity);
    }
    return ret;
  }
}
