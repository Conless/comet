package dev.conless.comet.frontend.ast.def;

import dev.conless.comet.frontend.ast.*;
import dev.conless.comet.utils.*;

public class VarDefNode extends ASTNode {
  public String name;
  public TypeNameNode type;
  public VarCtorNode ctor;

  public VarDefNode(Position position) {
    super(position);
  }

  @Override
  public String toString() {
    return type.toString() + " " + name + " " + ctor.toString() + ";";
  }
}
