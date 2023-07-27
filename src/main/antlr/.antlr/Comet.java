// Generated from /Users/conless/Desktop/study/system/sjtu-cs2966/comet/src/main/antlr/Comet.g4 by ANTLR 4.9.2
package dev.conless.comet.frontend.grammar;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Comet extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

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
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Void) | (1L << Bool) | (1L << Int) | (1L << String) | (1L << Class))) != 0) || _la==Identifier) {
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
	public static class CustomTypeContext extends TypeNameContext {
		public Token type;
		public TerminalNode Identifier() { return getToken(Comet.Identifier, 0); }
		public CustomTypeContext(TypeNameContext ctx) { copyFrom(ctx); }
	}
	public static class ArrayTypeContext extends TypeNameContext {
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TerminalNode LBracket() { return getToken(Comet.LBracket, 0); }
		public TerminalNode RBracket() { return getToken(Comet.RBracket, 0); }
		public ArrayTypeContext(TypeNameContext ctx) { copyFrom(ctx); }
	}
	public static class BuiltInTypeContext extends TypeNameContext {
		public Token type;
		public TerminalNode Int() { return getToken(Comet.Int, 0); }
		public TerminalNode Bool() { return getToken(Comet.Bool, 0); }
		public TerminalNode String() { return getToken(Comet.String, 0); }
		public TerminalNode Void() { return getToken(Comet.Void, 0); }
		public BuiltInTypeContext(TypeNameContext ctx) { copyFrom(ctx); }
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
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Void) | (1L << Bool) | (1L << Int) | (1L << String))) != 0)) ) {
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
	}
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
	}
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
	}
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
	}
	public static class NewExpressionContext extends ExpressionContext {
		public TerminalNode New() { return getToken(Comet.New, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TerminalNode LParen() { return getToken(Comet.LParen, 0); }
		public TerminalNode RParen() { return getToken(Comet.RParen, 0); }
		public NewExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
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
	}
	public static class PreSelfExpressionContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SelfAdd() { return getToken(Comet.SelfAdd, 0); }
		public TerminalNode SelfSub() { return getToken(Comet.SelfSub, 0); }
		public PreSelfExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class ParenExpressionContext extends ExpressionContext {
		public TerminalNode LParen() { return getToken(Comet.LParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RParen() { return getToken(Comet.RParen, 0); }
		public ParenExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
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
	}
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
	}
	public static class VariableExpressionContext extends ExpressionContext {
		public Token varibleName;
		public Token memberName;
		public TerminalNode Identifier() { return getToken(Comet.Identifier, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Member() { return getToken(Comet.Member, 0); }
		public VariableExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
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
				if (((((_la - 5)) & ~0x3f) == 0 && ((1L << (_la - 5)) & ((1L << (New - 5)) | (1L << (Null - 5)) | (1L << (True - 5)) | (1L << (False - 5)) | (1L << (This - 5)) | (1L << (Add - 5)) | (1L << (Sub - 5)) | (1L << (LogicNot - 5)) | (1L << (BitNot - 5)) | (1L << (SelfAdd - 5)) | (1L << (SelfSub - 5)) | (1L << (LParen - 5)) | (1L << (Identifier - 5)) | (1L << (IntegerConst - 5)) | (1L << (StringConst - 5)))) != 0)) {
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
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Add) | (1L << Sub) | (1L << LogicNot) | (1L << BitNot))) != 0)) ) {
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
				if ( !(((((_la - 7)) & ~0x3f) == 0 && ((1L << (_la - 7)) & ((1L << (Null - 7)) | (1L << (True - 7)) | (1L << (False - 7)) | (1L << (This - 7)) | (1L << (Identifier - 7)) | (1L << (IntegerConst - 7)) | (1L << (StringConst - 7)))) != 0)) ) {
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
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Mul) | (1L << Div) | (1L << Mod))) != 0)) ) {
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
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Greater) | (1L << Less) | (1L << GreaterEqual) | (1L << LessEqual))) != 0)) ) {
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
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Assign) | (1L << AddAssign) | (1L << SubAssign) | (1L << MulAssign) | (1L << DivAssign) | (1L << ModAssign) | (1L << AndAssign) | (1L << XorAssign) | (1L << OrAssign) | (1L << BitLShiftAssign) | (1L << BitRShiftAssign))) != 0)) ) {
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
						if (((((_la - 5)) & ~0x3f) == 0 && ((1L << (_la - 5)) & ((1L << (New - 5)) | (1L << (Null - 5)) | (1L << (True - 5)) | (1L << (False - 5)) | (1L << (This - 5)) | (1L << (Add - 5)) | (1L << (Sub - 5)) | (1L << (LogicNot - 5)) | (1L << (BitNot - 5)) | (1L << (SelfAdd - 5)) | (1L << (SelfSub - 5)) | (1L << (LParen - 5)) | (1L << (Identifier - 5)) | (1L << (IntegerConst - 5)) | (1L << (StringConst - 5)))) != 0)) {
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
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Void) | (1L << Bool) | (1L << Int) | (1L << String))) != 0) || _la==Identifier) {
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
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Void) | (1L << Bool) | (1L << Int) | (1L << String))) != 0) || _la==Identifier) {
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

	public static class ReturnTypeContext extends ParserRuleContext {
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public ReturnTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnType; }
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
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Void) | (1L << Bool) | (1L << Int) | (1L << String) | (1L << New) | (1L << Class) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << If) | (1L << For) | (1L << While) | (1L << Break) | (1L << Continue) | (1L << Return) | (1L << Add) | (1L << Sub) | (1L << LogicNot) | (1L << BitNot) | (1L << SelfAdd) | (1L << SelfSub) | (1L << LParen) | (1L << Semi) | (1L << LBrace))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (Identifier - 65)) | (1L << (IntegerConst - 65)) | (1L << (StringConst - 65)))) != 0)) {
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
			if (((((_la - 5)) & ~0x3f) == 0 && ((1L << (_la - 5)) & ((1L << (New - 5)) | (1L << (Null - 5)) | (1L << (True - 5)) | (1L << (False - 5)) | (1L << (This - 5)) | (1L << (Add - 5)) | (1L << (Sub - 5)) | (1L << (LogicNot - 5)) | (1L << (BitNot - 5)) | (1L << (SelfAdd - 5)) | (1L << (SelfSub - 5)) | (1L << (LParen - 5)) | (1L << (Identifier - 5)) | (1L << (IntegerConst - 5)) | (1L << (StringConst - 5)))) != 0)) {
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

	public static class ContinueStatementContext extends ParserRuleContext {
		public TerminalNode Continue() { return getToken(Comet.Continue, 0); }
		public ContinueStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_continueStatement; }
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

	public static class BreakStatementContext extends ParserRuleContext {
		public TerminalNode Break() { return getToken(Comet.Break, 0); }
		public BreakStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_breakStatement; }
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

	public static class ReturnStatementContext extends ParserRuleContext {
		public TerminalNode Return() { return getToken(Comet.Return, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
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
			if (((((_la - 5)) & ~0x3f) == 0 && ((1L << (_la - 5)) & ((1L << (New - 5)) | (1L << (Null - 5)) | (1L << (True - 5)) | (1L << (False - 5)) | (1L << (This - 5)) | (1L << (Add - 5)) | (1L << (Sub - 5)) | (1L << (LogicNot - 5)) | (1L << (BitNot - 5)) | (1L << (SelfAdd - 5)) | (1L << (SelfSub - 5)) | (1L << (LParen - 5)) | (1L << (Identifier - 5)) | (1L << (IntegerConst - 5)) | (1L << (StringConst - 5)))) != 0)) {
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3F\u0128\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\2\3\2\3\2\3\2\3\2\7\2\62\n\2"+
		"\f\2\16\2\65\13\2\3\2\3\2\3\3\3\3\3\3\5\3<\n\3\3\3\3\3\3\3\7\3A\n\3\f"+
		"\3\16\3D\13\3\3\4\3\4\3\4\3\4\3\4\5\4K\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\5\4U\n\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4]\n\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u008e\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\7\4\u0098\n\4\f\4\16\4\u009b\13\4\3\5\3\5\3\5\3\5\7\5\u00a1\n\5\f\5\16"+
		"\5\u00a4\13\5\3\6\3\6\3\6\5\6\u00a9\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\7\7\u00b3\n\7\f\7\16\7\u00b6\13\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3"+
		"\t\3\t\3\t\5\t\u00c3\n\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u00ce"+
		"\n\n\f\n\16\n\u00d1\13\n\3\13\3\13\3\13\7\13\u00d6\n\13\f\13\16\13\u00d9"+
		"\13\13\3\f\3\f\3\r\3\r\7\r\u00df\n\r\f\r\16\r\u00e2\13\r\3\r\3\r\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00fd\n\16\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\5\17\u0106\n\17\3\20\3\20\3\20\3\20\3\20\5\20\u010d"+
		"\n\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\23\3\23"+
		"\3\24\3\24\5\24\u011e\n\24\3\25\3\25\3\25\7\25\u0123\n\25\f\25\16\25\u0126"+
		"\13\25\3\25\2\4\4\6\26\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(\2"+
		"\f\3\2\3\6\5\2\24\25!!\'\'\3\2\63\64\5\2\t\fCDFF\3\2\26\30\3\2\24\25\3"+
		"\2\"#\3\2\31\34\3\2\35\36\3\2(\62\2\u0148\2\63\3\2\2\2\4;\3\2\2\2\6\\"+
		"\3\2\2\2\b\u009c\3\2\2\2\n\u00a5\3\2\2\2\f\u00aa\3\2\2\2\16\u00b9\3\2"+
		"\2\2\20\u00be\3\2\2\2\22\u00c7\3\2\2\2\24\u00d2\3\2\2\2\26\u00da\3\2\2"+
		"\2\30\u00dc\3\2\2\2\32\u00fc\3\2\2\2\34\u00fe\3\2\2\2\36\u0107\3\2\2\2"+
		" \u0111\3\2\2\2\"\u0117\3\2\2\2$\u0119\3\2\2\2&\u011b\3\2\2\2(\u011f\3"+
		"\2\2\2*+\5\b\5\2+,\7<\2\2,\62\3\2\2\2-.\5\f\7\2./\7<\2\2/\62\3\2\2\2\60"+
		"\62\5\20\t\2\61*\3\2\2\2\61-\3\2\2\2\61\60\3\2\2\2\62\65\3\2\2\2\63\61"+
		"\3\2\2\2\63\64\3\2\2\2\64\66\3\2\2\2\65\63\3\2\2\2\66\67\7\2\2\3\67\3"+
		"\3\2\2\289\b\3\1\29<\t\2\2\2:<\7C\2\2;8\3\2\2\2;:\3\2\2\2<B\3\2\2\2=>"+
		"\f\3\2\2>?\7\66\2\2?A\7\67\2\2@=\3\2\2\2AD\3\2\2\2B@\3\2\2\2BC\3\2\2\2"+
		"C\5\3\2\2\2DB\3\2\2\2EF\b\4\1\2FG\7\7\2\2GJ\5\4\3\2HI\78\2\2IK\79\2\2"+
		"JH\3\2\2\2JK\3\2\2\2K]\3\2\2\2LM\78\2\2MN\5\6\4\2NO\79\2\2O]\3\2\2\2P"+
		"]\7C\2\2QR\7C\2\2RT\78\2\2SU\5\24\13\2TS\3\2\2\2TU\3\2\2\2UV\3\2\2\2V"+
		"]\79\2\2WX\t\3\2\2X]\5\6\4\21YZ\t\4\2\2Z]\5\6\4\20[]\t\5\2\2\\E\3\2\2"+
		"\2\\L\3\2\2\2\\P\3\2\2\2\\Q\3\2\2\2\\W\3\2\2\2\\Y\3\2\2\2\\[\3\2\2\2]"+
		"\u0099\3\2\2\2^_\f\17\2\2_`\t\6\2\2`\u0098\5\6\4\20ab\f\16\2\2bc\t\7\2"+
		"\2c\u0098\5\6\4\17de\f\r\2\2ef\t\b\2\2f\u0098\5\6\4\16gh\f\f\2\2hi\t\t"+
		"\2\2i\u0098\5\6\4\rjk\f\13\2\2kl\t\n\2\2l\u0098\5\6\4\fmn\f\n\2\2no\7"+
		"$\2\2o\u0098\5\6\4\13pq\f\t\2\2qr\7&\2\2r\u0098\5\6\4\nst\f\b\2\2tu\7"+
		"%\2\2u\u0098\5\6\4\tvw\f\7\2\2wx\7\37\2\2x\u0098\5\6\4\byz\f\6\2\2z{\7"+
		" \2\2{\u0098\5\6\4\7|}\f\5\2\2}~\7:\2\2~\177\5\6\4\2\177\u0080\7;\2\2"+
		"\u0080\u0081\5\6\4\6\u0081\u0098\3\2\2\2\u0082\u0083\f\4\2\2\u0083\u0084"+
		"\t\13\2\2\u0084\u0098\5\6\4\5\u0085\u0086\f\26\2\2\u0086\u0087\7\65\2"+
		"\2\u0087\u0098\7C\2\2\u0088\u0089\f\24\2\2\u0089\u008a\7\65\2\2\u008a"+
		"\u008b\7C\2\2\u008b\u008d\78\2\2\u008c\u008e\5\24\13\2\u008d\u008c\3\2"+
		"\2\2\u008d\u008e\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0098\79\2\2\u0090"+
		"\u0091\f\23\2\2\u0091\u0092\7\66\2\2\u0092\u0093\5\6\4\2\u0093\u0094\7"+
		"\67\2\2\u0094\u0098\3\2\2\2\u0095\u0096\f\22\2\2\u0096\u0098\t\4\2\2\u0097"+
		"^\3\2\2\2\u0097a\3\2\2\2\u0097d\3\2\2\2\u0097g\3\2\2\2\u0097j\3\2\2\2"+
		"\u0097m\3\2\2\2\u0097p\3\2\2\2\u0097s\3\2\2\2\u0097v\3\2\2\2\u0097y\3"+
		"\2\2\2\u0097|\3\2\2\2\u0097\u0082\3\2\2\2\u0097\u0085\3\2\2\2\u0097\u0088"+
		"\3\2\2\2\u0097\u0090\3\2\2\2\u0097\u0095\3\2\2\2\u0098\u009b\3\2\2\2\u0099"+
		"\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a\7\3\2\2\2\u009b\u0099\3\2\2\2"+
		"\u009c\u009d\5\4\3\2\u009d\u00a2\5\n\6\2\u009e\u009f\7=\2\2\u009f\u00a1"+
		"\5\n\6\2\u00a0\u009e\3\2\2\2\u00a1\u00a4\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a2"+
		"\u00a3\3\2\2\2\u00a3\t\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a5\u00a8\7C\2\2"+
		"\u00a6\u00a7\7(\2\2\u00a7\u00a9\5\6\4\2\u00a8\u00a6\3\2\2\2\u00a8\u00a9"+
		"\3\2\2\2\u00a9\13\3\2\2\2\u00aa\u00ab\7\b\2\2\u00ab\u00ac\7C\2\2\u00ac"+
		"\u00b4\7>\2\2\u00ad\u00ae\5\b\5\2\u00ae\u00af\7<\2\2\u00af\u00b3\3\2\2"+
		"\2\u00b0\u00b3\5\20\t\2\u00b1\u00b3\5\16\b\2\u00b2\u00ad\3\2\2\2\u00b2"+
		"\u00b0\3\2\2\2\u00b2\u00b1\3\2\2\2\u00b3\u00b6\3\2\2\2\u00b4\u00b2\3\2"+
		"\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b7\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b7"+
		"\u00b8\7?\2\2\u00b8\r\3\2\2\2\u00b9\u00ba\7C\2\2\u00ba\u00bb\78\2\2\u00bb"+
		"\u00bc\79\2\2\u00bc\u00bd\5\30\r\2\u00bd\17\3\2\2\2\u00be\u00bf\5\26\f"+
		"\2\u00bf\u00c0\7C\2\2\u00c0\u00c2\78\2\2\u00c1\u00c3\5\22\n\2\u00c2\u00c1"+
		"\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c5\79\2\2\u00c5"+
		"\u00c6\5\30\r\2\u00c6\21\3\2\2\2\u00c7\u00c8\5\4\3\2\u00c8\u00cf\5\n\6"+
		"\2\u00c9\u00ca\7=\2\2\u00ca\u00cb\5\4\3\2\u00cb\u00cc\5\n\6\2\u00cc\u00ce"+
		"\3\2\2\2\u00cd\u00c9\3\2\2\2\u00ce\u00d1\3\2\2\2\u00cf\u00cd\3\2\2\2\u00cf"+
		"\u00d0\3\2\2\2\u00d0\23\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d2\u00d7\5\6\4"+
		"\2\u00d3\u00d4\7=\2\2\u00d4\u00d6\5\6\4\2\u00d5\u00d3\3\2\2\2\u00d6\u00d9"+
		"\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\25\3\2\2\2\u00d9"+
		"\u00d7\3\2\2\2\u00da\u00db\5\4\3\2\u00db\27\3\2\2\2\u00dc\u00e0\7>\2\2"+
		"\u00dd\u00df\5\32\16\2\u00de\u00dd\3\2\2\2\u00df\u00e2\3\2\2\2\u00e0\u00de"+
		"\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e3\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e3"+
		"\u00e4\7?\2\2\u00e4\31\3\2\2\2\u00e5\u00fd\5\30\r\2\u00e6\u00fd\5\34\17"+
		"\2\u00e7\u00fd\5\36\20\2\u00e8\u00fd\5 \21\2\u00e9\u00ea\5\b\5\2\u00ea"+
		"\u00eb\7<\2\2\u00eb\u00fd\3\2\2\2\u00ec\u00ed\5\f\7\2\u00ed\u00ee\7<\2"+
		"\2\u00ee\u00fd\3\2\2\2\u00ef\u00f0\5\"\22\2\u00f0\u00f1\7<\2\2\u00f1\u00fd"+
		"\3\2\2\2\u00f2\u00f3\5$\23\2\u00f3\u00f4\7<\2\2\u00f4\u00fd\3\2\2\2\u00f5"+
		"\u00f6\5&\24\2\u00f6\u00f7\7<\2\2\u00f7\u00fd\3\2\2\2\u00f8\u00f9\5(\25"+
		"\2\u00f9\u00fa\7<\2\2\u00fa\u00fd\3\2\2\2\u00fb\u00fd\7<\2\2\u00fc\u00e5"+
		"\3\2\2\2\u00fc\u00e6\3\2\2\2\u00fc\u00e7\3\2\2\2\u00fc\u00e8\3\2\2\2\u00fc"+
		"\u00e9\3\2\2\2\u00fc\u00ec\3\2\2\2\u00fc\u00ef\3\2\2\2\u00fc\u00f2\3\2"+
		"\2\2\u00fc\u00f5\3\2\2\2\u00fc\u00f8\3\2\2\2\u00fc\u00fb\3\2\2\2\u00fd"+
		"\33\3\2\2\2\u00fe\u00ff\7\r\2\2\u00ff\u0100\78\2\2\u0100\u0101\5\6\4\2"+
		"\u0101\u0102\79\2\2\u0102\u0105\5\32\16\2\u0103\u0104\7\16\2\2\u0104\u0106"+
		"\5\32\16\2\u0105\u0103\3\2\2\2\u0105\u0106\3\2\2\2\u0106\35\3\2\2\2\u0107"+
		"\u0108\7\17\2\2\u0108\u0109\78\2\2\u0109\u010a\5\32\16\2\u010a\u010c\5"+
		"\32\16\2\u010b\u010d\5(\25\2\u010c\u010b\3\2\2\2\u010c\u010d\3\2\2\2\u010d"+
		"\u010e\3\2\2\2\u010e\u010f\79\2\2\u010f\u0110\5\32\16\2\u0110\37\3\2\2"+
		"\2\u0111\u0112\7\20\2\2\u0112\u0113\78\2\2\u0113\u0114\5\6\4\2\u0114\u0115"+
		"\79\2\2\u0115\u0116\5\32\16\2\u0116!\3\2\2\2\u0117\u0118\7\22\2\2\u0118"+
		"#\3\2\2\2\u0119\u011a\7\21\2\2\u011a%\3\2\2\2\u011b\u011d\7\23\2\2\u011c"+
		"\u011e\5\6\4\2\u011d\u011c\3\2\2\2\u011d\u011e\3\2\2\2\u011e\'\3\2\2\2"+
		"\u011f\u0124\5\6\4\2\u0120\u0121\7=\2\2\u0121\u0123\5\6\4\2\u0122\u0120"+
		"\3\2\2\2\u0123\u0126\3\2\2\2\u0124\u0122\3\2\2\2\u0124\u0125\3\2\2\2\u0125"+
		")\3\2\2\2\u0126\u0124\3\2\2\2\31\61\63;BJT\\\u008d\u0097\u0099\u00a2\u00a8"+
		"\u00b2\u00b4\u00c2\u00cf\u00d7\u00e0\u00fc\u0105\u010c\u011d\u0124";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}