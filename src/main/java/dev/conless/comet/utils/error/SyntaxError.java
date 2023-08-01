package dev.conless.comet.utils.error;

import dev.conless.comet.utils.container.Position;

public class SyntaxError extends Error {
  public SyntaxError(String msg, Position pos) {
    super("Syntax Error: " + msg, pos);
  }
}
