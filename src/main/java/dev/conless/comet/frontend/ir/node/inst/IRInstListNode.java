package dev.conless.comet.frontend.ir.node.inst;

import dev.conless.comet.frontend.ir.node.IRInstNode;
import dev.conless.comet.utils.container.Array;

import lombok.Getter;

@Getter
public final class IRInstListNode extends IRInstNode {
  private Array<IRInstNode> insts;

  public IRInstListNode() {
    insts = new Array<>();
  }

  public IRInstListNode(Array<IRInstNode> insts) {
    this.insts = insts;
  }

  public void addInst(IRInstNode inst) {
    insts.add(inst);
  }

  @Override
  public String toString() {
    return insts.toString(" ", "\n");
  }
}
