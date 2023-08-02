package dev.conless.comet.frontend.ast.stmt;

import dev.conless.comet.frontend.ast.ASTVisitor;
import dev.conless.comet.utils.container.Position;

public class ContinueStmtNode extends StmtNode {
  public ContinueStmtNode(Position position) {
    super(position);
  }

  @Override
  public String toString() {
    return super.toString() + "continue;";
  }

  @Override
  public void accept(ASTVisitor visitor) throws Exception {
    visitor.visit(this);
  }
}
