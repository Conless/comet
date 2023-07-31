package dev.conless.comet.frontend.ast.stmt;

import dev.conless.comet.frontend.ast.expr.ExprNode;
import dev.conless.comet.utils.Position;

public class WhileStmtNode extends StmtNode {
  public ExprNode condition;
  public StmtNode body;

  public WhileStmtNode(Position position, ExprNode condition, StmtNode body) {
    super(position);
    this.condition = condition;
    this.body = body;
  }

  @Override
  public String toString() {
    String str = "while (" + condition.toString() + ")";
    if (body instanceof BlockStmtNode) {
      str += " " + body.toString();
    } else {
      indentDepth++;
      str += "\n" + body.toString();
      indentDepth--;
    }
    return super.toString() + str;
  }
}
