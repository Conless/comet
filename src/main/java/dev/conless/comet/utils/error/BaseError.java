package dev.conless.comet.utils.error;

import dev.conless.comet.utils.container.Position;

abstract public class BaseError extends RuntimeException {
  private Position pos;
  private String message;

  public BaseError(String msg) {
    this.message = msg;
    this.pos = null;
  }

  public BaseError(String msg, Position pos) {
    this.pos = pos;
    this.message = msg;
  }

  public String toString() {
    return message + (pos == null ? "" : " at " + pos.toString());
  }
}
