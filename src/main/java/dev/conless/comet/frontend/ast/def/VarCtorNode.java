package dev.conless.comet.frontend.ast.def;

import dev.conless.comet.frontend.ast.*;
import dev.conless.comet.frontend.ast.expr.*;
import dev.conless.comet.utils.*;

public class VarCtorNode extends ASTNode {
  public ExprNode expr;

  public VarCtorNode(Position position) {
    super(position);
  }

  @Override public String toString() {
    return "= " + expr.toString();
  }
}
