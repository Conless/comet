package dev.conless.comet.backend.asm;

import dev.conless.comet.backend.asm.entity.ASMAddress;
import dev.conless.comet.utils.container.Map;

public class ASMCounter {
  public static int funcCount = 0;
  public int stackCount = 0;
  public Map<String, ASMAddress> offsetMap = new Map<>();

}
