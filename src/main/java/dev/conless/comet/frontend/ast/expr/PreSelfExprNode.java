package dev.conless.comet.frontend.ast.expr;

import dev.conless.comet.utils.Position;

public class PreSelfExprNode extends ExprNode {
  public ExprNode expr;
  public String op;

  public PreSelfExprNode(Position position) {
    super(position);
  }

  @Override
  public String toString() {
    return op + expr.toString();
  }
}
