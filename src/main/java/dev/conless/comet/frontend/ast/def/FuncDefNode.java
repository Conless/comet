package dev.conless.comet.frontend.ast.def;

import dev.conless.comet.frontend.ast.ASTNode;
import dev.conless.comet.frontend.ast.stmt.BlockStmtNode;
import dev.conless.comet.frontend.ast.type.TypeNameNode;
import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.container.Position;

public class FuncDefNode extends ASTNode {
  public TypeNameNode type;
  public String name;
  public Array<VarDefNode> params;
  public BlockStmtNode body;

  public FuncDefNode(Position position, TypeNameNode type, String name) {
    super(position);
    this.type = type;
    this.name = name;
    params = new Array<VarDefNode>();
  }

  public void addParam(VarDefNode param) {
    params.add(param);
  }

  @Override
  public String toString() {
    String str = type.toString() + " " + name + "(";
    str += params.toString(", ");
    str += ") " + body.toString();
    return str;
  }
}
