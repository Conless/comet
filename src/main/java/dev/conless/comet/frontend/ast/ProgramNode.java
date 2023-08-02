package dev.conless.comet.frontend.ast;

import dev.conless.comet.frontend.ast.def.*;
import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.container.Position;
import dev.conless.comet.utils.metadata.BaseInfo;
import dev.conless.comet.utils.metadata.ClassInfo;
import dev.conless.comet.utils.metadata.FuncInfo;
import dev.conless.comet.utils.metadata.VarInfo;
import dev.conless.comet.utils.scope.BaseScope;
import dev.conless.comet.utils.scope.GlobalScope;

public class ProgramNode extends ASTNode implements ScopedNode {
  public GlobalScope scope;
  public Array<BaseDefNode> defs;

  public ProgramNode(Position position) {
    super(position);
    this.defs = new Array<BaseDefNode>();
  }

  public void addDef(BaseDefNode def) {
    defs.add(def);
  }

  public Array<BaseDefNode> getDefs() {
    return defs;
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
  public void accept(ASTVisitor visitor) throws Exception {
    visitor.visit(this);
  }

  @Override
  public BaseScope getScope() {
    return scope;
  }

  @Override
  public void addScope(BaseScope scope) {
    this.scope = new GlobalScope();
  }
}
