package dev.conless.comet.frontend.ast.node.stmt;

import dev.conless.comet.frontend.ast.ASTVisitor;
import dev.conless.comet.frontend.ast.node.expr.ExprNode;
import dev.conless.comet.frontend.ast.node.global.NodeWithExpr;
import dev.conless.comet.utils.error.*;
import dev.conless.comet.utils.container.Array;

/**
 * The `ExprStmtNode` class represents a statement node in an abstract syntax tree (AST) that contains
 * an array of expression nodes.
 */
@lombok.experimental.SuperBuilder
@lombok.Getter
@lombok.Setter
public final class ExprStmtNode extends StmtNode implements NodeWithExpr {
  private Array<ExprNode> exprs;

  @Override
  public String toString() {
    return super.toString() + exprs.toString(", ") + ";";
  }

  @Override
  public <T> T accept(ASTVisitor<T> visitor) throws BaseError {
    return visitor.visit(this);
  }

  @Override
  public void replaceExpr(ExprNode expr, ExprNode replacement) {
    if (exprs.contains(expr)) {
      exprs.set(exprs.indexOf(expr), replacement);
    } else {
      throw new RuntimeError("Cannot replace expression that does not exist in this node");
    }
  }
}
