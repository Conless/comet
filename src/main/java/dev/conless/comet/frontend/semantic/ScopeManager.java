package dev.conless.comet.frontend.semantic;

import dev.conless.comet.utils.metadata.TypeInfo;
import dev.conless.comet.utils.scope.BaseScope;
import dev.conless.comet.utils.scope.GlobalScope;

public class ScopeManager {
  public GlobalScope globalScope;
  public BaseScope currentScope;

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
    return type.isBuiltIn || globalScope.get(type.getName(), "class") != null;
  }
}
