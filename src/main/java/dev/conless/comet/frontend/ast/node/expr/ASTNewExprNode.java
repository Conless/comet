package dev.conless.comet.frontend.ast.node.expr;

import dev.conless.comet.frontend.ast.ASTVisitor;
import dev.conless.comet.frontend.ast.node.utils.ASTNodeWithExpr;
import dev.conless.comet.frontend.utils.metadata.TypeInfo;
import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.error.*;

/**
 * The `NewExprNode` class represents a new expression node in an abstract syntax tree (AST) and
 * includes information about the lengths of the array being created.
 */
@lombok.experimental.SuperBuilder
@lombok.Getter
@lombok.Setter
public final class ASTNewExprNode extends ASTExprNode implements ASTNodeWithExpr {
  private Array<ASTExprNode> lengths;
  private TypeInfo type;

  @Override
  public String toString() {
    String str = "new " + type.getName();
    for (int i = 0; i < type.getDepth(); i++) {
      str += "[" + (i < lengths.size() ? lengths.get(i).toString() : "") + "]";
    }
    return str;
  }

  @Override
  public <T> T accept(ASTVisitor<T> visitor) throws BaseError {
    return visitor.visit(this);
  }

  @Override
  public void replaceExpr(ASTExprNode expr, ASTExprNode replacement) {
    for (int i = 0; i < lengths.size(); i++) {
      if (lengths.get(i) == expr) {
        lengths.set(i, replacement);
        return;
      }
    }
    throw new RuntimeError("Cannot replace expression that does not exist in this node");
  }
}
