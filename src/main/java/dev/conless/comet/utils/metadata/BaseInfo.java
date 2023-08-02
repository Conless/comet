package dev.conless.comet.utils.metadata;

public class BaseInfo {
  public String name;

  public BaseInfo(String name) {
    this.name = name;
  }

  public String name() {
    return name;
  }

  public String toString() {
    throw new RuntimeException("BaseInfo.toString() called");
  }
}
