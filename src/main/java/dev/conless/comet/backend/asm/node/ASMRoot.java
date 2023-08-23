package dev.conless.comet.backend.asm.node;

import dev.conless.comet.backend.asm.ASMVisitor;
import dev.conless.comet.backend.asm.node.global.*;
import dev.conless.comet.utils.container.Array;

@lombok.Getter
@lombok.Setter
public final class ASMRoot extends ASMNode {
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
    str += "  .data\n" + vars.toString("\n") + "\n\n";
    str += "  .rodata\n" + strs.toString("\n") + "\n\n";
    str += funcs.toString("  .text\n", "\n\n");
    return str;
  }

  @Override
  public <T> T accept(ASMVisitor<T> visitor) {
    return visitor.visit(this);
  }
}
