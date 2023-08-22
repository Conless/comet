package dev.conless.comet.frontend.ast.node.utils;

import dev.conless.comet.frontend.utils.scope.BaseScope;

public interface ASTNodeWithScope {
  BaseScope getScope();
  void addScope(BaseScope scope);
}
