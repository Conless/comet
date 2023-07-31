package dev.conless.comet.frontend.ast.type;

import dev.conless.comet.frontend.ast.ASTNode;
import dev.conless.comet.utils.Position;

public class TypeNameNode extends ASTNode {
  public TypeNode type;
  public Integer arrayDepth;

  public TypeNameNode(Position position, TypeNode type, Integer arrayDepth) {
    super(position);
    this.type = type;
    this.arrayDepth = arrayDepth;
  }

  @Override
  public String toString() {
    String str = type.toString();
    for (int i = 1; i <= arrayDepth; i++) {
      str += "[]";
    }
    return str;
  }
}
