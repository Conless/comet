package dev.conless.comet.frontend.ast.node.expr;

import dev.conless.comet.frontend.ast.ASTVisitor;
import dev.conless.comet.utils.error.BaseError;

import lombok.experimental.SuperBuilder;
import lombok.Value;
import lombok.EqualsAndHashCode;

/**
 * The `ConditionalExprNode` class represents a conditional expression node in an abstract syntax tree
 * (AST) and provides methods for converting it to a string and accepting an AST visitor.
 */
@SuperBuilder
@Value
@EqualsAndHashCode(callSuper = true)
public final class ConditionalExprNode extends ExprNode {
  private ExprNode condition, lhs, rhs;

  @Override
  public String toString() {
    return condition.toString() + " ? " + lhs.toString() + " : " + rhs.toString();
  }

  @Override
  public <T> T accept(ASTVisitor<T> visitor) throws BaseError {
    return visitor.visit(this);
  }
}
