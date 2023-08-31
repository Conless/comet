package dev.conless.comet.frontend.ir.node.inst;

import dev.conless.comet.frontend.ir.IRVisitor;
import dev.conless.comet.frontend.ir.entity.IRVariable;
import dev.conless.comet.frontend.ir.type.IRType;
import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.error.BaseError;

@lombok.Value
@lombok.EqualsAndHashCode(callSuper = true)
public final class IRLoadNode extends IRInstNode {
  private IRVariable dest, src;
  private IRType type;

  public IRLoadNode(IRVariable dest, IRVariable src) {
    this.type = dest.getType();
    this.dest = dest;
    this.src = src;
  }

  @Override
  public IRVariable getDef() {
    return dest;
  }

  @Override
  public Array<IRVariable> getUses() {
    var uses = new Array<IRVariable>();
    if (src instanceof IRVariable) {
      uses.add((IRVariable) src);
    }
    return uses;
  }

  @Override
  public String toString() {
    return dest.getValue() + " = load " + type.toString() + ", " + src.toString();
  }

  @Override
  public <T> T accept(IRVisitor<T> visitor) throws BaseError {
    return visitor.visit(this);
  }
}
