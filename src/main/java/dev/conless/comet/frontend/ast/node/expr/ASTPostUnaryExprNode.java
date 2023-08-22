package dev.conless.comet.frontend.ast.node.expr;

import dev.conless.comet.frontend.ast.ASTVisitor;
import dev.conless.comet.frontend.ast.node.utils.ASTNodeWithExpr;
import dev.conless.comet.utils.error.*;

/**
 * The `PostUnaryExprNode` class represents a post-unary expression node in an abstract syntax tree
 * (AST) and provides methods for converting the node to a string and accepting an AST visitor.
 */
@lombok.experimental.SuperBuilder
@lombok.Getter
@lombok.Setter
public final class ASTPostUnaryExprNode extends ASTExprNode implements ASTNodeWithExpr {
  private ASTExprNode expr;
  private String op;

  @Override
  public String toString() {
    return expr.toString() + op;
  }

  @Override
  public <T> T accept(ASTVisitor<T> visitor) throws BaseError {
    return visitor.visit(this);
  }

  @Override
  public void replaceExpr(ASTExprNode expr, ASTExprNode replacement) {
    if (this.expr == expr) {
      this.expr = replacement;
    } else {
      throw new RuntimeError("Cannot replace expression that does not exist in this node");
    }
  }
}
