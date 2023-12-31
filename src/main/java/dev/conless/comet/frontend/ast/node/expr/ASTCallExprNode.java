package dev.conless.comet.frontend.ast.node.expr;

import dev.conless.comet.frontend.ast.ASTVisitor;
import dev.conless.comet.frontend.ast.node.utils.ASTNodeWithExpr;
import dev.conless.comet.utils.error.*;
import dev.conless.comet.utils.container.Array;

/**
 * The `CallExprNode` class represents a function call expression in an abstract syntax tree (AST) and
 * provides methods for manipulating and visiting the node.
 */
@lombok.experimental.SuperBuilder
@lombok.Getter
@lombok.Setter
public final class ASTCallExprNode extends ASTExprNode implements ASTNodeWithExpr {
  private ASTExprNode func;
  private Array<ASTExprNode> args;

  @Override
  public String toString() {
    return func + "(" + args.toString(", ") + ")";
  }

  
  
  @Override
  public <T> T accept(ASTVisitor<T> visitor) throws BaseError {
    return visitor.visit(this);
  }

  @Override
  public void replaceExpr(ASTExprNode expr, ASTExprNode replacement) {
    if (func == expr) {
      func = replacement;
    } else {
      for (int i = 0; i < args.size(); i++) {
        if (args.get(i) == expr) {
          args.set(i, replacement);
          return;
        }
      }
      throw new RuntimeError("Cannot replace expression that does not exist in this node");
    }
  }
}
