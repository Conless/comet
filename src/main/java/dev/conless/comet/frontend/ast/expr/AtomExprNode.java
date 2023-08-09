package dev.conless.comet.frontend.ast.expr;

import dev.conless.comet.frontend.ast.ASTVisitor;
import dev.conless.comet.utils.error.BaseError;
import dev.conless.comet.utils.AtomType;

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
  private AtomType atomType;
  private String value;

  @Override
  public String toString() {
    return value;
  }

  @Override
  public void accept(ASTVisitor visitor) throws BaseError {
    visitor.visit(this);
  }
}
