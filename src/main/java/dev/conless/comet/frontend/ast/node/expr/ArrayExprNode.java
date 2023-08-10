package dev.conless.comet.frontend.ast.node.expr;

import dev.conless.comet.frontend.ast.ASTVisitor;
import dev.conless.comet.utils.error.BaseError;
import lombok.experimental.SuperBuilder;
import lombok.Value;
import lombok.EqualsAndHashCode;

/**
 * The `ArrayExprNode` class represents an array expression node in an abstract syntax tree (AST) and
 * provides methods for converting it to a string and accepting an AST visitor.
 */
@SuperBuilder
@Value
@EqualsAndHashCode(callSuper = true)
public final class ArrayExprNode extends ExprNode {
  private ExprNode array, subscript;

  @Override
  public String toString() {
    return array.toString() + "[" + subscript.toString() + "]";
  }

  @Override
  public <T> T accept(ASTVisitor<T> visitor) throws BaseError {
    return visitor.visit(this);
  }
}
