package dev.conless.comet.utils.metadata;

import java.util.List;

import dev.conless.comet.utils.container.Map;

public class ClassInfo extends BaseInfo {
  public Map<String, TypeInfo> vars;
  public Map<String, FuncInfo> funcs;

  public ClassInfo(String name) {
    super(name);
    vars = new Map<String, TypeInfo>();
    funcs = new Map<String, FuncInfo>();
  }

  public ClassInfo(String name, List<TypeInfo> vars, List<FuncInfo> funcs) {
    super(name);
    this.vars = new Map<String, TypeInfo>();
    this.funcs = new Map<String, FuncInfo>();
    for (TypeInfo var : vars) {
      this.vars.put(var.name, var);
    }
    for (FuncInfo func : funcs) {
      this.funcs.put(func.name, func);
    }
  }
}
