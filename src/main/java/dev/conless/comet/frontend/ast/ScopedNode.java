package dev.conless.comet.frontend.ast;

import dev.conless.comet.utils.scope.BaseScope;

public interface ScopedNode {
  BaseScope getScope();
  void addScope(BaseScope scope);
}
