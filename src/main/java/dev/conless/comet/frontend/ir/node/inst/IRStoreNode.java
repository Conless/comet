package dev.conless.comet.frontend.ir.node.inst;

import dev.conless.comet.frontend.ir.IRVisitor;
import dev.conless.comet.frontend.ir.entity.IREntity;
import dev.conless.comet.frontend.ir.entity.IRVariable;
import dev.conless.comet.frontend.utils.scope.GlobalScope;
import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.error.BaseError;
import dev.conless.comet.utils.error.RuntimeError;

@lombok.Value
@lombok.EqualsAndHashCode(callSuper = true)
public final class IRStoreNode extends IRInstNode {
  private IREntity src;
  private IRVariable dest;

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
  public IRVariable getDef() {
    return null;
  }

  @Override
  public Array<IRVariable> getUses() {
    var uses = new Array<IRVariable>();
    if (src instanceof IRVariable) {
      uses.add((IRVariable) src);
    }
    if (dest instanceof IRVariable) {
      uses.add((IRVariable) dest);
    }
    return uses;
  }

  @Override
  public String toString() {
    return "store " + src.toString() + ", " + dest.toString();
  }

  @Override
  public <T> T accept(IRVisitor<T> visitor) throws BaseError {
    return visitor.visit(this);
  }
}
