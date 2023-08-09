package dev.conless.comet.frontend.ast.node;

import dev.conless.comet.frontend.ast.ASTVisitor;
import dev.conless.comet.utils.container.Position;
import dev.conless.comet.utils.error.BaseError;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class ASTNode {
  protected Position position;

  public void accept(ASTVisitor visitor) throws BaseError {
    visitor.visit(this);
  }

  public String toString() {
    return position.toString();
  }
}
