package dev.conless.comet.frontend.ast.expr;

import dev.conless.comet.utils.Position;

public class PreUnaryExprNode extends ExprNode {
  public String op;
  public ExprNode expr;

  public PreUnaryExprNode(Position position, ExprNode expr, String op) {
    super(position);
    this.expr = expr;
    this.op = op;
  }

  @Override
  public String toString() {
    return op + expr.toString();
  }
}
