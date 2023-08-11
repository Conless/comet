package dev.conless.comet.frontend.ir.node;

import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.container.Map;

import lombok.*;

@Getter
@Setter
public class IRProgramNode extends IRNode {
  private Array<IRModuleNode> modules;
  private Map<String, IRModuleNode> name2Module;

  public IRProgramNode() {
    modules = new Array<>();
    name2Module = new Map<>();
  }

  public void addModule(IRModuleNode module) {
    module.setParent(this);
    modules.add(module);
    name2Module.put(module.getName(), module);
  }

  public IRModuleNode getModule(String name) {
    return name2Module.get(name);
  }

  @Override
  public String toString() {
    String str = "";
    for (var module : modules) {
      str += module.toString();
    }
    return str;
  }
  
}
