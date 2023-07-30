package dev.conless.comet.frontend.ast;

import java.util.ArrayList;

import dev.conless.comet.utils.*;

public class ProgramNode extends ASTNode {
  public ArrayList<ASTNode> defs;

  public ProgramNode(Position position) {
    super(position);
    this.defs = new ArrayList<ASTNode>();
  }

  @Override
  public String toString() {
    String str = "";
    for (ASTNode def : defs) {
      str += def.toString() + "\n";
    }
    return str;
  }
}
