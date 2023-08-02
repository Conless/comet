package dev.conless.comet.frontend.ast;

import dev.conless.comet.frontend.ast.def.*;
import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.container.Position;
import dev.conless.comet.utils.metadata.BaseInfo;
import dev.conless.comet.utils.metadata.ClassInfo;
import dev.conless.comet.utils.metadata.FuncInfo;
import dev.conless.comet.utils.metadata.VarInfo;
import dev.conless.comet.utils.scope.BaseScope;
import dev.conless.comet.utils.scope.GlobalScope;

public class ProgramNode extends ASTNode implements ScopedNode {
  public GlobalScope scope;
  public Array<BaseDefNode> defs;

  public ProgramNode(Position position) {
    super(position);
    this.defs = new Array<BaseDefNode>();
  }

  public void addDef(BaseDefNode def) {
    defs.add(def);
  }

  public Array<BaseDefNode> getDefs() {
    return defs;
  }

  @Override
  public String toString() {
    String str = "";
    for (ASTNode def : defs) {
      str += def.toString();
      if (def instanceof ClassDefNode || def instanceof VarDefNode) {
        str += ";\n";
      } else {
        str += "\n";
      }
    }
    return str;
  }

  @Override
  public void accept(ASTVisitor visitor) throws Exception {
    visitor.visit(this);
  }

  @Override
  public void addScope(BaseScope scope) {
    this.scope = new GlobalScope();
  }

  @Override
  public void declare(BaseInfo info) {
    if (info instanceof ClassInfo) {
      scope.classes.put(info.name, (ClassInfo) info);
    } else if (info instanceof FuncInfo) {
      scope.funcs.put(info.name, (FuncInfo) info);
    } else if (info instanceof VarInfo) {
      scope.vars.put(info.name, (VarInfo) info);
    }
  }

  @Override
  public BaseInfo get(String name) {
    if (scope.vars.containsKey(name)) {
      return scope.vars.get(name);
    } else if (scope.funcs.containsKey(name)) {
      return scope.funcs.get(name);
    } else if (scope.classes.containsKey(name)) {
      return scope.classes.get(name);
    }
    return null;
  }

  public BaseInfo get(String name, String type) {
    if (type == "var") {
      if (scope.vars.containsKey(name)) {
        return scope.vars.get(name);
      }
    } else if (type == "func") {
      if (scope.funcs.containsKey(name)) {
        return scope.funcs.get(name);
      }
    } else if (type == "class") {
      if (scope.classes.containsKey(name)) {
        return scope.classes.get(name);
      }
    }
    return null;
  }

  @Override
  public BaseInfo getRecur(String name) {
    return null;
  }

  public BaseInfo getRecur(String name, String type) {
    return null;
  }
}
