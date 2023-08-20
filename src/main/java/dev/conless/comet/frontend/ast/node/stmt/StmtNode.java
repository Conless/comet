package dev.conless.comet.frontend.ast.node.stmt;

import dev.conless.comet.frontend.ast.node.ASTNode;

@lombok.experimental.SuperBuilder
@lombok.EqualsAndHashCode(callSuper = false)
public abstract class StmtNode extends ASTNode {
  public static int indentDepth = 0;

  @Override
  public String toString() {
    return "  ".repeat(indentDepth);
  }
}
