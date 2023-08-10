package dev.conless.comet.frontend.ast.node.stmt;

import dev.conless.comet.frontend.ast.ASTVisitor;
import dev.conless.comet.frontend.ast.node.def.ClassDefNode;
import dev.conless.comet.utils.error.BaseError;
import lombok.experimental.SuperBuilder;
import lombok.Value;
import lombok.EqualsAndHashCode;

/**
 * The ClassDefStmtNode class represents a statement node that defines a class in an abstract syntax
 * tree.
 */
@SuperBuilder
@Value
@EqualsAndHashCode(callSuper = true)
public final class ClassDefStmtNode extends StmtNode {
  private ClassDefNode def;

  @Override
  public String toString() {
    return super.toString() + def.toString() + ";";
  }

  @Override
  public <T> T accept(ASTVisitor<T> visitor) throws BaseError {
    return visitor.visit(this);
  }
}
