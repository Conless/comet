package dev.conless.comet.backend.asm.node.global;

import dev.conless.comet.backend.asm.ASMVisitor;
import dev.conless.comet.backend.asm.node.ASMNode;
import dev.conless.comet.backend.asm.node.inst.ASMReturnNode;
import dev.conless.comet.backend.asm.node.stmt.ASMStmtsNode;
import dev.conless.comet.backend.asm.node.utils.ASMCommentNode;
import dev.conless.comet.backend.asm.node.utils.ASMLabelNode;
import dev.conless.comet.utils.container.Pair;

@lombok.Getter
@lombok.Setter
public final class ASMFuncDefNode extends ASMNode {
  private String name;
  private ASMStmtsNode body;
  private Pair<Integer, Integer> memUsed;
  private ASMStmtsNode ldRegs, stRegs;

  public ASMFuncDefNode(String name) {
    this.name = name;
    this.memUsed = null;
    this.body = new ASMStmtsNode();
    this.ldRegs = new ASMStmtsNode();
    this.stRegs = new ASMStmtsNode();
  }

  @Override
  public String toString() {
    var str = "  .globl " + name + "\n";
    str += name + ":\n";
    var beginStr = stRegs.getNodes().toString("  ", "\n", "\n");
    var endStr = ldRegs.getNodes().toString("  ", "\n", "\n");
    str += beginStr;
    for (var node : body.getNodes()) {
      if (node instanceof ASMReturnNode) {
        str += endStr;
      }
      if (node instanceof ASMLabelNode || node instanceof ASMCommentNode) {
        str += node.toString() + "\n";
      } else {
        str += "  " + node.toString() + "\n";
      }
    }
    return str;
  }

  @Override
  public <T> T accept(ASMVisitor<T> visitor) {
    return visitor.visit(this);
  }
}
