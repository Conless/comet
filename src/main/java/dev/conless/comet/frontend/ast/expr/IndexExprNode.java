package dev.conless.comet.frontend.ast.expr;

import dev.conless.comet.utils.Position;

public class IndexExprNode extends ExprNode {
  ExprNode array;
  ExprNode index;

  public IndexExprNode(Position position) {
    super(position);
  }

  @Override
  public String toString() {
    return array.toString() + "." + index.toString();
  }
}
