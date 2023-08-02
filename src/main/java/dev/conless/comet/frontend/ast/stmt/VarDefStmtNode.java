package dev.conless.comet.frontend.ast.stmt;

import dev.conless.comet.frontend.ast.ASTVisitor;
import dev.conless.comet.frontend.ast.def.VarDefNode;
import dev.conless.comet.utils.container.Position;

public class VarDefStmtNode extends StmtNode {
  public VarDefNode def;

  public VarDefStmtNode(Position position, VarDefNode def) {
    super(position);
    this.def = def;
  }

  public VarDefNode getDef() {
    return def;
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
