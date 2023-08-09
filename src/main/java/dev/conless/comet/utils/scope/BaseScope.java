package dev.conless.comet.utils.scope;

import dev.conless.comet.utils.container.Map;
import dev.conless.comet.utils.metadata.BaseInfo;
import dev.conless.comet.utils.metadata.ClassInfo;
import dev.conless.comet.utils.metadata.FlowInfo;
import dev.conless.comet.utils.metadata.FuncInfo;
import dev.conless.comet.utils.metadata.VarInfo;
import lombok.Getter;

@Getter
public class BaseScope {
  private BaseScope parent;
  private BaseInfo info;
  protected Map<String, VarInfo> vars;

  public BaseScope(BaseScope parent, BaseInfo info) {
    this.parent = parent;
    this.info = info;
    this.vars = new Map<String, VarInfo>();
  }

  public BaseScope getParent() {
    return parent;
  }

  public BaseScope getLastLoop() {
    BaseScope scope = this;
    while (scope != null) {
      BaseInfo info = scope.getInfo();
      if (info instanceof FlowInfo && ((FlowInfo) info).isLoop()) {
        return scope;
      }
      scope = scope.getParent();
    }
    return null;
  }
  
  public BaseScope getLastFunc() {
    BaseScope scope = this;
    while (scope != null) {
      BaseInfo info = scope.getInfo();
      if (info instanceof FuncInfo) {
        return scope;
      }
      scope = scope.getParent();
    }
    return null;
  }

  public BaseScope getLastClass() {
    BaseScope scope = this;
    while (scope != null) {
      BaseInfo info = scope.getInfo();
      if (info instanceof ClassInfo) {
        return scope;
      }
      scope = scope.getParent();
    }
    return null;
  }

  public void declare(BaseInfo info) {
    if (info instanceof VarInfo) {
      vars.put(info.getName(), (VarInfo) info);
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
    if (type.equals("var")) {
      if (vars.containsKey(name)) {
        return vars.get(name);
      }
    } else {
      throw new RuntimeException("ClassScope.get() called with unknown type");
    }
    return null;
  }

  public BaseInfo getRecur(String name) {
    if (vars.containsKey(name)) {
      return vars.get(name);
    }
    if (parent != null) {
      return parent.getRecur(name);
    }
    return null;
  }
}
