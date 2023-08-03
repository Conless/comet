package dev.conless.comet.frontend.ast.expr;

import dev.conless.comet.frontend.ast.ASTVisitor;
import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.container.Position;
import dev.conless.comet.utils.metadata.TypeInfo;

public class NewExprNode extends ExprNode {
  public Array<ExprNode> lengths;

  public NewExprNode(Position position, String typeName, Integer arrayDepth) {
    super(position);
    this.info = new TypeInfo(typeName, arrayDepth);
    lengths = new Array<ExprNode>();
  }

  public void addLength(ExprNode length) {
    lengths.add(length);
  }

  public Array<ExprNode> getLengths() {
    return lengths;
  }

  @Override
  public String toString() {
    String str = "new " + info.name;
    for (int i = 0; i < ((TypeInfo) info).depth; i++) {
      str += "[" + (i < lengths.size() ? lengths.get(i).toString() : "") + "]";
    }
    return str;
  }

  @Override
  public void accept(ASTVisitor visitor) throws Exception {
    visitor.visit(this);
  }
}
