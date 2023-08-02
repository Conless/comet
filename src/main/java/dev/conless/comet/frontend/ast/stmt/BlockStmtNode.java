package dev.conless.comet.frontend.ast.stmt;

import dev.conless.comet.frontend.ast.ASTVisitor;
import dev.conless.comet.frontend.ast.ScopedNode;
import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.container.Position;
import dev.conless.comet.utils.metadata.BaseInfo;
import dev.conless.comet.utils.scope.BaseScope;

public class BlockStmtNode extends StmtNode implements ScopedNode {
  public BaseScope scope;
  public Array<StmtNode> stmts;
  
  public BlockStmtNode(Position position) {
    super(position);
    stmts = new Array<StmtNode>();
  }

  public void addStmt(StmtNode stmt) {
    stmts.add(stmt);
  }

  public Array<StmtNode> getStmts() {
    return stmts;
  }

  @Override
  public String toString() {
    indentDepth++;
    String str = "{\n" + stmts.toString("\n");
    indentDepth--;
    str += "\n" + super.toString() + "}";
    return str;
  }

  @Override
  public void accept(ASTVisitor visitor) throws Exception {
    visitor.visit(this);
  }

  @Override
  public void addScope(BaseScope scope) {
    scope = new BaseScope(scope, new BaseInfo("block"));
  }

  @Override
  public BaseScope getScope() {
    return scope;
  }
}
