package dev.conless.comet.frontend.ast.node.expr;

import dev.conless.comet.frontend.ast.ASTVisitor;
import dev.conless.comet.frontend.ast.node.global.NodeWithExpr;
import dev.conless.comet.utils.error.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * The `PreUnaryExprNode` class represents a pre-unary expression node in an abstract syntax tree (AST)
 * and provides methods for converting the node to a string and accepting an AST visitor.
 */
@SuperBuilder
@Getter
@Setter
public final class PreUnaryExprNode extends ExprNode implements NodeWithExpr {
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

  @Override
  public void replaceExpr(ExprNode expr, ExprNode replacement) {
    if (this.expr == expr) {
      this.expr = replacement;
    } else {
      throw new RuntimeError("Cannot replace expression that does not exist in this node");
    }
  }  
}
