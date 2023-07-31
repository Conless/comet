package dev.conless.comet.frontend.ast.expr;

import dev.conless.comet.utils.Position;

public class BinaryArithExprNode extends ExprNode {
  public ExprNode lhs, rhs;
  public String op;

  public BinaryArithExprNode(Position position) {
    super(position);
  }

  @Override
  public String toString() {
    return lhs.toString() + " " + op + " " + rhs.toString();
  }
}
