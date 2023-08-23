package dev.conless.comet.backend.asm.node;

import dev.conless.comet.backend.asm.node.global.*;
import dev.conless.comet.utils.container.Array;

@lombok.Getter
public class ASMRoot extends ASMNode {
  private Array<ASMVarDefNode> vars;
  private Array<ASMStrDefNode> strs;
  private Array<ASMFuncDefNode> funcs;

  public ASMRoot() {
    vars = new Array<>();
    strs = new Array<>();
    funcs = new Array<>();
  }

  @Override
  public String toString() {
    var str = "";
    str += ".data\n" + vars.toString("\n") + "\n\n";
    str += ".rodata\n" + strs.toString("\n") + "\n\n";
    str += ".text\n" + funcs.toString("\n\n");
    return str;
  }
}
