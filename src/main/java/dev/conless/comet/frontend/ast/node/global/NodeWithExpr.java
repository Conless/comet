package dev.conless.comet.frontend.ast.node.global;

import dev.conless.comet.frontend.ast.node.expr.ExprNode;

public interface NodeWithExpr {
  public void replaceExpr(ExprNode expr, ExprNode replacement);
}
