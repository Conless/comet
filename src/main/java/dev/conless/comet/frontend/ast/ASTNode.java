package dev.conless.comet.frontend.ast;

import dev.conless.comet.utils.Position;

public abstract class ASTNode {
  Position position;

  public ASTNode(Position position) {
    this.position = position;
  }

  public abstract String toString();
}
