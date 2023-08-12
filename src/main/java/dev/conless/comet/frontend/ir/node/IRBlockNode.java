package dev.conless.comet.frontend.ir.node;

import dev.conless.comet.frontend.ir.node.inst.IRInstNode;
import dev.conless.comet.utils.container.Array;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IRBlockNode extends IRNode {
  private String tagName;
  private Array<IRInstNode> insts;

  public IRBlockNode(String tagName) {
    this.tagName = tagName;
    this.insts = new Array<>();
  }

  public void addInst(IRInstNode inst) {
    inst.setParent(this);
    this.insts.add(inst);
  }

  public String getName() {
    return tagName;
  }

  @Override
  public String toString() {
    String str = tagName + ":\n";
    for (var inst : insts) {
      str += "  " + inst.toString() + "\n";
    }
    return str;
  }
}
