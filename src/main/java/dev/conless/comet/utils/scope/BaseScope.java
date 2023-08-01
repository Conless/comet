package dev.conless.comet.utils.scope;

public class BaseScope {
  public BaseScope parent;

  public BaseScope(BaseScope parent) {
    this.parent = parent;
  }
}
