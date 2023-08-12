package dev.conless.comet.frontend.ir.node.inst;

import dev.conless.comet.frontend.ir.entity.IRLiteral;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = true)
public class IRGlobalNode extends IRInstNode {
  private String name;
  private IRLiteral init;

  public IRGlobalNode(String name, IRLiteral init) {
    this.name = name;
    this.init = init;
  }

  @Override
  public String toString() {
    return "@" + name + " = global " + init.getType().toString() + " " + init.getValue();
  }
}
