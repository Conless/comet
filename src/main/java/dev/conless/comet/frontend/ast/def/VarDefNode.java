package dev.conless.comet.frontend.ast.def;

import dev.conless.comet.frontend.ast.ASTNode;
import dev.conless.comet.frontend.ast.TypeNameNode;
import dev.conless.comet.frontend.ast.expr.ExprNode;
import dev.conless.comet.utils.Position;

public class VarDefNode extends ASTNode {
  public String name;
  public TypeNameNode type;
  public ExprNode constructor;

  public VarDefNode(Position position) {
    super(position);
  }

  @Override
  public String toString() {
    String str = type.toString() + " " + name;
    if (constructor != null) {
      str += " = " + constructor.toString();
    }
    return str;
  }
}
