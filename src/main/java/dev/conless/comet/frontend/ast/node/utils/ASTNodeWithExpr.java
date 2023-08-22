package dev.conless.comet.frontend.ast.node.utils;

import dev.conless.comet.frontend.ast.node.expr.ASTExprNode;

public interface ASTNodeWithExpr {
  public void replaceExpr(ASTExprNode expr, ASTExprNode replacement);
}
