package dev.conless.comet.utils.error;

import dev.conless.comet.utils.container.Position;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class CometErrorListener extends BaseErrorListener {
  @Override
  public void syntaxError(Recognizer<?, ?> recognizer,
      Object offendingSymbol,
      int line, int charPositionInLine,
      String msg,
      RecognitionException e) {

    throw new SyntaxError(msg, new Position(line, charPositionInLine));
  }
}