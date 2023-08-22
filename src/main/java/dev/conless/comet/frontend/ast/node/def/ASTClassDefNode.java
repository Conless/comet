package dev.conless.comet.frontend.ast.node.def;

import dev.conless.comet.frontend.ast.ASTVisitor;
import dev.conless.comet.frontend.ast.node.stmt.ASTStmtNode;
import dev.conless.comet.frontend.ast.node.utils.ASTNodeWithScope;
import dev.conless.comet.frontend.utils.metadata.ClassInfo;
import dev.conless.comet.frontend.utils.scope.BaseScope;
import dev.conless.comet.frontend.utils.scope.ClassScope;
import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.error.BaseError;

/**
 * The ClassDefNode class represents a class definition in Mx* programming language and contains
 * information about the class, its variables, and its functions.
 */
@lombok.experimental.SuperBuilder
@lombok.Getter
@lombok.Setter
public final class ASTClassDefNode extends ASTDefNode implements ASTNodeWithScope {
  private ClassScope classScope;
  private final ASTFuncDefNode constructor;
  private final Array<ASTVarDefNode> varDefs;
  private final Array<ASTFuncDefNode> funcDefs;

  @Override
  public String toString() {
    String str = "class " + getInfo().getName() + " {\n";
    ASTStmtNode.indentDepth++;
    if (constructor != null) {
      str += "  " + constructor.toString() + "\n";
    }
    str += varDefs.toString("  ", "\n", "\n");
    str += funcDefs.toString("  ", "\n");
    ASTStmtNode.indentDepth--;
    str += "\n};";
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
