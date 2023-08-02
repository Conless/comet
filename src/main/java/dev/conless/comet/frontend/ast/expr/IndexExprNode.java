package dev.conless.comet.frontend.ast.expr;

import dev.conless.comet.frontend.ast.ASTVisitor;
import dev.conless.comet.utils.container.Position;

public class IndexExprNode extends ExprNode {
  public ExprNode array, index;

  public IndexExprNode(Position position, ExprNode array, ExprNode index) {
    super(position);
    this.array = array;
    this.index = index;
  }

  @Override
  public String toString() {
    return array.toString() + "[" + index.toString() + "]";
  }

  @Override
  public void accept(ASTVisitor visitor) throws Exception {
    visitor.visit(this);
  }
}
