package dev.conless.comet.frontend.utils.metadata;

@lombok.Value
@lombok.EqualsAndHashCode(callSuper = true)
public class VarInfo extends BaseInfo {
  TypeInfo type;

  public VarInfo(String name, TypeInfo type) {
    super(name);
    this.type = type;
  }

  @Override
  public String toString() {
    return type.toString() + " " + getName();
  }
}
