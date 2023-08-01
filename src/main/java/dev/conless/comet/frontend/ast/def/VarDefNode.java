package dev.conless.comet.frontend.ast.def;

import dev.conless.comet.frontend.ast.ASTNode;
import dev.conless.comet.frontend.ast.expr.ExprNode;
import dev.conless.comet.frontend.ast.type.TypeNameNode;
import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.container.Pair;
import dev.conless.comet.utils.container.Position;

public class VarDefNode extends ASTNode {
  public TypeNameNode type;
  public Array<Pair<String, ExprNode>> vars;

  public VarDefNode(Position position, TypeNameNode type) {
    super(position);
    this.type = type;
    this.vars = new Array<Pair<String, ExprNode>>();
  }

  public VarDefNode(Position position, TypeNameNode type, String name, ExprNode init) {
    super(position);
    this.type = type;
    vars = new Array<Pair<String, ExprNode>>();
    vars.add(new Pair<String, ExprNode>(name, init));
  }

  public void addVar(String name, ExprNode value) {
    vars.add(new Pair<String, ExprNode>(name, value));
  }

  @Override
  public String toString() {
    String str = type.toString() + " ";
    boolean first = true;
    for (var variable : vars) {
      if (first) {
        first = false;
      } else {
        str += ", ";
      }
      str += variable.a + (variable.b != null ? (" = " + variable.b.toString()) : "");
    }
    return str;
  }
}
