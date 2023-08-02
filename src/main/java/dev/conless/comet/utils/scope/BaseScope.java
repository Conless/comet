package dev.conless.comet.utils.scope;

import dev.conless.comet.utils.container.Map;
import dev.conless.comet.utils.metadata.BaseInfo;
import dev.conless.comet.utils.metadata.VarInfo;

public class BaseScope {
  BaseScope parent;
  Map<String, VarInfo> vars;
  boolean exited;

  public BaseScope(BaseScope parent) {
    this.parent = parent;
    this.vars = new Map<String, VarInfo>();
  }

  public BaseScope getParent() {
    return parent;
  }

  public void exit() {
    exited = true;
  }

  public boolean isExited() {
    return exited;
  }

  public void declare(BaseInfo info) {
    if (info instanceof VarInfo) {
      vars.put(info.name, (VarInfo) info);
    } else {
      throw new RuntimeException("BaseScope.declare() called with unknown type");
    }
  }

  public BaseInfo get(String name) {
    if (vars.containsKey(name)) {
      return vars.get(name);
    }
    return null;
  }

  public BaseInfo get(String name, String type) {
    if (type == "var") {
      if (vars.containsKey(name)) {
        return vars.get(name);
      }
    } else {
      throw new RuntimeException("ClassScope.get() called with unknown type");
    }
    return null;
  }

  public BaseInfo getRecur(String name) {
    return null;
  }

  public BaseInfo getRecur(String name, String type) {
    return null;
  }
}
