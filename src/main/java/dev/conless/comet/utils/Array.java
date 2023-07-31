package dev.conless.comet.utils;

import java.util.ArrayList;

public class Array<E> extends ArrayList<E> {
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
