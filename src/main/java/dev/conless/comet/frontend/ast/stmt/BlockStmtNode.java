package dev.conless.comet.frontend.ast.stmt;

import dev.conless.comet.frontend.ast.ASTVisitor;
import dev.conless.comet.frontend.ast.ScopedNode;
import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.error.BaseError;
import dev.conless.comet.utils.metadata.FlowInfo;
import dev.conless.comet.utils.scope.BaseScope;

import lombok.experimental.SuperBuilder;
import lombok.Getter;
import lombok.EqualsAndHashCode;

/**
 * The `BlockStmtNode` class represents a block statement node in an abstract syntax tree (AST) and
 * implements the `ScopedNode` interface.
 */
@SuperBuilder
@Getter
@EqualsAndHashCode(callSuper = true)
public final class BlockStmtNode extends StmtNode implements ScopedNode {
  private BaseScope scope;
  private final Array<StmtNode> stmts;

  @Override
  public String toString() {
    indentDepth++;
    String str = "{\n" + stmts.toString("\n");
    indentDepth--;
    str += "\n" + super.toString() + "}";
    return str;
  }

  @Override
  public void accept(ASTVisitor visitor) throws BaseError {
    visitor.visit(this);
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
