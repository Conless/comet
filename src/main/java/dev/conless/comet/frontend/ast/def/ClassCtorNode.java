package dev.conless.comet.frontend.ast.def;

import dev.conless.comet.frontend.ast.*;
import dev.conless.comet.frontend.ast.stmt.*;
import dev.conless.comet.utils.*;

public class ClassCtorNode extends ASTNode {
  public String name;
  public BlockStmtNode body;

  public ClassCtorNode(Position position) {
    super(position);
  }

  @Override
  public String toString() {
    String str = name + "(";
    str += ") {\n";
    str += body.toString();
    str += "}";
    return str;
  }
}
