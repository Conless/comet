package dev.conless.comet.frontend.ir.type;

import dev.conless.comet.frontend.utils.metadata.TypeInfo;
import dev.conless.comet.frontend.utils.scope.GlobalScope;
import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.error.RuntimeError;
import lombok.*;

@Getter
public class IRType {
  private String typeName;
  private int typeSize;

  public IRType(String typeName, int typeSize) {
    this.typeName = typeName;
    this.typeSize = typeSize;
  }

  public IRType(TypeInfo type) {
    if (type.equals(GlobalScope.intType)) {
      this.typeName = "i32";
      this.typeSize = 4;
    } else if (type.equals(GlobalScope.boolType)) {
      this.typeName = "i1";
      this.typeSize = 1;
    } else if (type.equals(GlobalScope.voidType)) {
      this.typeName = "void";
      this.typeSize = 0;
    } else {
      this.typeName = "ptr";
      this.typeSize = 4;
    }
  }

  protected static int getTotalSize(Array<IRType> members) {
    int totalSize = 0;
    for (IRType member : members) {
      totalSize += member.getTypeSize();
    }
    return totalSize;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof IRType) {
      return ((IRType) obj).typeName.equals(typeName);
    }
    return false;
  }

  @Override
  public String toString() {
    return typeName;
  }
}
