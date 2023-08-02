package dev.conless.comet.utils.metadata;

import java.util.List;

import dev.conless.comet.utils.container.Map;

public class ClassInfo extends BaseInfo {
  public Map<String, VarInfo> vars;
  public Map<String, FuncInfo> funcs;

  public ClassInfo(String name) {
    super(name);
    vars = new Map<String, VarInfo>();
    funcs = new Map<String, FuncInfo>();
  }

  public ClassInfo(String name, List<VarInfo> vars, List<FuncInfo> funcs) {
    super(name);
    this.vars = new Map<String, VarInfo>();
    this.funcs = new Map<String, FuncInfo>();
    for (VarInfo var : vars) {
      this.vars.put(var.name, var);
    }
    for (FuncInfo func : funcs) {
      this.funcs.put(func.name, func);
    }
  }

  public void addVar(VarInfo var) {
    vars.put(var.name, var);
  }

  public void addFunc(FuncInfo func) {
    funcs.put(func.name, func);
  }

  @Override
  public String toString() {
    String str = "class " + name + " {\n";
    for (var varName : vars.keySet()) {
      str += "  " + vars.get(varName).toString() + "\n";
    }
    for (var func : funcs.values()) {
      str += "  " + func.toString() + "\n";
    }
    str += "};";
    return str;
  }
}
