package dev.conless.comet.frontend.ast;

import dev.conless.comet.utils.container.Position;

public abstract class ASTNode {
  public Position position;

  public ASTNode(Position position) {
    this.position = position;
  }

  public void accept(ASTVisitor visitor) throws Exception {
    visitor.visit(this);
  }

  public abstract String toString();
}
