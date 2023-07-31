package dev.conless.comet.frontend.ast.stmt;

import dev.conless.comet.frontend.ast.*;
import dev.conless.comet.utils.*;

public abstract class StmtNode extends ASTNode {
  public static int indentDepth = 0;

  public StmtNode(Position position) {
    super(position);
  }

  @Override
  public String toString() {
    return "  ".repeat(indentDepth);
  }
}
