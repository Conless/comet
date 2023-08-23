package dev.conless.comet.backend.asm.node.global;

import dev.conless.comet.backend.asm.node.ASMNode;

@lombok.Value
@lombok.EqualsAndHashCode(callSuper = true)
public class ASMStrDefNode extends ASMNode {
  private String name;
  private String value;

  public ASMStrDefNode(String name, String value) {
    this.name = name;
    this.value = value;
  }

  @Override
  public String toString() {
    return String.format("%s:\n  .string \"%s\"", name, value);
  }
}
