package dev.conless.comet.frontend.ast.node.stmt;

import dev.conless.comet.frontend.ast.ASTVisitor;
import dev.conless.comet.frontend.ast.node.expr.ASTExprNode;
import dev.conless.comet.frontend.ast.node.utils.ASTNodeWithExpr;
import dev.conless.comet.frontend.ast.node.utils.ASTNodeWithScope;
import dev.conless.comet.frontend.utils.metadata.FlowInfo;
import dev.conless.comet.frontend.utils.scope.BaseScope;
import dev.conless.comet.utils.error.BaseError;
import dev.conless.comet.utils.error.RuntimeError;

/**
 * The `IfStmtNode` class represents an if statement in a programming language and includes fields for
 * the condition, then statement, else statement, and scopes.
 */
@lombok.experimental.SuperBuilder
@lombok.Getter
@lombok.EqualsAndHashCode(callSuper = true)
public final class ASTIfStmtNode extends ASTStmtNode implements ASTNodeWithScope, ASTNodeWithExpr {
  private BaseScope thenScope, elseScope;
  private ASTExprNode condition;
  private final ASTStmtNode thenStmt, elseStmt;

  @Override
  public String toString() {
    String str = "if (" + condition.toString() + ")";
    if (thenStmt instanceof ASTBlockStmtNode) {
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
      if (elseStmt instanceof ASTBlockStmtNode) {
        str += " " + elseStmt.toString();
      } else if (elseStmt instanceof ASTIfStmtNode) {
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
  public <T> T accept(ASTVisitor<T> visitor) throws BaseError {
    return visitor.visit(this);
  }

  @Override
  public BaseScope getScope() {
    throw new RuntimeError("getScope() is not implemented for ifStmt", getPosition());
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

  @Override
  public void replaceExpr(ASTExprNode expr, ASTExprNode replacement) {
    if (condition == expr) {
      condition = replacement;
    } else {
      throw new RuntimeError("Cannot replace expression that does not exist in this node");
    }
  }
}
