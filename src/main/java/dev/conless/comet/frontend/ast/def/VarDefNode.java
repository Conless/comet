package dev.conless.comet.frontend.ast.def;

import dev.conless.comet.frontend.ast.ASTVisitor;
import dev.conless.comet.frontend.ast.expr.ExprNode;
import dev.conless.comet.utils.error.BaseError;
import dev.conless.comet.utils.metadata.TypeInfo;
import dev.conless.comet.utils.metadata.VarInfo;
import lombok.experimental.SuperBuilder;
import lombok.Getter;
import lombok.Setter;

/**
 * The VarDefNode class represents a variable definition node in an abstract syntax tree (AST) and
 * includes an initializer expression.
 */
@SuperBuilder
@Getter
@Setter
public final class VarDefNode extends BaseDefNode {
  private final ExprNode init;

  @Override
  public String toString() {
    return getInfo().toString() + (init != null ? " = " + init.toString() : "");
  }

  public TypeInfo getType() {
    return ((VarInfo) getInfo()).getType();
  }

  @Override
  public void accept(ASTVisitor visitor) throws BaseError {
    visitor.visit(this);
  }
}
