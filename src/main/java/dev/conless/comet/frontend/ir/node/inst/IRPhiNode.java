package dev.conless.comet.frontend.ir.node.inst;

import dev.conless.comet.frontend.ir.entity.IREntity;
import dev.conless.comet.frontend.ir.type.IRType;
import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.container.Pair;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = true)
public final class IRPhiNode extends IRInstNode {
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
}
