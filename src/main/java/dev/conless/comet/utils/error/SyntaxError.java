package dev.conless.comet.utils.error;

import dev.conless.comet.utils.container.Position;

public class SyntaxError extends BaseError {
  public SyntaxError(String msg, Position pos) {
    super("Syntax Error: " + msg, pos);
  }
}
