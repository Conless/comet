package dev.conless.comet.backend.asm.node.inst;

import dev.conless.comet.backend.asm.node.ASMNode;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = true)
public class ASMCallNode extends ASMNode {
  private String label;

  public ASMCallNode(String label) {
    this.label = label;
  }
}
