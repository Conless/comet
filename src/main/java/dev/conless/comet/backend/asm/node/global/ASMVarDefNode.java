package dev.conless.comet.backend.asm.node.global;

import dev.conless.comet.backend.asm.node.ASMNode;

@lombok.Value
@lombok.EqualsAndHashCode(callSuper = true)
public class ASMVarDefNode extends ASMNode {
  private String name;
  private int value;

  public ASMVarDefNode(String name, int value) {
    this.name = name;
    this.value = value;
  }

  @Override
  public String toString() {
    return String.format("%s:\n  .word %d", name, value);
  }
}
