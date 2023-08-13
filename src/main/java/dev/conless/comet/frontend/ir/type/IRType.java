package dev.conless.comet.frontend.ir.type;

import dev.conless.comet.frontend.utils.metadata.TypeInfo;
import dev.conless.comet.frontend.utils.scope.GlobalScope;
import dev.conless.comet.utils.container.Array;
import lombok.*;

@Getter
public class IRType {
  private String typeName;
  private int typeSize;

  public enum Case {
    PARAM,
    CTOR,
    USE
  };

  public IRType(String typeName, int typeSize) {
    this.typeName = typeName;
    this.typeSize = typeSize;
  }

  public IRType(TypeInfo type, Case caze) {
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
      if (type.equals(GlobalScope.stringClass) || caze.equals(Case.PARAM) || caze.equals(Case.CTOR)) {
        this.typeName = "ptr";
        this.typeSize = 4;
      } else {
        if (type.getDepth() > 0) {
          this.typeName = "%builtIn.array";
          this.typeSize = 8;
        } else {
          this.typeName = "%class." + type.getName();
          this.typeSize = 0;
        }
      }
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
