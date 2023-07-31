parser grammar Comet;
options {
	tokenVocab = Meteor;
}

@header {package dev.conless.comet.frontend.grammar;}

program: ((varDef ';') | (classDef ';') | funcDef)* EOF;

type:
  Int
  | Bool
  | String
  | Void
  | Identifier
  ;
typeName: type ('[' ']')*;

expr:
	New type ('[' expr ']')* ('[' ']')* ('(' ')')?              										# newExpr

	// Exprs that MAY result with lvalue
	| '(' expr ')'											                        										# parenExpr
	| expr '.' member = Identifier							                										# memberExpr
	| expr '(' funcArgList? ')'			                            										# callExpr
	| expr '[' expr ']'										                      										# indexExpr

	// Unary exprs
	| expr op = (SelfAdd | SelfSub)				      																		# postUnaryExpr
	| <assoc = right> op = (SelfAdd | SelfSub | LogicNot | BitNot | Add | Sub) expr	# preUnaryExpr

	// Binary exprs that results with rvalue
	| expr op = (Mul | Div | Mod) expr								          										# binaryExpr
	| expr op = (Add | Sub) expr									              										# binaryExpr
	| expr op = (BitLShift | BitRShift) expr						        										# binaryExpr
	| expr op = (Less | Greater | LessEqual | GreaterEqual) expr										# binaryExpr
	| expr op = (Eqaul | NotEqual) expr								          										# binaryExpr
	| expr op = BitAnd expr											                										# binaryExpr
	| expr op = BitXor expr											                										# binaryExpr
	| expr op = BitOr expr											                										# binaryExpr
	| expr op = LogicAnd expr										                										# binaryExpr
	| expr op = LogicOr expr										                										# binaryExpr

	// Conditional expr
	| expr '?' expr ':' expr                                    										# conditionalExpr

	// Assignment exprs, requires lvalue and results with lvalue
	| expr op = (
		Assign
		| AddAssign
		| SubAssign
		| MulAssign
		| DivAssign
		| ModAssign
		| AndAssign
		| XorAssign
		| OrAssign
		| BitLShiftAssign
		| BitRShiftAssign
	) expr                                                       										# assignExpr
	| value = (
		IntegerConst
		| StringConst
		| True
		| False
		| Null
		| Identifier
		| This
	)                                                            										# atomExpr
  ;

varDef: typeName varConstructor (',' varConstructor)*;
varConstructor: name = Identifier ('=' expr)?;

classDef:
	Class name = Identifier '{' (
		(varDef ';')
		| funcDef
		| classConstructor
	)* '}';
classConstructor: name = Identifier '(' ')' blockStmt;

funcDef:
	typeName name = Identifier '(' funcParamList? ')' blockStmt;
funcParamList: funcParam (',' funcParam)*;
funcParam: typeName varConstructor;
funcArgList: expr (',' expr)*;

blockStmt: '{' stmt* '}';
stmt:
	blockStmt
	| ifStmt
	| forStmt
	| whileStmt
	| continueStmt ';'
	| breakStmt ';'
	| returnStmt ';'
	| exprStmt ';'
	| varDef ';'
	| classDef ';'
	| ';'
	;

ifStmt: If '(' expr ')' stmt (Else stmt)?;
forStmt:
	For '(' init = stmt condition = stmt update = exprStmt? ')' body=stmt;
whileStmt: While '(' expr ')' stmt;

continueStmt: Continue;
breakStmt: Break;
returnStmt: Return expr?;

exprStmt: expr (',' expr)*;