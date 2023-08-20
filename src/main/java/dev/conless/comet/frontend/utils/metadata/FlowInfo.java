package dev.conless.comet.frontend.utils.metadata;

@lombok.Value
@lombok.EqualsAndHashCode(callSuper = true)
public class FlowInfo extends BaseInfo {
  public FlowInfo(String name) {
    super(name);
  }

  public boolean isLoop() {
    return getName().equals("for") || getName().equals("while");
  }

  @Override
  public String toString() {
    return getName() + "() {}";
  }
}
