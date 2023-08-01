package dev.conless.comet.frontend.ast.expr;

import dev.conless.comet.frontend.ast.ASTNode;
import dev.conless.comet.utils.container.Position;

public abstract class ExprNode extends ASTNode {
  public ExprNode(Position position) {
    super(position);
  }
}
