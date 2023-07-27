// Generated from Comet.g4 by ANTLR 4.13.0
package dev.conless.comet.frontend.grammar;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class Comet extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Void=1, Bool=2, Int=3, String=4, New=5, Class=6, Null=7, True=8, False=9, 
		This=10, If=11, Else=12, For=13, While=14, Break=15, Continue=16, Return=17, 
		Add=18, Sub=19, Mul=20, Div=21, Mod=22, Greater=23, Less=24, GreaterEqual=25, 
		LessEqual=26, NotEqual=27, Eqaul=28, LogicAnd=29, LogicOr=30, LogicNot=31, 
		BitRShift=32, BitLShift=33, BitAnd=34, BitOr=35, BitXor=36, BitNot=37, 
		Assign=38, AddAssign=39, SubAssign=40, MulAssign=41, DivAssign=42, ModAssign=43, 
		AndAssign=44, XorAssign=45, OrAssign=46, BitLShiftAssign=47, BitRShiftAssign=48, 
		SelfAdd=49, SelfSub=50, Member=51, LBracket=52, RBracket=53, LParen=54, 
		RParen=55, QMark=56, Colon=57, Semi=58, Comma=59, LBrace=60, RBrace=61, 
		Blank=62, CommentLine=63, CommentPara=64, Identifier=65, IntegerConst=66, 
		StringCharacter=67, StringConst=68;
	public static final int
		RULE_program = 0, RULE_typeName = 1, RULE_expression = 2, RULE_variableDefinition = 3, 
		RULE_variableConstructor = 4, RULE_classDefinition = 5, RULE_classConstructor = 6, 
		RULE_functionDefinition = 7, RULE_functionParaList = 8, RULE_functionArgList = 9, 
		RULE_returnType = 10, RULE_blockStatement = 11, RULE_statement = 12, RULE_ifStatement = 13, 
		RULE_forStatement = 14, RULE_whileStatement = 15, RULE_continueStatement = 16, 
		RULE_breakStatement = 17, RULE_returnStatement = 18, RULE_expressionStatement = 19;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "typeName", "expression", "variableDefinition", "variableConstructor", 
			"classDefinition", "classConstructor", "functionDefinition", "functionParaList", 
			"functionArgList", "returnType", "blockStatement", "statement", "ifStatement", 
			"forStatement", "whileStatement", "continueStatement", "breakStatement", 
			"returnStatement", "expressionStatement"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'void'", "'bool'", "'int'", "'string'", "'new'", "'class'", "'null'", 
			"'true'", "'false'", "'this'", "'if'", "'else'", "'for'", "'while'", 
			"'break'", "'continue'", "'return'", "'+'", "'-'", "'*'", "'/'", "'%'", 
			"'>'", "'<'", "'>='", "'<='", "'!='", "'=='", "'&&'", "'||'", "'!'", 
			"'>>'", "'<<'", "'&'", "'|'", "'^'", "'~'", "'='", "'+='", "'-='", "'*='", 
			"'/='", "'%='", "'&='", "'^='", "'|='", "'<<='", "'>>='", "'++'", "'--'", 
			"'.'", "'['", "']'", "'('", "')'", "'?'", "':'", "';'", "','", "'{'", 
			"'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "Void", "Bool", "Int", "String", "New", "Class", "Null", "True", 
			"False", "This", "If", "Else", "For", "While", "Break", "Continue", "Return", 
			"Add", "Sub", "Mul", "Div", "Mod", "Greater", "Less", "GreaterEqual", 
			"LessEqual", "NotEqual", "Eqaul", "LogicAnd", "LogicOr", "LogicNot", 
			"BitRShift", "BitLShift", "BitAnd", "BitOr", "BitXor", "BitNot", "Assign", 
			"AddAssign", "SubAssign", "MulAssign", "DivAssign", "ModAssign", "AndAssign", 
			"XorAssign", "OrAssign", "BitLShiftAssign", "BitRShiftAssign", "SelfAdd", 
			"SelfSub", "Member", "LBracket", "RBracket", "LParen", "RParen", "QMark", 
			"Colon", "Semi", "Comma", "LBrace", "RBrace", "Blank", "CommentLine", 
			"CommentPara", "Identifier", "IntegerConst", "StringCharacter", "StringConst"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Comet.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public Comet(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(Comet.EOF, 0); }
		public List<FunctionDefinitionContext> functionDefinition() {
			return getRuleContexts(FunctionDefinitionContext.class);
		}
		public FunctionDefinitionContext functionDefinition(int i) {
			return getRuleContext(FunctionDefinitionContext.class,i);
		}
		public List<VariableDefinitionContext> variableDefinition() {
			return getRuleContexts(VariableDefinitionContext.class);
		}
		public VariableDefinitionContext variableDefinition(int i) {
			return getRuleContext(VariableDefinitionContext.class,i);
		}
		public List<TerminalNode> Semi() { return getTokens(Comet.Semi); }
		public TerminalNode Semi(int i) {
			return getToken(Comet.Semi, i);
		}
		public List<ClassDefinitionContext> classDefinition() {
			return getRuleContexts(ClassDefinitionContext.class);
		}
		public ClassDefinitionContext classDefinition(int i) {
			return getRuleContext(ClassDefinitionContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CometVisitor ) return ((CometVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 94L) != 0) || _la==Identifier) {
				{
				setState(47);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					{
					setState(40);
					variableDefinition();
					setState(41);
					match(Semi);
					}
					}
					break;
				case 2:
					{
					{
					setState(43);
					classDefinition();
					setState(44);
					match(Semi);
					}
					}
					break;
				case 3:
					{
					setState(46);
					functionDefinition();
					}
					break;
				}
				}
				setState(51);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(52);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeNameContext extends ParserRuleContext {
		public TypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeName; }
	 
		public TypeNameContext() { }
		public void copyFrom(TypeNameContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CustomTypeContext extends TypeNameContext {
		public Token type;
		public TerminalNode Identifier() { return getToken(Comet.Identifier, 0); }
		public CustomTypeContext(TypeNameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).enterCustomType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).exitCustomType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CometVisitor ) return ((CometVisitor<? extends T>)visitor).visitCustomType(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArrayTypeContext extends TypeNameContext {
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TerminalNode LBracket() { return getToken(Comet.LBracket, 0); }
		public TerminalNode RBracket() { return getToken(Comet.RBracket, 0); }
		public ArrayTypeContext(TypeNameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).enterArrayType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).exitArrayType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CometVisitor ) return ((CometVisitor<? extends T>)visitor).visitArrayType(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BuiltInTypeContext extends TypeNameContext {
		public Token type;
		public TerminalNode Int() { return getToken(Comet.Int, 0); }
		public TerminalNode Bool() { return getToken(Comet.Bool, 0); }
		public TerminalNode String() { return getToken(Comet.String, 0); }
		public TerminalNode Void() { return getToken(Comet.Void, 0); }
		public BuiltInTypeContext(TypeNameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).enterBuiltInType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).exitBuiltInType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CometVisitor ) return ((CometVisitor<? extends T>)visitor).visitBuiltInType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeNameContext typeName() throws RecognitionException {
		return typeName(0);
	}

	private TypeNameContext typeName(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeNameContext _localctx = new TypeNameContext(_ctx, _parentState);
		TypeNameContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_typeName, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Void:
			case Bool:
			case Int:
			case String:
				{
				_localctx = new BuiltInTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(55);
				((BuiltInTypeContext)_localctx).type = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 30L) != 0)) ) {
					((BuiltInTypeContext)_localctx).type = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case Identifier:
				{
				_localctx = new CustomTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(56);
				((CustomTypeContext)_localctx).type = match(Identifier);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(64);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ArrayTypeContext(new TypeNameContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_typeName);
					setState(59);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(60);
					match(LBracket);
					setState(61);
					match(RBracket);
					}
					} 
				}
				setState(66);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CallExpressionContext extends ExpressionContext {
		public Token functionName;
		public Token methodName;
		public TerminalNode LParen() { return getToken(Comet.LParen, 0); }
		public TerminalNode RParen() { return getToken(Comet.RParen, 0); }
		public TerminalNode Identifier() { return getToken(Comet.Identifier, 0); }
		public FunctionArgListContext functionArgList() {
			return getRuleContext(FunctionArgListContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Member() { return getToken(Comet.Member, 0); }
		public CallExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).enterCallExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).exitCallExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CometVisitor ) return ((CometVisitor<? extends T>)visitor).visitCallExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UnaryArithExpressionContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode LogicNot() { return getToken(Comet.LogicNot, 0); }
		public TerminalNode BitNot() { return getToken(Comet.BitNot, 0); }
		public TerminalNode Add() { return getToken(Comet.Add, 0); }
		public TerminalNode Sub() { return getToken(Comet.Sub, 0); }
		public TerminalNode SelfAdd() { return getToken(Comet.SelfAdd, 0); }
		public TerminalNode SelfSub() { return getToken(Comet.SelfSub, 0); }
		public UnaryArithExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).enterUnaryArithExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).exitUnaryArithExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CometVisitor ) return ((CometVisitor<? extends T>)visitor).visitUnaryArithExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AtomExpressionContext extends ExpressionContext {
		public Token value;
		public TerminalNode IntegerConst() { return getToken(Comet.IntegerConst, 0); }
		public TerminalNode StringConst() { return getToken(Comet.StringConst, 0); }
		public TerminalNode True() { return getToken(Comet.True, 0); }
		public TerminalNode False() { return getToken(Comet.False, 0); }
		public TerminalNode Null() { return getToken(Comet.Null, 0); }
		public TerminalNode Identifier() { return getToken(Comet.Identifier, 0); }
		public TerminalNode This() { return getToken(Comet.This, 0); }
		public AtomExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).enterAtomExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).exitAtomExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CometVisitor ) return ((CometVisitor<? extends T>)visitor).visitAtomExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ConditionalExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode QMark() { return getToken(Comet.QMark, 0); }
		public TerminalNode Colon() { return getToken(Comet.Colon, 0); }
		public ConditionalExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).enterConditionalExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).exitConditionalExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CometVisitor ) return ((CometVisitor<? extends T>)visitor).visitConditionalExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NewExpressionContext extends ExpressionContext {
		public TerminalNode New() { return getToken(Comet.New, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TerminalNode LParen() { return getToken(Comet.LParen, 0); }
		public TerminalNode RParen() { return getToken(Comet.RParen, 0); }
		public NewExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).enterNewExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).exitNewExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CometVisitor ) return ((CometVisitor<? extends T>)visitor).visitNewExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AssignExpressionContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Assign() { return getToken(Comet.Assign, 0); }
		public TerminalNode AddAssign() { return getToken(Comet.AddAssign, 0); }
		public TerminalNode SubAssign() { return getToken(Comet.SubAssign, 0); }
		public TerminalNode MulAssign() { return getToken(Comet.MulAssign, 0); }
		public TerminalNode DivAssign() { return getToken(Comet.DivAssign, 0); }
		public TerminalNode ModAssign() { return getToken(Comet.ModAssign, 0); }
		public TerminalNode AndAssign() { return getToken(Comet.AndAssign, 0); }
		public TerminalNode XorAssign() { return getToken(Comet.XorAssign, 0); }
		public TerminalNode OrAssign() { return getToken(Comet.OrAssign, 0); }
		public TerminalNode BitLShiftAssign() { return getToken(Comet.BitLShiftAssign, 0); }
		public TerminalNode BitRShiftAssign() { return getToken(Comet.BitRShiftAssign, 0); }
		public AssignExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).enterAssignExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).exitAssignExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CometVisitor ) return ((CometVisitor<? extends T>)visitor).visitAssignExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PreSelfExpressionContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SelfAdd() { return getToken(Comet.SelfAdd, 0); }
		public TerminalNode SelfSub() { return getToken(Comet.SelfSub, 0); }
		public PreSelfExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).enterPreSelfExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).exitPreSelfExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CometVisitor ) return ((CometVisitor<? extends T>)visitor).visitPreSelfExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenExpressionContext extends ExpressionContext {
		public TerminalNode LParen() { return getToken(Comet.LParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RParen() { return getToken(Comet.RParen, 0); }
		public ParenExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).enterParenExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).exitParenExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CometVisitor ) return ((CometVisitor<? extends T>)visitor).visitParenExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IndexExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LBracket() { return getToken(Comet.LBracket, 0); }
		public TerminalNode RBracket() { return getToken(Comet.RBracket, 0); }
		public IndexExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).enterIndexExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).exitIndexExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CometVisitor ) return ((CometVisitor<? extends T>)visitor).visitIndexExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BinaryArithExpressionContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Mul() { return getToken(Comet.Mul, 0); }
		public TerminalNode Div() { return getToken(Comet.Div, 0); }
		public TerminalNode Mod() { return getToken(Comet.Mod, 0); }
		public TerminalNode Add() { return getToken(Comet.Add, 0); }
		public TerminalNode Sub() { return getToken(Comet.Sub, 0); }
		public TerminalNode BitLShift() { return getToken(Comet.BitLShift, 0); }
		public TerminalNode BitRShift() { return getToken(Comet.BitRShift, 0); }
		public TerminalNode Less() { return getToken(Comet.Less, 0); }
		public TerminalNode Greater() { return getToken(Comet.Greater, 0); }
		public TerminalNode LessEqual() { return getToken(Comet.LessEqual, 0); }
		public TerminalNode GreaterEqual() { return getToken(Comet.GreaterEqual, 0); }
		public TerminalNode Eqaul() { return getToken(Comet.Eqaul, 0); }
		public TerminalNode NotEqual() { return getToken(Comet.NotEqual, 0); }
		public TerminalNode BitAnd() { return getToken(Comet.BitAnd, 0); }
		public TerminalNode BitXor() { return getToken(Comet.BitXor, 0); }
		public TerminalNode BitOr() { return getToken(Comet.BitOr, 0); }
		public TerminalNode LogicAnd() { return getToken(Comet.LogicAnd, 0); }
		public TerminalNode LogicOr() { return getToken(Comet.LogicOr, 0); }
		public BinaryArithExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).enterBinaryArithExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).exitBinaryArithExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CometVisitor ) return ((CometVisitor<? extends T>)visitor).visitBinaryArithExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VariableExpressionContext extends ExpressionContext {
		public Token varibleName;
		public Token memberName;
		public TerminalNode Identifier() { return getToken(Comet.Identifier, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Member() { return getToken(Comet.Member, 0); }
		public VariableExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).enterVariableExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).exitVariableExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CometVisitor ) return ((CometVisitor<? extends T>)visitor).visitVariableExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				_localctx = new NewExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(68);
				match(New);
				setState(69);
				typeName(0);
				setState(72);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(70);
					match(LParen);
					setState(71);
					match(RParen);
					}
					break;
				}
				}
				break;
			case 2:
				{
				_localctx = new ParenExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(74);
				match(LParen);
				setState(75);
				expression(0);
				setState(76);
				match(RParen);
				}
				break;
			case 3:
				{
				_localctx = new VariableExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(78);
				((VariableExpressionContext)_localctx).varibleName = match(Identifier);
				}
				break;
			case 4:
				{
				_localctx = new CallExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(79);
				((CallExpressionContext)_localctx).functionName = match(Identifier);
				setState(80);
				match(LParen);
				setState(82);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 5)) & ~0x3f) == 0 && ((1L << (_la - 5)) & -5763991792160579523L) != 0)) {
					{
					setState(81);
					functionArgList();
					}
				}

				setState(84);
				match(RParen);
				}
				break;
			case 5:
				{
				_localctx = new UnaryArithExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(85);
				((UnaryArithExpressionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 139587223552L) != 0)) ) {
					((UnaryArithExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(86);
				expression(15);
				}
				break;
			case 6:
				{
				_localctx = new PreSelfExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(87);
				((PreSelfExpressionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==SelfAdd || _la==SelfSub) ) {
					((PreSelfExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(88);
				expression(14);
				}
				break;
			case 7:
				{
				_localctx = new AtomExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(89);
				((AtomExpressionContext)_localctx).value = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 7)) & ~0x3f) == 0 && ((1L << (_la - 7)) & 3170534137668829199L) != 0)) ) {
					((AtomExpressionContext)_localctx).value = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(151);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(149);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryArithExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(92);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(93);
						((BinaryArithExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 7340032L) != 0)) ) {
							((BinaryArithExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(94);
						expression(14);
						}
						break;
					case 2:
						{
						_localctx = new BinaryArithExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(95);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(96);
						((BinaryArithExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==Add || _la==Sub) ) {
							((BinaryArithExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(97);
						expression(13);
						}
						break;
					case 3:
						{
						_localctx = new BinaryArithExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(98);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(99);
						((BinaryArithExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==BitRShift || _la==BitLShift) ) {
							((BinaryArithExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(100);
						expression(12);
						}
						break;
					case 4:
						{
						_localctx = new BinaryArithExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(101);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(102);
						((BinaryArithExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 125829120L) != 0)) ) {
							((BinaryArithExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(103);
						expression(11);
						}
						break;
					case 5:
						{
						_localctx = new BinaryArithExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(104);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(105);
						((BinaryArithExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==NotEqual || _la==Eqaul) ) {
							((BinaryArithExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(106);
						expression(10);
						}
						break;
					case 6:
						{
						_localctx = new BinaryArithExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(107);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(108);
						((BinaryArithExpressionContext)_localctx).op = match(BitAnd);
						setState(109);
						expression(9);
						}
						break;
					case 7:
						{
						_localctx = new BinaryArithExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(110);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(111);
						((BinaryArithExpressionContext)_localctx).op = match(BitXor);
						setState(112);
						expression(8);
						}
						break;
					case 8:
						{
						_localctx = new BinaryArithExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(113);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(114);
						((BinaryArithExpressionContext)_localctx).op = match(BitOr);
						setState(115);
						expression(7);
						}
						break;
					case 9:
						{
						_localctx = new BinaryArithExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(116);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(117);
						((BinaryArithExpressionContext)_localctx).op = match(LogicAnd);
						setState(118);
						expression(6);
						}
						break;
					case 10:
						{
						_localctx = new BinaryArithExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(119);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(120);
						((BinaryArithExpressionContext)_localctx).op = match(LogicOr);
						setState(121);
						expression(5);
						}
						break;
					case 11:
						{
						_localctx = new ConditionalExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(122);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(123);
						match(QMark);
						setState(124);
						expression(0);
						setState(125);
						match(Colon);
						setState(126);
						expression(4);
						}
						break;
					case 12:
						{
						_localctx = new AssignExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(128);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(129);
						((AssignExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 562675075514368L) != 0)) ) {
							((AssignExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(130);
						expression(3);
						}
						break;
					case 13:
						{
						_localctx = new VariableExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(131);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(132);
						match(Member);
						setState(133);
						((VariableExpressionContext)_localctx).memberName = match(Identifier);
						}
						break;
					case 14:
						{
						_localctx = new CallExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(134);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(135);
						match(Member);
						setState(136);
						((CallExpressionContext)_localctx).methodName = match(Identifier);
						setState(137);
						match(LParen);
						setState(139);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (((((_la - 5)) & ~0x3f) == 0 && ((1L << (_la - 5)) & -5763991792160579523L) != 0)) {
							{
							setState(138);
							functionArgList();
							}
						}

						setState(141);
						match(RParen);
						}
						break;
					case 15:
						{
						_localctx = new IndexExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(142);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(143);
						match(LBracket);
						setState(144);
						expression(0);
						setState(145);
						match(RBracket);
						}
						break;
					case 16:
						{
						_localctx = new UnaryArithExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(147);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(148);
						((UnaryArithExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==SelfAdd || _la==SelfSub) ) {
							((UnaryArithExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						break;
					}
					} 
				}
				setState(153);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariableDefinitionContext extends ParserRuleContext {
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public List<VariableConstructorContext> variableConstructor() {
			return getRuleContexts(VariableConstructorContext.class);
		}
		public VariableConstructorContext variableConstructor(int i) {
			return getRuleContext(VariableConstructorContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(Comet.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(Comet.Comma, i);
		}
		public VariableDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).enterVariableDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).exitVariableDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CometVisitor ) return ((CometVisitor<? extends T>)visitor).visitVariableDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDefinitionContext variableDefinition() throws RecognitionException {
		VariableDefinitionContext _localctx = new VariableDefinitionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_variableDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			typeName(0);
			setState(155);
			variableConstructor();
			setState(160);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(156);
				match(Comma);
				setState(157);
				variableConstructor();
				}
				}
				setState(162);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariableConstructorContext extends ParserRuleContext {
		public Token varName;
		public TerminalNode Identifier() { return getToken(Comet.Identifier, 0); }
		public TerminalNode Assign() { return getToken(Comet.Assign, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VariableConstructorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableConstructor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).enterVariableConstructor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).exitVariableConstructor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CometVisitor ) return ((CometVisitor<? extends T>)visitor).visitVariableConstructor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableConstructorContext variableConstructor() throws RecognitionException {
		VariableConstructorContext _localctx = new VariableConstructorContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_variableConstructor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			((VariableConstructorContext)_localctx).varName = match(Identifier);
			setState(166);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Assign) {
				{
				setState(164);
				match(Assign);
				setState(165);
				expression(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ClassDefinitionContext extends ParserRuleContext {
		public Token className;
		public TerminalNode Class() { return getToken(Comet.Class, 0); }
		public TerminalNode LBrace() { return getToken(Comet.LBrace, 0); }
		public TerminalNode RBrace() { return getToken(Comet.RBrace, 0); }
		public TerminalNode Identifier() { return getToken(Comet.Identifier, 0); }
		public List<FunctionDefinitionContext> functionDefinition() {
			return getRuleContexts(FunctionDefinitionContext.class);
		}
		public FunctionDefinitionContext functionDefinition(int i) {
			return getRuleContext(FunctionDefinitionContext.class,i);
		}
		public List<ClassConstructorContext> classConstructor() {
			return getRuleContexts(ClassConstructorContext.class);
		}
		public ClassConstructorContext classConstructor(int i) {
			return getRuleContext(ClassConstructorContext.class,i);
		}
		public List<VariableDefinitionContext> variableDefinition() {
			return getRuleContexts(VariableDefinitionContext.class);
		}
		public VariableDefinitionContext variableDefinition(int i) {
			return getRuleContext(VariableDefinitionContext.class,i);
		}
		public List<TerminalNode> Semi() { return getTokens(Comet.Semi); }
		public TerminalNode Semi(int i) {
			return getToken(Comet.Semi, i);
		}
		public ClassDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).enterClassDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).exitClassDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CometVisitor ) return ((CometVisitor<? extends T>)visitor).visitClassDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDefinitionContext classDefinition() throws RecognitionException {
		ClassDefinitionContext _localctx = new ClassDefinitionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_classDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			match(Class);
			setState(169);
			((ClassDefinitionContext)_localctx).className = match(Identifier);
			setState(170);
			match(LBrace);
			setState(178);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 30L) != 0) || _la==Identifier) {
				{
				setState(176);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
				case 1:
					{
					{
					setState(171);
					variableDefinition();
					setState(172);
					match(Semi);
					}
					}
					break;
				case 2:
					{
					setState(174);
					functionDefinition();
					}
					break;
				case 3:
					{
					setState(175);
					classConstructor();
					}
					break;
				}
				}
				setState(180);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(181);
			match(RBrace);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ClassConstructorContext extends ParserRuleContext {
		public Token className;
		public TerminalNode LParen() { return getToken(Comet.LParen, 0); }
		public TerminalNode RParen() { return getToken(Comet.RParen, 0); }
		public BlockStatementContext blockStatement() {
			return getRuleContext(BlockStatementContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(Comet.Identifier, 0); }
		public ClassConstructorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classConstructor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).enterClassConstructor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).exitClassConstructor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CometVisitor ) return ((CometVisitor<? extends T>)visitor).visitClassConstructor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassConstructorContext classConstructor() throws RecognitionException {
		ClassConstructorContext _localctx = new ClassConstructorContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_classConstructor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			((ClassConstructorContext)_localctx).className = match(Identifier);
			setState(184);
			match(LParen);
			setState(185);
			match(RParen);
			setState(186);
			blockStatement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionDefinitionContext extends ParserRuleContext {
		public Token funcName;
		public ReturnTypeContext returnType() {
			return getRuleContext(ReturnTypeContext.class,0);
		}
		public TerminalNode LParen() { return getToken(Comet.LParen, 0); }
		public TerminalNode RParen() { return getToken(Comet.RParen, 0); }
		public BlockStatementContext blockStatement() {
			return getRuleContext(BlockStatementContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(Comet.Identifier, 0); }
		public FunctionParaListContext functionParaList() {
			return getRuleContext(FunctionParaListContext.class,0);
		}
		public FunctionDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).enterFunctionDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).exitFunctionDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CometVisitor ) return ((CometVisitor<? extends T>)visitor).visitFunctionDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDefinitionContext functionDefinition() throws RecognitionException {
		FunctionDefinitionContext _localctx = new FunctionDefinitionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_functionDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			returnType();
			setState(189);
			((FunctionDefinitionContext)_localctx).funcName = match(Identifier);
			setState(190);
			match(LParen);
			setState(192);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 30L) != 0) || _la==Identifier) {
				{
				setState(191);
				functionParaList();
				}
			}

			setState(194);
			match(RParen);
			setState(195);
			blockStatement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionParaListContext extends ParserRuleContext {
		public List<TypeNameContext> typeName() {
			return getRuleContexts(TypeNameContext.class);
		}
		public TypeNameContext typeName(int i) {
			return getRuleContext(TypeNameContext.class,i);
		}
		public List<VariableConstructorContext> variableConstructor() {
			return getRuleContexts(VariableConstructorContext.class);
		}
		public VariableConstructorContext variableConstructor(int i) {
			return getRuleContext(VariableConstructorContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(Comet.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(Comet.Comma, i);
		}
		public FunctionParaListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionParaList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).enterFunctionParaList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).exitFunctionParaList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CometVisitor ) return ((CometVisitor<? extends T>)visitor).visitFunctionParaList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionParaListContext functionParaList() throws RecognitionException {
		FunctionParaListContext _localctx = new FunctionParaListContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_functionParaList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			typeName(0);
			setState(198);
			variableConstructor();
			setState(205);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(199);
				match(Comma);
				setState(200);
				typeName(0);
				setState(201);
				variableConstructor();
				}
				}
				setState(207);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionArgListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(Comet.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(Comet.Comma, i);
		}
		public FunctionArgListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionArgList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).enterFunctionArgList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).exitFunctionArgList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CometVisitor ) return ((CometVisitor<? extends T>)visitor).visitFunctionArgList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionArgListContext functionArgList() throws RecognitionException {
		FunctionArgListContext _localctx = new FunctionArgListContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_functionArgList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			expression(0);
			setState(213);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(209);
				match(Comma);
				setState(210);
				expression(0);
				}
				}
				setState(215);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReturnTypeContext extends ParserRuleContext {
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public ReturnTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).enterReturnType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).exitReturnType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CometVisitor ) return ((CometVisitor<? extends T>)visitor).visitReturnType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnTypeContext returnType() throws RecognitionException {
		ReturnTypeContext _localctx = new ReturnTypeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_returnType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			typeName(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockStatementContext extends ParserRuleContext {
		public TerminalNode LBrace() { return getToken(Comet.LBrace, 0); }
		public TerminalNode RBrace() { return getToken(Comet.RBrace, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).enterBlockStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).exitBlockStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CometVisitor ) return ((CometVisitor<? extends T>)visitor).visitBlockStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockStatementContext blockStatement() throws RecognitionException {
		BlockStatementContext _localctx = new BlockStatementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_blockStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			match(LBrace);
			setState(222);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1460855268715786238L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 11L) != 0)) {
				{
				{
				setState(219);
				statement();
				}
				}
				setState(224);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(225);
			match(RBrace);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public BlockStatementContext blockStatement() {
			return getRuleContext(BlockStatementContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public ForStatementContext forStatement() {
			return getRuleContext(ForStatementContext.class,0);
		}
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public VariableDefinitionContext variableDefinition() {
			return getRuleContext(VariableDefinitionContext.class,0);
		}
		public TerminalNode Semi() { return getToken(Comet.Semi, 0); }
		public ClassDefinitionContext classDefinition() {
			return getRuleContext(ClassDefinitionContext.class,0);
		}
		public ContinueStatementContext continueStatement() {
			return getRuleContext(ContinueStatementContext.class,0);
		}
		public BreakStatementContext breakStatement() {
			return getRuleContext(BreakStatementContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public ExpressionStatementContext expressionStatement() {
			return getRuleContext(ExpressionStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CometVisitor ) return ((CometVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_statement);
		try {
			setState(250);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(227);
				blockStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(228);
				ifStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(229);
				forStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(230);
				whileStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(231);
				variableDefinition();
				setState(232);
				match(Semi);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(234);
				classDefinition();
				setState(235);
				match(Semi);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(237);
				continueStatement();
				setState(238);
				match(Semi);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(240);
				breakStatement();
				setState(241);
				match(Semi);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(243);
				returnStatement();
				setState(244);
				match(Semi);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(246);
				expressionStatement();
				setState(247);
				match(Semi);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(249);
				match(Semi);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfStatementContext extends ParserRuleContext {
		public TerminalNode If() { return getToken(Comet.If, 0); }
		public TerminalNode LParen() { return getToken(Comet.LParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RParen() { return getToken(Comet.RParen, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode Else() { return getToken(Comet.Else, 0); }
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CometVisitor ) return ((CometVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_ifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			match(If);
			setState(253);
			match(LParen);
			setState(254);
			expression(0);
			setState(255);
			match(RParen);
			setState(256);
			statement();
			setState(259);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(257);
				match(Else);
				setState(258);
				statement();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForStatementContext extends ParserRuleContext {
		public StatementContext init;
		public StatementContext condition;
		public ExpressionStatementContext update;
		public TerminalNode For() { return getToken(Comet.For, 0); }
		public TerminalNode LParen() { return getToken(Comet.LParen, 0); }
		public TerminalNode RParen() { return getToken(Comet.RParen, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ExpressionStatementContext expressionStatement() {
			return getRuleContext(ExpressionStatementContext.class,0);
		}
		public ForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).enterForStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).exitForStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CometVisitor ) return ((CometVisitor<? extends T>)visitor).visitForStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStatementContext forStatement() throws RecognitionException {
		ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_forStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
			match(For);
			setState(262);
			match(LParen);
			setState(263);
			((ForStatementContext)_localctx).init = statement();
			setState(264);
			((ForStatementContext)_localctx).condition = statement();
			setState(266);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 5)) & ~0x3f) == 0 && ((1L << (_la - 5)) & -5763991792160579523L) != 0)) {
				{
				setState(265);
				((ForStatementContext)_localctx).update = expressionStatement();
				}
			}

			setState(268);
			match(RParen);
			setState(269);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WhileStatementContext extends ParserRuleContext {
		public ExpressionContext condition;
		public TerminalNode While() { return getToken(Comet.While, 0); }
		public TerminalNode LParen() { return getToken(Comet.LParen, 0); }
		public TerminalNode RParen() { return getToken(Comet.RParen, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).enterWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).exitWhileStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CometVisitor ) return ((CometVisitor<? extends T>)visitor).visitWhileStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
			match(While);
			setState(272);
			match(LParen);
			setState(273);
			((WhileStatementContext)_localctx).condition = expression(0);
			setState(274);
			match(RParen);
			setState(275);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ContinueStatementContext extends ParserRuleContext {
		public TerminalNode Continue() { return getToken(Comet.Continue, 0); }
		public ContinueStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_continueStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).enterContinueStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).exitContinueStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CometVisitor ) return ((CometVisitor<? extends T>)visitor).visitContinueStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContinueStatementContext continueStatement() throws RecognitionException {
		ContinueStatementContext _localctx = new ContinueStatementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_continueStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(277);
			match(Continue);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BreakStatementContext extends ParserRuleContext {
		public TerminalNode Break() { return getToken(Comet.Break, 0); }
		public BreakStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_breakStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).enterBreakStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).exitBreakStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CometVisitor ) return ((CometVisitor<? extends T>)visitor).visitBreakStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BreakStatementContext breakStatement() throws RecognitionException {
		BreakStatementContext _localctx = new BreakStatementContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_breakStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(279);
			match(Break);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReturnStatementContext extends ParserRuleContext {
		public TerminalNode Return() { return getToken(Comet.Return, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).exitReturnStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CometVisitor ) return ((CometVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_returnStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(281);
			match(Return);
			setState(283);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 5)) & ~0x3f) == 0 && ((1L << (_la - 5)) & -5763991792160579523L) != 0)) {
				{
				setState(282);
				expression(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionStatementContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(Comet.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(Comet.Comma, i);
		}
		public ExpressionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).enterExpressionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).exitExpressionStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CometVisitor ) return ((CometVisitor<? extends T>)visitor).visitExpressionStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionStatementContext expressionStatement() throws RecognitionException {
		ExpressionStatementContext _localctx = new ExpressionStatementContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_expressionStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285);
			expression(0);
			setState(290);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(286);
				match(Comma);
				setState(287);
				expression(0);
				}
				}
				setState(292);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return typeName_sempred((TypeNameContext)_localctx, predIndex);
		case 2:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean typeName_sempred(TypeNameContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 13);
		case 2:
			return precpred(_ctx, 12);
		case 3:
			return precpred(_ctx, 11);
		case 4:
			return precpred(_ctx, 10);
		case 5:
			return precpred(_ctx, 9);
		case 6:
			return precpred(_ctx, 8);
		case 7:
			return precpred(_ctx, 7);
		case 8:
			return precpred(_ctx, 6);
		case 9:
			return precpred(_ctx, 5);
		case 10:
			return precpred(_ctx, 4);
		case 11:
			return precpred(_ctx, 3);
		case 12:
			return precpred(_ctx, 2);
		case 13:
			return precpred(_ctx, 20);
		case 14:
			return precpred(_ctx, 18);
		case 15:
			return precpred(_ctx, 17);
		case 16:
			return precpred(_ctx, 16);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001D\u0126\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0005\u00000\b\u0000\n\u0000\f\u0000"+
		"3\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u0001:\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001"+
		"?\b\u0001\n\u0001\f\u0001B\t\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0003\u0002I\b\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0003\u0002S\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0003\u0002[\b\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002\u008c\b\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0005\u0002\u0096\b\u0002\n\u0002\f\u0002\u0099\t\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003\u009f\b\u0003\n"+
		"\u0003\f\u0003\u00a2\t\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0003"+
		"\u0004\u00a7\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005\u00b1\b\u0005\n"+
		"\u0005\f\u0005\u00b4\t\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0003\u0007\u00c1\b\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b\u00cc\b"+
		"\b\n\b\f\b\u00cf\t\b\u0001\t\u0001\t\u0001\t\u0005\t\u00d4\b\t\n\t\f\t"+
		"\u00d7\t\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0005\u000b\u00dd\b"+
		"\u000b\n\u000b\f\u000b\u00e0\t\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0003\f\u00fb\b\f\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0003\r\u0104\b\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u010b\b\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001"+
		"\u0012\u0001\u0012\u0003\u0012\u011c\b\u0012\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0005\u0013\u0121\b\u0013\n\u0013\f\u0013\u0124\t\u0013\u0001\u0013"+
		"\u0000\u0002\u0002\u0004\u0014\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&\u0000\n\u0001\u0000\u0001"+
		"\u0004\u0003\u0000\u0012\u0013\u001f\u001f%%\u0001\u000012\u0003\u0000"+
		"\u0007\nABDD\u0001\u0000\u0014\u0016\u0001\u0000\u0012\u0013\u0001\u0000"+
		" !\u0001\u0000\u0017\u001a\u0001\u0000\u001b\u001c\u0001\u0000&0\u0146"+
		"\u00001\u0001\u0000\u0000\u0000\u00029\u0001\u0000\u0000\u0000\u0004Z"+
		"\u0001\u0000\u0000\u0000\u0006\u009a\u0001\u0000\u0000\u0000\b\u00a3\u0001"+
		"\u0000\u0000\u0000\n\u00a8\u0001\u0000\u0000\u0000\f\u00b7\u0001\u0000"+
		"\u0000\u0000\u000e\u00bc\u0001\u0000\u0000\u0000\u0010\u00c5\u0001\u0000"+
		"\u0000\u0000\u0012\u00d0\u0001\u0000\u0000\u0000\u0014\u00d8\u0001\u0000"+
		"\u0000\u0000\u0016\u00da\u0001\u0000\u0000\u0000\u0018\u00fa\u0001\u0000"+
		"\u0000\u0000\u001a\u00fc\u0001\u0000\u0000\u0000\u001c\u0105\u0001\u0000"+
		"\u0000\u0000\u001e\u010f\u0001\u0000\u0000\u0000 \u0115\u0001\u0000\u0000"+
		"\u0000\"\u0117\u0001\u0000\u0000\u0000$\u0119\u0001\u0000\u0000\u0000"+
		"&\u011d\u0001\u0000\u0000\u0000()\u0003\u0006\u0003\u0000)*\u0005:\u0000"+
		"\u0000*0\u0001\u0000\u0000\u0000+,\u0003\n\u0005\u0000,-\u0005:\u0000"+
		"\u0000-0\u0001\u0000\u0000\u0000.0\u0003\u000e\u0007\u0000/(\u0001\u0000"+
		"\u0000\u0000/+\u0001\u0000\u0000\u0000/.\u0001\u0000\u0000\u000003\u0001"+
		"\u0000\u0000\u00001/\u0001\u0000\u0000\u000012\u0001\u0000\u0000\u0000"+
		"24\u0001\u0000\u0000\u000031\u0001\u0000\u0000\u000045\u0005\u0000\u0000"+
		"\u00015\u0001\u0001\u0000\u0000\u000067\u0006\u0001\uffff\uffff\u0000"+
		"7:\u0007\u0000\u0000\u00008:\u0005A\u0000\u000096\u0001\u0000\u0000\u0000"+
		"98\u0001\u0000\u0000\u0000:@\u0001\u0000\u0000\u0000;<\n\u0001\u0000\u0000"+
		"<=\u00054\u0000\u0000=?\u00055\u0000\u0000>;\u0001\u0000\u0000\u0000?"+
		"B\u0001\u0000\u0000\u0000@>\u0001\u0000\u0000\u0000@A\u0001\u0000\u0000"+
		"\u0000A\u0003\u0001\u0000\u0000\u0000B@\u0001\u0000\u0000\u0000CD\u0006"+
		"\u0002\uffff\uffff\u0000DE\u0005\u0005\u0000\u0000EH\u0003\u0002\u0001"+
		"\u0000FG\u00056\u0000\u0000GI\u00057\u0000\u0000HF\u0001\u0000\u0000\u0000"+
		"HI\u0001\u0000\u0000\u0000I[\u0001\u0000\u0000\u0000JK\u00056\u0000\u0000"+
		"KL\u0003\u0004\u0002\u0000LM\u00057\u0000\u0000M[\u0001\u0000\u0000\u0000"+
		"N[\u0005A\u0000\u0000OP\u0005A\u0000\u0000PR\u00056\u0000\u0000QS\u0003"+
		"\u0012\t\u0000RQ\u0001\u0000\u0000\u0000RS\u0001\u0000\u0000\u0000ST\u0001"+
		"\u0000\u0000\u0000T[\u00057\u0000\u0000UV\u0007\u0001\u0000\u0000V[\u0003"+
		"\u0004\u0002\u000fWX\u0007\u0002\u0000\u0000X[\u0003\u0004\u0002\u000e"+
		"Y[\u0007\u0003\u0000\u0000ZC\u0001\u0000\u0000\u0000ZJ\u0001\u0000\u0000"+
		"\u0000ZN\u0001\u0000\u0000\u0000ZO\u0001\u0000\u0000\u0000ZU\u0001\u0000"+
		"\u0000\u0000ZW\u0001\u0000\u0000\u0000ZY\u0001\u0000\u0000\u0000[\u0097"+
		"\u0001\u0000\u0000\u0000\\]\n\r\u0000\u0000]^\u0007\u0004\u0000\u0000"+
		"^\u0096\u0003\u0004\u0002\u000e_`\n\f\u0000\u0000`a\u0007\u0005\u0000"+
		"\u0000a\u0096\u0003\u0004\u0002\rbc\n\u000b\u0000\u0000cd\u0007\u0006"+
		"\u0000\u0000d\u0096\u0003\u0004\u0002\fef\n\n\u0000\u0000fg\u0007\u0007"+
		"\u0000\u0000g\u0096\u0003\u0004\u0002\u000bhi\n\t\u0000\u0000ij\u0007"+
		"\b\u0000\u0000j\u0096\u0003\u0004\u0002\nkl\n\b\u0000\u0000lm\u0005\""+
		"\u0000\u0000m\u0096\u0003\u0004\u0002\tno\n\u0007\u0000\u0000op\u0005"+
		"$\u0000\u0000p\u0096\u0003\u0004\u0002\bqr\n\u0006\u0000\u0000rs\u0005"+
		"#\u0000\u0000s\u0096\u0003\u0004\u0002\u0007tu\n\u0005\u0000\u0000uv\u0005"+
		"\u001d\u0000\u0000v\u0096\u0003\u0004\u0002\u0006wx\n\u0004\u0000\u0000"+
		"xy\u0005\u001e\u0000\u0000y\u0096\u0003\u0004\u0002\u0005z{\n\u0003\u0000"+
		"\u0000{|\u00058\u0000\u0000|}\u0003\u0004\u0002\u0000}~\u00059\u0000\u0000"+
		"~\u007f\u0003\u0004\u0002\u0004\u007f\u0096\u0001\u0000\u0000\u0000\u0080"+
		"\u0081\n\u0002\u0000\u0000\u0081\u0082\u0007\t\u0000\u0000\u0082\u0096"+
		"\u0003\u0004\u0002\u0003\u0083\u0084\n\u0014\u0000\u0000\u0084\u0085\u0005"+
		"3\u0000\u0000\u0085\u0096\u0005A\u0000\u0000\u0086\u0087\n\u0012\u0000"+
		"\u0000\u0087\u0088\u00053\u0000\u0000\u0088\u0089\u0005A\u0000\u0000\u0089"+
		"\u008b\u00056\u0000\u0000\u008a\u008c\u0003\u0012\t\u0000\u008b\u008a"+
		"\u0001\u0000\u0000\u0000\u008b\u008c\u0001\u0000\u0000\u0000\u008c\u008d"+
		"\u0001\u0000\u0000\u0000\u008d\u0096\u00057\u0000\u0000\u008e\u008f\n"+
		"\u0011\u0000\u0000\u008f\u0090\u00054\u0000\u0000\u0090\u0091\u0003\u0004"+
		"\u0002\u0000\u0091\u0092\u00055\u0000\u0000\u0092\u0096\u0001\u0000\u0000"+
		"\u0000\u0093\u0094\n\u0010\u0000\u0000\u0094\u0096\u0007\u0002\u0000\u0000"+
		"\u0095\\\u0001\u0000\u0000\u0000\u0095_\u0001\u0000\u0000\u0000\u0095"+
		"b\u0001\u0000\u0000\u0000\u0095e\u0001\u0000\u0000\u0000\u0095h\u0001"+
		"\u0000\u0000\u0000\u0095k\u0001\u0000\u0000\u0000\u0095n\u0001\u0000\u0000"+
		"\u0000\u0095q\u0001\u0000\u0000\u0000\u0095t\u0001\u0000\u0000\u0000\u0095"+
		"w\u0001\u0000\u0000\u0000\u0095z\u0001\u0000\u0000\u0000\u0095\u0080\u0001"+
		"\u0000\u0000\u0000\u0095\u0083\u0001\u0000\u0000\u0000\u0095\u0086\u0001"+
		"\u0000\u0000\u0000\u0095\u008e\u0001\u0000\u0000\u0000\u0095\u0093\u0001"+
		"\u0000\u0000\u0000\u0096\u0099\u0001\u0000\u0000\u0000\u0097\u0095\u0001"+
		"\u0000\u0000\u0000\u0097\u0098\u0001\u0000\u0000\u0000\u0098\u0005\u0001"+
		"\u0000\u0000\u0000\u0099\u0097\u0001\u0000\u0000\u0000\u009a\u009b\u0003"+
		"\u0002\u0001\u0000\u009b\u00a0\u0003\b\u0004\u0000\u009c\u009d\u0005;"+
		"\u0000\u0000\u009d\u009f\u0003\b\u0004\u0000\u009e\u009c\u0001\u0000\u0000"+
		"\u0000\u009f\u00a2\u0001\u0000\u0000\u0000\u00a0\u009e\u0001\u0000\u0000"+
		"\u0000\u00a0\u00a1\u0001\u0000\u0000\u0000\u00a1\u0007\u0001\u0000\u0000"+
		"\u0000\u00a2\u00a0\u0001\u0000\u0000\u0000\u00a3\u00a6\u0005A\u0000\u0000"+
		"\u00a4\u00a5\u0005&\u0000\u0000\u00a5\u00a7\u0003\u0004\u0002\u0000\u00a6"+
		"\u00a4\u0001\u0000\u0000\u0000\u00a6\u00a7\u0001\u0000\u0000\u0000\u00a7"+
		"\t\u0001\u0000\u0000\u0000\u00a8\u00a9\u0005\u0006\u0000\u0000\u00a9\u00aa"+
		"\u0005A\u0000\u0000\u00aa\u00b2\u0005<\u0000\u0000\u00ab\u00ac\u0003\u0006"+
		"\u0003\u0000\u00ac\u00ad\u0005:\u0000\u0000\u00ad\u00b1\u0001\u0000\u0000"+
		"\u0000\u00ae\u00b1\u0003\u000e\u0007\u0000\u00af\u00b1\u0003\f\u0006\u0000"+
		"\u00b0\u00ab\u0001\u0000\u0000\u0000\u00b0\u00ae\u0001\u0000\u0000\u0000"+
		"\u00b0\u00af\u0001\u0000\u0000\u0000\u00b1\u00b4\u0001\u0000\u0000\u0000"+
		"\u00b2\u00b0\u0001\u0000\u0000\u0000\u00b2\u00b3\u0001\u0000\u0000\u0000"+
		"\u00b3\u00b5\u0001\u0000\u0000\u0000\u00b4\u00b2\u0001\u0000\u0000\u0000"+
		"\u00b5\u00b6\u0005=\u0000\u0000\u00b6\u000b\u0001\u0000\u0000\u0000\u00b7"+
		"\u00b8\u0005A\u0000\u0000\u00b8\u00b9\u00056\u0000\u0000\u00b9\u00ba\u0005"+
		"7\u0000\u0000\u00ba\u00bb\u0003\u0016\u000b\u0000\u00bb\r\u0001\u0000"+
		"\u0000\u0000\u00bc\u00bd\u0003\u0014\n\u0000\u00bd\u00be\u0005A\u0000"+
		"\u0000\u00be\u00c0\u00056\u0000\u0000\u00bf\u00c1\u0003\u0010\b\u0000"+
		"\u00c0\u00bf\u0001\u0000\u0000\u0000\u00c0\u00c1\u0001\u0000\u0000\u0000"+
		"\u00c1\u00c2\u0001\u0000\u0000\u0000\u00c2\u00c3\u00057\u0000\u0000\u00c3"+
		"\u00c4\u0003\u0016\u000b\u0000\u00c4\u000f\u0001\u0000\u0000\u0000\u00c5"+
		"\u00c6\u0003\u0002\u0001\u0000\u00c6\u00cd\u0003\b\u0004\u0000\u00c7\u00c8"+
		"\u0005;\u0000\u0000\u00c8\u00c9\u0003\u0002\u0001\u0000\u00c9\u00ca\u0003"+
		"\b\u0004\u0000\u00ca\u00cc\u0001\u0000\u0000\u0000\u00cb\u00c7\u0001\u0000"+
		"\u0000\u0000\u00cc\u00cf\u0001\u0000\u0000\u0000\u00cd\u00cb\u0001\u0000"+
		"\u0000\u0000\u00cd\u00ce\u0001\u0000\u0000\u0000\u00ce\u0011\u0001\u0000"+
		"\u0000\u0000\u00cf\u00cd\u0001\u0000\u0000\u0000\u00d0\u00d5\u0003\u0004"+
		"\u0002\u0000\u00d1\u00d2\u0005;\u0000\u0000\u00d2\u00d4\u0003\u0004\u0002"+
		"\u0000\u00d3\u00d1\u0001\u0000\u0000\u0000\u00d4\u00d7\u0001\u0000\u0000"+
		"\u0000\u00d5\u00d3\u0001\u0000\u0000\u0000\u00d5\u00d6\u0001\u0000\u0000"+
		"\u0000\u00d6\u0013\u0001\u0000\u0000\u0000\u00d7\u00d5\u0001\u0000\u0000"+
		"\u0000\u00d8\u00d9\u0003\u0002\u0001\u0000\u00d9\u0015\u0001\u0000\u0000"+
		"\u0000\u00da\u00de\u0005<\u0000\u0000\u00db\u00dd\u0003\u0018\f\u0000"+
		"\u00dc\u00db\u0001\u0000\u0000\u0000\u00dd\u00e0\u0001\u0000\u0000\u0000"+
		"\u00de\u00dc\u0001\u0000\u0000\u0000\u00de\u00df\u0001\u0000\u0000\u0000"+
		"\u00df\u00e1\u0001\u0000\u0000\u0000\u00e0\u00de\u0001\u0000\u0000\u0000"+
		"\u00e1\u00e2\u0005=\u0000\u0000\u00e2\u0017\u0001\u0000\u0000\u0000\u00e3"+
		"\u00fb\u0003\u0016\u000b\u0000\u00e4\u00fb\u0003\u001a\r\u0000\u00e5\u00fb"+
		"\u0003\u001c\u000e\u0000\u00e6\u00fb\u0003\u001e\u000f\u0000\u00e7\u00e8"+
		"\u0003\u0006\u0003\u0000\u00e8\u00e9\u0005:\u0000\u0000\u00e9\u00fb\u0001"+
		"\u0000\u0000\u0000\u00ea\u00eb\u0003\n\u0005\u0000\u00eb\u00ec\u0005:"+
		"\u0000\u0000\u00ec\u00fb\u0001\u0000\u0000\u0000\u00ed\u00ee\u0003 \u0010"+
		"\u0000\u00ee\u00ef\u0005:\u0000\u0000\u00ef\u00fb\u0001\u0000\u0000\u0000"+
		"\u00f0\u00f1\u0003\"\u0011\u0000\u00f1\u00f2\u0005:\u0000\u0000\u00f2"+
		"\u00fb\u0001\u0000\u0000\u0000\u00f3\u00f4\u0003$\u0012\u0000\u00f4\u00f5"+
		"\u0005:\u0000\u0000\u00f5\u00fb\u0001\u0000\u0000\u0000\u00f6\u00f7\u0003"+
		"&\u0013\u0000\u00f7\u00f8\u0005:\u0000\u0000\u00f8\u00fb\u0001\u0000\u0000"+
		"\u0000\u00f9\u00fb\u0005:\u0000\u0000\u00fa\u00e3\u0001\u0000\u0000\u0000"+
		"\u00fa\u00e4\u0001\u0000\u0000\u0000\u00fa\u00e5\u0001\u0000\u0000\u0000"+
		"\u00fa\u00e6\u0001\u0000\u0000\u0000\u00fa\u00e7\u0001\u0000\u0000\u0000"+
		"\u00fa\u00ea\u0001\u0000\u0000\u0000\u00fa\u00ed\u0001\u0000\u0000\u0000"+
		"\u00fa\u00f0\u0001\u0000\u0000\u0000\u00fa\u00f3\u0001\u0000\u0000\u0000"+
		"\u00fa\u00f6\u0001\u0000\u0000\u0000\u00fa\u00f9\u0001\u0000\u0000\u0000"+
		"\u00fb\u0019\u0001\u0000\u0000\u0000\u00fc\u00fd\u0005\u000b\u0000\u0000"+
		"\u00fd\u00fe\u00056\u0000\u0000\u00fe\u00ff\u0003\u0004\u0002\u0000\u00ff"+
		"\u0100\u00057\u0000\u0000\u0100\u0103\u0003\u0018\f\u0000\u0101\u0102"+
		"\u0005\f\u0000\u0000\u0102\u0104\u0003\u0018\f\u0000\u0103\u0101\u0001"+
		"\u0000\u0000\u0000\u0103\u0104\u0001\u0000\u0000\u0000\u0104\u001b\u0001"+
		"\u0000\u0000\u0000\u0105\u0106\u0005\r\u0000\u0000\u0106\u0107\u00056"+
		"\u0000\u0000\u0107\u0108\u0003\u0018\f\u0000\u0108\u010a\u0003\u0018\f"+
		"\u0000\u0109\u010b\u0003&\u0013\u0000\u010a\u0109\u0001\u0000\u0000\u0000"+
		"\u010a\u010b\u0001\u0000\u0000\u0000\u010b\u010c\u0001\u0000\u0000\u0000"+
		"\u010c\u010d\u00057\u0000\u0000\u010d\u010e\u0003\u0018\f\u0000\u010e"+
		"\u001d\u0001\u0000\u0000\u0000\u010f\u0110\u0005\u000e\u0000\u0000\u0110"+
		"\u0111\u00056\u0000\u0000\u0111\u0112\u0003\u0004\u0002\u0000\u0112\u0113"+
		"\u00057\u0000\u0000\u0113\u0114\u0003\u0018\f\u0000\u0114\u001f\u0001"+
		"\u0000\u0000\u0000\u0115\u0116\u0005\u0010\u0000\u0000\u0116!\u0001\u0000"+
		"\u0000\u0000\u0117\u0118\u0005\u000f\u0000\u0000\u0118#\u0001\u0000\u0000"+
		"\u0000\u0119\u011b\u0005\u0011\u0000\u0000\u011a\u011c\u0003\u0004\u0002"+
		"\u0000\u011b\u011a\u0001\u0000\u0000\u0000\u011b\u011c\u0001\u0000\u0000"+
		"\u0000\u011c%\u0001\u0000\u0000\u0000\u011d\u0122\u0003\u0004\u0002\u0000"+
		"\u011e\u011f\u0005;\u0000\u0000\u011f\u0121\u0003\u0004\u0002\u0000\u0120"+
		"\u011e\u0001\u0000\u0000\u0000\u0121\u0124\u0001\u0000\u0000\u0000\u0122"+
		"\u0120\u0001\u0000\u0000\u0000\u0122\u0123\u0001\u0000\u0000\u0000\u0123"+
		"\'\u0001\u0000\u0000\u0000\u0124\u0122\u0001\u0000\u0000\u0000\u0017/"+
		"19@HRZ\u008b\u0095\u0097\u00a0\u00a6\u00b0\u00b2\u00c0\u00cd\u00d5\u00de"+
		"\u00fa\u0103\u010a\u011b\u0122";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}