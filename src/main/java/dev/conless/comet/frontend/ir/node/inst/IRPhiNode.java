package dev.conless.comet.frontend.ir.node.inst;

import dev.conless.comet.frontend.ir.IRVisitor;
import dev.conless.comet.frontend.ir.entity.IREntity;
import dev.conless.comet.frontend.ir.node.IRNode;
import dev.conless.comet.frontend.ir.type.IRType;
import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.container.Pair;
import dev.conless.comet.utils.error.BaseError;

@lombok.Value
@lombok.EqualsAndHashCode(callSuper = true)
public final class IRPhiNode extends IRNode {
  private String dest;
  private IRType type;
  private Array<Pair<IREntity, String>> values;

  public IRPhiNode(String dest, IRType type, Array<Pair<IREntity, String>> values) {
    this.dest = dest;
    this.type = type;
    this.values = values;
  }

  @Override
  public String toString() {
    return dest + " = phi " + type.toString() + " " + values.toString();
  }

  @Override
  public <T> T accept(IRVisitor<T> visitor) throws BaseError {
    return visitor.visit(this);
  }
}
