package dev.conless.comet.frontend.ast.node.expr;

import dev.conless.comet.frontend.ast.ASTVisitor;
import dev.conless.comet.utils.error.BaseError;
import lombok.experimental.SuperBuilder;
import lombok.Value;
import lombok.EqualsAndHashCode;

/**
 * The `AssignExprNode` class represents an assignment expression in Java and extends the `ExprNode`
 * class.
 */
@SuperBuilder
@Value
@EqualsAndHashCode(callSuper = true)
public final class AssignExprNode extends ExprNode {
  private ExprNode lhs, rhs;
  private String op;

  @Override
  public String toString() {
    return lhs.toString() + " " + op + " " + rhs.toString();
  }

  @Override
  public <T> T accept(ASTVisitor<T> visitor) throws BaseError {
    return visitor.visit(this);
  }
}
