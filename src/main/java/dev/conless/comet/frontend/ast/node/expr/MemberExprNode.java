package dev.conless.comet.frontend.ast.node.expr;

import dev.conless.comet.frontend.ast.ASTVisitor;
import dev.conless.comet.utils.error.BaseError;

import lombok.experimental.SuperBuilder;
import lombok.Value;
import lombok.EqualsAndHashCode;

/**
 * The `MemberExprNode` class represents a member expression in an abstract syntax tree (AST) and
 * provides methods for converting it to a string and accepting an AST visitor.
 */
@SuperBuilder
@Value
@EqualsAndHashCode(callSuper = true)
public final class MemberExprNode extends ExprNode {
  private ExprNode object;
  private String member;

  @Override
  public String toString() {
    return object.toString() + "." + member;
  }

  @Override
  public void accept(ASTVisitor visitor) throws BaseError {
    visitor.visit(this);
  }
}
