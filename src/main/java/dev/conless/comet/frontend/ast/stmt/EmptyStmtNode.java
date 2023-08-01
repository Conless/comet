package dev.conless.comet.frontend.ast.stmt;

import dev.conless.comet.utils.container.Position;

public class EmptyStmtNode extends StmtNode {
  public EmptyStmtNode(Position position) {
    super(position);
  }

  @Override
  public String toString() {
    return super.toString() + ";";
  }
}
