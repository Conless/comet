package dev.conless.comet.backend.asm.entity;

@lombok.Getter
@lombok.Setter
public class ASMPhysicalReg extends ASMReg implements java.lang.Comparable<ASMPhysicalReg> {
  private boolean isDirty;
  private int virtualID;

  public ASMPhysicalReg(String name) {
    super(name);
    isDirty = false;
    virtualID = -1;
  }

  @Override
  public String toString() {
    return getName();
  }

  @Override
  public int compareTo(ASMPhysicalReg o) {
    var str1 = getName().substring(1);
    var str2 = o.getName().substring(1);

    try {
      return Integer.parseInt(str1) - Integer.parseInt(str2);
    } catch (NumberFormatException e) {
      return getName().compareTo(o.getName());
    }
  }
}
