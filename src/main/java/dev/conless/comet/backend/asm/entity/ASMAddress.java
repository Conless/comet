package dev.conless.comet.backend.asm.entity;

@lombok.Value
public class ASMAddress {
  private ASMReg base;
  private int offset;

  public ASMAddress(ASMReg base, int offset) {
    this.base = base;
    this.offset = offset;
  }

  @Override
  public String toString() {
    return String.format("%d(%s)", offset, base);
  }
}
