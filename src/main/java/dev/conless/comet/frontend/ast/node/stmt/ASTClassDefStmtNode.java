package dev.conless.comet.frontend.ast.node.stmt;

import dev.conless.comet.frontend.ast.ASTVisitor;
import dev.conless.comet.frontend.ast.node.def.ASTClassDefNode;
import dev.conless.comet.utils.error.BaseError;

/**
 * The ClassDefStmtNode class represents a statement node that defines a class in an abstract syntax
 * tree.
 */
@lombok.experimental.SuperBuilder
@lombok.Value
@lombok.EqualsAndHashCode(callSuper = true)
public final class ASTClassDefStmtNode extends ASTStmtNode {
  private ASTClassDefNode def;

  @Override
  public String toString() {
    return super.toString() + def.toString() + ";";
  }

  @Override
  public <T> T accept(ASTVisitor<T> visitor) throws BaseError {
    return visitor.visit(this);
  }
}
