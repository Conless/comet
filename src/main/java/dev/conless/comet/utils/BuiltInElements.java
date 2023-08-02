package dev.conless.comet.utils;

import java.util.ArrayList;
import java.util.Arrays;

import dev.conless.comet.utils.metadata.ClassInfo;
import dev.conless.comet.utils.metadata.FuncInfo;
import dev.conless.comet.utils.metadata.TypeInfo;

public interface BuiltInElements {
  TypeInfo voidType = new TypeInfo("void", 0);
  TypeInfo intType = new TypeInfo("int", 0);
  TypeInfo boolType = new TypeInfo("bool", 0);
  TypeInfo stringType = new TypeInfo("string", 0);
  TypeInfo nullType = new TypeInfo("null", 0);
  TypeInfo thisType = new TypeInfo("this", 0);

  FuncInfo printFunc = new FuncInfo("print", voidType, Arrays.asList(stringType));
  FuncInfo printlnFunc = new FuncInfo("println", voidType, Arrays.asList(stringType));
  FuncInfo printIntFunc = new FuncInfo("printInt", voidType, Arrays.asList(intType));
  FuncInfo printlnIntFunc = new FuncInfo("printlnInt", voidType, Arrays.asList(intType));
  FuncInfo getStringFunc = new FuncInfo("getString", stringType);
  FuncInfo getIntFunc = new FuncInfo("getInt", intType);
  FuncInfo toStringFunc = new FuncInfo("toString", stringType, Arrays.asList(intType));
  FuncInfo[] builtInFuncs = { printFunc, printlnFunc, printIntFunc, printlnIntFunc, getStringFunc, getIntFunc,
      toStringFunc };

  FuncInfo stringLengthFunc = new FuncInfo("length", intType);
  FuncInfo stringSubstringFunc = new FuncInfo("substring", stringType, Arrays.asList(intType, intType));
  FuncInfo stringParseintFunc = new FuncInfo("parseInt", intType);
  FuncInfo stringOrdFunc = new FuncInfo("ord", intType, Arrays.asList(intType));
  
  ClassInfo voidClass = new ClassInfo("void");
  ClassInfo intClass = new ClassInfo("int");
  ClassInfo boolClass = new ClassInfo("bool");
  ClassInfo stringClass = new ClassInfo("string", Arrays.asList(),
      Arrays.asList(stringLengthFunc, stringSubstringFunc, stringParseintFunc, stringOrdFunc));
  ClassInfo nullClass = new ClassInfo("null");
  ClassInfo thisClass = new ClassInfo("this");
  ClassInfo[] builtInClasses = { voidClass, intClass, boolClass, stringClass, nullClass, thisClass };

  // FuncInfo stringLengthFunc = new FuncInfo(null, intType, "length", "string", null, 0);
  // FuncInfo stringSubstringFunc = new FuncInfo(null, stringType, "substring", "string", intType, 2);
  // FuncInfo stringParseintFunc = new FuncInfo(null, intType, "parseint", "string", null, 0);
  // FuncInfo stringOrdFunc = new FuncInfo(null, intType, "ord", "string", intType, 1);

  // FuncInfo ArraySizeFunc = new FuncInfo(null, intType, "size", null, 0);

  // // ------------------ IR Builtin Types ------------------

  // IRType irvoidType = new IRvoidType();
  // IRType irintType = new IRintType(32);
  // IRType irintPtrType = new IRPtrType(irintType);
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