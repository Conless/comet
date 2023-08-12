package dev.conless.comet.frontend.utils.scope;

import dev.conless.comet.frontend.utils.metadata.BaseInfo;
import dev.conless.comet.frontend.utils.metadata.ClassInfo;
import dev.conless.comet.frontend.utils.metadata.FuncInfo;
import dev.conless.comet.frontend.utils.metadata.VarInfo;
import dev.conless.comet.utils.container.Pair;

public class GlobalScope extends BuiltInScope {
  public GlobalScope() {
    super(null);
  }

  @Override
  public String toString() {
    String str = "";
    for (var func : funcs.values()) {
      str += func.toString() + "\n";
    }
    for (var class_ : classes.values()) {
      str += class_.toString() + "\n";
    }
    return str;
  }

  @Override
  public void declare(BaseInfo info) {
    if (info instanceof ClassInfo) {
      classes.put(info.getName(), (ClassInfo) info);
    } else if (info instanceof FuncInfo) {
      funcs.put(info.getName(), (FuncInfo) info);
    } else if (info instanceof VarInfo) {
      vars.put(info.getName(), (VarInfo) info);
    }
  }

  @Override
  public BaseInfo get(String name) {
    if (vars.containsKey(name)) {
      return vars.get(name);
    } else if (funcs.containsKey(name)) {
      return funcs.get(name);
    } else if (classes.containsKey(name)) {
      return classes.get(name);
    }
    return null;
  }

  @Override
  public BaseInfo get(String name, String type) {
    if (type.equals("var")) {
      if (vars.containsKey(name)) {
        return vars.get(name);
      }
    } else if (type.equals("func")) {
      if (funcs.containsKey(name)) {
        return funcs.get(name);
      }
    } else if (type.equals("class")) {
      if (classes.containsKey(name)) {
        return classes.get(name);
      }
    }
    return null;
  }

  @Override
  public BaseInfo getRecur(String name) {
    if (vars.containsKey(name)) {
      return vars.get(name);
    }
    if (funcs.containsKey(name)) {
      return funcs.get(name);
    }
    if (classes.containsKey(name)) {
      return classes.get(name);
    }
    return null;
  }

  @Override
  public Pair<BaseInfo, BaseScope> getRecurWithScope(String name) {
    if (vars.containsKey(name)) {
      return new Pair<BaseInfo, BaseScope>(vars.get(name), this);
    }
    if (funcs.containsKey(name)) {
      return new Pair<BaseInfo, BaseScope>(funcs.get(name), this);
    }
    if (classes.containsKey(name)) {
      return new Pair<BaseInfo, BaseScope>(classes.get(name), this);
    }
    return null;
  }
}
