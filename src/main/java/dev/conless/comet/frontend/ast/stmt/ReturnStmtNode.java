package dev.conless.comet.frontend.ast.stmt;

import dev.conless.comet.frontend.ast.ASTVisitor;
import dev.conless.comet.frontend.ast.expr.ExprNode;
import dev.conless.comet.utils.container.Position;

public class ReturnStmtNode extends StmtNode {
  ExprNode expr;

  public ReturnStmtNode(Position position, ExprNode expr) {
    super(position);
    this.expr = expr;
  }

  public ExprNode getExpr() {
    return expr;
  }

  @Override
  public String toString() {
    return super.toString() + "return" + (expr != null ? " " + expr.toString() : "") + ";";
  }

  @Override
  public void accept(ASTVisitor visitor) throws Exception {
    visitor.visit(this);
  }
}
