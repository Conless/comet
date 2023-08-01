package dev.conless.comet.utils.error;

import dev.conless.comet.utils.container.Position;

public class SemanticError extends BaseError {
  public SemanticError(String msg, Position pos) {
    super("Semantic Error: " + msg, pos);
  }
}
