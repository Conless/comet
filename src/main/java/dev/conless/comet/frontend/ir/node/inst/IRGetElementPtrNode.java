package dev.conless.comet.frontend.ir.node.inst;

import dev.conless.comet.frontend.ir.IRVisitor;
import dev.conless.comet.frontend.ir.entity.IREntity;
import dev.conless.comet.frontend.ir.entity.IRVariable;
import dev.conless.comet.frontend.ir.node.IRNode;
import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.error.BaseError;
import dev.conless.comet.utils.error.RuntimeError;

@lombok.Setter
@lombok.Getter
public final class IRGetElementPtrNode extends IRInstNode {
  private IRVariable dest;
  private IREntity src;
  private String type;
  private Array<IREntity> indices;

  public IRGetElementPtrNode(IRVariable dest, IRVariable src, String type, Array<IREntity> indices) {
    if (src == null) {
      throw new RuntimeError("src cannot be null");
    }
    this.type = type;
    this.dest = dest;
    this.src = src;
    this.indices = indices;
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
    for (var index : indices) {
      if (index instanceof IRVariable) {
        uses.add((IRVariable) index);
      }
    }
    return uses;
  }

  @Override
  public void replaceUse(IREntity old, IREntity newEntity) {
    if (src.equals(old)) {
      src = newEntity;
    }
    for (int i = 0; i < indices.size(); i++) {
      if (indices.get(i).equals(old)) {
        indices.set(i, newEntity);
      }
    }
  }

  @Override
  public String toString() {
    return dest.getValue() + " = getelementptr " + type.toString() + ", " + src.toString() + ", " + indices.toString(", ");
  }

  @Override
  public <T> T accept(IRVisitor<T> visitor) throws BaseError {
    return visitor.visit(this);
  }
}
