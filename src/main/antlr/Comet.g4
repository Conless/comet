parser grammar Comet;
options {
	tokenVocab = Meteor;
}

@header {package dev.conless.comet.frontend.grammar;}

program: ((varDef ';') | (classDef ';') | funcDef)* EOF;

typeName
  : type = (Int | Bool | String | Void)                                   # builtInType
  | type = Identifier                                                     # customType
  | typeName '[' ']'                                                      # arrayType
  ;

expr
  : New typeName ('(' ')')?                                               # newExpr
  
  // Exprs that MAY result with lvalue
  | '(' expr ')'                                                    # parenExpr
  | varName=Identifier                                                # varExpr
  | expr '.' varName=Identifier                                  # varExpr
  | funcName=Identifier '(' funcArgList? ')'                      # callExpr
  | expr '.' funcName=Identifier '(' funcArgList? ')'         # callExpr 
  | expr '[' expr ']'                                         # indexExpr

  // Unary exprs that result with rvalue
  | <assoc=right> expr op=(SelfAdd | SelfSub)                       # unaryArithExpr
  | <assoc=right> op=(LogicNot | BitNot | Add | Sub) expr           # unaryArithExpr

  // Prefix self operation
  | op=(SelfAdd | SelfSub) expr                                     # preSelfExpr

  // Binary exprs that results with rvalue
  | expr op=(Mul | Div | Mod) expr                            # binaryArithExpr
  | expr op=(Add | Sub) expr                                  # binaryArithExpr
  | expr op=(BitLShift | BitRShift) expr                      # binaryArithExpr
  | expr op=(Less | Greater | LessEqual | GreaterEqual) expr  # binaryArithExpr
  | expr op=(Eqaul | NotEqual) expr                           # binaryArithExpr
  | expr op=BitAnd expr                                       # binaryArithExpr
  | expr op=BitXor expr                                       # binaryArithExpr
  | expr op=BitOr expr                                        # binaryArithExpr
  | expr op=LogicAnd expr                                     # binaryArithExpr
  | expr op=LogicOr expr                                      # binaryArithExpr

  // Conditionall expr
  | expr '?' expr ':' expr                              # conditionalExpr

  // Assignment exprs, requires lvalue and results with lvalue
  | expr op=(Assign | AddAssign | SubAssign | MulAssign | DivAssign 
                  | ModAssign | AndAssign | XorAssign | OrAssign 
                  | BitLShiftAssign | BitRShiftAssign) expr         # assignExpr

  | value=(IntegerConst | StringConst | True | False | Null
          | Identifier | This)                                            # atomExpr
  ;

varDef: typeName varCtor (',' varCtor)*;
varCtor: varName=Identifier ('=' expr)?;

classDef: Class className=Identifier '{' ((varDef ';')| funcDef | classCtor)* '}';
classCtor: className=Identifier '(' ')' blockStmt;

funcDef: returnType funcName=Identifier '(' funcParaList? ')' blockStmt;
funcParaList: typeName varCtor (',' typeName varCtor)*;
funcArgList: expr (',' expr)*;
returnType: typeName;

blockStmt: '{' stmt* '}';
stmt
  : blockStmt
  | ifStmt
  | forStmt
  | whileStmt
  | varDef ';'
  | classDef ';'
  | continueStmt ';'
  | breakStmt ';'
  | returnStmt ';'
  | exprStmt ';'
  | ';'
  ;

ifStmt: If '(' expr ')' stmt (Else stmt)?;
forStmt: For '(' init=stmt condition=stmt update=exprStmt?')' stmt;
whileStmt: While '(' condition=expr ')' stmt;

continueStmt: Continue;
breakStmt: Break;
returnStmt: Return expr?;

exprStmt: expr (',' expr)*;