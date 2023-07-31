package dev.conless.comet.frontend.ast.stmt;

import dev.conless.comet.frontend.ast.expr.ExprNode;
import dev.conless.comet.utils.Position;

public class WhileStmtNode extends StmtNode {
  ExprNode condition;
  StmtNode body;

  WhileStmtNode(Position position) {
    super(position);
  }

  @Override
  public String toString() {
    return "while (" + condition.toString() + ") " + body.toString();
  }
}
