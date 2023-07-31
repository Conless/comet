package dev.conless.comet.frontend.ast.expr;

import dev.conless.comet.utils.Position;

public class UnaryArithExprNode extends ExprNode {
  ExprNode expr;
  String op;

  public UnaryArithExprNode(Position position) {
    super(position);
  }

  @Override
  public String toString() {
    String str = expr.toString();
    if (op == "++" || op == "--") {
      str = str + op;
    } else {
      str = op + str;
    }
    return str;
  }
}
