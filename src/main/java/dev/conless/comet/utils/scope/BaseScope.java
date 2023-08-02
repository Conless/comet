package dev.conless.comet.utils.scope;

import dev.conless.comet.utils.container.Map;
import dev.conless.comet.utils.metadata.VarInfo;

public class BaseScope {
  public BaseScope parent;
  public Map<String, VarInfo> vars;

  public BaseScope(BaseScope parent) {
    this.parent = parent;
    this.vars = new Map<String, VarInfo>();
  }
}
