package dev.conless.comet.frontend.semantic;

import dev.conless.comet.utils.scope.BaseScope;
import dev.conless.comet.utils.scope.GlobalScope;

public class ScopeManager {
  public static GlobalScope globalScope;
  public static BaseScope currentScope;

  public static void enterScope(BaseScope scope) {
    if (globalScope == null) {
      globalScope = (GlobalScope) scope;
    }
    currentScope = scope;
  }

  public static void exitScope() {
    currentScope = currentScope.getParent();
  }
}
