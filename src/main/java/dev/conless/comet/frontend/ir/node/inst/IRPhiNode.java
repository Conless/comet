package dev.conless.comet.frontend.ir.node.inst;

import dev.conless.comet.frontend.ir.IRVisitor;
import dev.conless.comet.frontend.ir.entity.IREntity;
import dev.conless.comet.frontend.ir.entity.IRVariable;
import dev.conless.comet.frontend.ir.type.IRType;
import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.container.Pair;
import dev.conless.comet.utils.error.BaseError;

@lombok.Value
@lombok.EqualsAndHashCode(callSuper = true)
public final class IRPhiNode extends IRInstNode {
  private IRVariable dest;
  private IRType type;
  private Array<Pair<IREntity, String>> values;

  public IRPhiNode(IRVariable dest, IRType type, Array<Pair<IREntity, String>> values) {
    this.dest = dest;
    this.type = type;
    this.values = values;
  }

  @Override
  public IRVariable getDef() {
    return dest;
  }

  @Override
  public Array<IRVariable> getUses() {
    var uses = new Array<IRVariable>();
    for (var value : values) {
      if (value.a instanceof IRVariable) {
        uses.add((IRVariable) value.a);
      }
    }
    return uses;
  }

  @Override
  public String toString() {
    var str = dest.getValue() + " = phi " + type.toString() + " ";
    boolean first = true;
    for (var value : values) {
      if (first) {
        first = false;
      } else {
        str += ", ";
      }
      str += "[ " + value.a.getValue() + ", " + value.b + " ]";
    }
    return str;
  }

  @Override
  public <T> T accept(IRVisitor<T> visitor) throws BaseError {
    return visitor.visit(this);
  }
}
