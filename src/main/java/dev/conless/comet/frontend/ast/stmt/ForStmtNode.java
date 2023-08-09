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
 * The `ForStmtNode` class represents a for loop statement in a programming language and includes
 * fields for the loop initialization, condition, update, and body.
 */
@SuperBuilder
@Getter
@EqualsAndHashCode(callSuper = true)
public final class ForStmtNode extends StmtNode implements ScopedNode {
  private BaseScope scope;
  private final StmtNode init;
  private final ExprNode condition;
  private final ExprNode update;
  private final StmtNode body;

  @Override
  public String toString() {
    String str = "for (";
    if (init != null) {
      str += init.toString().substring(indentDepth * 2);
    }
    str += ' ';
    if (condition != null) {
      str += condition.toString();
    }
    str += ';';
    if (update != null) {
      str += update.toString();
    }
    str += ')';
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
  public void accept(ASTVisitor visitor) throws BaseError {
    visitor.visit(this);
  }

  @Override
  public void addScope(BaseScope scope) {
    if (this.scope == null) {
      this.scope = new BaseScope(scope, new FlowInfo("for"));
    }
  }
}
