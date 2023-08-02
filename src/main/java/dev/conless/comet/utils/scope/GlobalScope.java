package dev.conless.comet.utils.scope;

import dev.conless.comet.utils.metadata.BaseInfo;
import dev.conless.comet.utils.metadata.ClassInfo;
import dev.conless.comet.utils.metadata.FuncInfo;
import dev.conless.comet.utils.metadata.VarInfo;

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
      classes.put(info.name, (ClassInfo) info);
    } else if (info instanceof FuncInfo) {
      funcs.put(info.name, (FuncInfo) info);
    } else if (info instanceof VarInfo) {
      vars.put(info.name, (VarInfo) info);
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
    if (type == "var") {
      if (vars.containsKey(name)) {
        return vars.get(name);
      }
    } else if (type == "func") {
      if (funcs.containsKey(name)) {
        return funcs.get(name);
      }
    } else if (type == "class") {
      if (classes.containsKey(name)) {
        return classes.get(name);
      }
    }
    return null;
  }

  @Override
  public BaseInfo getRecur(String name) {
    return null;
  }

  @Override
  public BaseInfo getRecur(String name, String type) {
    return null;
  }
}
