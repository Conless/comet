package dev.conless.comet.frontend.ast.def;

import dev.conless.comet.frontend.ast.ASTNode;
import dev.conless.comet.utils.Position;
import dev.conless.comet.utils.Array;

public class ClassDefNode extends ASTNode {
  public String name;
  public FuncDefNode constructor;
  public Array<VarDefNode> varDefs;
  public Array<FuncDefNode> funcDefs;
  
  public ClassDefNode(Position position, String name, FuncDefNode constructor) {
    super(position);
    this.name = name;
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

  @Override
  public String toString() {
    String str = "class " + name + " {\n";
    if (constructor != null) {
      str += "  " + constructor.toString() + "\n";
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
}
