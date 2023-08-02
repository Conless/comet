package dev.conless.comet.utils.scope;

import dev.conless.comet.utils.BuiltInElements;
import dev.conless.comet.utils.container.Map;
import dev.conless.comet.utils.metadata.ClassInfo;
import dev.conless.comet.utils.metadata.BaseInfo;
import dev.conless.comet.utils.metadata.FuncInfo;

public class BuiltInScope extends BaseScope implements BuiltInElements {
  Map<String, FuncInfo> funcs;
  Map<String, ClassInfo> classes;

  public BuiltInScope(BaseScope parent) {
    super(parent, new BaseInfo("built-in"));
    funcs = new Map<String, FuncInfo>();
    classes = new Map<String, ClassInfo>();
    for (FuncInfo func : builtInFuncs) {
      funcs.put(func.name, func);
    }
    for (ClassInfo class_ : builtInClasses) {
      classes.put(class_.name, class_);
    }
  }
}
