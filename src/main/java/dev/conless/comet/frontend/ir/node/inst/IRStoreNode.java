package dev.conless.comet.frontend.ir.node.inst;

import dev.conless.comet.frontend.ir.entity.IREntity;
import dev.conless.comet.frontend.ir.entity.IRVariable;
import dev.conless.comet.frontend.utils.scope.GlobalScope;
import dev.conless.comet.utils.error.RuntimeError;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = true)
public final class IRStoreNode extends IRInstNode {
  IREntity src;
  IRVariable dest;

  public IRStoreNode(IRVariable dest, IREntity src) {
    if (!(dest.getType().equals(GlobalScope.irPtrType))) {
      throw new RuntimeError("dest must be a pointer");
    }
    if (src == null) {
      throw new RuntimeError("src must not be null");
    }
    this.dest = dest;
    this.src = src;
  }

  @Override
  public String toString() {
    return "store " + src.toString() + ", " + dest.toString();
  }
}
