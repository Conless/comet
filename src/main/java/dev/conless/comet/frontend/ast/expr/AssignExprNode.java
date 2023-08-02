package dev.conless.comet.frontend.ast.expr;

import dev.conless.comet.frontend.ast.ASTVisitor;
import dev.conless.comet.utils.container.Position;

public class AssignExprNode extends ExprNode {
  public ExprNode lhs, rhs;
  public String op;

  public AssignExprNode(Position position, ExprNode lhs, String op, ExprNode rhs) {
    super(position);
    this.lhs = lhs;
    this.op = op;
    this.rhs = rhs;
  }

  @Override
  public String toString() {
    return lhs.toString() + " " + op + " " + rhs.toString();
  }

  @Override
  public void accept(ASTVisitor visitor) throws Exception {
    visitor.visit(this);
  }
}
