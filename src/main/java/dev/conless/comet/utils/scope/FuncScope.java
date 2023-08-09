package dev.conless.comet.utils.scope;

import dev.conless.comet.utils.metadata.BaseInfo;

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
