package dev.conless.comet.frontend.utils.metadata;

@lombok.Value
@lombok.EqualsAndHashCode(callSuper = true)
public final class ExprInfo extends BaseInfo {
  private BaseInfo type;
  private boolean isLValue;

  public ExprInfo(String name, BaseInfo type, boolean isLValue) {
    super(name);
    this.type = type;
    this.isLValue = isLValue;
  }
}
