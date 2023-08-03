package dev.conless.comet.utils.metadata;

import dev.conless.comet.utils.Type;

public class TypeInfo extends BaseInfo {
  public Type type;
  public Integer depth;
  public Boolean isBuiltIn;

  public TypeInfo(String typeName, Integer arrayDepth) {
    super(typeName);
    this.isBuiltIn = true;
    if (typeName.equals("int")) {
      this.type = Type.INT;
    } else if (typeName.equals("bool")) {
      this.type = Type.BOOL;
    } else if (typeName.equals("string")) {
      this.type = Type.STRING;
    } else if (typeName.equals("void")) {
      this.type = Type.VOID;
    } else if (typeName.equals("null")) {
      this.type = Type.NULL;
    } else {
      this.type = Type.CUSTOM;
      this.isBuiltIn = false;
    }
    this.depth = arrayDepth;
  }

  public boolean equals(TypeInfo other) {
    if (this.type == Type.NULL || other.type == Type.NULL) {
      return true;
    }
    return this.name.equals(other.name) && this.depth.equals(other.depth);
  }

  @Override
  public String toString() {
    return name + "[]".repeat(depth);
  }
}
