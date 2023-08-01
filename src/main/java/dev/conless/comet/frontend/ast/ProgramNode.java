package dev.conless.comet.frontend.ast;

import dev.conless.comet.frontend.ast.def.*;
import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.container.Position;

public class ProgramNode extends ASTNode {
  public Array<BaseDefNode> defs;

  public ProgramNode(Position position) {
    super(position);
    this.defs = new Array<BaseDefNode>();
  }

  public void addDef(BaseDefNode def) {
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
