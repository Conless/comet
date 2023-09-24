package dev.conless.comet.backend.allocator;

import dev.conless.comet.backend.asm.ASMVisitor;
import dev.conless.comet.backend.asm.entity.ASMAddress;
import dev.conless.comet.backend.asm.node.ASMNode;
import dev.conless.comet.backend.asm.node.ASMRoot;
import dev.conless.comet.backend.asm.node.global.ASMFuncDefNode;
import dev.conless.comet.backend.asm.node.global.ASMStrDefNode;
import dev.conless.comet.backend.asm.node.global.ASMVarDefNode;
import dev.conless.comet.backend.asm.node.inst.ASMBeqzNode;
import dev.conless.comet.backend.asm.node.inst.ASMBinaryNode;
import dev.conless.comet.backend.asm.node.inst.ASMCallNode;
import dev.conless.comet.backend.asm.node.inst.ASMJumpNode;
import dev.conless.comet.backend.asm.node.inst.ASMLoadAddrNode;
import dev.conless.comet.backend.asm.node.inst.ASMLoadImmNode;
import dev.conless.comet.backend.asm.node.inst.ASMLoadNode;
import dev.conless.comet.backend.asm.node.inst.ASMMoveNode;
import dev.conless.comet.backend.asm.node.inst.ASMReturnNode;
import dev.conless.comet.backend.asm.node.inst.ASMStoreNode;
import dev.conless.comet.backend.asm.node.inst.ASMUnaryNode;
import dev.conless.comet.backend.asm.node.stmt.ASMBlockStmtNode;
import dev.conless.comet.backend.asm.node.stmt.ASMStmtNode;
import dev.conless.comet.backend.asm.node.utils.ASMCommentNode;
import dev.conless.comet.backend.asm.node.utils.ASMLabelNode;
import dev.conless.comet.backend.asm.utils.ASMManager;
import dev.conless.comet.utils.container.Array;

public class StackManager extends ASMManager implements ASMVisitor<ASMNode> {
  @Override
  public ASMNode visit(ASMNode node) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'visit'");
  }

  @Override
  public ASMNode visit(ASMRoot node) {
    var funcs = new Array<ASMFuncDefNode>();
    for (var func : node.getFuncs()) {
      funcs.add((ASMFuncDefNode) func.accept(this));
    }
    node.setFuncs(funcs);
    return node;
  }

  @Override
  public ASMNode visit(ASMFuncDefNode node) {
    var blocks = node.getBlocks();
    var begin = new ASMStmtNode();
    var end = new ASMStmtNode();
    var totalMem = node.getSpilled() + node.getUsedRegs().size();
    if (totalMem != 0) {
      begin.addInst(new ASMMoveNode(regs.getSp(), regs.getS8()));
      begin.addInst(new ASMUnaryNode("addi", regs.getSp(), regs.getSp(), -4 * totalMem));
      var regsCount = 0;
      for (var reg : node.getUsedRegs()) {
        begin.addInst(new ASMStoreNode(reg, new ASMAddress(regs.getSp(), 4 * (node.getSpilled() + regsCount))));
        end.addInst(new ASMLoadNode(reg, new ASMAddress(regs.getSp(), 4 * (node.getSpilled() + regsCount))));
        regsCount++;
      }
      end.addInst(new ASMUnaryNode("addi", regs.getSp(), regs.getSp(), 4 * totalMem));
    }
    begin.getInsts().addAll(blocks.get(0).getInsts());
    blocks.get(0).setInsts(begin.getInsts());
    for (var block : blocks) { // the ret instruction can only appear in the last
      if (block.getExitInst().getInsts().getLast() instanceof ASMReturnNode) {
        block.getExitInst().getInsts().removeLast();
        block.getExitInst().appendInsts(end);
        block.getExitInst().addInst(new ASMReturnNode());
      }
    }
    return node;
  }

  @Override
  public ASMNode visit(ASMBlockStmtNode node) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'visit'");
  }

  @Override
  public ASMNode visit(ASMStrDefNode node) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'visit'");
  }

  @Override
  public ASMNode visit(ASMVarDefNode node) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'visit'");
  }

  @Override
  public ASMNode visit(ASMBeqzNode node) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'visit'");
  }

  @Override
  public ASMNode visit(ASMBinaryNode node) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'visit'");
  }

  @Override
  public ASMNode visit(ASMCallNode node) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'visit'");
  }

  @Override
  public ASMNode visit(ASMJumpNode node) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'visit'");
  }

  @Override
  public ASMNode visit(ASMLoadAddrNode node) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'visit'");
  }

  @Override
  public ASMNode visit(ASMLoadImmNode node) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'visit'");
  }

  @Override
  public ASMNode visit(ASMLoadNode node) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'visit'");
  }

  @Override
  public ASMNode visit(ASMMoveNode node) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'visit'");
  }

  @Override
  public ASMNode visit(ASMReturnNode node) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'visit'");
  }

  @Override
  public ASMNode visit(ASMStoreNode node) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'visit'");
  }

  @Override
  public ASMNode visit(ASMUnaryNode node) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'visit'");
  }

  @Override
  public ASMNode visit(ASMCommentNode node) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'visit'");
  }

  @Override
  public ASMNode visit(ASMLabelNode node) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'visit'");
  }
  
}
