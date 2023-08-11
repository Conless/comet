package dev.conless.comet.frontend.ir.type;

import dev.conless.comet.utils.container.Array;
import lombok.*;

@Getter
public class IRStructNode extends IRType {
  private Array<IRType> members;

  private static int getTotalSize(Array<IRType> members) {
    int totalSize = 0;
    for (IRType member : members) {
      totalSize += member.getTypeSize();
    }
    return totalSize;
  }

  public IRStructNode(Array<IRType> members) {
    super("struct", getTotalSize(members));
    this.members = members;
  }
}
