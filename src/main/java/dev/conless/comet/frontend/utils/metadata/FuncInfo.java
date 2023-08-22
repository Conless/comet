package dev.conless.comet.frontend.utils.metadata;

import dev.conless.comet.frontend.ast.node.def.ASTVarDefNode;
import dev.conless.comet.utils.container.Array;

@lombok.Value
@lombok.EqualsAndHashCode(callSuper = true)
public class FuncInfo extends BaseInfo {
  public TypeInfo type;
  public Array<TypeInfo> params;

  public FuncInfo(String name, TypeInfo type, TypeInfo... params) {
    super(name);
    this.type = type;
    this.params = new Array<TypeInfo>();
    for (var param : params) {
      this.params.add(param);
    }
  }

  public FuncInfo(String name, TypeInfo type, Array<ASTVarDefNode> params) {
    super(name);
    this.type = type;
    this.params = new Array<TypeInfo>();
    for (var param : params) {
      this.params.add(((VarInfo) param.getInfo()).getType());
    }
  }

  @Override
  public String toString() {
    String str = type.toString() + " " + getName() + "(";
    for (int i = 0; i < params.size(); i++) {
      str += params.get(i).toString();
      if (i != params.size() - 1) {
        str += ", ";
      }
    }
    str += ");";
    return str;
  }
}
