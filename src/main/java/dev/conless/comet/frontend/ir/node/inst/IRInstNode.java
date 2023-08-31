package dev.conless.comet.frontend.ir.node.inst;

import dev.conless.comet.frontend.ir.entity.IRVariable;
import dev.conless.comet.frontend.ir.node.IRNode;
import dev.conless.comet.utils.container.Array;

public abstract class IRInstNode extends IRNode {
  public abstract IRVariable getDef();
  public abstract Array<IRVariable> getUses();
}
