package dev.conless.comet.frontend.ir.node.utils;

import dev.conless.comet.frontend.ir.node.inst.IRInstNode;

public class IRCustomNode extends IRInstNode {
  private String str;

  public IRCustomNode(String str) {
    this.str = str;
  }

  @Override
  public String toString() {
    return str;
  }
}
