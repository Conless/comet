package dev.conless.comet.frontend.ast.def;

import dev.conless.comet.frontend.ast.stmt.BlockStmtNode;
import dev.conless.comet.frontend.ast.type.TypeNameNode;
import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.container.Position;
import dev.conless.comet.utils.metadata.FuncInfo;
import dev.conless.comet.utils.metadata.TypeInfo;

public class FuncDefNode extends BaseDefNode {
  public Array<VarDefNode> params;
  public BlockStmtNode body;

  public FuncDefNode(Position position, TypeNameNode type, String name) {
    super(position, new FuncInfo(name, type.type));
    params = new Array<VarDefNode>();
  }

  public void addParam(VarDefNode param) {
    params.add(param);
    ((FuncInfo) info).params.add((TypeInfo)param.info);
  }
  
  @Override
  public String name() {
    return info.name;
  }

  @Override
  public String toString() {
    String str = ((FuncInfo)info).type.toString() + " " + info.name + "(";
    str += params.toString(", ");
    str += ") " + body.toString();
    return str;
  }
}
