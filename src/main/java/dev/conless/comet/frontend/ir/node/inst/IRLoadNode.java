package dev.conless.comet.frontend.ir.node.inst;

import dev.conless.comet.frontend.ir.entity.IRVariable;
import dev.conless.comet.frontend.ir.type.IRType;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = true)
public final class IRLoadNode extends IRInstNode {
  private IRVariable dest, src;
  private IRType type;

  public IRLoadNode(IRVariable dest, IRVariable src, IRType type) {
    this.type = type;
    this.dest = dest;
    this.src = src;
  }

  @Override
  public String toString() {
    return dest.getValue() + " = load " + type.toString() + ", " + src.toString();
  }
}
