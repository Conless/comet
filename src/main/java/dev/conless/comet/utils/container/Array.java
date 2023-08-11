package dev.conless.comet.utils.container;

import java.util.ArrayList;

public class Array<E> extends ArrayList<E> {
  public Array() {
    super();
  }

  public Array(Array<E> tags) {
    super((ArrayList<E>) tags);
  }

  public Array(E firstTag, E... tags) {
    super();
    for (E tag : tags) {
      this.add(tag);
    }
  }

  public String toString(String separator) {
    String str = "";
    boolean first = true;
    for (E e : this) {
      if (first) {
        first = false;
      } else {
        str += separator;
      }
      str += e.toString();
    }
    return str;
  }
  public String toString(String prefix, String separator) {
    String str = "";
    boolean first = true;
    for (E e : this) {
      if (first) {
        first = false;
      } else {
        str += separator;
      }
      str += prefix + e.toString();
    }
    return str;
  }

  public String toString(String prefix, String separator, String suffix) {
    if (this.size() == 0) {
      return "";
    }
    String str = "";
    boolean first = true;
    for (E e : this) {
      if (first) {
        first = false;
      } else {
        str += separator;
      }
      str += prefix + e.toString();
    }
    return str + suffix;
  }
}
