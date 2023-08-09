package dev.conless.comet.frontend.utils.metadata;

import lombok.*;

@Value
@EqualsAndHashCode(callSuper = true)
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
