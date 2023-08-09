package dev.conless.comet.frontend.ast.stmt;

import dev.conless.comet.frontend.ast.*;

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
