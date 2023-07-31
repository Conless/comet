package dev.conless.comet.frontend.ast.def;

import java.util.ArrayList;

import org.antlr.v4.runtime.misc.Pair;

import dev.conless.comet.frontend.ast.ASTNode;
import dev.conless.comet.frontend.ast.expr.ExprNode;
import dev.conless.comet.frontend.ast.type.TypeNameNode;
import dev.conless.comet.utils.Position;

public class VarDefNode extends ASTNode {
  public TypeNameNode type;
  public ArrayList<Pair<String, ExprNode>> vars;

  public VarDefNode(Position position, TypeNameNode type) {
    super(position);
    this.type = type;
  }

  public VarDefNode(Position position, TypeNameNode type, String name, ExprNode init) {
    super(position);
    this.type = type;
    vars = new ArrayList<Pair<String, ExprNode>>();
    vars.add(new Pair<String, ExprNode>(name, init));
  }

  public void addVar(String name, ExprNode value) {
    vars.add(new Pair<String, ExprNode>(name, value));
  }

  @Override
  public String toString() {
    String str = type.toString() + " ";
    for (Pair<String, ExprNode> var : vars) {
      str += var.a + (var.b != null ? (" = " + var.b.toString()) : "") + ", ";
    }
    return str;
  }
}
