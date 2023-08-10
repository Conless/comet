package dev.conless.comet.frontend.ast.node.expr;

import dev.conless.comet.frontend.ast.ASTVisitor;
import dev.conless.comet.utils.error.BaseError;
import dev.conless.comet.utils.container.Array;

import lombok.experimental.SuperBuilder;
import lombok.Value;
import lombok.EqualsAndHashCode;

/**
 * The `CallExprNode` class represents a function call expression in an abstract syntax tree (AST) and
 * provides methods for manipulating and visiting the node.
 */
@SuperBuilder
@Value
@EqualsAndHashCode(callSuper = true)
public final class CallExprNode extends ExprNode {
  private ExprNode func;
  private Array<ExprNode> args;

  @Override
  public String toString() {
    return func + "(" + args.toString(", ") + ")";
  }
  
  @Override
  public <T> T accept(ASTVisitor<T> visitor) throws BaseError {
    return visitor.visit(this);
  }
}
