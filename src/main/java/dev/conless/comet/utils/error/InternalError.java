package dev.conless.comet.utils.error;

import dev.conless.comet.utils.Position;

public class InternalError extends Error {
  public InternalError(String msg, Position pos) {
    super("Internal Error:" + msg, pos);
  }
}
