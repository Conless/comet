package dev.conless.comet.frontend.ast.stmt;

import dev.conless.comet.frontend.ast.expr.ExprNode;
import dev.conless.comet.utils.Position;

public class ReturnStmtNode extends StmtNode {
  ExprNode expr;

  public ReturnStmtNode(Position position, ExprNode expr) {
    super(position);
    this.expr = expr;
  }

  @Override
  public String toString() {
    return "return " + expr.toString() + ";";
  }
}
