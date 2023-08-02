package dev.conless.comet.utils.scope;

import dev.conless.comet.utils.container.Map;
import dev.conless.comet.utils.metadata.BaseInfo;
import dev.conless.comet.utils.metadata.ClassInfo;
import dev.conless.comet.utils.metadata.FuncInfo;
import dev.conless.comet.utils.metadata.VarInfo;

public class ClassScope extends BaseScope {
  Map<String, FuncInfo> funcs;

  public ClassScope(BaseScope parent, ClassInfo info) {
    super(parent, info);
    funcs = new Map<String, FuncInfo>();
  }

  @Override
  public void declare(BaseInfo info) {
    if (info instanceof FuncInfo) {
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
    } else {
      throw new RuntimeException("ClassScope.get() called with unknown type");
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
    if (parent != null) {
      return parent.getRecur(name);
    }
    return null;
  }
}
