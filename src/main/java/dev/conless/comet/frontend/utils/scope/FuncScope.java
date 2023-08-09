package dev.conless.comet.frontend.utils.scope;

import dev.conless.comet.frontend.utils.metadata.BaseInfo;
import lombok.*;

@Getter
@Setter
public class FuncScope extends BaseScope {
  private Boolean isExited;

  public FuncScope(BaseScope parent, BaseInfo info) {
    super(parent, info);
    this.isExited = false;
  }
}
