package dev.conless.comet.frontend.ir.type;

import dev.conless.comet.frontend.ir.entity.IREntity;
import dev.conless.comet.frontend.utils.metadata.TypeInfo;
import dev.conless.comet.frontend.utils.scope.GlobalScope;
import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.error.RuntimeError;
import lombok.*;

@Getter
public class IRType {
  private String typeName;

  public enum Case {
    PARAM,
    CTOR,
    USE
  };

  public IRType(String typeName) {
    this.typeName = typeName;
  }

  public IRType(TypeInfo type, Case caze) {
    if (type.equals(GlobalScope.intType)) {
      this.typeName = "i32";
    } else if (type.equals(GlobalScope.boolType)) {
      this.typeName = "i1";
    } else if (type.equals(GlobalScope.voidType)) {
      this.typeName = "void";
    } else if (type.equals(GlobalScope.stringType)) {
      this.typeName = "ptr";
    } else {
      if (type.getDepth() > 0 || caze.equals(Case.PARAM) || caze.equals(Case.CTOR)) {
        this.typeName = "ptr";
      } else {
        this.typeName = "%class." + type.getName();
      }
    }
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof IRType) {
      return ((IRType) obj).typeName.equals(typeName);
    }
    return false;
  }

  @Override
  public String toString() {
    return typeName;
  }
}
