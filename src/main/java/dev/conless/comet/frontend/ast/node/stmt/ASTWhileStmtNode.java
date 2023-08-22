package dev.conless.comet.frontend.ast.node.stmt;

import dev.conless.comet.frontend.ast.ASTVisitor;
import dev.conless.comet.frontend.ast.node.expr.ASTExprNode;
import dev.conless.comet.frontend.ast.node.utils.ASTNodeWithExpr;
import dev.conless.comet.frontend.ast.node.utils.ASTNodeWithScope;
import dev.conless.comet.frontend.utils.metadata.FlowInfo;
import dev.conless.comet.frontend.utils.scope.BaseScope;
import dev.conless.comet.frontend.utils.scope.LoopScope;
import dev.conless.comet.utils.error.BaseError;
import dev.conless.comet.utils.error.RuntimeError;

/**
 * The `WhileStmtNode` class represents a while loop statement in a Java program and includes fields
 * for the loop condition and body, as well as methods for generating a string representation of the
 * node and accepting an AST visitor.
 */
@lombok.experimental.SuperBuilder
@lombok.Getter
@lombok.EqualsAndHashCode(callSuper = true)
public final class ASTWhileStmtNode extends ASTStmtNode implements ASTNodeWithScope, ASTNodeWithExpr {
  private LoopScope scope;
  private ASTExprNode condition;
  private final ASTStmtNode body;

  @Override
  public String toString() {
    String str = "while (" + condition.toString() + ")";
    if (body instanceof ASTBlockStmtNode) {
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
      this.scope = new LoopScope(scope, new FlowInfo("while"));
    }
  }

  @Override
  public LoopScope getScope() {
    return scope;
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
