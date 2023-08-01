package dev.conless.comet.utils.error;

import dev.conless.comet.utils.container.Position;

public class InternalError extends BaseError {
  public InternalError(String msg, Position pos) {
    super("Internal Error:" + msg, pos);
  }
}
