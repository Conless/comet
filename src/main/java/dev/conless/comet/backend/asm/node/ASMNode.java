package dev.conless.comet.backend.asm.node;

import dev.conless.comet.backend.asm.ASMVisitor;

public abstract class ASMNode {
  public abstract String toString();

  public <T> T accept(ASMVisitor<T> visitor) {
    return visitor.visit(this);
  }
}
