package dev.conless.comet.utils.scope;

public class GlobalScope extends BuiltInScope {
  public GlobalScope() {
    super(null);
  }

  public String toString() {
    String str = "";
    for (var func : funcs.values()) {
      str += func.toString() + "\n";
    }
    for (var class_ : classes.values()) {
      str += class_.toString() + "\n";
    }
    return str;
  }
}
