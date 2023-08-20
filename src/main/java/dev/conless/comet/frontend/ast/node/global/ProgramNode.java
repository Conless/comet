package dev.conless.comet.frontend.ast.node.global;

import dev.conless.comet.frontend.ast.ASTVisitor;
import dev.conless.comet.frontend.ast.node.ASTNode;
import dev.conless.comet.frontend.ast.node.def.*;
import dev.conless.comet.frontend.utils.scope.BaseScope;
import dev.conless.comet.frontend.utils.scope.GlobalScope;
import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.error.BaseError;

@lombok.experimental.SuperBuilder
@lombok.Getter
@lombok.Setter
public final class ProgramNode extends ASTNode implements NodeWithScope {
  public GlobalScope globalScope;
  public final Array<BaseDefNode> defs;

  public void addDef(BaseDefNode def) {
    defs.add(def);
  }

  @Override
  public String toString() {
    String str = defs.toString("\n");
    return str;
  }

  @Override
  public <T> T accept(ASTVisitor<T> visitor) throws BaseError {
    return visitor.visit(this);
  }

  @Override
  public BaseScope getScope() {
    return getGlobalScope();
  }

  @Override
  public void addScope(BaseScope scope) {
    if (this.globalScope == null) {
      this.globalScope = new GlobalScope();
    }
  }
}
