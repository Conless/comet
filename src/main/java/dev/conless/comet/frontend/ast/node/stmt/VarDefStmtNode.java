package dev.conless.comet.frontend.ast.node.stmt;

import dev.conless.comet.frontend.ast.ASTVisitor;
import dev.conless.comet.frontend.ast.node.def.VarDefNode;
import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.error.BaseError;

import lombok.experimental.SuperBuilder;
import lombok.Value;
import lombok.EqualsAndHashCode;

/**
 * The VarDefStmtNode class represents a statement node that defines multiple variables.
 */
@SuperBuilder
@Value
@EqualsAndHashCode(callSuper = true)
public final class VarDefStmtNode extends StmtNode {
  private Array<VarDefNode> defs;

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
