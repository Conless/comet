package dev.conless.comet.utils.scope;

import dev.conless.comet.utils.container.Map;
import dev.conless.comet.utils.metadata.FuncInfo;
import dev.conless.comet.utils.metadata.VarInfo;

public class ClassScope extends BaseScope {
  public Map<String, VarInfo> vars;
  public Map<String, FuncInfo> funcs;

  public ClassScope(BaseScope parent) {
    super(parent);
    vars = new Map<String, VarInfo>();
    funcs = new Map<String, FuncInfo>();
  }
}
