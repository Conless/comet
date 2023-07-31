package dev.conless.comet.frontend.ast.stmt;

import dev.conless.comet.frontend.ast.def.VarDefNode;
import dev.conless.comet.utils.Position;

public class VarDefStmtNode extends StmtNode {
  public VarDefNode varDef;

  public VarDefStmtNode(Position position) {
    super(position);
  }

  @Override
  public String toString() {
    return varDef.toString() + ";";
  }
}
