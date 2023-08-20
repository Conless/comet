package dev.conless.comet.utils.container;

import org.antlr.v4.runtime.Token;

@lombok.Value
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

  public String toString() {
    return "(" + row + "," + column + ")";
  }
}
