package dev.conless.comet.frontend.ast.node.stmt;

import dev.conless.comet.frontend.ast.ASTVisitor;
import dev.conless.comet.utils.error.BaseError;

/**
 * The `ContinueStmtNode` class represents a continue statement in an abstract syntax tree (AST) and
 * provides methods for generating its string representation and accepting an AST visitor.
 */
@lombok.experimental.SuperBuilder
@lombok.Value
@lombok.EqualsAndHashCode(callSuper = true)
public final class ContinueStmtNode extends StmtNode {
  @Override
  public String toString() {
    return super.toString() + "continue;";
  }

  @Override
  public <T> T accept(ASTVisitor<T> visitor) throws BaseError {
    return visitor.visit(this);
  }
}
