package dev.conless.comet.frontend.ast.expr;

import dev.conless.comet.utils.Position;

public class IndexExprNode extends ExprNode {
  public ExprNode array, index;

  public IndexExprNode(Position position, ExprNode array, ExprNode index) {
    super(position);
    this.array = array;
    this.index = index;
  }

  @Override
  public String toString() {
    return array.toString() + "." + index.toString();
  }
}
