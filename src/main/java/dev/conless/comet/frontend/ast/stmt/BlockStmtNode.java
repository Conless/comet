package dev.conless.comet.frontend.ast.stmt;

import dev.conless.comet.utils.Position;
import dev.conless.comet.utils.Array;

public class BlockStmtNode extends StmtNode {
  public Array<StmtNode> stmts;
  
  public BlockStmtNode(Position position) {
    super(position);
    stmts = new Array<StmtNode>();
  }

  public void addStmt(StmtNode stmt) {
    stmts.add(stmt);
  }

  @Override
  public String toString() {
    indentDepth++;
    String str = "{\n" + stmts.toString("\n");
    indentDepth--;
    str += "\n" + super.toString() + "}";
    return str;
  }
}
