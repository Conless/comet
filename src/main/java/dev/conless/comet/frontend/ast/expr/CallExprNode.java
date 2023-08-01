package dev.conless.comet.frontend.ast.expr;

import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.container.Position;

public class CallExprNode extends ExprNode {
  public ExprNode func;
  public Array<ExprNode> args;

  public CallExprNode(Position position, ExprNode func) {
    super(position);
    this.func = func;
    this.args = new Array<ExprNode>();
  }

  public void addArg(ExprNode arg) {
    args.add(arg);
  }

  @Override public String toString() {
    return func + "(" + args.toString(", ") + ")";
  }
}
