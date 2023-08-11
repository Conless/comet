package dev.conless.comet.frontend.ir.type;

import dev.conless.comet.frontend.utils.metadata.TypeInfo;
import dev.conless.comet.frontend.utils.scope.GlobalScope;
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
      this.typeName = "i8";
      this.typeSize = 1;
    } else if (type.equals(GlobalScope.voidType)) {
      this.typeName = "void";
      this.typeSize = 0;
    } else {
      this.typeName = "ptr";
      this.typeSize = 1;
    }
  }

  @Override
  public String toString() {
    return typeName;
  }
}
