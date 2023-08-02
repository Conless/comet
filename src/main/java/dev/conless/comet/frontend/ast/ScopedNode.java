package dev.conless.comet.frontend.ast;

import dev.conless.comet.utils.metadata.BaseInfo;
import dev.conless.comet.utils.scope.BaseScope;

public interface ScopedNode {
  void addScope(BaseScope scope);
  void declare(BaseInfo info);
  BaseInfo get(String name);
  BaseInfo getRecur(String name);
}
