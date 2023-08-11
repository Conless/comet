package dev.conless.comet.frontend.utils.metadata;

import lombok.*;

@Getter
@Setter
public abstract class BaseInfo {
  private String name;

  public BaseInfo(String name) {
    this.name = name;
  }
}
