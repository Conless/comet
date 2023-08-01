package dev.conless.comet.utils.scope;

import dev.conless.comet.utils.container.*;
import dev.conless.comet.utils.metadata.*;

public class GlobalScope extends BuiltInScope {
  public Map<String, TypeInfo> vars;
  public Map<String, FuncInfo> funcs;
  public Map<String, ClassInfo> classes;

  public GlobalScope() {
    super(null);
    vars = new Map<String, TypeInfo>();
    funcs = new Map<String, FuncInfo>();
    classes = new Map<String, ClassInfo>();
  }

  public boolean checkDeclared(String name) {
    return vars.containsKey(name) || funcs.containsKey(name) || classes.containsKey(name);
  }

  public void declare(BaseInfo type) {
    if (type instanceof ClassInfo) {
      classes.put(type.name, (ClassInfo) type);
    } else if (type instanceof FuncInfo) {
      funcs.put(type.name, (FuncInfo) type);
    } else if (type instanceof TypeInfo) {
      vars.put(type.name, (TypeInfo) type);
    }
  }
}
