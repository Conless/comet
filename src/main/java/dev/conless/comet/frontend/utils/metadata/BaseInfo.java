package dev.conless.comet.frontend.utils.metadata;

@lombok.Getter
@lombok.Setter
public abstract class BaseInfo {
  private String name;

  public BaseInfo(String name) {
    this.name = name;
  }
}
