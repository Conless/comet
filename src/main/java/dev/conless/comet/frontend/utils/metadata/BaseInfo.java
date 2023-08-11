package dev.conless.comet.frontend.utils.metadata;

import lombok.Getter;

@Getter
public abstract class BaseInfo {
  private final String name;

  public BaseInfo(String name) {
    this.name = name;
  }
}