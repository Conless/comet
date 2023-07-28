package dev.conless.comet.utils;

import org.antlr.v4.runtime.Token;

public class Position {
  private int row, column;

  public Position(int row, int column) {
    this.row = row;
    this.column = column;
  }
  
  public Position(Token token) {
    this.row = token.getLine();
    this.column = token.getCharPositionInLine();
  }

  public int row() {
    return row;
  }

  public int column() {
    return column;
  }

  public String toString() {
    return "(" + row + "," + column + ")";
  }
}
