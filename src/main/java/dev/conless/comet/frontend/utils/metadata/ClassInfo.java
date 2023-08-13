package dev.conless.comet.frontend.utils.metadata;

import dev.conless.comet.frontend.ast.node.def.FuncDefNode;
import dev.conless.comet.frontend.ast.node.def.VarDefNode;
import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.container.Map;

import lombok.*;

@Value
@EqualsAndHashCode(callSuper = true)
public final class ClassInfo extends BaseInfo {
  public Map<String, VarInfo> vars;
  public Map<String, FuncInfo> funcs;

  public ClassInfo(String name, Array<VarDefNode> vars, Array<FuncDefNode> funcs) {
    super(name);
    this.vars = new Map<String, VarInfo>();
    this.funcs = new Map<String, FuncInfo>();
    for (var v : vars) {
      this.vars.put(v.getName(), (VarInfo) v.getInfo());
    }
    for (var func : funcs) {
      this.funcs.put(func.getName(), (FuncInfo) func.getInfo());
    }
  }

  public ClassInfo(String name, FuncInfo... funcs) {
    super(name);
    this.vars = new Map<String, VarInfo>();
    this.funcs = new Map<String, FuncInfo>();
    for (var func : funcs) {
      this.funcs.put(func.getName(), func);
    }
  }

  public BaseInfo getMember(String name) {
    if (vars.get(name) != null) {
      return vars.get(name);
    } else if (funcs.get(name) != null) {
      return funcs.get(name);
    } else {
      return null;
    }
  }

  public int getOffset(String name) {
    int offset = 0;
    for (var varName : vars.keySet()) {
      if (varName.equals(name)) {
        return offset;
      }
      offset++;
    }
    return -1;
  }

  @Override
  public String toString() {
    String str = "class " + getName() + " {\n";
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
