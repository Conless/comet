package dev.conless.comet.frontend.ast.def;

import dev.conless.comet.frontend.ast.ASTVisitor;
import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.container.Position;
import dev.conless.comet.utils.metadata.BaseInfo;
import dev.conless.comet.utils.metadata.ClassInfo;
import dev.conless.comet.utils.metadata.FuncInfo;
import dev.conless.comet.utils.metadata.VarInfo;
import dev.conless.comet.utils.scope.BaseScope;
import dev.conless.comet.utils.scope.ClassScope;

public class ClassDefNode extends BaseDefNode {
  public ClassScope scope;
  public FuncDefNode constructor;
  public Array<VarDefNode> varDefs;
  public Array<FuncDefNode> funcDefs;
  
  public ClassDefNode(Position position, String name, FuncDefNode constructor) {
    super(position, new ClassInfo(name));
    this.constructor = constructor;
    this.varDefs = new Array<VarDefNode>();
    this.funcDefs = new Array<FuncDefNode>();
  }

  public void addVarDef(VarDefNode varDef) {
    varDefs.add(varDef);
  }

  public void addFuncDef(FuncDefNode funcDef) {
    funcDefs.add(funcDef);
  }

  public String getName() {
    return info.name;
  }

  @Override
  public String toString() {
    String str = "class " + info.name + " {\n";
    if (constructor != null) {
      String ctorString = constructor.toString();
      str += "  " + ctorString.replace("\n", "\n  ") + "\n";
    }
    str += varDefs.toString("  ", ";\n", ";\n");
    if (funcDefs.size() > 0) {
      String funcStr = funcDefs.toString("  ", "\n");
      funcStr = funcStr.replace("\n", "\n  ");
      str += funcStr + "\n";
    }
    str += "}";
    return str;
  }

  @Override
  public void accept(ASTVisitor visitor) throws Exception {
    visitor.visit(this);
  }

  @Override
  public void addScope(BaseScope scope) {
    this.scope = new ClassScope(scope);
  }

  @Override
  public void declare(BaseInfo info) {
    if (info instanceof FuncInfo) {
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
