package dev.conless.comet.frontend.ast.expr;

import java.util.ArrayList;

import dev.conless.comet.utils.Position;

public class CallExprNode extends ExprNode {
  public ExprNode func;
  public ArrayList<ExprNode> args;

  public CallExprNode(Position position, ExprNode func) {
    super(position);
    this.func = func;
    this.args = new ArrayList<ExprNode>();
  }

  public void addArg(ExprNode arg) {
    args.add(arg);
  }

  @Override public String toString() {
    return func + "(" + args.toString() + ")";
  }
}
