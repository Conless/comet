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
		RULE_program = 0, RULE_type = 1, RULE_typeName = 2, RULE_expr = 3, RULE_varDef = 4, 
		RULE_varCtor = 5, RULE_classDef = 6, RULE_classCtor = 7, RULE_funcDef = 8, 
		RULE_funcParaList = 9, RULE_funcArgList = 10, RULE_returnType = 11, RULE_blockStmt = 12, 
		RULE_stmt = 13, RULE_ifStmt = 14, RULE_forStmt = 15, RULE_whileStmt = 16, 
		RULE_continueStmt = 17, RULE_breakStmt = 18, RULE_returnStmt = 19, RULE_exprStmt = 20;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "type", "typeName", "expr", "varDef", "varCtor", "classDef", 
			"classCtor", "funcDef", "funcParaList", "funcArgList", "returnType", 
			"blockStmt", "stmt", "ifStmt", "forStmt", "whileStmt", "continueStmt", 
			"breakStmt", "returnStmt", "exprStmt"
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
		public List<FuncDefContext> funcDef() {
			return getRuleContexts(FuncDefContext.class);
		}
		public FuncDefContext funcDef(int i) {
			return getRuleContext(FuncDefContext.class,i);
		}
		public List<VarDefContext> varDef() {
			return getRuleContexts(VarDefContext.class);
		}
		public VarDefContext varDef(int i) {
			return getRuleContext(VarDefContext.class,i);
		}
		public List<TerminalNode> Semi() { return getTokens(Comet.Semi); }
		public TerminalNode Semi(int i) {
			return getToken(Comet.Semi, i);
		}
		public List<ClassDefContext> classDef() {
			return getRuleContexts(ClassDefContext.class);
		}
		public ClassDefContext classDef(int i) {
			return getRuleContext(ClassDefContext.class,i);
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
			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Void) | (1L << Bool) | (1L << Int) | (1L << String) | (1L << Class))) != 0) || _la==Identifier) {
				{
				setState(49);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					{
					setState(42);
					varDef();
					setState(43);
					match(Semi);
					}
					}
					break;
				case 2:
					{
					{
					setState(45);
					classDef();
					setState(46);
					match(Semi);
					}
					}
					break;
				case 3:
					{
					setState(48);
					funcDef();
					}
					break;
				}
				}
				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(54);
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

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode Int() { return getToken(Comet.Int, 0); }
		public TerminalNode Bool() { return getToken(Comet.Bool, 0); }
		public TerminalNode String() { return getToken(Comet.String, 0); }
		public TerminalNode Void() { return getToken(Comet.Void, 0); }
		public TerminalNode Identifier() { return getToken(Comet.Identifier, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Void) | (1L << Bool) | (1L << Int) | (1L << String))) != 0) || _la==Identifier) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class TypeNameContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> LBracket() { return getTokens(Comet.LBracket); }
		public TerminalNode LBracket(int i) {
			return getToken(Comet.LBracket, i);
		}
		public List<TerminalNode> RBracket() { return getTokens(Comet.RBracket); }
		public TerminalNode RBracket(int i) {
			return getToken(Comet.RBracket, i);
		}
		public TypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeName; }
	}

	public final TypeNameContext typeName() throws RecognitionException {
		TypeNameContext _localctx = new TypeNameContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_typeName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			type();
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBracket) {
				{
				{
				setState(59);
				match(LBracket);
				setState(60);
				match(RBracket);
				}
				}
				setState(65);
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

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NewExprContext extends ExprContext {
		public TerminalNode New() { return getToken(Comet.New, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> LBracket() { return getTokens(Comet.LBracket); }
		public TerminalNode LBracket(int i) {
			return getToken(Comet.LBracket, i);
		}
		public List<TerminalNode> RBracket() { return getTokens(Comet.RBracket); }
		public TerminalNode RBracket(int i) {
			return getToken(Comet.RBracket, i);
		}
		public TerminalNode LParen() { return getToken(Comet.LParen, 0); }
		public TerminalNode RParen() { return getToken(Comet.RParen, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public NewExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class IndexExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LBracket() { return getToken(Comet.LBracket, 0); }
		public TerminalNode RBracket() { return getToken(Comet.RBracket, 0); }
		public IndexExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class BinaryArithExprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
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
		public BinaryArithExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class PreSelfExprContext extends ExprContext {
		public Token op;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SelfAdd() { return getToken(Comet.SelfAdd, 0); }
		public TerminalNode SelfSub() { return getToken(Comet.SelfSub, 0); }
		public PreSelfExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class MemberExprContext extends ExprContext {
		public Token member;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode Member() { return getToken(Comet.Member, 0); }
		public TerminalNode Identifier() { return getToken(Comet.Identifier, 0); }
		public MemberExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class AtomExprContext extends ExprContext {
		public Token value;
		public TerminalNode IntegerConst() { return getToken(Comet.IntegerConst, 0); }
		public TerminalNode StringConst() { return getToken(Comet.StringConst, 0); }
		public TerminalNode True() { return getToken(Comet.True, 0); }
		public TerminalNode False() { return getToken(Comet.False, 0); }
		public TerminalNode Null() { return getToken(Comet.Null, 0); }
		public TerminalNode Identifier() { return getToken(Comet.Identifier, 0); }
		public TerminalNode This() { return getToken(Comet.This, 0); }
		public AtomExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class UnaryArithExprContext extends ExprContext {
		public Token op;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode LogicNot() { return getToken(Comet.LogicNot, 0); }
		public TerminalNode BitNot() { return getToken(Comet.BitNot, 0); }
		public TerminalNode Add() { return getToken(Comet.Add, 0); }
		public TerminalNode Sub() { return getToken(Comet.Sub, 0); }
		public TerminalNode SelfAdd() { return getToken(Comet.SelfAdd, 0); }
		public TerminalNode SelfSub() { return getToken(Comet.SelfSub, 0); }
		public UnaryArithExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class CallExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode LParen() { return getToken(Comet.LParen, 0); }
		public TerminalNode RParen() { return getToken(Comet.RParen, 0); }
		public FuncArgListContext funcArgList() {
			return getRuleContext(FuncArgListContext.class,0);
		}
		public CallExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class AssignExprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
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
		public AssignExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class ParenExprContext extends ExprContext {
		public TerminalNode LParen() { return getToken(Comet.LParen, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RParen() { return getToken(Comet.RParen, 0); }
		public ParenExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class ConditionalExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode QMark() { return getToken(Comet.QMark, 0); }
		public TerminalNode Colon() { return getToken(Comet.Colon, 0); }
		public ConditionalExprContext(ExprContext ctx) { copyFrom(ctx); }
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case New:
				{
				_localctx = new NewExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(67);
				match(New);
				setState(68);
				type();
				setState(76);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(69);
						match(LBracket);
						setState(71);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (((((_la - 5)) & ~0x3f) == 0 && ((1L << (_la - 5)) & ((1L << (New - 5)) | (1L << (Null - 5)) | (1L << (True - 5)) | (1L << (False - 5)) | (1L << (This - 5)) | (1L << (Add - 5)) | (1L << (Sub - 5)) | (1L << (LogicNot - 5)) | (1L << (BitNot - 5)) | (1L << (SelfAdd - 5)) | (1L << (SelfSub - 5)) | (1L << (LParen - 5)) | (1L << (Identifier - 5)) | (1L << (IntegerConst - 5)) | (1L << (StringConst - 5)))) != 0)) {
							{
							setState(70);
							expr(0);
							}
						}

						setState(73);
						match(RBracket);
						}
						} 
					}
					setState(78);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				}
				setState(81);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
				case 1:
					{
					setState(79);
					match(LParen);
					setState(80);
					match(RParen);
					}
					break;
				}
				}
				break;
			case LParen:
				{
				_localctx = new ParenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(83);
				match(LParen);
				setState(84);
				expr(0);
				setState(85);
				match(RParen);
				}
				break;
			case Add:
			case Sub:
			case LogicNot:
			case BitNot:
				{
				_localctx = new UnaryArithExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(87);
				((UnaryArithExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Add) | (1L << Sub) | (1L << LogicNot) | (1L << BitNot))) != 0)) ) {
					((UnaryArithExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(88);
				expr(15);
				}
				break;
			case SelfAdd:
			case SelfSub:
				{
				_localctx = new PreSelfExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(89);
				((PreSelfExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==SelfAdd || _la==SelfSub) ) {
					((PreSelfExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(90);
				expr(14);
				}
				break;
			case Null:
			case True:
			case False:
			case This:
			case Identifier:
			case IntegerConst:
			case StringConst:
				{
				_localctx = new AtomExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(91);
				((AtomExprContext)_localctx).value = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 7)) & ~0x3f) == 0 && ((1L << (_la - 7)) & ((1L << (Null - 7)) | (1L << (True - 7)) | (1L << (False - 7)) | (1L << (This - 7)) | (1L << (Identifier - 7)) | (1L << (IntegerConst - 7)) | (1L << (StringConst - 7)))) != 0)) ) {
					((AtomExprContext)_localctx).value = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
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
						_localctx = new BinaryArithExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(94);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(95);
						((BinaryArithExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Mul) | (1L << Div) | (1L << Mod))) != 0)) ) {
							((BinaryArithExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(96);
						expr(14);
						}
						break;
					case 2:
						{
						_localctx = new BinaryArithExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(97);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(98);
						((BinaryArithExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==Add || _la==Sub) ) {
							((BinaryArithExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(99);
						expr(13);
						}
						break;
					case 3:
						{
						_localctx = new BinaryArithExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(100);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(101);
						((BinaryArithExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==BitRShift || _la==BitLShift) ) {
							((BinaryArithExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(102);
						expr(12);
						}
						break;
					case 4:
						{
						_localctx = new BinaryArithExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(103);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(104);
						((BinaryArithExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Greater) | (1L << Less) | (1L << GreaterEqual) | (1L << LessEqual))) != 0)) ) {
							((BinaryArithExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(105);
						expr(11);
						}
						break;
					case 5:
						{
						_localctx = new BinaryArithExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(106);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(107);
						((BinaryArithExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==NotEqual || _la==Eqaul) ) {
							((BinaryArithExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(108);
						expr(10);
						}
						break;
					case 6:
						{
						_localctx = new BinaryArithExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(109);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(110);
						((BinaryArithExprContext)_localctx).op = match(BitAnd);
						setState(111);
						expr(9);
						}
						break;
					case 7:
						{
						_localctx = new BinaryArithExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(112);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(113);
						((BinaryArithExprContext)_localctx).op = match(BitXor);
						setState(114);
						expr(8);
						}
						break;
					case 8:
						{
						_localctx = new BinaryArithExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(115);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(116);
						((BinaryArithExprContext)_localctx).op = match(BitOr);
						setState(117);
						expr(7);
						}
						break;
					case 9:
						{
						_localctx = new BinaryArithExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(118);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(119);
						((BinaryArithExprContext)_localctx).op = match(LogicAnd);
						setState(120);
						expr(6);
						}
						break;
					case 10:
						{
						_localctx = new BinaryArithExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(121);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(122);
						((BinaryArithExprContext)_localctx).op = match(LogicOr);
						setState(123);
						expr(5);
						}
						break;
					case 11:
						{
						_localctx = new ConditionalExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(124);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(125);
						match(QMark);
						setState(126);
						expr(0);
						setState(127);
						match(Colon);
						setState(128);
						expr(4);
						}
						break;
					case 12:
						{
						_localctx = new AssignExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(130);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(131);
						((AssignExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Assign) | (1L << AddAssign) | (1L << SubAssign) | (1L << MulAssign) | (1L << DivAssign) | (1L << ModAssign) | (1L << AndAssign) | (1L << XorAssign) | (1L << OrAssign) | (1L << BitLShiftAssign) | (1L << BitRShiftAssign))) != 0)) ) {
							((AssignExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(132);
						expr(3);
						}
						break;
					case 13:
						{
						_localctx = new MemberExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(133);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(134);
						match(Member);
						setState(135);
						((MemberExprContext)_localctx).member = match(Identifier);
						}
						break;
					case 14:
						{
						_localctx = new CallExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(136);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(137);
						match(LParen);
						setState(139);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (((((_la - 5)) & ~0x3f) == 0 && ((1L << (_la - 5)) & ((1L << (New - 5)) | (1L << (Null - 5)) | (1L << (True - 5)) | (1L << (False - 5)) | (1L << (This - 5)) | (1L << (Add - 5)) | (1L << (Sub - 5)) | (1L << (LogicNot - 5)) | (1L << (BitNot - 5)) | (1L << (SelfAdd - 5)) | (1L << (SelfSub - 5)) | (1L << (LParen - 5)) | (1L << (Identifier - 5)) | (1L << (IntegerConst - 5)) | (1L << (StringConst - 5)))) != 0)) {
							{
							setState(138);
							funcArgList();
							}
						}

						setState(141);
						match(RParen);
						}
						break;
					case 15:
						{
						_localctx = new IndexExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(142);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(143);
						match(LBracket);
						setState(144);
						expr(0);
						setState(145);
						match(RBracket);
						}
						break;
					case 16:
						{
						_localctx = new UnaryArithExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(147);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(148);
						((UnaryArithExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==SelfAdd || _la==SelfSub) ) {
							((UnaryArithExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
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

	public static class VarDefContext extends ParserRuleContext {
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public List<VarCtorContext> varCtor() {
			return getRuleContexts(VarCtorContext.class);
		}
		public VarCtorContext varCtor(int i) {
			return getRuleContext(VarCtorContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(Comet.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(Comet.Comma, i);
		}
		public VarDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDef; }
	}

	public final VarDefContext varDef() throws RecognitionException {
		VarDefContext _localctx = new VarDefContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_varDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			typeName();
			setState(155);
			varCtor();
			setState(160);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(156);
				match(Comma);
				setState(157);
				varCtor();
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

	public static class VarCtorContext extends ParserRuleContext {
		public Token varName;
		public TerminalNode Identifier() { return getToken(Comet.Identifier, 0); }
		public TerminalNode Assign() { return getToken(Comet.Assign, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public VarCtorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varCtor; }
	}

	public final VarCtorContext varCtor() throws RecognitionException {
		VarCtorContext _localctx = new VarCtorContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_varCtor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			((VarCtorContext)_localctx).varName = match(Identifier);
			setState(166);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Assign) {
				{
				setState(164);
				match(Assign);
				setState(165);
				expr(0);
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

	public static class ClassDefContext extends ParserRuleContext {
		public Token className;
		public TerminalNode Class() { return getToken(Comet.Class, 0); }
		public TerminalNode LBrace() { return getToken(Comet.LBrace, 0); }
		public TerminalNode RBrace() { return getToken(Comet.RBrace, 0); }
		public TerminalNode Identifier() { return getToken(Comet.Identifier, 0); }
		public List<FuncDefContext> funcDef() {
			return getRuleContexts(FuncDefContext.class);
		}
		public FuncDefContext funcDef(int i) {
			return getRuleContext(FuncDefContext.class,i);
		}
		public List<ClassCtorContext> classCtor() {
			return getRuleContexts(ClassCtorContext.class);
		}
		public ClassCtorContext classCtor(int i) {
			return getRuleContext(ClassCtorContext.class,i);
		}
		public List<VarDefContext> varDef() {
			return getRuleContexts(VarDefContext.class);
		}
		public VarDefContext varDef(int i) {
			return getRuleContext(VarDefContext.class,i);
		}
		public List<TerminalNode> Semi() { return getTokens(Comet.Semi); }
		public TerminalNode Semi(int i) {
			return getToken(Comet.Semi, i);
		}
		public ClassDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDef; }
	}

	public final ClassDefContext classDef() throws RecognitionException {
		ClassDefContext _localctx = new ClassDefContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_classDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			match(Class);
			setState(169);
			((ClassDefContext)_localctx).className = match(Identifier);
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
					varDef();
					setState(172);
					match(Semi);
					}
					}
					break;
				case 2:
					{
					setState(174);
					funcDef();
					}
					break;
				case 3:
					{
					setState(175);
					classCtor();
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

	public static class ClassCtorContext extends ParserRuleContext {
		public Token className;
		public TerminalNode LParen() { return getToken(Comet.LParen, 0); }
		public TerminalNode RParen() { return getToken(Comet.RParen, 0); }
		public BlockStmtContext blockStmt() {
			return getRuleContext(BlockStmtContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(Comet.Identifier, 0); }
		public ClassCtorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classCtor; }
	}

	public final ClassCtorContext classCtor() throws RecognitionException {
		ClassCtorContext _localctx = new ClassCtorContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_classCtor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			((ClassCtorContext)_localctx).className = match(Identifier);
			setState(184);
			match(LParen);
			setState(185);
			match(RParen);
			setState(186);
			blockStmt();
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

	public static class FuncDefContext extends ParserRuleContext {
		public Token funcName;
		public ReturnTypeContext returnType() {
			return getRuleContext(ReturnTypeContext.class,0);
		}
		public TerminalNode LParen() { return getToken(Comet.LParen, 0); }
		public TerminalNode RParen() { return getToken(Comet.RParen, 0); }
		public BlockStmtContext blockStmt() {
			return getRuleContext(BlockStmtContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(Comet.Identifier, 0); }
		public FuncParaListContext funcParaList() {
			return getRuleContext(FuncParaListContext.class,0);
		}
		public FuncDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDef; }
	}

	public final FuncDefContext funcDef() throws RecognitionException {
		FuncDefContext _localctx = new FuncDefContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_funcDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			returnType();
			setState(189);
			((FuncDefContext)_localctx).funcName = match(Identifier);
			setState(190);
			match(LParen);
			setState(192);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Void) | (1L << Bool) | (1L << Int) | (1L << String))) != 0) || _la==Identifier) {
				{
				setState(191);
				funcParaList();
				}
			}

			setState(194);
			match(RParen);
			setState(195);
			blockStmt();
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

	public static class FuncParaListContext extends ParserRuleContext {
		public List<TypeNameContext> typeName() {
			return getRuleContexts(TypeNameContext.class);
		}
		public TypeNameContext typeName(int i) {
			return getRuleContext(TypeNameContext.class,i);
		}
		public List<VarCtorContext> varCtor() {
			return getRuleContexts(VarCtorContext.class);
		}
		public VarCtorContext varCtor(int i) {
			return getRuleContext(VarCtorContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(Comet.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(Comet.Comma, i);
		}
		public FuncParaListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcParaList; }
	}

	public final FuncParaListContext funcParaList() throws RecognitionException {
		FuncParaListContext _localctx = new FuncParaListContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_funcParaList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			typeName();
			setState(198);
			varCtor();
			setState(205);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(199);
				match(Comma);
				setState(200);
				typeName();
				setState(201);
				varCtor();
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

	public static class FuncArgListContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(Comet.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(Comet.Comma, i);
		}
		public FuncArgListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcArgList; }
	}

	public final FuncArgListContext funcArgList() throws RecognitionException {
		FuncArgListContext _localctx = new FuncArgListContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_funcArgList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			expr(0);
			setState(213);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(209);
				match(Comma);
				setState(210);
				expr(0);
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
		enterRule(_localctx, 22, RULE_returnType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			typeName();
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

	public static class BlockStmtContext extends ParserRuleContext {
		public TerminalNode LBrace() { return getToken(Comet.LBrace, 0); }
		public TerminalNode RBrace() { return getToken(Comet.RBrace, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public BlockStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockStmt; }
	}

	public final BlockStmtContext blockStmt() throws RecognitionException {
		BlockStmtContext _localctx = new BlockStmtContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_blockStmt);
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
				stmt();
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

	public static class StmtContext extends ParserRuleContext {
		public BlockStmtContext blockStmt() {
			return getRuleContext(BlockStmtContext.class,0);
		}
		public IfStmtContext ifStmt() {
			return getRuleContext(IfStmtContext.class,0);
		}
		public ForStmtContext forStmt() {
			return getRuleContext(ForStmtContext.class,0);
		}
		public WhileStmtContext whileStmt() {
			return getRuleContext(WhileStmtContext.class,0);
		}
		public VarDefContext varDef() {
			return getRuleContext(VarDefContext.class,0);
		}
		public TerminalNode Semi() { return getToken(Comet.Semi, 0); }
		public ClassDefContext classDef() {
			return getRuleContext(ClassDefContext.class,0);
		}
		public ContinueStmtContext continueStmt() {
			return getRuleContext(ContinueStmtContext.class,0);
		}
		public BreakStmtContext breakStmt() {
			return getRuleContext(BreakStmtContext.class,0);
		}
		public ReturnStmtContext returnStmt() {
			return getRuleContext(ReturnStmtContext.class,0);
		}
		public ExprStmtContext exprStmt() {
			return getRuleContext(ExprStmtContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_stmt);
		try {
			setState(250);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(227);
				blockStmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(228);
				ifStmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(229);
				forStmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(230);
				whileStmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(231);
				varDef();
				setState(232);
				match(Semi);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(234);
				classDef();
				setState(235);
				match(Semi);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(237);
				continueStmt();
				setState(238);
				match(Semi);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(240);
				breakStmt();
				setState(241);
				match(Semi);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(243);
				returnStmt();
				setState(244);
				match(Semi);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(246);
				exprStmt();
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

	public static class IfStmtContext extends ParserRuleContext {
		public TerminalNode If() { return getToken(Comet.If, 0); }
		public TerminalNode LParen() { return getToken(Comet.LParen, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RParen() { return getToken(Comet.RParen, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public TerminalNode Else() { return getToken(Comet.Else, 0); }
		public IfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStmt; }
	}

	public final IfStmtContext ifStmt() throws RecognitionException {
		IfStmtContext _localctx = new IfStmtContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_ifStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			match(If);
			setState(253);
			match(LParen);
			setState(254);
			expr(0);
			setState(255);
			match(RParen);
			setState(256);
			stmt();
			setState(259);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(257);
				match(Else);
				setState(258);
				stmt();
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

	public static class ForStmtContext extends ParserRuleContext {
		public StmtContext init;
		public StmtContext condition;
		public ExprStmtContext update;
		public TerminalNode For() { return getToken(Comet.For, 0); }
		public TerminalNode LParen() { return getToken(Comet.LParen, 0); }
		public TerminalNode RParen() { return getToken(Comet.RParen, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public ExprStmtContext exprStmt() {
			return getRuleContext(ExprStmtContext.class,0);
		}
		public ForStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStmt; }
	}

	public final ForStmtContext forStmt() throws RecognitionException {
		ForStmtContext _localctx = new ForStmtContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_forStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
			match(For);
			setState(262);
			match(LParen);
			setState(263);
			((ForStmtContext)_localctx).init = stmt();
			setState(264);
			((ForStmtContext)_localctx).condition = stmt();
			setState(266);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 5)) & ~0x3f) == 0 && ((1L << (_la - 5)) & ((1L << (New - 5)) | (1L << (Null - 5)) | (1L << (True - 5)) | (1L << (False - 5)) | (1L << (This - 5)) | (1L << (Add - 5)) | (1L << (Sub - 5)) | (1L << (LogicNot - 5)) | (1L << (BitNot - 5)) | (1L << (SelfAdd - 5)) | (1L << (SelfSub - 5)) | (1L << (LParen - 5)) | (1L << (Identifier - 5)) | (1L << (IntegerConst - 5)) | (1L << (StringConst - 5)))) != 0)) {
				{
				setState(265);
				((ForStmtContext)_localctx).update = exprStmt();
				}
			}

			setState(268);
			match(RParen);
			setState(269);
			stmt();
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

	public static class WhileStmtContext extends ParserRuleContext {
		public ExprContext condition;
		public TerminalNode While() { return getToken(Comet.While, 0); }
		public TerminalNode LParen() { return getToken(Comet.LParen, 0); }
		public TerminalNode RParen() { return getToken(Comet.RParen, 0); }
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public WhileStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStmt; }
	}

	public final WhileStmtContext whileStmt() throws RecognitionException {
		WhileStmtContext _localctx = new WhileStmtContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_whileStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
			match(While);
			setState(272);
			match(LParen);
			setState(273);
			((WhileStmtContext)_localctx).condition = expr(0);
			setState(274);
			match(RParen);
			setState(275);
			stmt();
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

	public static class ContinueStmtContext extends ParserRuleContext {
		public TerminalNode Continue() { return getToken(Comet.Continue, 0); }
		public ContinueStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_continueStmt; }
	}

	public final ContinueStmtContext continueStmt() throws RecognitionException {
		ContinueStmtContext _localctx = new ContinueStmtContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_continueStmt);
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

	public static class BreakStmtContext extends ParserRuleContext {
		public TerminalNode Break() { return getToken(Comet.Break, 0); }
		public BreakStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_breakStmt; }
	}

	public final BreakStmtContext breakStmt() throws RecognitionException {
		BreakStmtContext _localctx = new BreakStmtContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_breakStmt);
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

	public static class ReturnStmtContext extends ParserRuleContext {
		public TerminalNode Return() { return getToken(Comet.Return, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStmt; }
	}

	public final ReturnStmtContext returnStmt() throws RecognitionException {
		ReturnStmtContext _localctx = new ReturnStmtContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_returnStmt);
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
				expr(0);
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

	public static class ExprStmtContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(Comet.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(Comet.Comma, i);
		}
		public ExprStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprStmt; }
	}

	public final ExprStmtContext exprStmt() throws RecognitionException {
		ExprStmtContext _localctx = new ExprStmtContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_exprStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285);
			expr(0);
			setState(290);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(286);
				match(Comma);
				setState(287);
				expr(0);
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
		case 3:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 13);
		case 1:
			return precpred(_ctx, 12);
		case 2:
			return precpred(_ctx, 11);
		case 3:
			return precpred(_ctx, 10);
		case 4:
			return precpred(_ctx, 9);
		case 5:
			return precpred(_ctx, 8);
		case 6:
			return precpred(_ctx, 7);
		case 7:
			return precpred(_ctx, 6);
		case 8:
			return precpred(_ctx, 5);
		case 9:
			return precpred(_ctx, 4);
		case 10:
			return precpred(_ctx, 3);
		case 11:
			return precpred(_ctx, 2);
		case 12:
			return precpred(_ctx, 19);
		case 13:
			return precpred(_ctx, 18);
		case 14:
			return precpred(_ctx, 17);
		case 15:
			return precpred(_ctx, 16);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3F\u0128\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\2\3\2\3\2\3\2\3\2\7"+
		"\2\64\n\2\f\2\16\2\67\13\2\3\2\3\2\3\3\3\3\3\4\3\4\3\4\7\4@\n\4\f\4\16"+
		"\4C\13\4\3\5\3\5\3\5\3\5\3\5\5\5J\n\5\3\5\7\5M\n\5\f\5\16\5P\13\5\3\5"+
		"\3\5\5\5T\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5_\n\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u008e\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\7\5\u0098\n\5\f\5\16\5\u009b\13\5\3\6\3\6\3\6\3\6\7\6\u00a1\n\6\f"+
		"\6\16\6\u00a4\13\6\3\7\3\7\3\7\5\7\u00a9\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\7\b\u00b3\n\b\f\b\16\b\u00b6\13\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3"+
		"\n\3\n\3\n\3\n\5\n\u00c3\n\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\7\13\u00ce\n\13\f\13\16\13\u00d1\13\13\3\f\3\f\3\f\7\f\u00d6\n\f\f\f"+
		"\16\f\u00d9\13\f\3\r\3\r\3\16\3\16\7\16\u00df\n\16\f\16\16\16\u00e2\13"+
		"\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00fd"+
		"\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u0106\n\20\3\21\3\21\3\21"+
		"\3\21\3\21\5\21\u010d\n\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\23\3\23\3\24\3\24\3\25\3\25\5\25\u011e\n\25\3\26\3\26\3\26\7\26\u0123"+
		"\n\26\f\26\16\26\u0126\13\26\3\26\2\3\b\27\2\4\6\b\n\f\16\20\22\24\26"+
		"\30\32\34\36 \"$&(*\2\f\4\2\3\6CC\5\2\24\25!!\'\'\3\2\63\64\5\2\t\fCD"+
		"FF\3\2\26\30\3\2\24\25\3\2\"#\3\2\31\34\3\2\35\36\3\2(\62\2\u0145\2\65"+
		"\3\2\2\2\4:\3\2\2\2\6<\3\2\2\2\b^\3\2\2\2\n\u009c\3\2\2\2\f\u00a5\3\2"+
		"\2\2\16\u00aa\3\2\2\2\20\u00b9\3\2\2\2\22\u00be\3\2\2\2\24\u00c7\3\2\2"+
		"\2\26\u00d2\3\2\2\2\30\u00da\3\2\2\2\32\u00dc\3\2\2\2\34\u00fc\3\2\2\2"+
		"\36\u00fe\3\2\2\2 \u0107\3\2\2\2\"\u0111\3\2\2\2$\u0117\3\2\2\2&\u0119"+
		"\3\2\2\2(\u011b\3\2\2\2*\u011f\3\2\2\2,-\5\n\6\2-.\7<\2\2.\64\3\2\2\2"+
		"/\60\5\16\b\2\60\61\7<\2\2\61\64\3\2\2\2\62\64\5\22\n\2\63,\3\2\2\2\63"+
		"/\3\2\2\2\63\62\3\2\2\2\64\67\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2\668"+
		"\3\2\2\2\67\65\3\2\2\289\7\2\2\39\3\3\2\2\2:;\t\2\2\2;\5\3\2\2\2<A\5\4"+
		"\3\2=>\7\66\2\2>@\7\67\2\2?=\3\2\2\2@C\3\2\2\2A?\3\2\2\2AB\3\2\2\2B\7"+
		"\3\2\2\2CA\3\2\2\2DE\b\5\1\2EF\7\7\2\2FN\5\4\3\2GI\7\66\2\2HJ\5\b\5\2"+
		"IH\3\2\2\2IJ\3\2\2\2JK\3\2\2\2KM\7\67\2\2LG\3\2\2\2MP\3\2\2\2NL\3\2\2"+
		"\2NO\3\2\2\2OS\3\2\2\2PN\3\2\2\2QR\78\2\2RT\79\2\2SQ\3\2\2\2ST\3\2\2\2"+
		"T_\3\2\2\2UV\78\2\2VW\5\b\5\2WX\79\2\2X_\3\2\2\2YZ\t\3\2\2Z_\5\b\5\21"+
		"[\\\t\4\2\2\\_\5\b\5\20]_\t\5\2\2^D\3\2\2\2^U\3\2\2\2^Y\3\2\2\2^[\3\2"+
		"\2\2^]\3\2\2\2_\u0099\3\2\2\2`a\f\17\2\2ab\t\6\2\2b\u0098\5\b\5\20cd\f"+
		"\16\2\2de\t\7\2\2e\u0098\5\b\5\17fg\f\r\2\2gh\t\b\2\2h\u0098\5\b\5\16"+
		"ij\f\f\2\2jk\t\t\2\2k\u0098\5\b\5\rlm\f\13\2\2mn\t\n\2\2n\u0098\5\b\5"+
		"\fop\f\n\2\2pq\7$\2\2q\u0098\5\b\5\13rs\f\t\2\2st\7&\2\2t\u0098\5\b\5"+
		"\nuv\f\b\2\2vw\7%\2\2w\u0098\5\b\5\txy\f\7\2\2yz\7\37\2\2z\u0098\5\b\5"+
		"\b{|\f\6\2\2|}\7 \2\2}\u0098\5\b\5\7~\177\f\5\2\2\177\u0080\7:\2\2\u0080"+
		"\u0081\5\b\5\2\u0081\u0082\7;\2\2\u0082\u0083\5\b\5\6\u0083\u0098\3\2"+
		"\2\2\u0084\u0085\f\4\2\2\u0085\u0086\t\13\2\2\u0086\u0098\5\b\5\5\u0087"+
		"\u0088\f\25\2\2\u0088\u0089\7\65\2\2\u0089\u0098\7C\2\2\u008a\u008b\f"+
		"\24\2\2\u008b\u008d\78\2\2\u008c\u008e\5\26\f\2\u008d\u008c\3\2\2\2\u008d"+
		"\u008e\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0098\79\2\2\u0090\u0091\f\23"+
		"\2\2\u0091\u0092\7\66\2\2\u0092\u0093\5\b\5\2\u0093\u0094\7\67\2\2\u0094"+
		"\u0098\3\2\2\2\u0095\u0096\f\22\2\2\u0096\u0098\t\4\2\2\u0097`\3\2\2\2"+
		"\u0097c\3\2\2\2\u0097f\3\2\2\2\u0097i\3\2\2\2\u0097l\3\2\2\2\u0097o\3"+
		"\2\2\2\u0097r\3\2\2\2\u0097u\3\2\2\2\u0097x\3\2\2\2\u0097{\3\2\2\2\u0097"+
		"~\3\2\2\2\u0097\u0084\3\2\2\2\u0097\u0087\3\2\2\2\u0097\u008a\3\2\2\2"+
		"\u0097\u0090\3\2\2\2\u0097\u0095\3\2\2\2\u0098\u009b\3\2\2\2\u0099\u0097"+
		"\3\2\2\2\u0099\u009a\3\2\2\2\u009a\t\3\2\2\2\u009b\u0099\3\2\2\2\u009c"+
		"\u009d\5\6\4\2\u009d\u00a2\5\f\7\2\u009e\u009f\7=\2\2\u009f\u00a1\5\f"+
		"\7\2\u00a0\u009e\3\2\2\2\u00a1\u00a4\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a2"+
		"\u00a3\3\2\2\2\u00a3\13\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a5\u00a8\7C\2\2"+
		"\u00a6\u00a7\7(\2\2\u00a7\u00a9\5\b\5\2\u00a8\u00a6\3\2\2\2\u00a8\u00a9"+
		"\3\2\2\2\u00a9\r\3\2\2\2\u00aa\u00ab\7\b\2\2\u00ab\u00ac\7C\2\2\u00ac"+
		"\u00b4\7>\2\2\u00ad\u00ae\5\n\6\2\u00ae\u00af\7<\2\2\u00af\u00b3\3\2\2"+
		"\2\u00b0\u00b3\5\22\n\2\u00b1\u00b3\5\20\t\2\u00b2\u00ad\3\2\2\2\u00b2"+
		"\u00b0\3\2\2\2\u00b2\u00b1\3\2\2\2\u00b3\u00b6\3\2\2\2\u00b4\u00b2\3\2"+
		"\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b7\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b7"+
		"\u00b8\7?\2\2\u00b8\17\3\2\2\2\u00b9\u00ba\7C\2\2\u00ba\u00bb\78\2\2\u00bb"+
		"\u00bc\79\2\2\u00bc\u00bd\5\32\16\2\u00bd\21\3\2\2\2\u00be\u00bf\5\30"+
		"\r\2\u00bf\u00c0\7C\2\2\u00c0\u00c2\78\2\2\u00c1\u00c3\5\24\13\2\u00c2"+
		"\u00c1\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c5\79"+
		"\2\2\u00c5\u00c6\5\32\16\2\u00c6\23\3\2\2\2\u00c7\u00c8\5\6\4\2\u00c8"+
		"\u00cf\5\f\7\2\u00c9\u00ca\7=\2\2\u00ca\u00cb\5\6\4\2\u00cb\u00cc\5\f"+
		"\7\2\u00cc\u00ce\3\2\2\2\u00cd\u00c9\3\2\2\2\u00ce\u00d1\3\2\2\2\u00cf"+
		"\u00cd\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\25\3\2\2\2\u00d1\u00cf\3\2\2"+
		"\2\u00d2\u00d7\5\b\5\2\u00d3\u00d4\7=\2\2\u00d4\u00d6\5\b\5\2\u00d5\u00d3"+
		"\3\2\2\2\u00d6\u00d9\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8"+
		"\27\3\2\2\2\u00d9\u00d7\3\2\2\2\u00da\u00db\5\6\4\2\u00db\31\3\2\2\2\u00dc"+
		"\u00e0\7>\2\2\u00dd\u00df\5\34\17\2\u00de\u00dd\3\2\2\2\u00df\u00e2\3"+
		"\2\2\2\u00e0\u00de\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e3\3\2\2\2\u00e2"+
		"\u00e0\3\2\2\2\u00e3\u00e4\7?\2\2\u00e4\33\3\2\2\2\u00e5\u00fd\5\32\16"+
		"\2\u00e6\u00fd\5\36\20\2\u00e7\u00fd\5 \21\2\u00e8\u00fd\5\"\22\2\u00e9"+
		"\u00ea\5\n\6\2\u00ea\u00eb\7<\2\2\u00eb\u00fd\3\2\2\2\u00ec\u00ed\5\16"+
		"\b\2\u00ed\u00ee\7<\2\2\u00ee\u00fd\3\2\2\2\u00ef\u00f0\5$\23\2\u00f0"+
		"\u00f1\7<\2\2\u00f1\u00fd\3\2\2\2\u00f2\u00f3\5&\24\2\u00f3\u00f4\7<\2"+
		"\2\u00f4\u00fd\3\2\2\2\u00f5\u00f6\5(\25\2\u00f6\u00f7\7<\2\2\u00f7\u00fd"+
		"\3\2\2\2\u00f8\u00f9\5*\26\2\u00f9\u00fa\7<\2\2\u00fa\u00fd\3\2\2\2\u00fb"+
		"\u00fd\7<\2\2\u00fc\u00e5\3\2\2\2\u00fc\u00e6\3\2\2\2\u00fc\u00e7\3\2"+
		"\2\2\u00fc\u00e8\3\2\2\2\u00fc\u00e9\3\2\2\2\u00fc\u00ec\3\2\2\2\u00fc"+
		"\u00ef\3\2\2\2\u00fc\u00f2\3\2\2\2\u00fc\u00f5\3\2\2\2\u00fc\u00f8\3\2"+
		"\2\2\u00fc\u00fb\3\2\2\2\u00fd\35\3\2\2\2\u00fe\u00ff\7\r\2\2\u00ff\u0100"+
		"\78\2\2\u0100\u0101\5\b\5\2\u0101\u0102\79\2\2\u0102\u0105\5\34\17\2\u0103"+
		"\u0104\7\16\2\2\u0104\u0106\5\34\17\2\u0105\u0103\3\2\2\2\u0105\u0106"+
		"\3\2\2\2\u0106\37\3\2\2\2\u0107\u0108\7\17\2\2\u0108\u0109\78\2\2\u0109"+
		"\u010a\5\34\17\2\u010a\u010c\5\34\17\2\u010b\u010d\5*\26\2\u010c\u010b"+
		"\3\2\2\2\u010c\u010d\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u010f\79\2\2\u010f"+
		"\u0110\5\34\17\2\u0110!\3\2\2\2\u0111\u0112\7\20\2\2\u0112\u0113\78\2"+
		"\2\u0113\u0114\5\b\5\2\u0114\u0115\79\2\2\u0115\u0116\5\34\17\2\u0116"+
		"#\3\2\2\2\u0117\u0118\7\22\2\2\u0118%\3\2\2\2\u0119\u011a\7\21\2\2\u011a"+
		"\'\3\2\2\2\u011b\u011d\7\23\2\2\u011c\u011e\5\b\5\2\u011d\u011c\3\2\2"+
		"\2\u011d\u011e\3\2\2\2\u011e)\3\2\2\2\u011f\u0124\5\b\5\2\u0120\u0121"+
		"\7=\2\2\u0121\u0123\5\b\5\2\u0122\u0120\3\2\2\2\u0123\u0126\3\2\2\2\u0124"+
		"\u0122\3\2\2\2\u0124\u0125\3\2\2\2\u0125+\3\2\2\2\u0126\u0124\3\2\2\2"+
		"\31\63\65AINS^\u008d\u0097\u0099\u00a2\u00a8\u00b2\u00b4\u00c2\u00cf\u00d7"+
		"\u00e0\u00fc\u0105\u010c\u011d\u0124";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}