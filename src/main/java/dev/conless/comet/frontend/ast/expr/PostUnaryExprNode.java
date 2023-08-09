package dev.conless.comet.frontend.ast.expr;

import dev.conless.comet.frontend.ast.ASTVisitor;
import dev.conless.comet.utils.error.BaseError;

import lombok.experimental.SuperBuilder;
import lombok.Value;
import lombok.EqualsAndHashCode;

/**
 * The `PostUnaryExprNode` class represents a post-unary expression node in an abstract syntax tree
 * (AST) and provides methods for converting the node to a string and accepting an AST visitor.
 */
@SuperBuilder
@Value
@EqualsAndHashCode(callSuper = true)
public final class PostUnaryExprNode extends ExprNode {
  private ExprNode expr;
  private String op;

  @Override
  public String toString() {
    return expr.toString() + op;
  }

  @Override
  public void accept(ASTVisitor visitor) throws BaseError {
    visitor.visit(this);
  }
}
