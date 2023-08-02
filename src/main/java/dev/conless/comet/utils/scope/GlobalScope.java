package dev.conless.comet.utils.scope;

import dev.conless.comet.utils.container.*;
import dev.conless.comet.utils.metadata.*;

public class GlobalScope extends BuiltInScope {
  public GlobalScope() {
    super(null);
    vars = new Map<String, VarInfo>();
  }
}
