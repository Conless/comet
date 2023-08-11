package dev.conless.comet.frontend.ir.node;

import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.container.Map;

import lombok.Getter;

@Getter
public abstract class IRModuleNode extends IRNode {
  private Array<IRBlockNode> blocks;
  private Map<String, IRBlockNode> tag2Block;

  public IRModuleNode() {
    blocks = new Array<>();
    tag2Block = new Map<>();
  }

  public abstract String getName();
  
  public void addBlock(IRBlockNode block) {
    block.setParent(this);
    this.blocks.add(block);
    this.tag2Block.put(block.getName(), block);
  }

  public IRBlockNode getBlock(String name) {
    return tag2Block.get(name);
  }

  @Override
  public String toString() {
    String str = "";
    for (var block : blocks) {
      str += block.toString() + "\n";
    }
    return str;
  }
}
