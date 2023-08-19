package dev.conless.comet.frontend.ir.node.utils;

import dev.conless.comet.frontend.ir.node.IRNode;

public final class IRCustomNode extends IRNode {
  private final String str;

  public IRCustomNode(String str) {
    this.str = str;
  }

  @Override
  public String toString() {
    return str;
  }
}
