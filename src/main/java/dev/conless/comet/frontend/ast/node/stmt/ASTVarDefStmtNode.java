package dev.conless.comet.frontend.ast.node.stmt;

import dev.conless.comet.frontend.ast.ASTVisitor;
import dev.conless.comet.frontend.ast.node.def.ASTVarDefNode;
import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.error.BaseError;

/**
 * The VarDefStmtNode class represents a statement node that defines multiple variables.
 */
@lombok.experimental.SuperBuilder
@lombok.Value
@lombok.EqualsAndHashCode(callSuper = true)
public final class ASTVarDefStmtNode extends ASTStmtNode {
  private Array<ASTVarDefNode> defs;

  @Override
  public String toString() {
    String str = super.toString() + defs.get(0).getType().toString() + " ";
    for (int i = 0; i < defs.size(); i++) {
      str += defs.get(i).getName();
      if (defs.get(i).getInit() != null) {
        str += " = " + defs.get(i).getInit().toString();
      }
      if (i < defs.size() - 1) {
        str += ", ";
      }
    }
    return str + ";";
  }

  @Override
  public <T> T accept(ASTVisitor<T> visitor) throws BaseError {
    return visitor.visit(this);
  }
}
