package dev.conless.comet.frontend.ir.node.stmt;

import dev.conless.comet.frontend.ir.IRVisitor;
import dev.conless.comet.utils.error.BaseError;

@lombok.Value
@lombok.EqualsAndHashCode(callSuper = false)
public class IRBlockStmtNode extends IRStmtNode {
  private String labelName;

  public IRBlockStmtNode(String labelName) {
    this.labelName = labelName;
  }

  @Override
  public String toString() {
    return labelName + ":\n" + getNodes().toString("  ", "\n");
  }

  @Override
  public <T> T accept(IRVisitor<T> visitor) throws BaseError {
    return visitor.visit(this);
  }
}
