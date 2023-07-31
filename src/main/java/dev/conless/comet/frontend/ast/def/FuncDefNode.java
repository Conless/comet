package dev.conless.comet.frontend.ast.def;

import java.util.ArrayList;

import dev.conless.comet.frontend.ast.ASTNode;
import dev.conless.comet.frontend.ast.stmt.BlockStmtNode;
import dev.conless.comet.frontend.ast.type.TypeNameNode;
import dev.conless.comet.utils.Position;

public class FuncDefNode extends ASTNode {
  public TypeNameNode type;
  public String name;
  public ArrayList<VarDefNode> params;
  public BlockStmtNode body;

  public FuncDefNode(Position position, TypeNameNode type, String name) {
    super(position);
    this.type = type;
    this.name = name;
    params = new ArrayList<VarDefNode>();
  }

  public void addParam(VarDefNode param) {
    params.add(param);
  }

  @Override
  public String toString() {
    return "";
  }
}
