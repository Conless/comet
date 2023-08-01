package dev.conless.comet.frontend.ast.stmt;

import dev.conless.comet.frontend.ast.expr.ExprNode;
import dev.conless.comet.utils.container.Position;

public class ReturnStmtNode extends StmtNode {
  ExprNode expr;

  public ReturnStmtNode(Position position, ExprNode expr) {
    super(position);
    this.expr = expr;
  }

  @Override
  public String toString() {
    return super.toString() + "return" + (expr != null ? " " + expr.toString() : "") + ";";
  }
}
