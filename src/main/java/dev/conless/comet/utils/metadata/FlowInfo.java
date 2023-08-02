package dev.conless.comet.utils.metadata;

public class FlowInfo extends BaseInfo {
  public FlowInfo(String name) {
    super(name);
  }

  public boolean isLoop() {
    return name.equals("for") || name.equals("while");
  }

  @Override
  public String toString() {
    return name + "() {}";
  }
}
