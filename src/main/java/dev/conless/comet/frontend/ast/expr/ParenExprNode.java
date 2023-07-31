package dev.conless.comet.frontend.ast.expr;

import dev.conless.comet.utils.Position;

public class ParenExprNode extends ExprNode {
  public ExprNode expr;
  
  public ParenExprNode(Position position) {
    super(position);
  }
  @Override public String toString() {
    return "(" + expr.toString() + ")";
  }
}
