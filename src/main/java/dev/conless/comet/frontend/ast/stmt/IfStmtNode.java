package dev.conless.comet.frontend.ast.stmt;

import dev.conless.comet.frontend.ast.expr.ExprNode;
import dev.conless.comet.utils.Position;

public class IfStmtNode extends StmtNode {
  public ExprNode condition;
  public StmtNode thenStmt, elseStmt;

  public IfStmtNode(Position position, ExprNode condition, StmtNode thenStmt, StmtNode elseStmt) {
    super(position);
    this.condition = condition;
    this.thenStmt = thenStmt;
    this.elseStmt = elseStmt;
  }

  @Override
  public String toString() {
    return "if (" + condition.toString() + ") " + thenStmt.toString() + (elseStmt != null ? " else " + elseStmt.toString() : "");
  }
}
