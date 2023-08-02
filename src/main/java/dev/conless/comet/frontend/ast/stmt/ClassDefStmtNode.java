package dev.conless.comet.frontend.ast.stmt;

import dev.conless.comet.frontend.ast.ASTVisitor;
import dev.conless.comet.frontend.ast.def.ClassDefNode;
import dev.conless.comet.utils.container.Position;

public class ClassDefStmtNode extends StmtNode {
  public ClassDefNode def;

  public ClassDefStmtNode(Position position, ClassDefNode def) {
    super(position);
    this.def = def;
  }

  @Override
  public String toString() {
    return super.toString() + def.toString() + ";";
  }

  @Override
  public void accept(ASTVisitor visitor) throws Exception {
    visitor.visit(this);
  }
}
