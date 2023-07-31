package dev.conless.comet.frontend.ast.expr;

import dev.conless.comet.frontend.ast.type.TypeNode;
import dev.conless.comet.utils.Position;
import dev.conless.comet.utils.Array;

public class NewExprNode extends ExprNode {
  public TypeNode type;
  public Integer arrayDepth;
  public Array<ExprNode> lengths;

  public NewExprNode(Position position, TypeNode type, Integer arrayDepth) {
    super(position);
    this.type = type;
    lengths = new Array<ExprNode>();
  }

  public void addLength(ExprNode length) {
    lengths.add(length);
  }

  @Override
  public String toString() {
    return "new " + type.toString() + "(" + lengths.toString(", ") + ")";
  }
}
