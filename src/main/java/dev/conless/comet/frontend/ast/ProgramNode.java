package dev.conless.comet.frontend.ast;

import dev.conless.comet.frontend.ast.def.*;
import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.error.BaseError;
import dev.conless.comet.utils.scope.BaseScope;
import dev.conless.comet.utils.scope.GlobalScope;
import lombok.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
public final class ProgramNode extends ASTNode implements ScopedNode {
  public GlobalScope globalScope;
  public final Array<BaseDefNode> defs;

  public void addDef(BaseDefNode def) {
    defs.add(def);
  }

  @Override
  public String toString() {
    String str = "";
    for (ASTNode def : defs) {
      str += def.toString();
      if (def instanceof ClassDefNode || def instanceof VarDefNode) {
        str += ";\n";
      } else {
        str += "\n";
      }
    }
    return str;
  }

  @Override
  public void accept(ASTVisitor visitor) throws BaseError {
    visitor.visit(this);
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
