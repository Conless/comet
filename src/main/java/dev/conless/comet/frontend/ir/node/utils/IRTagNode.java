package dev.conless.comet.frontend.ir.node.utils;

import dev.conless.comet.frontend.ir.node.IRNode;
import lombok.Getter;

@Getter
public class IRTagNode extends IRNode {
  private String name;

  public IRTagNode(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return this.name + ":";
  }
}
