package dev.conless.comet.frontend.ast.def;

import java.util.ArrayList;

import dev.conless.comet.frontend.ast.*;
import dev.conless.comet.utils.*;

public class ClassDefNode extends ASTNode {
  public String name;
  public ClassCtorNode ctor;
  public ArrayList<ASTNode> varDefs;
  public ArrayList<ASTNode> funcDefs;
  
  public ClassDefNode(Position position) {
    super(position);
    this.varDefs = new ArrayList<ASTNode>();
    this.funcDefs = new ArrayList<ASTNode>();
  }

  @Override
  public String toString() {
    String str = "class " + name + " {\n";
    str += "  " + ctor.toString() + "\n";
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
