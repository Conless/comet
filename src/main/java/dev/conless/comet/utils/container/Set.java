package dev.conless.comet.utils.container;

public class Set<A> extends java.util.TreeSet<A> {
  public Set() {
  }

  public Set(A first, A... args) {
    super();
    this.add(first);
    for (A arg : args) {
      this.add(arg);
    }
  }
}
