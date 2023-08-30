package dev.conless.comet.backend.asm.node.global;

import dev.conless.comet.backend.asm.ASMVisitor;
import dev.conless.comet.backend.asm.node.ASMNode;
import dev.conless.comet.backend.asm.node.inst.ASMReturnNode;
import dev.conless.comet.backend.asm.node.stmt.ASMBlockStmtNode;
import dev.conless.comet.backend.asm.node.stmt.ASMStmtNode;
import dev.conless.comet.backend.asm.node.utils.ASMCommentNode;
import dev.conless.comet.backend.asm.node.utils.ASMLabelNode;
import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.container.Pair;

@lombok.Getter
@lombok.Setter
public final class ASMFuncDefNode extends ASMNode {
  private String name;
  private Array<ASMBlockStmtNode> blocks;
  private Pair<Integer, Integer> memUsed;

  public ASMFuncDefNode(String name) {
    this.name = name;
    this.memUsed = null;
    this.blocks = new Array<>();
  }

  public void addBlock(ASMBlockStmtNode block) {
    blocks.add(block);
  }

  @Override
  public String toString() {
    return "  .globl " + name + "\n" + blocks.toString("") + "\n";
  }

  @Override
  public <T> T accept(ASMVisitor<T> visitor) {
    return visitor.visit(this);
  }
}
