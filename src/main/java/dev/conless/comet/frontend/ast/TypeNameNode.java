package dev.conless.comet.frontend.ast;

import dev.conless.comet.utils.Position;

public class TypeNameNode extends ASTNode {
  public String typeName;
  public boolean isBuiltIn;
  public int arrayDepth;

  public TypeNameNode(Position position) {
    super(position);
  }

  @Override
  public String toString() {
    String str = typeName;
    for (int i = 1; i <= arrayDepth; i++) {
      str += "[]";
    }
    return str;
  }
}
