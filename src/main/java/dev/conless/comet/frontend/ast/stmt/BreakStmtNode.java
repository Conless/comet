package dev.conless.comet.frontend.ast.stmt;

import dev.conless.comet.frontend.ast.ASTVisitor;
import dev.conless.comet.utils.error.BaseError;

import lombok.experimental.SuperBuilder;
import lombok.Value;
import lombok.EqualsAndHashCode;

/**
 * The `BreakStmtNode` class represents a break statement in a Java program and extends the `StmtNode`
 * class.
 */
@SuperBuilder
@Value
@EqualsAndHashCode(callSuper = true)
public final class BreakStmtNode extends StmtNode {
  @Override
  public String toString() {
    return super.toString() + "break;";
  }

  @Override
  public void accept(ASTVisitor visitor) throws BaseError {
    visitor.visit(this);
  }
}
