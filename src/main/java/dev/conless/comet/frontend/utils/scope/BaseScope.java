package dev.conless.comet.frontend.utils.scope;

import dev.conless.comet.frontend.utils.metadata.BaseInfo;
import dev.conless.comet.frontend.utils.metadata.ClassInfo;
import dev.conless.comet.frontend.utils.metadata.VarInfo;
import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.container.Map;
import dev.conless.comet.utils.container.Pair;
import dev.conless.comet.utils.error.RuntimeError;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseScope {
  private BaseScope parent;
  private BaseInfo info;
  private Array<Integer> tags;
  private Integer count;
  protected Map<String, VarInfo> vars;

  public BaseScope(BaseScope parent, BaseInfo info) {
    this.parent = parent;
    this.info = info;
    this.vars = new Map<String, VarInfo>();
    this.count = 0;
    if (parent != null) {
      this.tags = new Array<Integer>(parent.getTags());
      int count = parent.getCount();
      this.tags.add(count);
      parent.setCount(count + 1);
    } else {
      this.tags = new Array<Integer>();
    }
  }

  public String getSuffix() {
    String suffix = "";
    for (int tag : tags) {
      suffix += "." + tag;
    }
    return suffix;
  }

  public LoopScope getLastLoop() {
    BaseScope scope = this;
    while (scope != null) {
      if (scope instanceof LoopScope) {
        return (LoopScope) scope;
      }
      scope = scope.getParent();
    }
    return null;
  }

  public FuncScope getLastFunc() {
    BaseScope scope = this;
    while (scope != null) {
      if (scope instanceof FuncScope) {
        return (FuncScope) scope;
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
      throw new RuntimeError("BaseScope.declare() called with unknown type");
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
      throw new RuntimeError("ClassScope.get() called with unknown type");
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

  public Pair<BaseInfo, BaseScope> getRecurWithScope(String name) {
    if (vars.containsKey(name)) {
      return new Pair<>(vars.get(name), this);
    }
    if (parent != null) {
      return parent.getRecurWithScope(name);
    }
    return null;
  }
}
