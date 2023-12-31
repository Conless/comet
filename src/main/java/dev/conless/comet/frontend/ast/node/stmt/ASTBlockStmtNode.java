package dev.conless.comet.frontend.ast.node.stmt;

import dev.conless.comet.frontend.ast.ASTVisitor;
import dev.conless.comet.frontend.ast.node.utils.ASTNodeWithScope;
import dev.conless.comet.frontend.utils.metadata.FlowInfo;
import dev.conless.comet.frontend.utils.scope.BaseScope;
import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.error.BaseError;

/**
 * The `BlockStmtNode` class represents a block statement node in an abstract syntax tree (AST) and
 * implements the `ScopedNode` interface.
 */
@lombok.experimental.SuperBuilder
@lombok.Getter
@lombok.EqualsAndHashCode(callSuper = true)
public final class ASTBlockStmtNode extends ASTStmtNode implements ASTNodeWithScope {
  private BaseScope scope;
  private final Array<ASTStmtNode> stmts;

  @Override
  public String toString() {
    indentDepth++;
    String str = "{\n" + stmts.toString("\n");
    indentDepth--;
    str += "\n" + super.toString() + "}";
    return str;
  }

  @Override
  public <T> T accept(ASTVisitor<T> visitor) throws BaseError {
    return visitor.visit(this);
  }

  @Override
  public void addScope(BaseScope scope) {
    if (this.scope == null) {
      this.scope = new BaseScope(scope, new FlowInfo("block"));
    }
  }

  @Override
  public BaseScope getScope() {
    return scope;
  }
}
