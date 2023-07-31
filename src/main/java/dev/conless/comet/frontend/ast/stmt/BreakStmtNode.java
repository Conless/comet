package dev.conless.comet.frontend.ast.stmt;

import dev.conless.comet.utils.Position;

public class BreakStmtNode extends StmtNode {
  public BreakStmtNode(Position position) {
    super(position);
  }

  @Override
  public String toString() {
    return "break;";
  }
}
