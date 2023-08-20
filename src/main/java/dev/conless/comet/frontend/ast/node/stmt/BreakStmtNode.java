package dev.conless.comet.frontend.ast.node.stmt;

import dev.conless.comet.frontend.ast.ASTVisitor;
import dev.conless.comet.utils.error.BaseError;

/**
 * The `BreakStmtNode` class represents a break statement in a Java program and extends the `StmtNode`
 * class.
 */
@lombok.experimental.SuperBuilder
@lombok.Value
@lombok.EqualsAndHashCode(callSuper = true)
public final class BreakStmtNode extends StmtNode {
  @Override
  public String toString() {
    return super.toString() + "break;";
  }

  @Override
  public <T> T accept(ASTVisitor<T> visitor) throws BaseError {
    return visitor.visit(this);
  }
}
