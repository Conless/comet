package dev.conless.comet.frontend.utils.scope;

import dev.conless.comet.frontend.utils.metadata.BaseInfo;

@lombok.Getter
@lombok.Setter
public class LoopScope extends BaseScope {
  private int loopCount;

  public LoopScope(BaseScope parent, BaseInfo info) {
    super(parent, info);
  }
}
