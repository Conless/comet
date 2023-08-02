package dev.conless.comet.frontend.ast.expr;

import dev.conless.comet.frontend.ast.ASTVisitor;
import dev.conless.comet.utils.container.Position;

public class MemberExprNode extends ExprNode {
  public ExprNode object;
  public String member;

  public MemberExprNode(Position position, ExprNode object, String member) {
    super(position);
    this.object = object;
    this.member = member;
  }

  @Override
  public String toString() {
    return object.toString() + "." + member;
  }

  @Override
  public void accept(ASTVisitor visitor) throws Exception {
    visitor.visit(this);
  }
}
