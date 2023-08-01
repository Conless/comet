package dev.conless.comet.frontend.ast.type;

import dev.conless.comet.frontend.ast.ASTNode;
import dev.conless.comet.utils.Type;
import dev.conless.comet.utils.container.Position;
import dev.conless.comet.utils.metadata.TypeInfo;

public class TypeNameNode extends ASTNode {
  public TypeInfo type;

  public TypeNameNode(Position position, String typeName, Integer arrayDepth) {
    super(position);
    this.type = new TypeInfo(typeName);
    this.type.depth = arrayDepth;
    this.type.isBuiltIn = true;
    if (typeName == "int") {
      this.type.type = Type.INT;
    } else if (typeName == "bool") {
      this.type.type = Type.BOOL;
    } else if (typeName == "string") {
      this.type.type = Type.STRING;
    } else if (typeName == "void") {
      this.type.type = Type.VOID;
    } else {
      this.type.type = Type.CUSTOM;
      this.type.isBuiltIn = false;
    }
  }

  @Override
  public String toString() {
    String str = type.name;
    for (int i = 1; i <= type.depth; i++) {
      str += "[]";
    }
    return str;
  }
}
