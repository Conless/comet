package dev.conless.comet.frontend.ast.expr;

import dev.conless.comet.utils.Position;

public class ConditionalExprNode extends ExprNode {
  ExprNode condition, lhs, rhs;

  public ConditionalExprNode(Position position) {
    super(position);
  }

  @Override
  public String toString() {
    return condition.toString() + " ? " + lhs.toString() + " : " + rhs.toString();
  }
}
