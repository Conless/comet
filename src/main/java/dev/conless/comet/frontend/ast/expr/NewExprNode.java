package dev.conless.comet.frontend.ast.expr;

import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.container.Position;
import dev.conless.comet.utils.metadata.TypeInfo;

public class NewExprNode extends ExprNode {
  public TypeInfo type;
  public Array<ExprNode> lengths;

  public NewExprNode(Position position, String typeName, Integer arrayDepth) {
    super(position);
    this.type = new TypeInfo(typeName);
    this.type.depth = arrayDepth;
    lengths = new Array<ExprNode>();
  }

  public void addLength(ExprNode length) {
    lengths.add(length);
  }

  @Override
  public String toString() {
    String str = "new " + type.name;
    for (int i = 0; i < type.depth; i++) {
      str += "[" + (i < lengths.size() ? lengths.get(i).toString() : "") + "]";
    }
    return str;
  }
}
