package dev.conless.comet.frontend.ir.node.global;

import dev.conless.comet.frontend.ir.entity.IRVariable;

public class IRStrDefNode extends IRGlobalDefNode {
  private String value;
  private int length;

  public IRStrDefNode(IRVariable var, String value) {
    super(var);
    String ret = "";
    for (int i = 0; i < value.length(); ++i) {
      char c = value.charAt(i);
      switch (c) {
        case '\n':
          ret += "\\0A";
          break;
        case '\"':
          ret += "\\22";
          break;
        case '\\':
          ret += "\\\\";
          break;
        default:
          ret += c;
      }
      length++;
    }
    this.value = ret + "\\00";
    length++;
  }

  @Override
  public String toString() {
    return getVar().getValue() + " = constant" + String.format(" [%d x i8] c", length) + "\"" + value + "\"";
  }
}
