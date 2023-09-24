package dev.conless.comet.backend.asm.entity;

@lombok.Getter
public class ASMVirtualReg extends ASMReg implements Comparable<ASMVirtualReg> {
  private static int count = 0;

  public ASMVirtualReg() {
    super(String.valueOf(count++));
  }

  public static int getCount() {
    return count;
  }

  public static void resetCount() {
    count = 0;
  }

  public int getID() {
    return Integer.parseInt(this.getName());
  }

  @Override
  public String toString() {
    return "%" + getName();
  }

  @Override
  public int compareTo(ASMVirtualReg o) {
    return this.getID() - o.getID();
  }
}
