package dev.conless.comet.utils.scope;

import dev.conless.comet.utils.BuiltInElements;
import dev.conless.comet.utils.container.Map;
import dev.conless.comet.utils.metadata.ClassInfo;
import dev.conless.comet.utils.metadata.FlowInfo;
import dev.conless.comet.utils.metadata.FuncInfo;

public class BuiltInScope extends BaseScope implements BuiltInElements {
  Map<String, FuncInfo> funcs;
  Map<String, ClassInfo> classes;

  public BuiltInScope(BaseScope parent) {
    super(parent, new FlowInfo("built-in"));
    funcs = new Map<String, FuncInfo>();
    classes = new Map<String, ClassInfo>();
    for (FuncInfo func : builtInFuncs) {
      funcs.put(func.getName(), func);
    }
    for (ClassInfo classInfo : builtInClasses) {
      classes.put(classInfo.getName(), classInfo);
    }
  }
}
