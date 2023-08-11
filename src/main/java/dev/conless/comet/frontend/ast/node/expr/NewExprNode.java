package dev.conless.comet.frontend.ast.node.expr;

import dev.conless.comet.frontend.ast.ASTVisitor;
import dev.conless.comet.frontend.utils.metadata.TypeInfo;
import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.error.BaseError;

import lombok.experimental.SuperBuilder;
import lombok.Value;
import lombok.EqualsAndHashCode;

/**
 * The `NewExprNode` class represents a new expression node in an abstract syntax tree (AST) and
 * includes information about the lengths of the array being created.
 */
@SuperBuilder
@Value
@EqualsAndHashCode(callSuper = true)
public final class NewExprNode extends ExprNode {
  private Array<ExprNode> lengths;
  private TypeInfo type;

  @Override
  public String toString() {
    String str = "new " + type.getName();
    for (int i = 0; i < type.depth; i++) {
      str += "[" + (i < lengths.size() ? lengths.get(i).toString() : "") + "]";
    }
    return str;
  }

  @Override
  public <T> T accept(ASTVisitor<T> visitor) throws BaseError {
    return visitor.visit(this);
  }
}