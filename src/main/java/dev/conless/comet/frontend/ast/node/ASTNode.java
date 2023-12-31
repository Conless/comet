package dev.conless.comet.frontend.ast.node;

import dev.conless.comet.frontend.ast.ASTVisitor;
import dev.conless.comet.utils.container.Position;
import dev.conless.comet.utils.error.BaseError;

@lombok.experimental.SuperBuilder
@lombok.Getter
@lombok.Setter
public class ASTNode {
  protected ASTNode parent;
  protected Position position;

  public <T> T accept(ASTVisitor<T> visitor) throws BaseError {
    return visitor.visit(this);
  }

  public String toString() {
    return position.toString();
  }
}
