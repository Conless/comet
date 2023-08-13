package dev.conless.comet.frontend.ir.node.global;

import dev.conless.comet.frontend.ir.entity.IRVariable;

public class IRStrDefNode extends IRGlobalDefNode {
  private String value;

  public IRStrDefNode(IRVariable var, String value) {
    super(var);
    this.value = value;
  }

  @Override
  public String toString() {
    return getVar().getValue() + " = private constant" + String.format(" [%d x i8] c", value.length() - 1) + "\"" + value.substring(1, value.length() - 1) + "\\00\"";
  }
}
