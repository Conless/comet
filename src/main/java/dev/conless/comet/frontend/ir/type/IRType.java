package dev.conless.comet.frontend.ir.type;

import dev.conless.comet.frontend.utils.metadata.TypeInfo;
import dev.conless.comet.frontend.utils.scope.GlobalScope;
import dev.conless.comet.utils.error.RuntimeError;

@lombok.Getter
public class IRType {
  private String typeName;
  public IRType(String typeName) {
    this.typeName = typeName;
  }

  public IRType(TypeInfo type) {
    if (type.equals(GlobalScope.intType)) {
      this.typeName = "i32";
    } else if (type.equals(GlobalScope.boolType)) {
      this.typeName = "i1";
    } else if (type.equals(GlobalScope.voidType)) {
      this.typeName = "void";
    } else {
      this.typeName = "ptr";
    }
  }

  public IRType(TypeInfo type, boolean isAlloca) {
    if (!isAlloca) {
      throw new RuntimeError("IRType constructor called with isAlloca = false");
    }
    if (type.getDepth() > 0 || type.equals(GlobalScope.stringType)) {
      this.typeName = "ptr";
    } else if (type.equals(GlobalScope.intType)) {
      this.typeName = "i32";
    } else if (type.equals(GlobalScope.boolType)) {
      this.typeName = "i1";
    } else if (type.equals(GlobalScope.voidType)) {
      this.typeName = "void";
    } else if (!type.isBuiltIn()) {
      this.typeName = "%class." + type.getName();
    } else {
      throw new RuntimeError("IRType constructor called with invalid type");
    }
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
