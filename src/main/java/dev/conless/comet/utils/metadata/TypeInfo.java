package dev.conless.comet.utils.metadata;

import dev.conless.comet.utils.Type;

public class TypeInfo extends BaseInfo {
  public Type type;
  public Integer depth;
  public Boolean isBuiltIn;

  public TypeInfo(String name) {
    super(name);
    this.depth = 0;
    this.isBuiltIn = false;
  }

  @Override
  public String toString() {
    return name + "[]".repeat(depth);
  }
}
