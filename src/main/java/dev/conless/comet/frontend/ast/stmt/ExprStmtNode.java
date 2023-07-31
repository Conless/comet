package dev.conless.comet.frontend.ast.stmt;

import dev.conless.comet.frontend.ast.expr.ExprNode;
import dev.conless.comet.utils.Position;
import dev.conless.comet.utils.Array;

public class ExprStmtNode extends StmtNode {
  public Array<ExprNode> exprs;

  public ExprStmtNode(Position position) {
    super(position);
    exprs = new Array<ExprNode>();
  }

  public void addExpr(ExprNode expr) {
    exprs.add(expr);
  }

  @Override
  public String toString() {
    return exprs.toString(", ");
  }
}
