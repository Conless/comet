package dev.conless.comet.utils.error;

import dev.conless.comet.utils.Position;

abstract public class Error extends RuntimeException {
  private Position pos;
  private String message;

  public Error(String msg, Position pos) {
    this.pos = pos;
    this.message = msg;
  }

  public String toString() {
    return message + ": " + pos.toString();
  }
}
