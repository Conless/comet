package dev.conless.comet.backend.asm.node.utils;

import dev.conless.comet.backend.asm.node.ASMNode;

@lombok.Value
@lombok.EqualsAndHashCode(callSuper = true)
public class ASMLabelNode extends ASMNode {
  private String label;

  public ASMLabelNode(String label) {
    this.label = label;
  }

  @Override
  public String toString() {
    return label + ":";
  }
}
