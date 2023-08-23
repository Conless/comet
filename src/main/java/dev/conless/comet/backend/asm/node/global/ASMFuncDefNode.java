package dev.conless.comet.backend.asm.node.global;

import dev.conless.comet.backend.asm.node.ASMNode;
import dev.conless.comet.backend.asm.node.inst.ASMReturnNode;
import dev.conless.comet.backend.asm.node.stmt.ASMStmtsNode;
import dev.conless.comet.backend.asm.node.utils.ASMCommentNode;
import dev.conless.comet.backend.asm.node.utils.ASMLabelNode;

@lombok.Getter
@lombok.Setter
public class ASMFuncDefNode extends ASMNode {
  private String name;
  private ASMStmtsNode body;
  private ASMStmtsNode begin, end;

  public ASMFuncDefNode(String name) {
    this.name = name;
    this.body = new ASMStmtsNode();
    this.begin = new ASMStmtsNode();
    this.end = new ASMStmtsNode();
  }

  @Override
  public String toString() {
    var str = "";
    str += name + ":\n";
    var beginStr = "";
    for (var node : begin.getNodes()) {
      beginStr += "  " + node.toString() + "\n";
    }
    str += beginStr;
    var endStr = "";
    for (var node : end.getNodes()) {
      endStr += "  " + node.toString() + "\n";
    }
    str += endStr;
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
}
