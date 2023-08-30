package dev.conless.comet.backend.asm.node.stmt;

import dev.conless.comet.backend.asm.ASMVisitor;
import dev.conless.comet.backend.asm.node.utils.ASMCommentNode;
import dev.conless.comet.backend.asm.node.utils.ASMLabelNode;
import dev.conless.comet.utils.error.RuntimeError;

@lombok.Getter
@lombok.Setter
public class ASMBlockStmtNode extends ASMStmtNode {
  private ASMLabelNode label;

  public ASMBlockStmtNode(ASMLabelNode label) {
    this.label = label;
  }

  @Override
  public String toString() {
    var str = label.toString() + "\n";
    for (var node : getNodes()) {
      if (node instanceof ASMLabelNode) {
        throw new RuntimeError("ASMLabelNode should not appear in ASMBlockStmtNode");
      }
      if (node instanceof ASMCommentNode) {
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
