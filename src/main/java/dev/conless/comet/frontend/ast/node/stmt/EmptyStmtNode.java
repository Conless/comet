package dev.conless.comet.frontend.ast.node.stmt;

import dev.conless.comet.frontend.ast.ASTVisitor;
import dev.conless.comet.utils.error.BaseError;

/**
 * The class EmptyStmtNode extends StmtNode and represents an empty statement in Java code.
 */
@lombok.experimental.SuperBuilder
@lombok.Value
@lombok.EqualsAndHashCode(callSuper = true)
public final class EmptyStmtNode extends StmtNode {
  @Override
  public String toString() {
    return super.toString() + ";";
  }

  @Override
  public <T> T accept(ASTVisitor<T> visitor) throws BaseError {
    return visitor.visit(this);
  }
}
