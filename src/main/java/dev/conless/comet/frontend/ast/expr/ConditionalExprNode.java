package dev.conless.comet.frontend.ast.expr;

import dev.conless.comet.utils.Position;

public class ConditionalExprNode extends ExprNode {
  public ExprNode condition, lhs, rhs;

  public ConditionalExprNode(Position position, ExprNode condition, ExprNode lhs, ExprNode rhs) {
    super(position);
    this.condition = condition;
    this.lhs = lhs;
    this.rhs = rhs;
  }

  @Override
  public String toString() {
    return condition.toString() + " ? " + lhs.toString() + " : " + rhs.toString();
  }
}
