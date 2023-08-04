package dev.conless.comet.frontend.ast.stmt;

import dev.conless.comet.frontend.ast.ASTVisitor;
import dev.conless.comet.frontend.ast.ScopedNode;
import dev.conless.comet.frontend.ast.expr.ExprNode;
import dev.conless.comet.utils.container.Position;
import dev.conless.comet.utils.metadata.FlowInfo;
import dev.conless.comet.utils.scope.BaseScope;

public class IfStmtNode extends StmtNode implements ScopedNode {
  public BaseScope thenScope, elseScope;
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
      if (elseStmt instanceof BlockStmtNode) {
        str += " " + elseStmt.toString();
      } else if (elseStmt instanceof IfStmtNode) {
        String elseStr = elseStmt.toString();
        str += " " + elseStr.substring(indentDepth * 2);
      } else {
        indentDepth++;
        str += "\n" + elseStmt.toString();
        indentDepth--;
      }
    }
    return super.toString() + str;
  }

  @Override
  public void accept(ASTVisitor visitor) throws Exception {
    visitor.visit(this);
  }

  @Override
  public BaseScope getScope() {
    throw new RuntimeException("Not implemented");
  }

  public BaseScope getScope(String str) {
    if (str.equals("then")) {
      return thenScope;
    } else {
      return elseScope;
    }
  }

  @Override
  public void addScope(BaseScope scope) {
    if (this.thenScope == null) {
      this.thenScope = new BaseScope(scope, new FlowInfo("then"));
      this.elseScope = new BaseScope(scope, new FlowInfo("else"));
    }
  }
}
