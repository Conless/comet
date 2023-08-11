package dev.conless.comet.frontend.ir.node.inst;

import dev.conless.comet.frontend.ir.entity.IREntity;
import dev.conless.comet.frontend.ir.entity.IRVariable;
import dev.conless.comet.frontend.ir.node.IRInstNode;
import dev.conless.comet.frontend.ir.type.IRType;
import dev.conless.comet.utils.container.Array;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = true)
public final class IRGetElementPtrNode extends IRInstNode {
  private IRVariable dest, src;
  private IRType type;
  private Array<IREntity> idxs;

  public IRGetElementPtrNode(IRVariable dest, IRVariable src, IRType type, Array<IREntity> idxs) {
    this.type = type;
    this.dest = dest;
    this.src = src;
    this.idxs = idxs;
  }

  @Override
  public String toString() {
    return dest.getValue() + " = getelementptr " + type.toString() + ", " + src.toString() + ", " + idxs.toString();
  }
}
