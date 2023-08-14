package dev.conless.comet.frontend.utils;

import dev.conless.comet.frontend.ir.type.IRStructType;
import dev.conless.comet.frontend.ir.type.IRType;
import dev.conless.comet.frontend.ir.type.IRType.Case;
import dev.conless.comet.frontend.utils.metadata.ClassInfo;
import dev.conless.comet.frontend.utils.metadata.FuncInfo;
import dev.conless.comet.frontend.utils.metadata.TypeInfo;
import dev.conless.comet.frontend.utils.scope.GlobalScope;
import dev.conless.comet.utils.container.Array;

public interface BuiltInElements {
  TypeInfo voidType = new TypeInfo("void", 0);
  TypeInfo intType = new TypeInfo("int", 0);
  TypeInfo boolType = new TypeInfo("bool", 0);
  TypeInfo stringType = new TypeInfo("string", 0);
  TypeInfo nullType = new TypeInfo("null", 0);
  TypeInfo thisType = new TypeInfo("this", 0);

  FuncInfo printFunc = new FuncInfo("print", voidType, stringType);
  FuncInfo printlnFunc = new FuncInfo("println", voidType, stringType);
  FuncInfo printIntFunc = new FuncInfo("printInt", voidType, intType);
  FuncInfo printlnIntFunc = new FuncInfo("printlnInt", voidType, intType);
  FuncInfo getStringFunc = new FuncInfo("getString", stringType);
  FuncInfo getIntFunc = new FuncInfo("getInt", intType);
  FuncInfo toStringFunc = new FuncInfo("toString", stringType, intType);
  FuncInfo[] builtInFuncs = { printFunc, printlnFunc, printIntFunc, printlnIntFunc, getStringFunc, getIntFunc,
      toStringFunc };

  FuncInfo arraySizeFunc = new FuncInfo("size", intType);
  FuncInfo stringLengthFunc = new FuncInfo("length", intType);
  FuncInfo stringSubstringFunc = new FuncInfo("substring", stringType, intType, intType);
  FuncInfo stringParseintFunc = new FuncInfo("parseInt", intType);
  FuncInfo stringOrdFunc = new FuncInfo("ord", intType, intType);
  
  ClassInfo intClass = new ClassInfo("int");
  ClassInfo boolClass = new ClassInfo("bool");
  ClassInfo stringClass = new ClassInfo("string", stringLengthFunc, stringSubstringFunc, stringParseintFunc, stringOrdFunc);
  ClassInfo[] builtInClasses = { intClass, boolClass, stringClass };

  // // ------------------ IR Builtin Types ------------------

  IRType irVoidType = new IRType(GlobalScope.voidType, Case.CTOR);
  IRType irIntType = new IRType(GlobalScope.intType, Case.CTOR);
  IRType irBoolType = new IRType(GlobalScope.boolType, Case.CTOR);
  IRType irPtrType = new IRType("ptr", 1);

  // IRType irNullType = new IRPtrType(irvoidType);
  // IRType irBoolType = new IRintType(8), irCharType = irBoolType;
  // IRType irCondType = new IRintType(1);
  // IRType irstringType = new IRPtrType(irCharType);

  // // ------------------ IR Builtin Constants ------------------

  // IRvoidConst irvoidConst = new IRvoidConst();
  // IRCondConst irTrueConst = new IRCondConst(true);
  // IRCondConst irFalseConst = new IRCondConst(false);
  // IRBoolConst irBoolTrueConst = new IRBoolConst(true);
  // IRBoolConst irBoolFalseConst = new IRBoolConst(false);
  // IRintConst irintConst0 = new IRintConst(0);
  // IRintConst irintConst1 = new IRintConst(1);
  // IRintConst irintConstn1 = new IRintConst(-1);
  // IRintConst irintConst4 = new IRintConst(4);
}