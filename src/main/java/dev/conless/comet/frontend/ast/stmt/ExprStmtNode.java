package dev.conless.comet.frontend.ast.stmt;

import dev.conless.comet.frontend.ast.ASTVisitor;
import dev.conless.comet.frontend.ast.expr.ExprNode;
import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.container.Position;

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
    return super.toString() + exprs.toString(", ") + ";";
  }

  @Override
  public void accept(ASTVisitor visitor) throws Exception {
    visitor.visit(this);
  }
}
