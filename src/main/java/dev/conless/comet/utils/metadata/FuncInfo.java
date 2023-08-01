package dev.conless.comet.utils.metadata;

import dev.conless.comet.utils.container.Array;

public class FuncInfo extends BaseInfo {
  public TypeInfo type;
  public Array<TypeInfo> params;

  public FuncInfo(String name, TypeInfo type) {
    super(name);
    this.type = type;
    this.params = new Array<TypeInfo>();
  }
}
