package dev.conless.comet.frontend.ir.node.module;

import dev.conless.comet.frontend.ir.entity.IRVariable;
import dev.conless.comet.frontend.ir.node.IRBlockNode;
import dev.conless.comet.frontend.ir.node.IRModuleNode;
import dev.conless.comet.frontend.ir.node.inst.IRAllocaNode;
import dev.conless.comet.frontend.ir.node.inst.IRCallNode;
import dev.conless.comet.frontend.ir.node.inst.IRJumpNode;
import dev.conless.comet.frontend.ir.node.inst.IRStoreNode;
import dev.conless.comet.frontend.ir.type.IRType;
import dev.conless.comet.frontend.utils.scope.GlobalScope;
import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.container.Map;
import dev.conless.comet.utils.error.RuntimeError;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IRFuncNode extends IRModuleNode {
  private String name;
  private Array<IRVariable> params;
  private IRType returnType;

  private Array<IRBlockNode> blocks;
  private Map<String, IRBlockNode> tag2Block;

  private Integer depth;
  private Array<Integer> counter;

  public IRFuncNode(String name, Array<IRVariable> params, IRType returnType) {
    this.name = name;
    this.params = params;
    this.returnType = returnType;

    blocks = new Array<>();
    tag2Block = new Map<>();

    depth = 0;
    counter = new Array<>();
    counter.add(0);

    var entry = new IRBlockNode("entry");
    if (name.equals("main")) {
      entry.addInst(new IRCallNode(GlobalScope.irVoidType, "init", new Array<>()));
    }
    for (var param : params) {
      if (!param.getName().endsWith(".param")) {
        throw new RuntimeError("Invalid parameter name: " + param.getName());
      }
      var paramPtr = new IRVariable(GlobalScope.irPtrType, param.getValue().replace(".param", ""), false);
      entry.addInst(new IRAllocaNode(paramPtr, param.getType()));
      entry.addInst(new IRStoreNode(new IRVariable(param.getType(), param.getValue(), false), paramPtr));
    }
    blocks.add(entry);
    tag2Block.put(entry.getName(), entry);
  }

  public IRBlockNode addBlock(boolean stepIn) {
    if (stepIn) {
      depth++;
      counter.add(0);
    }
    counter.set(depth, counter.get(depth) + 1);
    var blockName = getName() + "." + counter.toString(".");
    var block = new IRBlockNode(blockName);
    block.setParent(this);
    this.blocks.add(block);
    this.tag2Block.put(block.getName(), block);
    if (depth == 0 && counter.get(0) == 1) {
      getBlock("entry").addInst(new IRJumpNode(block.getName()));
    }
    return block;
  }

  public void exitBlock() {
    depth--;
    counter.remove(depth + 1);
  }

  @Override
  public IRBlockNode getBlock(String name) {
    return tag2Block.get(name);
  }

  @Override
  public String toString() {
    String str = "; The definition of function " + name + "\n";
    str += "define " + returnType.toString() + " @" + name + "(";
    str += params.toString(".param, ") + ") {\n";
    for (var block : blocks) {
      str += block.toString();
    }
    str += "}";
    return str;
  }
}
