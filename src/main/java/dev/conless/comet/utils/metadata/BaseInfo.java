package dev.conless.comet.utils.metadata;

public class BaseInfo {
  public String name;

  public BaseInfo(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public String toString() {
    return name + ";";
  }
}
