package dev.conless.comet.frontend.ast.def;

import dev.conless.comet.frontend.ast.ASTNode;
import dev.conless.comet.utils.container.Position;
import dev.conless.comet.utils.metadata.BaseInfo;

public abstract class BaseDefNode extends ASTNode {
  public BaseInfo info;

  public BaseDefNode(Position position, BaseInfo info) {
    super(position);
    this.info = info;
  }

  public abstract String name();
}
