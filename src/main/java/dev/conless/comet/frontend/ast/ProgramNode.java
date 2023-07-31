package dev.conless.comet.frontend.ast;

import dev.conless.comet.frontend.ast.def.*;
import dev.conless.comet.utils.Position;
import dev.conless.comet.utils.Array;

public class ProgramNode extends ASTNode {
  public Array<ASTNode> defs;

  public ProgramNode(Position position) {
    super(position);
    this.defs = new Array<ASTNode>();
  }

  public void addDef(ASTNode def) {
    defs.add(def);
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
}
