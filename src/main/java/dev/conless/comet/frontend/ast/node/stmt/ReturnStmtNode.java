package dev.conless.comet.frontend.ast.node.stmt;

import dev.conless.comet.frontend.ast.ASTVisitor;
import dev.conless.comet.frontend.ast.node.expr.ExprNode;
import dev.conless.comet.utils.error.BaseError;

import lombok.experimental.SuperBuilder;
import lombok.Value;
import lombok.EqualsAndHashCode;

/**
 * The `ReturnStmtNode` class represents a return statement in a Java program and extends the
 * `StmtNode` class.
 */
@SuperBuilder
@Value
@EqualsAndHashCode(callSuper = true)
public final class ReturnStmtNode extends StmtNode {
  private ExprNode expr;

  @Override
  public String toString() {
    return super.toString() + "return" + (expr != null ? " " + expr.toString() : "") + ";";
  }

  @Override
  public <T> T accept(ASTVisitor<T> visitor) throws BaseError {
    return visitor.visit(this);
  }
}
