package dev.conless.comet.frontend.ast.node.stmt;

import dev.conless.comet.frontend.ast.node.ASTNode;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public abstract class StmtNode extends ASTNode {
  protected static int indentDepth = 0;

  @Override
  public String toString() {
    return "  ".repeat(indentDepth);
  }
}
