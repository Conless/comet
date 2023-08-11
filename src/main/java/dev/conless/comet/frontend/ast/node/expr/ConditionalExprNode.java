package dev.conless.comet.frontend.ast.node.expr;

import dev.conless.comet.frontend.ast.ASTVisitor;
import dev.conless.comet.frontend.ast.node.special.HasExprNode;
import dev.conless.comet.utils.error.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


/**
 * The `ConditionalExprNode` class represents a conditional expression node in an abstract syntax tree
 * (AST) and provides methods for converting it to a string and accepting an AST visitor.
 */
@SuperBuilder
@Getter
@Setter
public final class ConditionalExprNode extends ExprNode implements HasExprNode {
  private ExprNode condition, lhs, rhs;

  @Override
  public String toString() {
    return condition.toString() + " ? " + lhs.toString() + " : " + rhs.toString();
  }

  @Override
  public <T> T accept(ASTVisitor<T> visitor) throws BaseError {
    return visitor.visit(this);
  }

  @Override
  public void replaceExpr(ExprNode expr, ExprNode replacement) {
    if (condition == expr) {
      condition = replacement;
    } else if (lhs == expr) {
      lhs = replacement;
    } else if (rhs == expr) {
      rhs = replacement;
    } else {
      throw new RuntimeError("Cannot replace expression that does not exist in this node");
    }
  }
}
