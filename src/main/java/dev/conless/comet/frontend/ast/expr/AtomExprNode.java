package dev.conless.comet.frontend.ast.expr;

import dev.conless.comet.frontend.ast.type.Type;
import dev.conless.comet.utils.container.Position;

public class AtomExprNode extends ExprNode {
  public Type type;
  public String value;

  public AtomExprNode(Position position, Type type, String value) {
    super(position);
    this.type = type;
    this.value = value;
  }

  @Override
  public String toString() {
    return value;
  }
}
