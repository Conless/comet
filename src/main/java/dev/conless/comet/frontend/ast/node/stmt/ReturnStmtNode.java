package dev.conless.comet.frontend.ast.node.stmt;

import dev.conless.comet.frontend.ast.ASTVisitor;
import dev.conless.comet.frontend.ast.node.expr.ExprNode;
import dev.conless.comet.frontend.ast.node.global.NodeWithExpr;
import dev.conless.comet.utils.error.*;

/**
 * The `ReturnStmtNode` class represents a return statement in a Java program and extends the
 * `StmtNode` class.
 */
@lombok.experimental.SuperBuilder
@lombok.Getter
@lombok.Setter
public final class ReturnStmtNode extends StmtNode implements NodeWithExpr {
  private ExprNode expr;

  @Override
  public String toString() {
    return super.toString() + "return" + (expr != null ? " " + expr.toString() : "") + ";";
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
