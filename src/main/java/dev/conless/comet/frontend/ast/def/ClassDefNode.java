package dev.conless.comet.frontend.ast.def;

import dev.conless.comet.frontend.ast.ASTVisitor;
import dev.conless.comet.frontend.ast.ScopedNode;
import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.container.Position;
import dev.conless.comet.utils.metadata.BaseInfo;
import dev.conless.comet.utils.metadata.ClassInfo;
import dev.conless.comet.utils.metadata.FuncInfo;
import dev.conless.comet.utils.metadata.VarInfo;
import dev.conless.comet.utils.scope.BaseScope;
import dev.conless.comet.utils.scope.ClassScope;

public class ClassDefNode extends BaseDefNode implements ScopedNode {
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

  public Array<VarDefNode> getVarDefs() {
    return varDefs;
  }

  public Array<FuncDefNode> getFuncDefs() {
    return funcDefs;
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
  public BaseScope getScope() {
    return scope;
  }
}
