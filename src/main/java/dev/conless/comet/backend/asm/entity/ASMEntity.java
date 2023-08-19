package dev.conless.comet.backend.asm.entity;

import lombok.*;

@Getter
public abstract class ASMEntity {
  private String name;

  public ASMEntity(String name) {
    this.name = name;
  }
}
