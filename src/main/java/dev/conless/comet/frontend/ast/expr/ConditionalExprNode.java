package dev.conless.comet.frontend.ast.expr;

import dev.conless.comet.frontend.ast.ASTVisitor;
import dev.conless.comet.utils.container.Position;

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

  @Override
  public void accept(ASTVisitor visitor) throws Exception {
    visitor.visit(this);
  }
}
