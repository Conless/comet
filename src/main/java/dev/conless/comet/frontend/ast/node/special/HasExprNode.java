package dev.conless.comet.frontend.ast.node.special;

import dev.conless.comet.frontend.ast.node.expr.ExprNode;

public interface HasExprNode {
  public void replaceExpr(ExprNode expr, ExprNode replacement);
}
