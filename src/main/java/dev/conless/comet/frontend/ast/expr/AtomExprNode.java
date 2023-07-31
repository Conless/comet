package dev.conless.comet.frontend.ast.expr;

import dev.conless.comet.utils.Position;

enum Type {
  Int, Str, Bool, Null, Identifier, This
};

public class AtomExprNode extends ExprNode {
  public Type type;
  public String value;

  public AtomExprNode(Position position) {
    super(position);
  }

  @Override
  public String toString() {
    return value;
  }
}
