package dev.conless.comet.frontend.ast.expr;

import dev.conless.comet.frontend.ast.type.TypeNode;
import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.container.Position;

public class NewExprNode extends ExprNode {
  public TypeNode type;
  public Integer arrayDepth;
  public Array<ExprNode> lengths;

  public NewExprNode(Position position, TypeNode type, Integer arrayDepth) {
    super(position);
    this.type = type;
    this.arrayDepth = arrayDepth;
    lengths = new Array<ExprNode>();
  }

  public void addLength(ExprNode length) {
    lengths.add(length);
  }

  @Override
  public String toString() {
    String str = "new " + type.toString();
    for (int i = 0; i < arrayDepth; i++) {
      str += "[" + (i < lengths.size() ? lengths.get(i).toString() : "") + "]";
    }
    return str;
  }
}
