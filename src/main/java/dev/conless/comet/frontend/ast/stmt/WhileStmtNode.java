package dev.conless.comet.frontend.ast.stmt;

import dev.conless.comet.frontend.ast.ASTVisitor;
import dev.conless.comet.frontend.ast.ScopedNode;
import dev.conless.comet.frontend.ast.expr.ExprNode;
import dev.conless.comet.utils.error.BaseError;
import dev.conless.comet.utils.metadata.FlowInfo;
import dev.conless.comet.utils.scope.BaseScope;

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
public final class WhileStmtNode extends StmtNode implements ScopedNode {
  private BaseScope scope;
  private final ExprNode condition;
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
  public void accept(ASTVisitor visitor) throws BaseError {
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
