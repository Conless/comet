package dev.conless.comet.frontend.ir.node.inst;

import dev.conless.comet.frontend.ir.entity.IRVariable;
import dev.conless.comet.frontend.ir.node.IRInstNode;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = true)
public final class IRStoreNode extends IRInstNode {
  IRVariable dest, src;

  public IRStoreNode(IRVariable dest, IRVariable src) {
    this.dest = dest;
    this.src = src;
  }

  @Override
  public String toString() {
    return "store " + dest.getType().toString() + " " + src.toString() + ", " + dest.toString();
  }
}