package dev.conless.comet.frontend.ast.expr;

import dev.conless.comet.frontend.ast.ASTNode;
import dev.conless.comet.utils.container.Position;
import dev.conless.comet.utils.metadata.BaseInfo;

public abstract class ExprNode extends ASTNode {
  BaseInfo info;
  boolean editable = false;

  public BaseInfo getInfo() {
    return info;
  }

  public void setInfo(BaseInfo info) {
    this.info = info;
  }

  public boolean isEditable() {
    return editable;
  }

  public void setEditable(boolean editable) {
    this.editable = editable;
  }

  public ExprNode(Position position) {
    super(position);
  }
}
