package dev.conless.comet.frontend.ir.node;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class IRNode {
  private IRNode parent;

  protected IRNode() {
    this.parent = null;
  }

  public abstract String toString(); 
}
