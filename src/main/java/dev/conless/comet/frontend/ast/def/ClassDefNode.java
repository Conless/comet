package dev.conless.comet.frontend.ast.def;

import java.util.ArrayList;

import dev.conless.comet.frontend.ast.ASTNode;
import dev.conless.comet.utils.Position;

public class ClassDefNode extends ASTNode {
  public String name;
  public FuncDefNode constructor;
  public ArrayList<VarDefNode> varDefs;
  public ArrayList<FuncDefNode> funcDefs;
  
  public ClassDefNode(Position position) {
    super(position);
    this.varDefs = new ArrayList<VarDefNode>();
    this.funcDefs = new ArrayList<FuncDefNode>();
  }

  @Override
  public String toString() {
    String str = "class " + name + " {\n";
    str += "  " + constructor.toString() + "\n";
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
