parser grammar Comet;
options {
	tokenVocab = Meteor;
}

@header {package dev.conless.comet.frontend.grammar;}

// Program contains varDef, classDef and funcDef Notice that there has to be exact one main
// function, which should be handled in SemanticChecker.
program: ((varDef ';') | (classDef ';') | funcDef)* EOF;

type: Int | Bool | String | Void | Identifier;
arrayUnit: '[' expr? ']';
typeName: type arrayUnit*;

expr:
	New type arrayUnit* ('(' ')')? # newExpr

	// Exprs that MAY result with lvalue
	| '(' expr ')'					# parenExpr
	| expr '.' member = Identifier	# memberExpr
	| expr '(' funcArgList? ')'		# callExpr // in Mx only need to deal with args without default value
	| expr '[' expr ']'				# indexExpr

	// Unary exprs
	| expr op = (SelfAdd | SelfSub) # postUnaryExpr
	| <assoc = right> op = (
		SelfAdd
		| SelfSub
		| LogicNot
		| BitNot
		| Add
		| Sub
	) expr # preUnaryExpr

	// Binary exprs that results with rvalue
	| expr op = (Mul | Div | Mod) expr								# binaryExpr
	| expr op = (Add | Sub) expr									# binaryExpr
	| expr op = (BitLShift | BitRShift) expr						# binaryExpr
	| expr op = (Less | Greater | LessEqual | GreaterEqual) expr	# binaryExpr
	| expr op = (Eqaul | NotEqual) expr								# binaryExpr
	| expr op = BitAnd expr											# binaryExpr
	| expr op = BitXor expr											# binaryExpr
	| expr op = BitOr expr											# binaryExpr
	| expr op = LogicAnd expr										# binaryExpr
	| expr op = LogicOr expr										# binaryExpr

	// Conditional expr
	| expr '?' expr ':' expr # conditionalExpr

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
	) expr				# assignExpr // in Mx only need to deal with Assign
	| atom	# atomExpr
	;

atom:
	IntegerLiteral
	| StringLiteral
	| True
	| False
	| Null
	| Identifier
	| This;

varDef: typeName varConstructor (',' varConstructor)*;
varConstructor: name = Identifier ('=' expr)?;

classDef:
		// Notice that there're limitations for classConstructor, which should be handled in SemanticChecker.
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
	| ';';

ifStmt: If '(' expr ')' stmt (Else stmt)?;
forStmt:
	For '(' init = stmt condition = expr ';' update = exprStmt? ')' body = stmt;
	// Notice that condition statement can only be exprStmt or emptyStmt.
whileStmt: While '(' expr ')' stmt;

continueStmt: Continue;
breakStmt: Break;
returnStmt: Return expr?;

exprStmt: expr (',' expr)*;