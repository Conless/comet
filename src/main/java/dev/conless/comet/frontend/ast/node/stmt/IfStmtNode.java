package dev.conless.comet.frontend.ast.node.stmt;

import dev.conless.comet.frontend.ast.ASTVisitor;
import dev.conless.comet.frontend.ast.node.ScopedNode;
import dev.conless.comet.frontend.ast.node.expr.ExprNode;
import dev.conless.comet.frontend.utils.metadata.FlowInfo;
import dev.conless.comet.frontend.utils.scope.BaseScope;
import dev.conless.comet.utils.error.BaseError;
import lombok.experimental.SuperBuilder;
import lombok.Getter;
import lombok.EqualsAndHashCode;

/**
 * The `IfStmtNode` class represents an if statement in a programming language and includes fields for
 * the condition, then statement, else statement, and scopes.
 */
@SuperBuilder
@Getter
@EqualsAndHashCode(callSuper = true)
public final class IfStmtNode extends StmtNode implements ScopedNode {
  private BaseScope thenScope, elseScope;
  private final ExprNode condition;
  private final StmtNode thenStmt, elseStmt;

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
  public void accept(ASTVisitor visitor) throws BaseError {
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
