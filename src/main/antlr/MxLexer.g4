lexer grammar MxLexer;

@header {package dev.conless.comet.frontend.grammar;}

// Reserved word
Void: 'void';
Bool: 'bool';
Int: 'int';
String: 'string';
New: 'new';
Class: 'class';
Null: 'null';
True: 'true';
False: 'false';
This: 'this';
If: 'if';
Else: 'else';
For: 'for';
While: 'while';
Break: 'break';
Continue: 'continue';
Return: 'return';

// Binary operators
Add: '+';
Sub: '-';
Mul: '*';
Div: '/';
Mod: '%';

// Comparing operators
Greater: '>';
Less: '<';
GreaterEqual: '>=';
LessEqual: '<=';
NotEqual: '!=';
Eqaul: '==';

// Logic operators
LogicAnd: '&&';
LogicOr: '||';
LogicNot: '!';

// Bit operators
BitRShift: '>>';
BitLShift: '<<';
BitAnd: '&';
BitOr: '|';
BitXor: '^';
BitNot: '~';

// Assign operators
Assign: '=';
AddAssign: '+=';
SubAssign: '-=';
MulAssign: '*=';
DivAssign: '/=';
ModAssign: '%=';
AndAssign: '&=';
XorAssign: '^=';
OrAssign: '|=';
BitLShiftAssign: '<<=';
BitRShiftAssign: '>>=';

// Self operators
SelfAdd: '++';
SelfSub: '--';

// Member access
Member: '.';

// Index access
LBracket: '[';
RBracket: ']';

// Prior operator
LParen: '(';
RParen: ')';

// Conditional Operator
QMark: '?';
Colon: ':';

// Fragment Operator
Semi: ';';
Comma: ',';
LBrace: '{';
RBrace: '}';

// Special symbol
Blank: [ \n\r\t]+ -> skip;

// Comments
CommentLine: '//' ~[\r\n]* -> skip;
CommentPara: '/*' .*? '*/' -> skip;


// Identifier
Identifier: [A-Za-z][0-9A-Za-z_]*;

// Constants
IntegerConst: [1-9][0-9]* | '0';
StringCharacter: '\\n' | '\\\\' | '\\"' | [ -~];
StringConst: '"' StringCharacter* '"';
