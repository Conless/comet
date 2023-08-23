package dev.conless.comet.backend.asm.entity;

@lombok.Getter
public abstract class ASMReg {
  private final String name;

  public ASMReg(String name) {
    this.name = name;
  }
}
