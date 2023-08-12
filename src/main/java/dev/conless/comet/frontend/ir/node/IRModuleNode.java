package dev.conless.comet.frontend.ir.node;

import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.container.Map;

import lombok.Getter;

@Getter
public abstract class IRModuleNode extends IRNode {
  public abstract String getName();
  public abstract IRBlockNode getBlock(String name);
}
