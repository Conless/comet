package dev.conless.comet.frontend.ast.node.expr;

import dev.conless.comet.frontend.ast.ASTVisitor;
import dev.conless.comet.frontend.ast.node.utils.ASTNodeWithExpr;
import dev.conless.comet.utils.error.*;

/**
 * The `BinaryExprNode` class represents a binary expression node in an abstract syntax tree (AST) and
 * provides methods for converting it to a string and accepting an AST visitor.
 */
@lombok.experimental.SuperBuilder
@lombok.Getter
@lombok.Setter
public final class ASTBinaryExprNode extends ASTExprNode implements ASTNodeWithExpr {
  private ASTExprNode lhs, rhs;
  private String op;

  @Override
  public String toString() {
    return lhs.toString() + " " + op + " " + rhs.toString();
  }

  @Override
  public <T> T accept(ASTVisitor<T> visitor) throws BaseError {
    return visitor.visit(this);
  }

  @Override
  public void replaceExpr(ASTExprNode expr, ASTExprNode replacement) {
    if (lhs == expr) {
      lhs = replacement;
    } else if (rhs == expr) {
      rhs = replacement;
    } else {
      throw new RuntimeError("Cannot replace expression that does not exist in this node");
    }
  }
}
