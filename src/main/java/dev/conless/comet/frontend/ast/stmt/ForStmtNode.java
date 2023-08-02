package dev.conless.comet.frontend.ast.stmt;

import dev.conless.comet.frontend.ast.ASTVisitor;
import dev.conless.comet.utils.container.Position;

public class ForStmtNode extends StmtNode {
  public StmtNode init, condition, body;
  public ExprStmtNode update;

  public ForStmtNode(Position position, StmtNode init, StmtNode condition, ExprStmtNode update, StmtNode body) {
    super(position);
    this.init = init;
    this.condition = condition;
    this.update = update;
    this.body = body;
  }

  @Override
  public String toString() {
    String str = "for (";
    str += init.toString().substring(indentDepth * 2) + " ";
    str += condition.toString().substring(indentDepth * 2) + " ";
    String updateStr = update.toString();
    updateStr = updateStr.substring(indentDepth * 2, updateStr.length() - 1);
    str += updateStr + ")";
    if (body != null) {
      if (body instanceof BlockStmtNode) {
        str += " " + body.toString();
      } else {
        indentDepth++;
        str += "\n" + body.toString();
        indentDepth--;
      }
    } else {
      str += "\n" + super.toString() + ";";
    }
    return super.toString() + str;
  }

  @Override
  public void accept(ASTVisitor visitor) throws Exception {
    visitor.visit(this);
  }
}
