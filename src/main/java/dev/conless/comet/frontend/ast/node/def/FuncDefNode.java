package dev.conless.comet.frontend.ast.node.def;

import dev.conless.comet.frontend.ast.ASTVisitor;
import dev.conless.comet.frontend.ast.node.ScopedNode;
import dev.conless.comet.frontend.ast.node.stmt.BlockStmtNode;
import dev.conless.comet.frontend.ast.node.stmt.StmtNode;
import dev.conless.comet.frontend.utils.metadata.FuncInfo;
import dev.conless.comet.frontend.utils.metadata.TypeInfo;
import dev.conless.comet.frontend.utils.scope.BaseScope;
import dev.conless.comet.frontend.utils.scope.FuncScope;
import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.error.BaseError;
import lombok.experimental.SuperBuilder;
import lombok.Getter;
import lombok.Setter;

/**
 * The `FuncDefNode` class represents a function definition node in an abstract syntax tree, with
 * properties such as scope, parameters, and a blocked body.
 */
@SuperBuilder
@Getter
@Setter
public final class FuncDefNode extends BaseDefNode implements ScopedNode {
  private FuncScope scope;
  private final Array<VarDefNode> params;
  private final BlockStmtNode blockedBody;
  
  public TypeInfo getReturnType() {
    return ((FuncInfo) getInfo()).getType();
  }

  public Array<StmtNode> getBody() {
    return getBlockedBody().getStmts();
  }

  @Override
  public String toString() {
    String str = ((FuncInfo) getInfo()).type.toString() + " " + getInfo().getName() + "(";
    if (params != null) {
      str += params.toString(", ");
    }
    str += ") " + blockedBody.toString();
    return str;
  }

  @Override
  public <T> T accept(ASTVisitor<T> visitor) throws BaseError {
    return visitor.visit(this);
  }

  @Override
  public void addScope(BaseScope scope) {
    if (this.scope == null) {
      this.scope = new FuncScope(scope, getInfo());
    }
  }
}
