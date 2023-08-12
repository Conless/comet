package dev.conless.comet.frontend.ast.node.global;

import dev.conless.comet.frontend.utils.scope.BaseScope;

public interface ScopedNode {
  BaseScope getScope();
  void addScope(BaseScope scope);
}
