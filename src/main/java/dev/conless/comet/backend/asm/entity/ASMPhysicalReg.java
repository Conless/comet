package dev.conless.comet.backend.asm.entity;

public class ASMPhysicalReg extends ASMReg {
  public ASMPhysicalReg(String name) {
    super(name);
  }

  @Override
  public String toString() {
    return getName();
  }
}
