package dev.conless.comet.frontend.ast.node.stmt;

import dev.conless.comet.frontend.ast.ASTVisitor;
import dev.conless.comet.frontend.ast.node.expr.ExprNode;
import dev.conless.comet.frontend.ast.node.global.HasExprNode;
import dev.conless.comet.frontend.ast.node.global.ScopedNode;
import dev.conless.comet.frontend.utils.metadata.FlowInfo;
import dev.conless.comet.frontend.utils.scope.BaseScope;
import dev.conless.comet.utils.error.BaseError;
import dev.conless.comet.utils.error.RuntimeError;
import lombok.experimental.SuperBuilder;
import lombok.Getter;
import lombok.EqualsAndHashCode;

/**
 * The `WhileStmtNode` class represents a while loop statement in a Java program and includes fields
 * for the loop condition and body, as well as methods for generating a string representation of the
 * node and accepting an AST visitor.
 */
@SuperBuilder
@Getter
@EqualsAndHashCode(callSuper = true)
public final class WhileStmtNode extends StmtNode implements ScopedNode, HasExprNode {
  private BaseScope scope;
  private ExprNode condition;
  private final StmtNode body;

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
  public <T> T accept(ASTVisitor<T> visitor) throws BaseError {
    return visitor.visit(this);
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

  @Override
  public void replaceExpr(ExprNode expr, ExprNode replacement) {
    if (condition == expr) {
      condition = replacement;
    } else {
      throw new RuntimeError("Cannot replace expression that does not exist in this node");
    }
  }
}
