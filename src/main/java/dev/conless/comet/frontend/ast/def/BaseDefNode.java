package dev.conless.comet.frontend.ast.def;

import dev.conless.comet.frontend.ast.ASTNode;
import dev.conless.comet.frontend.ast.ASTVisitor;
import dev.conless.comet.utils.error.BaseError;
import dev.conless.comet.utils.metadata.BaseInfo;

import lombok.experimental.SuperBuilder;
import lombok.Getter;

@SuperBuilder
@Getter
/**
 * The class BaseDefNode is an abstract class that extends ASTNode and has a private field info of type
 * BaseInfo, and it provides a method getName() that returns the name of the info object.
 */
public abstract class BaseDefNode extends ASTNode {
  private final BaseInfo info;

  public String getName() {
    return getInfo().getName();
  }

  @Override
  public void accept(ASTVisitor visitor) throws BaseError {
    visitor.visit(this);
  }
}
