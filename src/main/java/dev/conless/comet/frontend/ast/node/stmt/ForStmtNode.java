package dev.conless.comet.frontend.ast.node.stmt;

import dev.conless.comet.frontend.ast.ASTVisitor;
import dev.conless.comet.frontend.ast.node.expr.ExprNode;
import dev.conless.comet.frontend.ast.node.global.NodeWithExpr;
import dev.conless.comet.frontend.ast.node.global.NodeWithScope;
import dev.conless.comet.frontend.utils.metadata.FlowInfo;
import dev.conless.comet.frontend.utils.scope.BaseScope;
import dev.conless.comet.frontend.utils.scope.LoopScope;
import dev.conless.comet.utils.error.*;
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
public final class ForStmtNode extends StmtNode implements NodeWithScope, NodeWithExpr {
  private LoopScope scope;
  private final StmtNode init;
  private ExprNode condition;
  private ExprNode update;
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
  public <T> T accept(ASTVisitor<T> visitor) throws BaseError {
    return visitor.visit(this);
  }

  @Override
  public void addScope(BaseScope scope) {
    if (this.scope == null) {
      this.scope = new LoopScope(scope, new FlowInfo("for"));
    }
  }

  @Override
  public void replaceExpr(ExprNode expr, ExprNode replacement) {
    if (condition == expr) {
      condition = replacement;
    } else if (update == expr) {
      update = replacement;
    } else {
      throw new RuntimeError("Cannot replace expression that does not exist in this node");
    }
  }
}
