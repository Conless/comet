package dev.conless.comet.frontend.ir.node.stmt;

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
}
