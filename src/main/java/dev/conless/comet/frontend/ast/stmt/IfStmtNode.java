package dev.conless.comet.frontend.ast.stmt;

import dev.conless.comet.frontend.ast.expr.ExprNode;
import dev.conless.comet.utils.Position;

public class IfStmtNode extends StmtNode {
  public ExprNode condition;
  public StmtNode thenStmt, elseStmt;

  public IfStmtNode(Position position, ExprNode condition, StmtNode thenStmt, StmtNode elseStmt) {
    super(position);
    this.condition = condition;
    this.thenStmt = thenStmt;
    this.elseStmt = elseStmt;
  }

  @Override
  public String toString() {
    String str = "if (" + condition.toString() + ")";
    if (thenStmt instanceof BlockStmtNode) {
      str += " " + thenStmt.toString();
    } else {
      indentDepth++;
      str += "\n" + thenStmt.toString();
      indentDepth--;
    }
    if (elseStmt != null) {
      if (str.endsWith("}")) {
        str += " else";
      } else {
        str += "\n" + super.toString() + "else";
      }
      if (elseStmt instanceof BlockStmtNode || elseStmt instanceof IfStmtNode) {
        str += " " + elseStmt.toString().substring(indentDepth * 2);
      } else {
        indentDepth++;
        str += "\n" + elseStmt.toString();
        indentDepth--;
      }
    }
    return super.toString() + str;
  }
}
