package dev.conless.comet.backend.asm.utils;

import dev.conless.comet.backend.asm.RegAllocator;
import dev.conless.comet.backend.asm.entity.ASMPhysicalReg;
import dev.conless.comet.backend.asm.node.*;
import dev.conless.comet.backend.asm.node.global.*;
import dev.conless.comet.backend.asm.node.inst.*;
import dev.conless.comet.backend.asm.node.utils.*;
import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.error.*;

public class BasicAllocator extends RegAllocator {
  @Override
  public ASMNode visit(ASMNode node) {
    throw new RuntimeError("BasicAllocator.visit(ASMNode) should not be called");
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

  @Override
  protected ASMPhysicalReg getReg() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getReg'");
  }
  
}
