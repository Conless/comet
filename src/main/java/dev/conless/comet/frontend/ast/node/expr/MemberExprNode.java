package dev.conless.comet.frontend.ast.node.expr;

import dev.conless.comet.frontend.ast.ASTVisitor;
import dev.conless.comet.frontend.ast.node.global.NodeWithExpr;
import dev.conless.comet.utils.error.*;

/**
 * The `MemberExprNode` class represents a member expression in an abstract syntax tree (AST) and
 * provides methods for converting it to a string and accepting an AST visitor.
 */
@lombok.experimental.SuperBuilder
@lombok.Getter
@lombok.Setter
public final class MemberExprNode extends ExprNode implements NodeWithExpr {
  private ExprNode object;
  private String member;

  @Override
  public String toString() {
    return object.toString() + "." + member;
  }

  @Override
  public <T> T accept(ASTVisitor<T> visitor) throws BaseError {
    return visitor.visit(this);
  }

  @Override
  public void replaceExpr(ExprNode expr, ExprNode replacement) {
    if (object == expr) {
      object = replacement;
    } else {
      throw new RuntimeError("Cannot replace expression that does not exist in this node");
    }
  }
}
