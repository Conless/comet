package dev.conless.comet.frontend.ast.def;

import dev.conless.comet.frontend.ast.ASTVisitor;
import dev.conless.comet.frontend.ast.ScopedNode;
import dev.conless.comet.frontend.ast.stmt.BlockStmtNode;
import dev.conless.comet.frontend.ast.stmt.StmtNode;
import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.container.Position;
import dev.conless.comet.utils.metadata.FuncInfo;
import dev.conless.comet.utils.metadata.TypeInfo;
import dev.conless.comet.utils.scope.BaseScope;

public class FuncDefNode extends BaseDefNode implements ScopedNode {
  public BaseScope scope;
  public Array<VarDefNode> params;
  public BlockStmtNode body;

  public FuncDefNode(Position position, TypeInfo type, String name, BlockStmtNode body) {
    super(position, new FuncInfo(name, type));
    params = new Array<VarDefNode>();
    this.body = body;
  }

  public void addParam(VarDefNode param) {
    params.add(param);
    ((FuncInfo) info).addParam((TypeInfo) param.getInfo());
  }

  public Array<VarDefNode> getParams() {
    return params;
  }
  
  public TypeInfo getReturnType() {
    return ((FuncInfo) info).type;
  }

  public Array<StmtNode> getBody() {
    return body.stmts;
  }

  @Override
  public String getName() {
    return info.name;
  }

  @Override
  public String toString() {
    String str = ((FuncInfo) info).type.toString() + " " + info.name + "(";
    str += params.toString(", ");
    str += ") " + body.toString();
    return str;
  }

  @Override
  public void accept(ASTVisitor visitor) throws Exception {
    visitor.visit(this);
  }

  @Override
  public void addScope(BaseScope scope) {
    if (this.scope == null) {
      this.scope = new BaseScope(scope, info);
    }
  }
  
  @Override
  public BaseScope getScope() {
    return scope;
  }
}
