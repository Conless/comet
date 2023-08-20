package dev.conless.comet.backend.asm.entity;

@lombok.Value
@lombok.EqualsAndHashCode(callSuper = true)
public class ASMRegister extends ASMEntity {
  public ASMRegister(String name) {
    super(name);
  }
}
