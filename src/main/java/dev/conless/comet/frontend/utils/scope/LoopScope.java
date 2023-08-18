package dev.conless.comet.frontend.utils.scope;

import dev.conless.comet.frontend.utils.metadata.BaseInfo;
import lombok.*;

@Getter
@Setter
public class LoopScope extends BaseScope {
  private Integer loopCount;

  public LoopScope(BaseScope parent, BaseInfo info) {
    super(parent, info);
  }
}
