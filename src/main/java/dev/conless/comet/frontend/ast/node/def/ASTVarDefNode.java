package dev.conless.comet.frontend.ast.node.def;

import dev.conless.comet.frontend.ast.ASTVisitor;
import dev.conless.comet.frontend.ast.node.expr.ASTExprNode;
import dev.conless.comet.frontend.ast.node.utils.ASTNodeWithExpr;
import dev.conless.comet.frontend.utils.metadata.TypeInfo;
import dev.conless.comet.frontend.utils.metadata.VarInfo;
import dev.conless.comet.utils.error.*;

/**
 * The VarDefNode class represents a variable definition node in an abstract syntax tree (AST) and
 * includes an initializer expression.
 */
@lombok.experimental.SuperBuilder
@lombok.Getter
@lombok.Setter
public final class ASTVarDefNode extends ASTDefNode implements ASTNodeWithExpr {
  private ASTExprNode init;

  @Override
  public String toString() {
    return getInfo().toString() + (init != null ? " = " + init.toString() : "") + ";";
  }

  public TypeInfo getType() {
    return ((VarInfo) getInfo()).getType();
  }

  @Override
  public void replaceExpr(ASTExprNode expr, ASTExprNode replacement) {
    if (init == expr) {
      init = replacement;
    } else {
      throw new RuntimeError("Cannot replace expression that does not exist in this node");
    }
  }

  @Override
  public <T> T accept(ASTVisitor<T> visitor) throws BaseError {
    return visitor.visit(this);
  }
}
