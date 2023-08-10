package dev.conless.comet.frontend.ast.node.expr;

import dev.conless.comet.frontend.ast.ASTVisitor;
import dev.conless.comet.utils.error.BaseError;

import lombok.experimental.SuperBuilder;
import lombok.Value;
import lombok.EqualsAndHashCode;

/**
 * The `PreUnaryExprNode` class represents a pre-unary expression node in an abstract syntax tree (AST)
 * and provides methods for converting the node to a string and accepting an AST visitor.
 */
@SuperBuilder
@Value
@EqualsAndHashCode(callSuper = true)
public final class PreUnaryExprNode extends ExprNode {
  private String op;
  private ExprNode expr;

  @Override
  public String toString() {
    return op + expr.toString();
  }

  @Override
  public <T> T accept(ASTVisitor<T> visitor) throws BaseError {
    return visitor.visit(this);
  }
}
