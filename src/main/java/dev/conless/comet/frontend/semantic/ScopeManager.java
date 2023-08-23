package dev.conless.comet.frontend.semantic;

import dev.conless.comet.frontend.utils.metadata.TypeInfo;
import dev.conless.comet.frontend.utils.scope.BaseScope;
import dev.conless.comet.frontend.utils.scope.GlobalScope;
import dev.conless.comet.utils.container.Array;

public class ScopeManager {
  protected GlobalScope globalScope;
  protected BaseScope currentScope;

  protected int depth;
  protected Array<Integer> counter;

  public void enterScope(BaseScope scope) {
    if (globalScope == null) {
      globalScope = (GlobalScope) scope;
    }
    currentScope = scope;
  }

  public void exitScope() {
    currentScope = currentScope.getParent();
  }

  public boolean checkTypeValid(TypeInfo type) {
    return (type.isBuiltIn() && (type.getName().equals("int") || type.getName().equals("string") || type.getName().equals("bool"))) || globalScope.get(type.getName(), "class") != null;
  }
}
