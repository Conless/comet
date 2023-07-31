package dev.conless.comet.frontend.ast.expr;

import dev.conless.comet.utils.Position;

public class AssignExprNode extends ExprNode {
  public ExprNode lhs, rhs;
  public String op;

  public AssignExprNode(Position position) {
    super(position);
  }

  @Override
  public String toString() {
    return lhs.toString() + " " + op + " " + rhs.toString();
  }
}
