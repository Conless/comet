package dev.conless.comet.frontend.ir.type;

import dev.conless.comet.utils.container.Array;
import lombok.*;

@Getter
public class IRStructType extends IRType {
  private Array<IRType> members;

  public IRStructType(String name, Array<IRType> members) {
    super("%" + name, getTotalSize(members));
    this.members = members;
  }

  @Override
  public String toString() {
    return "{ " + members.toString(", ") + " }";
  }
}
