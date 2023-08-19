package dev.conless.comet.backend.asm.entity;

import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = true)
public class ASMRegister extends ASMEntity {
  public ASMRegister(String name) {
    super(name);
  }
}
