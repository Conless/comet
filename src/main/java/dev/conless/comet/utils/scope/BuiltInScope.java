package dev.conless.comet.utils.scope;

import dev.conless.comet.utils.BuiltInElements;
import dev.conless.comet.utils.container.Map;
import dev.conless.comet.utils.metadata.ClassInfo;
import dev.conless.comet.utils.metadata.FuncInfo;

public class BuiltInScope extends BaseScope implements BuiltInElements {
  public Map<String, FuncInfo> funcs;
  public Map<String, ClassInfo> classes;

  public BuiltInScope(BaseScope parent) {
    super(parent);
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
