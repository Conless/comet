package dev.conless.comet.backend.asm.entity;

@lombok.Getter
@lombok.Setter
public class ASMPhysicalReg extends ASMReg {
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
}
