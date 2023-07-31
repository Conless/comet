package dev.conless.comet.frontend.ast.stmt;

import dev.conless.comet.frontend.ast.def.ClassDefNode;
import dev.conless.comet.utils.Position;

public class ClassDefStmtNode extends StmtNode {
  ClassDefNode varDef;

  public ClassDefStmtNode(Position position) {
    super(position);
  }

  @Override
  public String toString() {
    return varDef.toString() + ";";
  }
}
