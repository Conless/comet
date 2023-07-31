package dev.conless.comet.frontend.ast.expr;

import dev.conless.comet.utils.Position;

public class PostUnaryExprNode extends ExprNode {
  public ExprNode expr;
  public String op;

  public PostUnaryExprNode(Position position, ExprNode expr, String op) {
    super(position);
    this.expr = expr;
    this.op = op;
  }

  @Override
  public String toString() {
    return expr.toString() + op;
  }
}
