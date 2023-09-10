package dev.conless.comet.utils.container;

import java.util.TreeMap;

public class Map<A, B> extends TreeMap<A, B> {
  public Map<A, B> clone() {
    var ret = new Map<A, B>();
    for (var entry : this.entrySet()) {
      ret.put(entry.getKey(), entry.getValue());
    }
    return ret;
  }
}
