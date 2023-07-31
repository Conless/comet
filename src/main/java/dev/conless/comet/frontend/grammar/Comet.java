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
		RULE_program = 0, RULE_type = 1, RULE_typeName = 2, RULE_expr = 3, RULE_varDef = 4, 
		RULE_varConstructor = 5, RULE_classDef = 6, RULE_classConstructor = 7, 
		RULE_funcDef = 8, RULE_funcParamList = 9, RULE_funcParam = 10, RULE_funcArgList = 11, 
		RULE_blockStmt = 12, RULE_stmt = 13, RULE_ifStmt = 14, RULE_forStmt = 15, 
		RULE_whileStmt = 16, RULE_continueStmt = 17, RULE_breakStmt = 18, RULE_returnStmt = 19, 
		RULE_exprStmt = 20;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "type", "typeName", "expr", "varDef", "varConstructor", "classDef", 
			"classConstructor", "funcDef", "funcParamList", "funcParam", "funcArgList", 
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

	@SuppressWarnings("CheckReturnValue")
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
			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 94L) != 0) || _la==Identifier) {
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

	@SuppressWarnings("CheckReturnValue")
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CometVisitor ) return ((CometVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
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
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 30L) != 0) || _la==Identifier) ) {
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

	@SuppressWarnings("CheckReturnValue")
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).enterTypeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).exitTypeName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CometVisitor ) return ((CometVisitor<? extends T>)visitor).visitTypeName(this);
			else return visitor.visitChildren(this);
		}
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

	@SuppressWarnings("CheckReturnValue")
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
	@SuppressWarnings("CheckReturnValue")
	public static class NewExprContext extends ExprContext {
		public TerminalNode New() { return getToken(Comet.New, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> LBracket() { return getTokens(Comet.LBracket); }
		public TerminalNode LBracket(int i) {
			return getToken(Comet.LBracket, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> RBracket() { return getTokens(Comet.RBracket); }
		public TerminalNode RBracket(int i) {
			return getToken(Comet.RBracket, i);
		}
		public TerminalNode LParen() { return getToken(Comet.LParen, 0); }
		public TerminalNode RParen() { return getToken(Comet.RParen, 0); }
		public NewExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).enterNewExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).exitNewExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CometVisitor ) return ((CometVisitor<? extends T>)visitor).visitNewExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).enterIndexExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).exitIndexExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CometVisitor ) return ((CometVisitor<? extends T>)visitor).visitIndexExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PostUnaryExprContext extends ExprContext {
		public Token op;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SelfAdd() { return getToken(Comet.SelfAdd, 0); }
		public TerminalNode SelfSub() { return getToken(Comet.SelfSub, 0); }
		public PostUnaryExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).enterPostUnaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).exitPostUnaryExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CometVisitor ) return ((CometVisitor<? extends T>)visitor).visitPostUnaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PreUnaryExprContext extends ExprContext {
		public Token op;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SelfAdd() { return getToken(Comet.SelfAdd, 0); }
		public TerminalNode SelfSub() { return getToken(Comet.SelfSub, 0); }
		public TerminalNode LogicNot() { return getToken(Comet.LogicNot, 0); }
		public TerminalNode BitNot() { return getToken(Comet.BitNot, 0); }
		public TerminalNode Add() { return getToken(Comet.Add, 0); }
		public TerminalNode Sub() { return getToken(Comet.Sub, 0); }
		public PreUnaryExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).enterPreUnaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).exitPreUnaryExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CometVisitor ) return ((CometVisitor<? extends T>)visitor).visitPreUnaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MemberExprContext extends ExprContext {
		public Token member;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode Member() { return getToken(Comet.Member, 0); }
		public TerminalNode Identifier() { return getToken(Comet.Identifier, 0); }
		public MemberExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).enterMemberExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).exitMemberExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CometVisitor ) return ((CometVisitor<? extends T>)visitor).visitMemberExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).enterAtomExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).exitAtomExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CometVisitor ) return ((CometVisitor<? extends T>)visitor).visitAtomExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BinaryExprContext extends ExprContext {
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
		public BinaryExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).enterBinaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).exitBinaryExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CometVisitor ) return ((CometVisitor<? extends T>)visitor).visitBinaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).enterCallExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).exitCallExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CometVisitor ) return ((CometVisitor<? extends T>)visitor).visitCallExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).enterAssignExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).exitAssignExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CometVisitor ) return ((CometVisitor<? extends T>)visitor).visitAssignExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenExprContext extends ExprContext {
		public TerminalNode LParen() { return getToken(Comet.LParen, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RParen() { return getToken(Comet.RParen, 0); }
		public ParenExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).enterParenExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).exitParenExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CometVisitor ) return ((CometVisitor<? extends T>)visitor).visitParenExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).enterConditionalExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).exitConditionalExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CometVisitor ) return ((CometVisitor<? extends T>)visitor).visitConditionalExpr(this);
			else return visitor.visitChildren(this);
		}
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
			setState(96);
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
				setState(75);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(69);
						match(LBracket);
						setState(70);
						expr(0);
						setState(71);
						match(RBracket);
						}
						} 
					}
					setState(77);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				}
				setState(82);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(78);
						match(LBracket);
						setState(79);
						match(RBracket);
						}
						} 
					}
					setState(84);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				}
				setState(87);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
				case 1:
					{
					setState(85);
					match(LParen);
					setState(86);
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
				setState(89);
				match(LParen);
				setState(90);
				expr(0);
				setState(91);
				match(RParen);
				}
				break;
			case Add:
			case Sub:
			case LogicNot:
			case BitNot:
			case SelfAdd:
			case SelfSub:
				{
				_localctx = new PreUnaryExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(93);
				((PreUnaryExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1688989447487488L) != 0)) ) {
					((PreUnaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(94);
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
				setState(95);
				((AtomExprContext)_localctx).value = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 7)) & ~0x3f) == 0 && ((1L << (_la - 7)) & 3170534137668829199L) != 0)) ) {
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
			setState(155);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(153);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(98);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(99);
						((BinaryExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 7340032L) != 0)) ) {
							((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(100);
						expr(14);
						}
						break;
					case 2:
						{
						_localctx = new BinaryExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(101);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(102);
						((BinaryExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==Add || _la==Sub) ) {
							((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(103);
						expr(13);
						}
						break;
					case 3:
						{
						_localctx = new BinaryExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(104);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(105);
						((BinaryExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==BitRShift || _la==BitLShift) ) {
							((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(106);
						expr(12);
						}
						break;
					case 4:
						{
						_localctx = new BinaryExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(107);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(108);
						((BinaryExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 125829120L) != 0)) ) {
							((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(109);
						expr(11);
						}
						break;
					case 5:
						{
						_localctx = new BinaryExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(110);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(111);
						((BinaryExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==NotEqual || _la==Eqaul) ) {
							((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(112);
						expr(10);
						}
						break;
					case 6:
						{
						_localctx = new BinaryExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(113);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(114);
						((BinaryExprContext)_localctx).op = match(BitAnd);
						setState(115);
						expr(9);
						}
						break;
					case 7:
						{
						_localctx = new BinaryExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(116);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(117);
						((BinaryExprContext)_localctx).op = match(BitXor);
						setState(118);
						expr(8);
						}
						break;
					case 8:
						{
						_localctx = new BinaryExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(119);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(120);
						((BinaryExprContext)_localctx).op = match(BitOr);
						setState(121);
						expr(7);
						}
						break;
					case 9:
						{
						_localctx = new BinaryExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(122);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(123);
						((BinaryExprContext)_localctx).op = match(LogicAnd);
						setState(124);
						expr(6);
						}
						break;
					case 10:
						{
						_localctx = new BinaryExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(125);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(126);
						((BinaryExprContext)_localctx).op = match(LogicOr);
						setState(127);
						expr(5);
						}
						break;
					case 11:
						{
						_localctx = new ConditionalExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(128);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(129);
						match(QMark);
						setState(130);
						expr(0);
						setState(131);
						match(Colon);
						setState(132);
						expr(4);
						}
						break;
					case 12:
						{
						_localctx = new AssignExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(134);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(135);
						((AssignExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 562675075514368L) != 0)) ) {
							((AssignExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(136);
						expr(3);
						}
						break;
					case 13:
						{
						_localctx = new MemberExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(137);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(138);
						match(Member);
						setState(139);
						((MemberExprContext)_localctx).member = match(Identifier);
						}
						break;
					case 14:
						{
						_localctx = new CallExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(140);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(141);
						match(LParen);
						setState(143);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (((((_la - 5)) & ~0x3f) == 0 && ((1L << (_la - 5)) & -5763991792160579523L) != 0)) {
							{
							setState(142);
							funcArgList();
							}
						}

						setState(145);
						match(RParen);
						}
						break;
					case 15:
						{
						_localctx = new IndexExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(146);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(147);
						match(LBracket);
						setState(148);
						expr(0);
						setState(149);
						match(RBracket);
						}
						break;
					case 16:
						{
						_localctx = new PostUnaryExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(151);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(152);
						((PostUnaryExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==SelfAdd || _la==SelfSub) ) {
							((PostUnaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
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
				setState(157);
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
	public static class VarDefContext extends ParserRuleContext {
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public List<VarConstructorContext> varConstructor() {
			return getRuleContexts(VarConstructorContext.class);
		}
		public VarConstructorContext varConstructor(int i) {
			return getRuleContext(VarConstructorContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(Comet.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(Comet.Comma, i);
		}
		public VarDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).enterVarDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).exitVarDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CometVisitor ) return ((CometVisitor<? extends T>)visitor).visitVarDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDefContext varDef() throws RecognitionException {
		VarDefContext _localctx = new VarDefContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_varDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			typeName();
			setState(159);
			varConstructor();
			setState(164);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(160);
				match(Comma);
				setState(161);
				varConstructor();
				}
				}
				setState(166);
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
	public static class VarConstructorContext extends ParserRuleContext {
		public Token name;
		public TerminalNode Identifier() { return getToken(Comet.Identifier, 0); }
		public TerminalNode Assign() { return getToken(Comet.Assign, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public VarConstructorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varConstructor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).enterVarConstructor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).exitVarConstructor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CometVisitor ) return ((CometVisitor<? extends T>)visitor).visitVarConstructor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarConstructorContext varConstructor() throws RecognitionException {
		VarConstructorContext _localctx = new VarConstructorContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_varConstructor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			((VarConstructorContext)_localctx).name = match(Identifier);
			setState(170);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Assign) {
				{
				setState(168);
				match(Assign);
				setState(169);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ClassDefContext extends ParserRuleContext {
		public Token name;
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
		public List<ClassConstructorContext> classConstructor() {
			return getRuleContexts(ClassConstructorContext.class);
		}
		public ClassConstructorContext classConstructor(int i) {
			return getRuleContext(ClassConstructorContext.class,i);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).enterClassDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).exitClassDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CometVisitor ) return ((CometVisitor<? extends T>)visitor).visitClassDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDefContext classDef() throws RecognitionException {
		ClassDefContext _localctx = new ClassDefContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_classDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			match(Class);
			setState(173);
			((ClassDefContext)_localctx).name = match(Identifier);
			setState(174);
			match(LBrace);
			setState(182);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 30L) != 0) || _la==Identifier) {
				{
				setState(180);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
				case 1:
					{
					{
					setState(175);
					varDef();
					setState(176);
					match(Semi);
					}
					}
					break;
				case 2:
					{
					setState(178);
					funcDef();
					}
					break;
				case 3:
					{
					setState(179);
					classConstructor();
					}
					break;
				}
				}
				setState(184);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(185);
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
		public Token name;
		public TerminalNode LParen() { return getToken(Comet.LParen, 0); }
		public TerminalNode RParen() { return getToken(Comet.RParen, 0); }
		public BlockStmtContext blockStmt() {
			return getRuleContext(BlockStmtContext.class,0);
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
		enterRule(_localctx, 14, RULE_classConstructor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			((ClassConstructorContext)_localctx).name = match(Identifier);
			setState(188);
			match(LParen);
			setState(189);
			match(RParen);
			setState(190);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FuncDefContext extends ParserRuleContext {
		public Token name;
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TerminalNode LParen() { return getToken(Comet.LParen, 0); }
		public TerminalNode RParen() { return getToken(Comet.RParen, 0); }
		public BlockStmtContext blockStmt() {
			return getRuleContext(BlockStmtContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(Comet.Identifier, 0); }
		public FuncParamListContext funcParamList() {
			return getRuleContext(FuncParamListContext.class,0);
		}
		public FuncDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).enterFuncDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).exitFuncDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CometVisitor ) return ((CometVisitor<? extends T>)visitor).visitFuncDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncDefContext funcDef() throws RecognitionException {
		FuncDefContext _localctx = new FuncDefContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_funcDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			typeName();
			setState(193);
			((FuncDefContext)_localctx).name = match(Identifier);
			setState(194);
			match(LParen);
			setState(196);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 30L) != 0) || _la==Identifier) {
				{
				setState(195);
				funcParamList();
				}
			}

			setState(198);
			match(RParen);
			setState(199);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FuncParamListContext extends ParserRuleContext {
		public List<FuncParamContext> funcParam() {
			return getRuleContexts(FuncParamContext.class);
		}
		public FuncParamContext funcParam(int i) {
			return getRuleContext(FuncParamContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(Comet.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(Comet.Comma, i);
		}
		public FuncParamListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcParamList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).enterFuncParamList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).exitFuncParamList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CometVisitor ) return ((CometVisitor<? extends T>)visitor).visitFuncParamList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncParamListContext funcParamList() throws RecognitionException {
		FuncParamListContext _localctx = new FuncParamListContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_funcParamList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			funcParam();
			setState(206);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(202);
				match(Comma);
				setState(203);
				funcParam();
				}
				}
				setState(208);
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
	public static class FuncParamContext extends ParserRuleContext {
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public VarConstructorContext varConstructor() {
			return getRuleContext(VarConstructorContext.class,0);
		}
		public FuncParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcParam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).enterFuncParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).exitFuncParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CometVisitor ) return ((CometVisitor<? extends T>)visitor).visitFuncParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncParamContext funcParam() throws RecognitionException {
		FuncParamContext _localctx = new FuncParamContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_funcParam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			typeName();
			setState(210);
			varConstructor();
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).enterFuncArgList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).exitFuncArgList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CometVisitor ) return ((CometVisitor<? extends T>)visitor).visitFuncArgList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncArgListContext funcArgList() throws RecognitionException {
		FuncArgListContext _localctx = new FuncArgListContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_funcArgList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			expr(0);
			setState(217);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(213);
				match(Comma);
				setState(214);
				expr(0);
				}
				}
				setState(219);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).enterBlockStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).exitBlockStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CometVisitor ) return ((CometVisitor<? extends T>)visitor).visitBlockStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockStmtContext blockStmt() throws RecognitionException {
		BlockStmtContext _localctx = new BlockStmtContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_blockStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			match(LBrace);
			setState(224);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1460855268715786238L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 11L) != 0)) {
				{
				{
				setState(221);
				stmt();
				}
				}
				setState(226);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(227);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).exitStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CometVisitor ) return ((CometVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_stmt);
		try {
			setState(252);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(229);
				blockStmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(230);
				ifStmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(231);
				forStmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(232);
				whileStmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(233);
				varDef();
				setState(234);
				match(Semi);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(236);
				classDef();
				setState(237);
				match(Semi);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(239);
				continueStmt();
				setState(240);
				match(Semi);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(242);
				breakStmt();
				setState(243);
				match(Semi);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(245);
				returnStmt();
				setState(246);
				match(Semi);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(248);
				exprStmt();
				setState(249);
				match(Semi);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(251);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).enterIfStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).exitIfStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CometVisitor ) return ((CometVisitor<? extends T>)visitor).visitIfStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStmtContext ifStmt() throws RecognitionException {
		IfStmtContext _localctx = new IfStmtContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_ifStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
			match(If);
			setState(255);
			match(LParen);
			setState(256);
			expr(0);
			setState(257);
			match(RParen);
			setState(258);
			stmt();
			setState(261);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(259);
				match(Else);
				setState(260);
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

	@SuppressWarnings("CheckReturnValue")
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).enterForStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).exitForStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CometVisitor ) return ((CometVisitor<? extends T>)visitor).visitForStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStmtContext forStmt() throws RecognitionException {
		ForStmtContext _localctx = new ForStmtContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_forStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
			match(For);
			setState(264);
			match(LParen);
			setState(265);
			((ForStmtContext)_localctx).init = stmt();
			setState(266);
			((ForStmtContext)_localctx).condition = stmt();
			setState(268);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 5)) & ~0x3f) == 0 && ((1L << (_la - 5)) & -5763991792160579523L) != 0)) {
				{
				setState(267);
				((ForStmtContext)_localctx).update = exprStmt();
				}
			}

			setState(270);
			match(RParen);
			setState(271);
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

	@SuppressWarnings("CheckReturnValue")
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).enterWhileStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).exitWhileStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CometVisitor ) return ((CometVisitor<? extends T>)visitor).visitWhileStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStmtContext whileStmt() throws RecognitionException {
		WhileStmtContext _localctx = new WhileStmtContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_whileStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273);
			match(While);
			setState(274);
			match(LParen);
			setState(275);
			((WhileStmtContext)_localctx).condition = expr(0);
			setState(276);
			match(RParen);
			setState(277);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ContinueStmtContext extends ParserRuleContext {
		public TerminalNode Continue() { return getToken(Comet.Continue, 0); }
		public ContinueStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_continueStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).enterContinueStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).exitContinueStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CometVisitor ) return ((CometVisitor<? extends T>)visitor).visitContinueStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContinueStmtContext continueStmt() throws RecognitionException {
		ContinueStmtContext _localctx = new ContinueStmtContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_continueStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(279);
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
	public static class BreakStmtContext extends ParserRuleContext {
		public TerminalNode Break() { return getToken(Comet.Break, 0); }
		public BreakStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_breakStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).enterBreakStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).exitBreakStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CometVisitor ) return ((CometVisitor<? extends T>)visitor).visitBreakStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BreakStmtContext breakStmt() throws RecognitionException {
		BreakStmtContext _localctx = new BreakStmtContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_breakStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(281);
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
	public static class ReturnStmtContext extends ParserRuleContext {
		public TerminalNode Return() { return getToken(Comet.Return, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).enterReturnStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).exitReturnStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CometVisitor ) return ((CometVisitor<? extends T>)visitor).visitReturnStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStmtContext returnStmt() throws RecognitionException {
		ReturnStmtContext _localctx = new ReturnStmtContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_returnStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(283);
			match(Return);
			setState(285);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 5)) & ~0x3f) == 0 && ((1L << (_la - 5)) & -5763991792160579523L) != 0)) {
				{
				setState(284);
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

	@SuppressWarnings("CheckReturnValue")
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).enterExprStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).exitExprStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CometVisitor ) return ((CometVisitor<? extends T>)visitor).visitExprStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprStmtContext exprStmt() throws RecognitionException {
		ExprStmtContext _localctx = new ExprStmtContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_exprStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(287);
			expr(0);
			setState(292);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(288);
				match(Comma);
				setState(289);
				expr(0);
				}
				}
				setState(294);
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
			return precpred(_ctx, 18);
		case 13:
			return precpred(_ctx, 17);
		case 14:
			return precpred(_ctx, 16);
		case 15:
			return precpred(_ctx, 15);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001D\u0128\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0005\u0000"+
		"2\b\u0000\n\u0000\f\u00005\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002>\b\u0002"+
		"\n\u0002\f\u0002A\t\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003J\b\u0003\n\u0003\f\u0003"+
		"M\t\u0003\u0001\u0003\u0001\u0003\u0005\u0003Q\b\u0003\n\u0003\f\u0003"+
		"T\t\u0003\u0001\u0003\u0001\u0003\u0003\u0003X\b\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003"+
		"\u0003a\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003\u0090"+
		"\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0005\u0003\u009a\b\u0003\n\u0003\f\u0003"+
		"\u009d\t\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004"+
		"\u00a3\b\u0004\n\u0004\f\u0004\u00a6\t\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0003\u0005\u00ab\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006\u00b5"+
		"\b\u0006\n\u0006\f\u0006\u00b8\t\u0006\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0003\b\u00c5\b\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001"+
		"\t\u0005\t\u00cd\b\t\n\t\f\t\u00d0\t\t\u0001\n\u0001\n\u0001\n\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0005\u000b\u00d8\b\u000b\n\u000b\f\u000b\u00db"+
		"\t\u000b\u0001\f\u0001\f\u0005\f\u00df\b\f\n\f\f\f\u00e2\t\f\u0001\f\u0001"+
		"\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u00fd\b\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0003\u000e\u0106\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0003\u000f\u010d\b\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013"+
		"\u0003\u0013\u011e\b\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0005\u0014"+
		"\u0123\b\u0014\n\u0014\f\u0014\u0126\t\u0014\u0001\u0014\u0000\u0001\u0006"+
		"\u0015\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"+
		"\u001a\u001c\u001e \"$&(\u0000\n\u0002\u0000\u0001\u0004AA\u0004\u0000"+
		"\u0012\u0013\u001f\u001f%%12\u0003\u0000\u0007\nABDD\u0001\u0000\u0014"+
		"\u0016\u0001\u0000\u0012\u0013\u0001\u0000 !\u0001\u0000\u0017\u001a\u0001"+
		"\u0000\u001b\u001c\u0001\u0000&0\u0001\u000012\u0144\u00003\u0001\u0000"+
		"\u0000\u0000\u00028\u0001\u0000\u0000\u0000\u0004:\u0001\u0000\u0000\u0000"+
		"\u0006`\u0001\u0000\u0000\u0000\b\u009e\u0001\u0000\u0000\u0000\n\u00a7"+
		"\u0001\u0000\u0000\u0000\f\u00ac\u0001\u0000\u0000\u0000\u000e\u00bb\u0001"+
		"\u0000\u0000\u0000\u0010\u00c0\u0001\u0000\u0000\u0000\u0012\u00c9\u0001"+
		"\u0000\u0000\u0000\u0014\u00d1\u0001\u0000\u0000\u0000\u0016\u00d4\u0001"+
		"\u0000\u0000\u0000\u0018\u00dc\u0001\u0000\u0000\u0000\u001a\u00fc\u0001"+
		"\u0000\u0000\u0000\u001c\u00fe\u0001\u0000\u0000\u0000\u001e\u0107\u0001"+
		"\u0000\u0000\u0000 \u0111\u0001\u0000\u0000\u0000\"\u0117\u0001\u0000"+
		"\u0000\u0000$\u0119\u0001\u0000\u0000\u0000&\u011b\u0001\u0000\u0000\u0000"+
		"(\u011f\u0001\u0000\u0000\u0000*+\u0003\b\u0004\u0000+,\u0005:\u0000\u0000"+
		",2\u0001\u0000\u0000\u0000-.\u0003\f\u0006\u0000./\u0005:\u0000\u0000"+
		"/2\u0001\u0000\u0000\u000002\u0003\u0010\b\u00001*\u0001\u0000\u0000\u0000"+
		"1-\u0001\u0000\u0000\u000010\u0001\u0000\u0000\u000025\u0001\u0000\u0000"+
		"\u000031\u0001\u0000\u0000\u000034\u0001\u0000\u0000\u000046\u0001\u0000"+
		"\u0000\u000053\u0001\u0000\u0000\u000067\u0005\u0000\u0000\u00017\u0001"+
		"\u0001\u0000\u0000\u000089\u0007\u0000\u0000\u00009\u0003\u0001\u0000"+
		"\u0000\u0000:?\u0003\u0002\u0001\u0000;<\u00054\u0000\u0000<>\u00055\u0000"+
		"\u0000=;\u0001\u0000\u0000\u0000>A\u0001\u0000\u0000\u0000?=\u0001\u0000"+
		"\u0000\u0000?@\u0001\u0000\u0000\u0000@\u0005\u0001\u0000\u0000\u0000"+
		"A?\u0001\u0000\u0000\u0000BC\u0006\u0003\uffff\uffff\u0000CD\u0005\u0005"+
		"\u0000\u0000DK\u0003\u0002\u0001\u0000EF\u00054\u0000\u0000FG\u0003\u0006"+
		"\u0003\u0000GH\u00055\u0000\u0000HJ\u0001\u0000\u0000\u0000IE\u0001\u0000"+
		"\u0000\u0000JM\u0001\u0000\u0000\u0000KI\u0001\u0000\u0000\u0000KL\u0001"+
		"\u0000\u0000\u0000LR\u0001\u0000\u0000\u0000MK\u0001\u0000\u0000\u0000"+
		"NO\u00054\u0000\u0000OQ\u00055\u0000\u0000PN\u0001\u0000\u0000\u0000Q"+
		"T\u0001\u0000\u0000\u0000RP\u0001\u0000\u0000\u0000RS\u0001\u0000\u0000"+
		"\u0000SW\u0001\u0000\u0000\u0000TR\u0001\u0000\u0000\u0000UV\u00056\u0000"+
		"\u0000VX\u00057\u0000\u0000WU\u0001\u0000\u0000\u0000WX\u0001\u0000\u0000"+
		"\u0000Xa\u0001\u0000\u0000\u0000YZ\u00056\u0000\u0000Z[\u0003\u0006\u0003"+
		"\u0000[\\\u00057\u0000\u0000\\a\u0001\u0000\u0000\u0000]^\u0007\u0001"+
		"\u0000\u0000^a\u0003\u0006\u0003\u000e_a\u0007\u0002\u0000\u0000`B\u0001"+
		"\u0000\u0000\u0000`Y\u0001\u0000\u0000\u0000`]\u0001\u0000\u0000\u0000"+
		"`_\u0001\u0000\u0000\u0000a\u009b\u0001\u0000\u0000\u0000bc\n\r\u0000"+
		"\u0000cd\u0007\u0003\u0000\u0000d\u009a\u0003\u0006\u0003\u000eef\n\f"+
		"\u0000\u0000fg\u0007\u0004\u0000\u0000g\u009a\u0003\u0006\u0003\rhi\n"+
		"\u000b\u0000\u0000ij\u0007\u0005\u0000\u0000j\u009a\u0003\u0006\u0003"+
		"\fkl\n\n\u0000\u0000lm\u0007\u0006\u0000\u0000m\u009a\u0003\u0006\u0003"+
		"\u000bno\n\t\u0000\u0000op\u0007\u0007\u0000\u0000p\u009a\u0003\u0006"+
		"\u0003\nqr\n\b\u0000\u0000rs\u0005\"\u0000\u0000s\u009a\u0003\u0006\u0003"+
		"\ttu\n\u0007\u0000\u0000uv\u0005$\u0000\u0000v\u009a\u0003\u0006\u0003"+
		"\bwx\n\u0006\u0000\u0000xy\u0005#\u0000\u0000y\u009a\u0003\u0006\u0003"+
		"\u0007z{\n\u0005\u0000\u0000{|\u0005\u001d\u0000\u0000|\u009a\u0003\u0006"+
		"\u0003\u0006}~\n\u0004\u0000\u0000~\u007f\u0005\u001e\u0000\u0000\u007f"+
		"\u009a\u0003\u0006\u0003\u0005\u0080\u0081\n\u0003\u0000\u0000\u0081\u0082"+
		"\u00058\u0000\u0000\u0082\u0083\u0003\u0006\u0003\u0000\u0083\u0084\u0005"+
		"9\u0000\u0000\u0084\u0085\u0003\u0006\u0003\u0004\u0085\u009a\u0001\u0000"+
		"\u0000\u0000\u0086\u0087\n\u0002\u0000\u0000\u0087\u0088\u0007\b\u0000"+
		"\u0000\u0088\u009a\u0003\u0006\u0003\u0003\u0089\u008a\n\u0012\u0000\u0000"+
		"\u008a\u008b\u00053\u0000\u0000\u008b\u009a\u0005A\u0000\u0000\u008c\u008d"+
		"\n\u0011\u0000\u0000\u008d\u008f\u00056\u0000\u0000\u008e\u0090\u0003"+
		"\u0016\u000b\u0000\u008f\u008e\u0001\u0000\u0000\u0000\u008f\u0090\u0001"+
		"\u0000\u0000\u0000\u0090\u0091\u0001\u0000\u0000\u0000\u0091\u009a\u0005"+
		"7\u0000\u0000\u0092\u0093\n\u0010\u0000\u0000\u0093\u0094\u00054\u0000"+
		"\u0000\u0094\u0095\u0003\u0006\u0003\u0000\u0095\u0096\u00055\u0000\u0000"+
		"\u0096\u009a\u0001\u0000\u0000\u0000\u0097\u0098\n\u000f\u0000\u0000\u0098"+
		"\u009a\u0007\t\u0000\u0000\u0099b\u0001\u0000\u0000\u0000\u0099e\u0001"+
		"\u0000\u0000\u0000\u0099h\u0001\u0000\u0000\u0000\u0099k\u0001\u0000\u0000"+
		"\u0000\u0099n\u0001\u0000\u0000\u0000\u0099q\u0001\u0000\u0000\u0000\u0099"+
		"t\u0001\u0000\u0000\u0000\u0099w\u0001\u0000\u0000\u0000\u0099z\u0001"+
		"\u0000\u0000\u0000\u0099}\u0001\u0000\u0000\u0000\u0099\u0080\u0001\u0000"+
		"\u0000\u0000\u0099\u0086\u0001\u0000\u0000\u0000\u0099\u0089\u0001\u0000"+
		"\u0000\u0000\u0099\u008c\u0001\u0000\u0000\u0000\u0099\u0092\u0001\u0000"+
		"\u0000\u0000\u0099\u0097\u0001\u0000\u0000\u0000\u009a\u009d\u0001\u0000"+
		"\u0000\u0000\u009b\u0099\u0001\u0000\u0000\u0000\u009b\u009c\u0001\u0000"+
		"\u0000\u0000\u009c\u0007\u0001\u0000\u0000\u0000\u009d\u009b\u0001\u0000"+
		"\u0000\u0000\u009e\u009f\u0003\u0004\u0002\u0000\u009f\u00a4\u0003\n\u0005"+
		"\u0000\u00a0\u00a1\u0005;\u0000\u0000\u00a1\u00a3\u0003\n\u0005\u0000"+
		"\u00a2\u00a0\u0001\u0000\u0000\u0000\u00a3\u00a6\u0001\u0000\u0000\u0000"+
		"\u00a4\u00a2\u0001\u0000\u0000\u0000\u00a4\u00a5\u0001\u0000\u0000\u0000"+
		"\u00a5\t\u0001\u0000\u0000\u0000\u00a6\u00a4\u0001\u0000\u0000\u0000\u00a7"+
		"\u00aa\u0005A\u0000\u0000\u00a8\u00a9\u0005&\u0000\u0000\u00a9\u00ab\u0003"+
		"\u0006\u0003\u0000\u00aa\u00a8\u0001\u0000\u0000\u0000\u00aa\u00ab\u0001"+
		"\u0000\u0000\u0000\u00ab\u000b\u0001\u0000\u0000\u0000\u00ac\u00ad\u0005"+
		"\u0006\u0000\u0000\u00ad\u00ae\u0005A\u0000\u0000\u00ae\u00b6\u0005<\u0000"+
		"\u0000\u00af\u00b0\u0003\b\u0004\u0000\u00b0\u00b1\u0005:\u0000\u0000"+
		"\u00b1\u00b5\u0001\u0000\u0000\u0000\u00b2\u00b5\u0003\u0010\b\u0000\u00b3"+
		"\u00b5\u0003\u000e\u0007\u0000\u00b4\u00af\u0001\u0000\u0000\u0000\u00b4"+
		"\u00b2\u0001\u0000\u0000\u0000\u00b4\u00b3\u0001\u0000\u0000\u0000\u00b5"+
		"\u00b8\u0001\u0000\u0000\u0000\u00b6\u00b4\u0001\u0000\u0000\u0000\u00b6"+
		"\u00b7\u0001\u0000\u0000\u0000\u00b7\u00b9\u0001\u0000\u0000\u0000\u00b8"+
		"\u00b6\u0001\u0000\u0000\u0000\u00b9\u00ba\u0005=\u0000\u0000\u00ba\r"+
		"\u0001\u0000\u0000\u0000\u00bb\u00bc\u0005A\u0000\u0000\u00bc\u00bd\u0005"+
		"6\u0000\u0000\u00bd\u00be\u00057\u0000\u0000\u00be\u00bf\u0003\u0018\f"+
		"\u0000\u00bf\u000f\u0001\u0000\u0000\u0000\u00c0\u00c1\u0003\u0004\u0002"+
		"\u0000\u00c1\u00c2\u0005A\u0000\u0000\u00c2\u00c4\u00056\u0000\u0000\u00c3"+
		"\u00c5\u0003\u0012\t\u0000\u00c4\u00c3\u0001\u0000\u0000\u0000\u00c4\u00c5"+
		"\u0001\u0000\u0000\u0000\u00c5\u00c6\u0001\u0000\u0000\u0000\u00c6\u00c7"+
		"\u00057\u0000\u0000\u00c7\u00c8\u0003\u0018\f\u0000\u00c8\u0011\u0001"+
		"\u0000\u0000\u0000\u00c9\u00ce\u0003\u0014\n\u0000\u00ca\u00cb\u0005;"+
		"\u0000\u0000\u00cb\u00cd\u0003\u0014\n\u0000\u00cc\u00ca\u0001\u0000\u0000"+
		"\u0000\u00cd\u00d0\u0001\u0000\u0000\u0000\u00ce\u00cc\u0001\u0000\u0000"+
		"\u0000\u00ce\u00cf\u0001\u0000\u0000\u0000\u00cf\u0013\u0001\u0000\u0000"+
		"\u0000\u00d0\u00ce\u0001\u0000\u0000\u0000\u00d1\u00d2\u0003\u0004\u0002"+
		"\u0000\u00d2\u00d3\u0003\n\u0005\u0000\u00d3\u0015\u0001\u0000\u0000\u0000"+
		"\u00d4\u00d9\u0003\u0006\u0003\u0000\u00d5\u00d6\u0005;\u0000\u0000\u00d6"+
		"\u00d8\u0003\u0006\u0003\u0000\u00d7\u00d5\u0001\u0000\u0000\u0000\u00d8"+
		"\u00db\u0001\u0000\u0000\u0000\u00d9\u00d7\u0001\u0000\u0000\u0000\u00d9"+
		"\u00da\u0001\u0000\u0000\u0000\u00da\u0017\u0001\u0000\u0000\u0000\u00db"+
		"\u00d9\u0001\u0000\u0000\u0000\u00dc\u00e0\u0005<\u0000\u0000\u00dd\u00df"+
		"\u0003\u001a\r\u0000\u00de\u00dd\u0001\u0000\u0000\u0000\u00df\u00e2\u0001"+
		"\u0000\u0000\u0000\u00e0\u00de\u0001\u0000\u0000\u0000\u00e0\u00e1\u0001"+
		"\u0000\u0000\u0000\u00e1\u00e3\u0001\u0000\u0000\u0000\u00e2\u00e0\u0001"+
		"\u0000\u0000\u0000\u00e3\u00e4\u0005=\u0000\u0000\u00e4\u0019\u0001\u0000"+
		"\u0000\u0000\u00e5\u00fd\u0003\u0018\f\u0000\u00e6\u00fd\u0003\u001c\u000e"+
		"\u0000\u00e7\u00fd\u0003\u001e\u000f\u0000\u00e8\u00fd\u0003 \u0010\u0000"+
		"\u00e9\u00ea\u0003\b\u0004\u0000\u00ea\u00eb\u0005:\u0000\u0000\u00eb"+
		"\u00fd\u0001\u0000\u0000\u0000\u00ec\u00ed\u0003\f\u0006\u0000\u00ed\u00ee"+
		"\u0005:\u0000\u0000\u00ee\u00fd\u0001\u0000\u0000\u0000\u00ef\u00f0\u0003"+
		"\"\u0011\u0000\u00f0\u00f1\u0005:\u0000\u0000\u00f1\u00fd\u0001\u0000"+
		"\u0000\u0000\u00f2\u00f3\u0003$\u0012\u0000\u00f3\u00f4\u0005:\u0000\u0000"+
		"\u00f4\u00fd\u0001\u0000\u0000\u0000\u00f5\u00f6\u0003&\u0013\u0000\u00f6"+
		"\u00f7\u0005:\u0000\u0000\u00f7\u00fd\u0001\u0000\u0000\u0000\u00f8\u00f9"+
		"\u0003(\u0014\u0000\u00f9\u00fa\u0005:\u0000\u0000\u00fa\u00fd\u0001\u0000"+
		"\u0000\u0000\u00fb\u00fd\u0005:\u0000\u0000\u00fc\u00e5\u0001\u0000\u0000"+
		"\u0000\u00fc\u00e6\u0001\u0000\u0000\u0000\u00fc\u00e7\u0001\u0000\u0000"+
		"\u0000\u00fc\u00e8\u0001\u0000\u0000\u0000\u00fc\u00e9\u0001\u0000\u0000"+
		"\u0000\u00fc\u00ec\u0001\u0000\u0000\u0000\u00fc\u00ef\u0001\u0000\u0000"+
		"\u0000\u00fc\u00f2\u0001\u0000\u0000\u0000\u00fc\u00f5\u0001\u0000\u0000"+
		"\u0000\u00fc\u00f8\u0001\u0000\u0000\u0000\u00fc\u00fb\u0001\u0000\u0000"+
		"\u0000\u00fd\u001b\u0001\u0000\u0000\u0000\u00fe\u00ff\u0005\u000b\u0000"+
		"\u0000\u00ff\u0100\u00056\u0000\u0000\u0100\u0101\u0003\u0006\u0003\u0000"+
		"\u0101\u0102\u00057\u0000\u0000\u0102\u0105\u0003\u001a\r\u0000\u0103"+
		"\u0104\u0005\f\u0000\u0000\u0104\u0106\u0003\u001a\r\u0000\u0105\u0103"+
		"\u0001\u0000\u0000\u0000\u0105\u0106\u0001\u0000\u0000\u0000\u0106\u001d"+
		"\u0001\u0000\u0000\u0000\u0107\u0108\u0005\r\u0000\u0000\u0108\u0109\u0005"+
		"6\u0000\u0000\u0109\u010a\u0003\u001a\r\u0000\u010a\u010c\u0003\u001a"+
		"\r\u0000\u010b\u010d\u0003(\u0014\u0000\u010c\u010b\u0001\u0000\u0000"+
		"\u0000\u010c\u010d\u0001\u0000\u0000\u0000\u010d\u010e\u0001\u0000\u0000"+
		"\u0000\u010e\u010f\u00057\u0000\u0000\u010f\u0110\u0003\u001a\r\u0000"+
		"\u0110\u001f\u0001\u0000\u0000\u0000\u0111\u0112\u0005\u000e\u0000\u0000"+
		"\u0112\u0113\u00056\u0000\u0000\u0113\u0114\u0003\u0006\u0003\u0000\u0114"+
		"\u0115\u00057\u0000\u0000\u0115\u0116\u0003\u001a\r\u0000\u0116!\u0001"+
		"\u0000\u0000\u0000\u0117\u0118\u0005\u0010\u0000\u0000\u0118#\u0001\u0000"+
		"\u0000\u0000\u0119\u011a\u0005\u000f\u0000\u0000\u011a%\u0001\u0000\u0000"+
		"\u0000\u011b\u011d\u0005\u0011\u0000\u0000\u011c\u011e\u0003\u0006\u0003"+
		"\u0000\u011d\u011c\u0001\u0000\u0000\u0000\u011d\u011e\u0001\u0000\u0000"+
		"\u0000\u011e\'\u0001\u0000\u0000\u0000\u011f\u0124\u0003\u0006\u0003\u0000"+
		"\u0120\u0121\u0005;\u0000\u0000\u0121\u0123\u0003\u0006\u0003\u0000\u0122"+
		"\u0120\u0001\u0000\u0000\u0000\u0123\u0126\u0001\u0000\u0000\u0000\u0124"+
		"\u0122\u0001\u0000\u0000\u0000\u0124\u0125\u0001\u0000\u0000\u0000\u0125"+
		")\u0001\u0000\u0000\u0000\u0126\u0124\u0001\u0000\u0000\u0000\u001713"+
		"?KRW`\u008f\u0099\u009b\u00a4\u00aa\u00b4\u00b6\u00c4\u00ce\u00d9\u00e0"+
		"\u00fc\u0105\u010c\u011d\u0124";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}