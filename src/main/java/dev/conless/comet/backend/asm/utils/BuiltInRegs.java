package dev.conless.comet.backend.asm.utils;

import dev.conless.comet.backend.asm.entity.ASMPhysicalReg;
import dev.conless.comet.utils.container.Array;

@lombok.Getter
public class BuiltInRegs {
  private final ASMPhysicalReg zero = new ASMPhysicalReg("zero");
  private final ASMPhysicalReg ra = new ASMPhysicalReg("ra");
  private final ASMPhysicalReg sp = new ASMPhysicalReg("sp");
  private final ASMPhysicalReg gp = new ASMPhysicalReg("gp");
  private final ASMPhysicalReg tp = new ASMPhysicalReg("tp");
  private final ASMPhysicalReg t0 = new ASMPhysicalReg("t0");
  private final ASMPhysicalReg t1 = new ASMPhysicalReg("t1");
  private final ASMPhysicalReg t2 = new ASMPhysicalReg("t2");
  private final ASMPhysicalReg s0 = new ASMPhysicalReg("s0");
  private final ASMPhysicalReg s1 = new ASMPhysicalReg("s1");
  private final ASMPhysicalReg a0 = new ASMPhysicalReg("a0");
  private final ASMPhysicalReg a1 = new ASMPhysicalReg("a1");
  private final ASMPhysicalReg a2 = new ASMPhysicalReg("a2");
  private final ASMPhysicalReg a3 = new ASMPhysicalReg("a3");
  private final ASMPhysicalReg a4 = new ASMPhysicalReg("a4");
  private final ASMPhysicalReg a5 = new ASMPhysicalReg("a5");
  private final ASMPhysicalReg a6 = new ASMPhysicalReg("a6");
  private final ASMPhysicalReg a7 = new ASMPhysicalReg("a7");
  private final ASMPhysicalReg s2 = new ASMPhysicalReg("s2");
  private final ASMPhysicalReg s3 = new ASMPhysicalReg("s3");
  private final ASMPhysicalReg s4 = new ASMPhysicalReg("s4");
  private final ASMPhysicalReg s5 = new ASMPhysicalReg("s5");
  private final ASMPhysicalReg s6 = new ASMPhysicalReg("s6");
  private final ASMPhysicalReg s7 = new ASMPhysicalReg("s7");
  private final ASMPhysicalReg s8 = new ASMPhysicalReg("s8");
  private final ASMPhysicalReg s9 = new ASMPhysicalReg("s9");
  private final ASMPhysicalReg s10 = new ASMPhysicalReg("s10");
  private final ASMPhysicalReg s11 = new ASMPhysicalReg("s11");
  private final ASMPhysicalReg t3 = new ASMPhysicalReg("t3");
  private final ASMPhysicalReg t4 = new ASMPhysicalReg("t4");
  private final ASMPhysicalReg t5 = new ASMPhysicalReg("t5");
  private final ASMPhysicalReg t6 = new ASMPhysicalReg("t6");

  private final Array<ASMPhysicalReg> argRegs = new Array<ASMPhysicalReg>(a0, a1, a2, a3, a4, a5, a6, a7);
  private final Array<ASMPhysicalReg> tempRegs = new Array<ASMPhysicalReg>(t0, t1, t2);
  private final Array<ASMPhysicalReg> freeRegs = new Array<>(s0, s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, t3, t4, t5, t6, s9, s10, s11);
}
