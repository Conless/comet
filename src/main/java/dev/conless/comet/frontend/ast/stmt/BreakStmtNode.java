package dev.conless.comet.frontend.ast.stmt;

import dev.conless.comet.utils.Position;

public class BreakStmtNode extends StmtNode {
  BreakStmtNode(Position position) {
    super(position);
  }

  @Override
  public String toString() {
    return "break;";
  }
}
