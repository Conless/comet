package dev.conless.comet.frontend.ast.expr;

import java.util.ArrayList;

import dev.conless.comet.utils.Position;

public class CallExprNode extends ExprNode {
  public ExprNode func;
  public ArrayList<ExprNode> args;

  public CallExprNode(Position position) {
    super(position);
  }

  @Override public String toString() {
    return func + "(" + args.toString() + ")";
  }
}
