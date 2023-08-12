package dev.conless.comet.frontend.ast.node.expr;

import dev.conless.comet.frontend.ast.ASTVisitor;
import dev.conless.comet.frontend.ast.node.global.HasExprNode;
import dev.conless.comet.utils.error.*;
import lombok.experimental.SuperBuilder;

import lombok.Getter;
import lombok.Setter;

/**
 * The `AssignExprNode` class represents an assignment expression in Java and extends the `ExprNode`
 * class.
 */
@SuperBuilder
@Getter
@Setter
public final class AssignExprNode extends ExprNode implements HasExprNode {
  private ExprNode lhs, rhs;
  private final String op;

  @Override
  public String toString() {
    return lhs.toString() + " " + op + " " + rhs.toString();
  }

  @Override
  public <T> T accept(ASTVisitor<T> visitor) throws BaseError {
    return visitor.visit(this);
  }

  @Override
  public void replaceExpr(ExprNode expr, ExprNode replacement) {
    if (lhs == expr) {
      lhs = replacement;
    } else if (rhs == expr) {
      rhs = replacement;
    } else {
      throw new RuntimeError("Cannot replace expression that does not exist in this node");
    }
  }
}
