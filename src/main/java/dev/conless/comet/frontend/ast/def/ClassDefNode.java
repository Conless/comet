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
    str += "  " + constructor.toString() + "\n";
    str += varDefs.toString("  ", ";\n");
    for (ASTNode varDef : varDefs) {
      str += "  " + varDef.toString() + "\n";
    }
    for (ASTNode funcDef : funcDefs) {
      str += "  " + funcDef.toString() + "\n";
    }
    str += "};";
    return str;
  }
}
