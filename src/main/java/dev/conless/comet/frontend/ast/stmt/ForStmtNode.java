package dev.conless.comet.frontend.ast.stmt;

import dev.conless.comet.frontend.ast.expr.ExprNode;
import dev.conless.comet.utils.Position;

public class ForStmtNode extends StmtNode {
  public StmtNode init, update, body;
  public ExprNode condition;

  public ForStmtNode(Position position) {
    super(position);
  }

  @Override
  public String toString() {
    String str = "for (";
    String initStr = init.toString();
    str += initStr.substring(0, initStr.length() - 1);
    String conditionStr = condition.toString();
    str += conditionStr;
    String updateStr = update.toString();
    str += updateStr.substring(0, updateStr.length() - 1);
    str += ") " + body.toString();
    return str;
  }
}
