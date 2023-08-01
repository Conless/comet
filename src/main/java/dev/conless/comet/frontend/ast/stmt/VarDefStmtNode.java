package dev.conless.comet.frontend.ast.stmt;

import dev.conless.comet.frontend.ast.def.VarDefNode;
import dev.conless.comet.utils.container.Position;

public class VarDefStmtNode extends StmtNode {
  public VarDefNode def;

  public VarDefStmtNode(Position position, VarDefNode def) {
    super(position);
    this.def = def;
  }

  @Override
  public String toString() {
    return super.toString() + def.toString() + ";";
  }
}
