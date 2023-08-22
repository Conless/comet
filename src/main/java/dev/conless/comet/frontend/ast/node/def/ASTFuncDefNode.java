package dev.conless.comet.frontend.ast.node.def;

import dev.conless.comet.frontend.ast.ASTVisitor;
import dev.conless.comet.frontend.ast.node.stmt.ASTBlockStmtNode;
import dev.conless.comet.frontend.ast.node.stmt.ASTStmtNode;
import dev.conless.comet.frontend.ast.node.utils.ASTNodeWithScope;
import dev.conless.comet.frontend.utils.metadata.FuncInfo;
import dev.conless.comet.frontend.utils.metadata.TypeInfo;
import dev.conless.comet.frontend.utils.scope.BaseScope;
import dev.conless.comet.frontend.utils.scope.FuncScope;
import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.error.BaseError;

/**
 * The `FuncDefNode` class represents a function definition node in an abstract syntax tree, with
 * properties such as scope, parameters, and a blocked body.
 */
@lombok.experimental.SuperBuilder
@lombok.Getter
@lombok.Setter
public final class ASTFuncDefNode extends ASTDefNode implements ASTNodeWithScope {
  private FuncScope scope;
  private final Array<ASTVarDefNode> params;
  private final ASTBlockStmtNode blockedBody;
  
  public TypeInfo getReturnType() {
    return ((FuncInfo) getInfo()).getType();
  }

  public Array<ASTStmtNode> getBody() {
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
