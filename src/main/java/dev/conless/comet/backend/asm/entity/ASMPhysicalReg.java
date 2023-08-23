package dev.conless.comet.backend.asm.entity;

@lombok.Getter
@lombok.Setter
public class ASMPhysicalReg extends ASMReg implements java.lang.Comparable<ASMPhysicalReg> {
  private boolean isDirty;
  private int virtualID;

  public ASMPhysicalReg(String name) {
    super(name);
    isDirty = true;
    virtualID = -1;
  }

  @Override
  public String toString() {
    return getName();
  }

  @Override
  public int compareTo(ASMPhysicalReg o) {
    return this.getName().compareTo(o.getName());
  }
}
