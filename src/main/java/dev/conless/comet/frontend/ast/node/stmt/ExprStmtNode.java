package dev.conless.comet.frontend.ast.node.stmt;

import dev.conless.comet.frontend.ast.ASTVisitor;
import dev.conless.comet.frontend.ast.node.expr.ExprNode;
import dev.conless.comet.utils.error.BaseError;
import dev.conless.comet.utils.container.Array;

import lombok.experimental.SuperBuilder;
import lombok.Value;
import lombok.EqualsAndHashCode;

/**
 * The `ExprStmtNode` class represents a statement node in an abstract syntax tree (AST) that contains
 * an array of expression nodes.
 */
@SuperBuilder
@Value
@EqualsAndHashCode(callSuper = true)
public final class ExprStmtNode extends StmtNode {
  private Array<ExprNode> exprs;

  @Override
  public String toString() {
    return super.toString() + exprs.toString(", ") + ";";
  }

  @Override
  public <T> T accept(ASTVisitor<T> visitor) throws BaseError {
    return visitor.visit(this);
  }
}
