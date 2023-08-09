package dev.conless.comet.utils.error;

import dev.conless.comet.frontend.ast.node.ASTNode;
import dev.conless.comet.utils.container.Position;

public class CompileError extends BaseError {
  public CompileError(String msg, Position pos) {
    super("Compile Error: " + msg, pos);
  }
  public CompileError(String msg, ASTNode node) {
    super("Compile Error: " + msg + " in " + node.toString(), node.getPosition());
  }
}
