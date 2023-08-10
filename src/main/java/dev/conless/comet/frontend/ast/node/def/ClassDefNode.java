package dev.conless.comet.frontend.ast.node.def;

import dev.conless.comet.frontend.ast.ASTVisitor;
import dev.conless.comet.frontend.ast.node.ScopedNode;
import dev.conless.comet.frontend.utils.metadata.ClassInfo;
import dev.conless.comet.frontend.utils.scope.BaseScope;
import dev.conless.comet.frontend.utils.scope.ClassScope;
import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.error.BaseError;
import lombok.experimental.SuperBuilder;
import lombok.Getter;
import lombok.Setter;

/**
 * The ClassDefNode class represents a class definition in Mx* programming language and contains
 * information about the class, its variables, and its functions.
 */
@SuperBuilder
@Getter
@Setter
public final class ClassDefNode extends BaseDefNode implements ScopedNode {
  private ClassScope classScope;
  private final FuncDefNode constructor;
  private final Array<VarDefNode> varDefs;
  private final Array<FuncDefNode> funcDefs;

  @Override
  public String toString() {
    String str = "class " + getInfo().getName() + " {\n";
    if (constructor != null) {
      String ctorString = constructor.toString();
      str += "  " + ctorString.replace("\n", "\n  ") + "\n";
    }
    str += varDefs.toString("  ", ";\n", ";\n");
    if (funcDefs.size() > 0) {
      String funcStr = funcDefs.toString("  ", "\n");
      funcStr = funcStr.replace("\n", "\n  ");
      str += funcStr + "\n";
    }
    str += "}";
    return str;
  }

  @Override
  public <T> T accept(ASTVisitor<T> visitor) throws BaseError {
    return visitor.visit(this);
  }

  @Override
  public void addScope(BaseScope scope) {
    if (this.classScope == null) {
      this.classScope = new ClassScope(scope, (ClassInfo) getInfo());
    }
  }

  @Override
  public BaseScope getScope() {
    return getClassScope();
  }
}
