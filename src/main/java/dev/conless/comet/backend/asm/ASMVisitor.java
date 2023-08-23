package dev.conless.comet.backend.asm;

import dev.conless.comet.backend.asm.node.*;
import dev.conless.comet.backend.asm.node.global.*;
import dev.conless.comet.backend.asm.node.inst.*;
import dev.conless.comet.backend.asm.node.utils.*;

public interface ASMVisitor<T> {
  public T visit(ASMNode node);
  public T visit(ASMRoot node);
  
  public T visit(ASMFuncDefNode node);
  public T visit(ASMStrDefNode node);
  public T visit(ASMVarDefNode node);
  
  public T visit(ASMBeqzNode node);
  public T visit(ASMBinaryNode node);
  public T visit(ASMCallNode node);
  public T visit(ASMJumpNode node);
  public T visit(ASMLoadAddrNode node);
  public T visit(ASMLoadImmNode node);
  public T visit(ASMLoadNode node);
  public T visit(ASMMoveNode node);
  public T visit(ASMReturnNode node);
  public T visit(ASMStoreNode node);
  public T visit(ASMUnaryNode node);

  public T visit(ASMCommentNode node);
  public T visit(ASMLabelNode node);
}
