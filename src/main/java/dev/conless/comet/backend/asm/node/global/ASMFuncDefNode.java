package dev.conless.comet.backend.asm.node.global;

import dev.conless.comet.backend.asm.ASMVisitor;
import dev.conless.comet.backend.asm.entity.ASMPhysicalReg;
import dev.conless.comet.backend.asm.node.ASMNode;
import dev.conless.comet.backend.asm.node.inst.ASMReturnNode;
import dev.conless.comet.backend.asm.node.stmt.ASMBlockStmtNode;
import dev.conless.comet.backend.asm.node.stmt.ASMStmtNode;
import dev.conless.comet.backend.asm.node.utils.ASMCommentNode;
import dev.conless.comet.backend.asm.node.utils.ASMLabelNode;
import dev.conless.comet.frontend.ir.node.stmt.IRBlockStmtNode;
import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.container.Map;
import dev.conless.comet.utils.container.Pair;
import dev.conless.comet.utils.container.Set;

@lombok.Getter
@lombok.Setter
public final class ASMFuncDefNode extends ASMNode {
  private String name;
  private int paramCount;
  private Array<ASMBlockStmtNode> blocks;
  private Set<ASMPhysicalReg> usedRegs;
  private int spilled;
  private Map<ASMBlockStmtNode, Integer> block2Order = new Map<>();
  private Array<ASMBlockStmtNode> order2Block = new Array<>();

  public ASMFuncDefNode(String name, int paramCount) {
    this.name = name;
    this.paramCount = paramCount;
    this.spilled = 0;
    this.blocks = new Array<>();
    this.usedRegs = new Set<>();
  }

  public void addBlock(ASMBlockStmtNode block) {
    blocks.add(block);
  }

  public void addSpilled() {
    this.spilled++;
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
