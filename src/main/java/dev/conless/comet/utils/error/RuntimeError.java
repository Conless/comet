package dev.conless.comet.utils.error;

import dev.conless.comet.utils.container.Position;

public class RuntimeError extends BaseError {
  public RuntimeError(String msg) {
    super("Runtime Error:" + msg);
  }
  public RuntimeError(String msg, Position pos) {
    super("Runtime Error:" + msg, pos);
  }
}
