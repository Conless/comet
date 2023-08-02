package dev.conless.comet.frontend.ast.stmt;

import dev.conless.comet.frontend.ast.ASTVisitor;
import dev.conless.comet.frontend.ast.ScopedNode;
import dev.conless.comet.frontend.ast.expr.ExprNode;
import dev.conless.comet.utils.container.Position;
import dev.conless.comet.utils.metadata.FlowInfo;
import dev.conless.comet.utils.scope.BaseScope;

public class ForStmtNode extends StmtNode implements ScopedNode {
  public BaseScope scope;
  public StmtNode init;
  public ExprNode condition;
  public ExprStmtNode update;
  public StmtNode body;

  public ForStmtNode(Position position, StmtNode init, ExprNode condition, ExprStmtNode update, StmtNode body) {
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
    str += condition.toString() + "; ";
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

  @Override
  public void addScope(BaseScope scope) {
    if (this.scope == null) {
      this.scope = new BaseScope(scope, new FlowInfo("for"));
    }
  }

  @Override
  public BaseScope getScope() {
    return scope;
  }
}
