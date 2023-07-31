package dev.conless.comet.frontend.ast.stmt;

import dev.conless.comet.frontend.ast.expr.ExprNode;
import dev.conless.comet.utils.Position;

public class IfStmtNode extends StmtNode {
  ExprNode condition;
  StmtNode thenStmt, elseStmt;

  IfStmtNode(Position position) {
    super(position);
  }

  @Override
  public String toString() {
    return "if (" + condition.toString() + ") " + thenStmt.toString() + (elseStmt != null ? " else " + elseStmt.toString() : "");
  }
}
