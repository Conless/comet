package dev.conless.comet.frontend.ast.node.stmt;

import dev.conless.comet.frontend.ast.ASTVisitor;
import dev.conless.comet.utils.error.BaseError;

import lombok.experimental.SuperBuilder;
import lombok.Value;
import lombok.EqualsAndHashCode;

/**
 * The class EmptyStmtNode extends StmtNode and represents an empty statement in Java code.
 */
@SuperBuilder
@Value
@EqualsAndHashCode(callSuper = true)
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
