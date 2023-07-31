package dev.conless.comet.frontend.ast.expr;

import dev.conless.comet.utils.Position;

public class MemberExprNode extends ExprNode {
  ExprNode object;
  String member;

  public MemberExprNode(Position position) {
    super(position);
  }

  @Override
  public String toString() {
    return object.toString() + "." + member;
  }
}
