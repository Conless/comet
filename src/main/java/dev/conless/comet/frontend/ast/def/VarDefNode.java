package dev.conless.comet.frontend.ast.def;

import dev.conless.comet.frontend.ast.ASTVisitor;
import dev.conless.comet.frontend.ast.expr.ExprNode;
import dev.conless.comet.frontend.ast.type.TypeNameNode;
import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.container.Pair;
import dev.conless.comet.utils.container.Position;
import dev.conless.comet.utils.metadata.TypeInfo;

public class VarDefNode extends BaseDefNode {
  public Array<Pair<String, ExprNode>> vars;

  public VarDefNode(Position position, TypeNameNode type) {
    super(position, type.type);
    this.vars = new Array<Pair<String, ExprNode>>();
  }

  public VarDefNode(Position position, TypeNameNode type, String name, ExprNode init) {
    super(position, type.type);
    vars = new Array<Pair<String, ExprNode>>();
    vars.add(new Pair<String, ExprNode>(name, init));
  }

  public void addVar(String name, ExprNode value) {
    vars.add(new Pair<String, ExprNode>(name, value));
  }

  @Override
  public String getName() throws Exception {
    throw new Exception("VarDefNode has no name");
  }

  @Override
  public String toString() {
    String str = ((TypeInfo) info).toString() + " ";
    boolean first = true;
    for (var v : vars) {
      if (first) {
        first = false;
      } else {
        str += ", ";
      }
      str += v.a + (v.b != null ? (" = " + v.b.toString()) : "");
    }
    return str;
  }

  @Override
  public void accept(ASTVisitor visitor) throws Exception {
    visitor.visit(this);
  }
}
