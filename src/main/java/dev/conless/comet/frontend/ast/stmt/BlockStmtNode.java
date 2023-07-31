package dev.conless.comet.frontend.ast.stmt;

import java.util.*;

import dev.conless.comet.utils.*;

public class BlockStmtNode extends StmtNode {
  public ArrayList<StmtNode> stmts;
  
  public BlockStmtNode(Position position) {
    super(position);
  }

  @Override
  public String toString() {
    return "{\n" + stmts.toString() + "\n}";
  }
}
