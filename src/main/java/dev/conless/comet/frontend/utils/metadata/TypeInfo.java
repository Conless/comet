package dev.conless.comet.frontend.utils.metadata;

import lombok.*;

@Getter
@Setter
public class TypeInfo extends BaseInfo {
  public Integer depth;
  public Boolean isBuiltIn;

  public TypeInfo(String typeName, Integer arrayDepth) {
    super(typeName);
    this.isBuiltIn = typeName.equals("int") || typeName.equals("bool") || typeName.equals("string") || typeName.equals("void") || typeName.equals("null");
    this.depth = arrayDepth;
  }

  @Override
  public boolean equals(Object otherInfo) {
    if (!(otherInfo instanceof TypeInfo)) {
      return false;
    }
    var other = (TypeInfo) otherInfo;
    if (this.getName().equals("null")) {
      return other.getName().equals("null") || other.depth > 0 || !other.isBuiltIn;
    }
    if (other.getName().equals("null")) {
      return this.depth > 0 || !this.isBuiltIn;
    }
    return this.getName().equals(other.getName()) && this.depth.equals(other.depth);
  }

  public int hashCode() {
    return this.getName().hashCode() + this.depth;
  }

  @Override
  public String toString() {
    return getName() + "[]".repeat(depth);
  }
}
