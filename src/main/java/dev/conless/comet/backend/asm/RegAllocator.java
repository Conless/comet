package dev.conless.comet.backend.asm;

import dev.conless.comet.backend.asm.entity.ASMPhysicalReg;
import dev.conless.comet.backend.asm.node.ASMNode;

@lombok.Getter
public abstract class RegAllocator implements ASMVisitor<ASMNode> {
  protected abstract ASMPhysicalReg getReg();
}
