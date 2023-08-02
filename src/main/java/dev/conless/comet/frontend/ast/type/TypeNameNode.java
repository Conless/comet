package dev.conless.comet.frontend.ast.type;

import dev.conless.comet.frontend.ast.ASTNode;
import dev.conless.comet.frontend.ast.ASTVisitor;
import dev.conless.comet.utils.container.Position;
import dev.conless.comet.utils.metadata.TypeInfo;

public class TypeNameNode extends ASTNode {
  public TypeInfo type;

  public TypeNameNode(Position position, String typeName, Integer arrayDepth) {
    super(position);
    this.type = new TypeInfo(typeName, arrayDepth);
  }

  @Override
  public String toString() {
    String str = type.name;
    for (int i = 1; i <= type.depth; i++) {
      str += "[]";
    }
    return str;
  }

  @Override
  public void accept(ASTVisitor visitor) throws Exception {
    visitor.visit(this);
  }
}
