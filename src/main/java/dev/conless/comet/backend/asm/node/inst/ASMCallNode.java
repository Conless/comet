package dev.conless.comet.backend.asm.node.inst;

import dev.conless.comet.backend.asm.node.ASMNode;

@lombok.Value
@lombok.EqualsAndHashCode(callSuper = true)
public class ASMCallNode extends ASMNode {
  private String label;

  public ASMCallNode(String label) {
    this.label = label;
  }
}
