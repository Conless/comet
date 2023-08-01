package dev.conless.comet.frontend.ast.type;

import dev.conless.comet.frontend.ast.ASTNode;
import dev.conless.comet.utils.container.Position;

public class TypeNode extends ASTNode {
  public Type type;
  public String typeName;
  public Boolean isBuiltIn;

  public TypeNode(Position position, String typeName) {
    super(position);
    this.typeName = typeName;
    this.isBuiltIn = true;
    if (typeName == "int") {
      this.type = Type.INT;
    } else if (typeName == "bool") {
      this.type = Type.BOOL;
    } else if (typeName == "string") {
      this.type = Type.STRING;
    } else if (typeName == "void") {
      this.type = Type.VOID;
    } else {
      this.type = Type.CUSTOM;
      this.isBuiltIn = false;
    }
  }

  @Override
  public String toString() {
    return typeName;
  }
}
