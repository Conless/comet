parser grammar MxParser;
options {
	tokenVocab = MxLexer;
}

@header {package dev.conless.comet.frontend.grammar;}

program: (variableDefinition | classDefinition | functionDefinition)* EOF;

typeName
  : type = (Int | Bool | String | Void)                                   # builtInType
  | type = Identifier                                                     # customType
  | typeName '[' ']'                                                      # arrayType
  ;

expression
  : New typeName                                                          # newExpression
  
  // Expressions that MAY result with lvalue
  | '(' expression ')'                                                    # subExpression
  | varibleName=Identifier                                                # variableExpression
  | functionName=Identifier '(' functionArgList? ')'                      # functionExpression
  | expression '[' expression ']'                                         # indexAccessExpression
  | expression '.' memberName=Identifier                                  # memberAccessExpression
  | expression '.' methodName=Identifier '(' functionArgList? ')'         # methodAccessExpression 

  // Unary expressions that result with rvalue
  | <assoc=right> expression op=(SelfAdd | SelfSub)                       # unaryArithExpression
  | <assoc=right> op=(LogicNot | BitNot | Add | Sub) expression           # unaryArithExpression

  // Prefix self operation
  | op=(SelfAdd | SelfSub) expression                                     # preSelfExpression

  // Binary expressions that results with rvalue
  | expression op=(Mul | Div | Mod) expression                            # binaryArithExpression
  | expression op=(Add | Sub) expression                                  # binaryArithExpression
  | expression op=(BitLShift | BitRShift) expression                      # binaryArithExpression
  | expression op=(Less | Greater | LessEqual | GreaterEqual) expression  # binaryArithExpression
  | expression op=(Eqaul | NotEqual) expression                           # binaryArithExpression
  | expression op=BitAnd expression                                       # binaryArithExpression
  | expression op=BitXor expression                                       # binaryArithExpression
  | expression op=BitOr expression                                        # binaryArithExpression
  | expression op=LogicAnd                                                # binaryArithExpression
  | expression op=LogicOr                                                 # binaryArithExpression

  // Conditionall expression
  | expression '?' expression ':' expression                              # conditionalExpression

  // Assignment expressions, requires lvalue and results with lvalue
  | expression op=(Assign | AddAssign | SubAssign | MulAssign | DivAssign 
                  | ModAssign | AndAssign | XorAssign | OrAssign 
                  | BitLShiftAssign | BitRShiftAssign) expression         # assignExpression

  | value=(IntegerConst | StringConst | True | False | Null
          | Identifier | This)                                            # atomExpression
  ;

variableDefinition: typeName variableConstructor (',' variableConstructor)*;
variableConstructor: varName=Identifier ('=' expression)?;

classDefinition: Class className=Identifier '{' (variableDefinition | functionDefinition | classConstructor)* '}';
classConstructor: className=Identifier '(' ')' suite;

functionDefinition: returnType funcName=Identifier '(' functionParaList? ')' suite;
functionParaList: typeName variableConstructor (',' typeName variableConstructor)*;
functionArgList: expression (',' expression)*;
returnType: typeName;


suite: '{' statement* '}';
statement
  : suite
  | variableDefinition
  | ifStatement | forStatement | whileStatement
  | continueStatement | breakStatement | returnStatement
  | expressionStatement
  ;

ifStatement: If '(' expression ')' statement (Else statement)?;
forInitStatement: variableDefinition | expressionStatement;
forStatement: For '(' init=forInitStatement condition=expressionStatement expression? ')' statement;
whileStatement: While '(' condition=expression ')' statement;

continueStatement: Continue ';';
breakStatement: Break ';';
returnStatement: Return expression ';';

expressionStatement: expression? ()';';