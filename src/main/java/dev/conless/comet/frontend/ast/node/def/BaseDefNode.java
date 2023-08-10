package dev.conless.comet.frontend.ast.node.def;

import dev.conless.comet.frontend.ast.ASTVisitor;
import dev.conless.comet.frontend.ast.node.ASTNode;
import dev.conless.comet.frontend.utils.metadata.BaseInfo;
import dev.conless.comet.utils.error.BaseError;
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
  public <T> T accept(ASTVisitor<T> visitor) throws BaseError {
    return visitor.visit(this);
  }
}
