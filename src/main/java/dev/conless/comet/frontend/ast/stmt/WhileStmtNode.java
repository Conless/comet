package dev.conless.comet.frontend.ast.stmt;

import dev.conless.comet.frontend.ast.ASTVisitor;
import dev.conless.comet.frontend.ast.ScopedNode;
import dev.conless.comet.frontend.ast.expr.ExprNode;
import dev.conless.comet.utils.container.Position;
import dev.conless.comet.utils.metadata.FlowInfo;
import dev.conless.comet.utils.scope.BaseScope;

public class WhileStmtNode extends StmtNode implements ScopedNode {
  public BaseScope scope;
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

  @Override
  public void accept(ASTVisitor visitor) throws Exception {
    visitor.visit(this);
  }

  @Override
  public void addScope(BaseScope scope) {
    if (this.scope == null) {
      this.scope = new BaseScope(scope, new FlowInfo("while"));
    }
  }

  @Override
  public BaseScope getScope() {
    return scope;
  }
}
