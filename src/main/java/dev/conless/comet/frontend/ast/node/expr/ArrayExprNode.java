package dev.conless.comet.frontend.ast.node.expr;

import dev.conless.comet.frontend.ast.ASTVisitor;
import dev.conless.comet.frontend.ast.node.special.HasExprNode;
import dev.conless.comet.utils.error.*;
import lombok.experimental.SuperBuilder;
import lombok.Getter;
import lombok.Setter;

/**
 * The `ArrayExprNode` class represents an array expression node in an abstract syntax tree (AST) and
 * provides methods for converting it to a string and accepting an AST visitor.
 */
@SuperBuilder
@Getter
@Setter
public final class ArrayExprNode extends ExprNode implements HasExprNode {
  private ExprNode array, subscript;

  @Override
  public String toString() {
    return array.toString() + "[" + subscript.toString() + "]";
  }

  @Override
  public <T> T accept(ASTVisitor<T> visitor) throws BaseError {
    return visitor.visit(this);
  }

  @Override
  public void replaceExpr(ExprNode expr, ExprNode replacement) {
    if (array == expr) {
      array = replacement;
    } else if (subscript == expr) {
      subscript = replacement;
    } else {
      throw new RuntimeError("Cannot replace expression that does not exist in this node");
    }
  }
}
