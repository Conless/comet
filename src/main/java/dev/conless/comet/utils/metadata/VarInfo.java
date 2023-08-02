package dev.conless.comet.utils.metadata;

public class VarInfo extends BaseInfo {
  TypeInfo type;

  public VarInfo(String name, TypeInfo type) {
    super(name);
    this.type = type;
  }

  @Override
  public String toString() {
    return type.toString() + " " + name + ";";
  }
}
