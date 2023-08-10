package dev.conless.comet.frontend.ast.node.expr;

import dev.conless.comet.frontend.ast.ASTVisitor;
import dev.conless.comet.utils.error.BaseError;
import lombok.experimental.SuperBuilder;
import lombok.Value;
import lombok.EqualsAndHashCode;

/**
 * The AtomExprNode class represents an atomic expression node in an abstract syntax tree (AST) and
 * contains information about the atom type and value.
 */
@SuperBuilder
@Value
@EqualsAndHashCode(callSuper = true)
public final class AtomExprNode extends ExprNode {
  public static enum Type {
    INT, BOOL, STRING, VOID, NULL, CUSTOM, THIS
  }

  private Type atomType;
  private String value;

  @Override
  public String toString() {
    return value;
  }

  @Override
  public <T> T accept(ASTVisitor<T> visitor) throws BaseError {
    return visitor.visit(this);
  }
}
