package dev.conless.comet.frontend.ir.node.inst;

import dev.conless.comet.frontend.ir.entity.IREntity;
import dev.conless.comet.frontend.ir.entity.IRVariable;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = true)
public final class IRStoreNode extends IRInstNode {
  IREntity src;
  IRVariable dest;

  public IRStoreNode(IRVariable dest, IREntity src) {
    this.dest = dest;
    this.src = src;
  }

  @Override
  public String toString() {
    return "store " + src.toString() + ", " + dest.toString();
  }
}
