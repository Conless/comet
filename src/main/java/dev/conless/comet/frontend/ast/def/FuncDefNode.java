package dev.conless.comet.frontend.ast.def;

import java.util.ArrayList;

import dev.conless.comet.frontend.ast.ASTNode;
import dev.conless.comet.frontend.ast.TypeNameNode;
import dev.conless.comet.utils.Position;

public class FuncDefNode extends ASTNode {
  public TypeNameNode type;
  public String name;
  public ArrayList<VarDefNode> args;

  public FuncDefNode(Position position) {
    super(position);
    args = new ArrayList<VarDefNode>();
  }

  @Override
  public String toString() {
    return "";
  }
}
