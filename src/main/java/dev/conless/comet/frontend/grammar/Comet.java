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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).enterBinaryArithExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).exitBinaryArithExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CometVisitor ) return ((CometVisitor<? extends T>)visitor).visitBinaryArithExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PreSelfExprContext extends ExprContext {
		public Token op;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SelfAdd() { return getToken(Comet.SelfAdd, 0); }
		public TerminalNode SelfSub() { return getToken(Comet.SelfSub, 0); }
		public PreSelfExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).enterPreSelfExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).exitPreSelfExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CometVisitor ) return ((CometVisitor<? extends T>)visitor).visitPreSelfExpr(this);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).enterUnaryArithExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).exitUnaryArithExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CometVisitor ) return ((CometVisitor<? extends T>)visitor).visitUnaryArithExpr(this);
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
			setState(98);
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
				{
				_localctx = new UnaryArithExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(93);
				((UnaryArithExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 139587223552L) != 0)) ) {
					((UnaryArithExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(94);
				expr(15);
				}
				break;
			case SelfAdd:
			case SelfSub:
				{
				_localctx = new PreSelfExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(95);
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
				setState(96);
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
				setState(97);
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
			setState(157);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(155);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryArithExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(100);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(101);
						((BinaryArithExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 7340032L) != 0)) ) {
							((BinaryArithExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(102);
						expr(14);
						}
						break;
					case 2:
						{
						_localctx = new BinaryArithExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(103);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(104);
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
						setState(105);
						expr(13);
						}
						break;
					case 3:
						{
						_localctx = new BinaryArithExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(106);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(107);
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
						setState(108);
						expr(12);
						}
						break;
					case 4:
						{
						_localctx = new BinaryArithExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(109);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(110);
						((BinaryArithExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 125829120L) != 0)) ) {
							((BinaryArithExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(111);
						expr(11);
						}
						break;
					case 5:
						{
						_localctx = new BinaryArithExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(112);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(113);
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
						setState(114);
						expr(10);
						}
						break;
					case 6:
						{
						_localctx = new BinaryArithExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(115);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(116);
						((BinaryArithExprContext)_localctx).op = match(BitAnd);
						setState(117);
						expr(9);
						}
						break;
					case 7:
						{
						_localctx = new BinaryArithExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(118);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(119);
						((BinaryArithExprContext)_localctx).op = match(BitXor);
						setState(120);
						expr(8);
						}
						break;
					case 8:
						{
						_localctx = new BinaryArithExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(121);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(122);
						((BinaryArithExprContext)_localctx).op = match(BitOr);
						setState(123);
						expr(7);
						}
						break;
					case 9:
						{
						_localctx = new BinaryArithExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(124);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(125);
						((BinaryArithExprContext)_localctx).op = match(LogicAnd);
						setState(126);
						expr(6);
						}
						break;
					case 10:
						{
						_localctx = new BinaryArithExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(127);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(128);
						((BinaryArithExprContext)_localctx).op = match(LogicOr);
						setState(129);
						expr(5);
						}
						break;
					case 11:
						{
						_localctx = new ConditionalExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(130);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(131);
						match(QMark);
						setState(132);
						expr(0);
						setState(133);
						match(Colon);
						setState(134);
						expr(4);
						}
						break;
					case 12:
						{
						_localctx = new AssignExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(136);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(137);
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
						setState(138);
						expr(3);
						}
						break;
					case 13:
						{
						_localctx = new MemberExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(139);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(140);
						match(Member);
						setState(141);
						((MemberExprContext)_localctx).member = match(Identifier);
						}
						break;
					case 14:
						{
						_localctx = new CallExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(142);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(143);
						match(LParen);
						setState(145);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (((((_la - 5)) & ~0x3f) == 0 && ((1L << (_la - 5)) & -5763991792160579523L) != 0)) {
							{
							setState(144);
							funcArgList();
							}
						}

						setState(147);
						match(RParen);
						}
						break;
					case 15:
						{
						_localctx = new IndexExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(148);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(149);
						match(LBracket);
						setState(150);
						expr(0);
						setState(151);
						match(RBracket);
						}
						break;
					case 16:
						{
						_localctx = new UnaryArithExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(153);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(154);
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
				setState(159);
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
			setState(160);
			typeName();
			setState(161);
			varCtor();
			setState(166);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(162);
				match(Comma);
				setState(163);
				varCtor();
				}
				}
				setState(168);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).enterVarCtor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).exitVarCtor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CometVisitor ) return ((CometVisitor<? extends T>)visitor).visitVarCtor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarCtorContext varCtor() throws RecognitionException {
		VarCtorContext _localctx = new VarCtorContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_varCtor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			((VarCtorContext)_localctx).varName = match(Identifier);
			setState(172);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Assign) {
				{
				setState(170);
				match(Assign);
				setState(171);
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
			setState(174);
			match(Class);
			setState(175);
			((ClassDefContext)_localctx).className = match(Identifier);
			setState(176);
			match(LBrace);
			setState(184);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 30L) != 0) || _la==Identifier) {
				{
				setState(182);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
				case 1:
					{
					{
					setState(177);
					varDef();
					setState(178);
					match(Semi);
					}
					}
					break;
				case 2:
					{
					setState(180);
					funcDef();
					}
					break;
				case 3:
					{
					setState(181);
					classCtor();
					}
					break;
				}
				}
				setState(186);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(187);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).enterClassCtor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).exitClassCtor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CometVisitor ) return ((CometVisitor<? extends T>)visitor).visitClassCtor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassCtorContext classCtor() throws RecognitionException {
		ClassCtorContext _localctx = new ClassCtorContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_classCtor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			((ClassCtorContext)_localctx).className = match(Identifier);
			setState(190);
			match(LParen);
			setState(191);
			match(RParen);
			setState(192);
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
			setState(194);
			returnType();
			setState(195);
			((FuncDefContext)_localctx).funcName = match(Identifier);
			setState(196);
			match(LParen);
			setState(198);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 30L) != 0) || _la==Identifier) {
				{
				setState(197);
				funcParaList();
				}
			}

			setState(200);
			match(RParen);
			setState(201);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).enterFuncParaList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CometListener ) ((CometListener)listener).exitFuncParaList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CometVisitor ) return ((CometVisitor<? extends T>)visitor).visitFuncParaList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncParaListContext funcParaList() throws RecognitionException {
		FuncParaListContext _localctx = new FuncParaListContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_funcParaList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			typeName();
			setState(204);
			varCtor();
			setState(211);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(205);
				match(Comma);
				setState(206);
				typeName();
				setState(207);
				varCtor();
				}
				}
				setState(213);
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
		enterRule(_localctx, 20, RULE_funcArgList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			expr(0);
			setState(219);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(215);
				match(Comma);
				setState(216);
				expr(0);
				}
				}
				setState(221);
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
		enterRule(_localctx, 22, RULE_returnType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
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
			setState(224);
			match(LBrace);
			setState(228);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1460855268715786238L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 11L) != 0)) {
				{
				{
				setState(225);
				stmt();
				}
				}
				setState(230);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(231);
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
			setState(256);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(233);
				blockStmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(234);
				ifStmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(235);
				forStmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(236);
				whileStmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(237);
				varDef();
				setState(238);
				match(Semi);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(240);
				classDef();
				setState(241);
				match(Semi);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(243);
				continueStmt();
				setState(244);
				match(Semi);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(246);
				breakStmt();
				setState(247);
				match(Semi);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(249);
				returnStmt();
				setState(250);
				match(Semi);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(252);
				exprStmt();
				setState(253);
				match(Semi);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(255);
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
			setState(258);
			match(If);
			setState(259);
			match(LParen);
			setState(260);
			expr(0);
			setState(261);
			match(RParen);
			setState(262);
			stmt();
			setState(265);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(263);
				match(Else);
				setState(264);
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
			setState(267);
			match(For);
			setState(268);
			match(LParen);
			setState(269);
			((ForStmtContext)_localctx).init = stmt();
			setState(270);
			((ForStmtContext)_localctx).condition = stmt();
			setState(272);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 5)) & ~0x3f) == 0 && ((1L << (_la - 5)) & -5763991792160579523L) != 0)) {
				{
				setState(271);
				((ForStmtContext)_localctx).update = exprStmt();
				}
			}

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
			setState(277);
			match(While);
			setState(278);
			match(LParen);
			setState(279);
			((WhileStmtContext)_localctx).condition = expr(0);
			setState(280);
			match(RParen);
			setState(281);
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
			setState(283);
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
			setState(285);
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
			setState(287);
			match(Return);
			setState(289);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 5)) & ~0x3f) == 0 && ((1L << (_la - 5)) & -5763991792160579523L) != 0)) {
				{
				setState(288);
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
			setState(291);
			expr(0);
			setState(296);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(292);
				match(Comma);
				setState(293);
				expr(0);
				}
				}
				setState(298);
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
		"\u0004\u0001D\u012c\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
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
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0003\u0003c\b\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0003\u0003\u0092\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003\u009c"+
		"\b\u0003\n\u0003\f\u0003\u009f\t\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0005\u0004\u00a5\b\u0004\n\u0004\f\u0004\u00a8\t\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u00ad\b\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0005\u0006\u00b7\b\u0006\n\u0006\f\u0006\u00ba\t\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u00c7\b\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t\u00d2\b\t\n"+
		"\t\f\t\u00d5\t\t\u0001\n\u0001\n\u0001\n\u0005\n\u00da\b\n\n\n\f\n\u00dd"+
		"\t\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0005\f\u00e3\b\f\n\f\f\f"+
		"\u00e6\t\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003"+
		"\r\u0101\b\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0003\u000e\u010a\b\u000e\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u0111\b\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012"+
		"\u0001\u0013\u0001\u0013\u0003\u0013\u0122\b\u0013\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0005\u0014\u0127\b\u0014\n\u0014\f\u0014\u012a\t\u0014\u0001"+
		"\u0014\u0000\u0001\u0006\u0015\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(\u0000\n\u0002\u0000\u0001"+
		"\u0004AA\u0003\u0000\u0012\u0013\u001f\u001f%%\u0001\u000012\u0003\u0000"+
		"\u0007\nABDD\u0001\u0000\u0014\u0016\u0001\u0000\u0012\u0013\u0001\u0000"+
		" !\u0001\u0000\u0017\u001a\u0001\u0000\u001b\u001c\u0001\u0000&0\u0149"+
		"\u00003\u0001\u0000\u0000\u0000\u00028\u0001\u0000\u0000\u0000\u0004:"+
		"\u0001\u0000\u0000\u0000\u0006b\u0001\u0000\u0000\u0000\b\u00a0\u0001"+
		"\u0000\u0000\u0000\n\u00a9\u0001\u0000\u0000\u0000\f\u00ae\u0001\u0000"+
		"\u0000\u0000\u000e\u00bd\u0001\u0000\u0000\u0000\u0010\u00c2\u0001\u0000"+
		"\u0000\u0000\u0012\u00cb\u0001\u0000\u0000\u0000\u0014\u00d6\u0001\u0000"+
		"\u0000\u0000\u0016\u00de\u0001\u0000\u0000\u0000\u0018\u00e0\u0001\u0000"+
		"\u0000\u0000\u001a\u0100\u0001\u0000\u0000\u0000\u001c\u0102\u0001\u0000"+
		"\u0000\u0000\u001e\u010b\u0001\u0000\u0000\u0000 \u0115\u0001\u0000\u0000"+
		"\u0000\"\u011b\u0001\u0000\u0000\u0000$\u011d\u0001\u0000\u0000\u0000"+
		"&\u011f\u0001\u0000\u0000\u0000(\u0123\u0001\u0000\u0000\u0000*+\u0003"+
		"\b\u0004\u0000+,\u0005:\u0000\u0000,2\u0001\u0000\u0000\u0000-.\u0003"+
		"\f\u0006\u0000./\u0005:\u0000\u0000/2\u0001\u0000\u0000\u000002\u0003"+
		"\u0010\b\u00001*\u0001\u0000\u0000\u00001-\u0001\u0000\u0000\u000010\u0001"+
		"\u0000\u0000\u000025\u0001\u0000\u0000\u000031\u0001\u0000\u0000\u0000"+
		"34\u0001\u0000\u0000\u000046\u0001\u0000\u0000\u000053\u0001\u0000\u0000"+
		"\u000067\u0005\u0000\u0000\u00017\u0001\u0001\u0000\u0000\u000089\u0007"+
		"\u0000\u0000\u00009\u0003\u0001\u0000\u0000\u0000:?\u0003\u0002\u0001"+
		"\u0000;<\u00054\u0000\u0000<>\u00055\u0000\u0000=;\u0001\u0000\u0000\u0000"+
		">A\u0001\u0000\u0000\u0000?=\u0001\u0000\u0000\u0000?@\u0001\u0000\u0000"+
		"\u0000@\u0005\u0001\u0000\u0000\u0000A?\u0001\u0000\u0000\u0000BC\u0006"+
		"\u0003\uffff\uffff\u0000CD\u0005\u0005\u0000\u0000DK\u0003\u0002\u0001"+
		"\u0000EF\u00054\u0000\u0000FG\u0003\u0006\u0003\u0000GH\u00055\u0000\u0000"+
		"HJ\u0001\u0000\u0000\u0000IE\u0001\u0000\u0000\u0000JM\u0001\u0000\u0000"+
		"\u0000KI\u0001\u0000\u0000\u0000KL\u0001\u0000\u0000\u0000LR\u0001\u0000"+
		"\u0000\u0000MK\u0001\u0000\u0000\u0000NO\u00054\u0000\u0000OQ\u00055\u0000"+
		"\u0000PN\u0001\u0000\u0000\u0000QT\u0001\u0000\u0000\u0000RP\u0001\u0000"+
		"\u0000\u0000RS\u0001\u0000\u0000\u0000SW\u0001\u0000\u0000\u0000TR\u0001"+
		"\u0000\u0000\u0000UV\u00056\u0000\u0000VX\u00057\u0000\u0000WU\u0001\u0000"+
		"\u0000\u0000WX\u0001\u0000\u0000\u0000Xc\u0001\u0000\u0000\u0000YZ\u0005"+
		"6\u0000\u0000Z[\u0003\u0006\u0003\u0000[\\\u00057\u0000\u0000\\c\u0001"+
		"\u0000\u0000\u0000]^\u0007\u0001\u0000\u0000^c\u0003\u0006\u0003\u000f"+
		"_`\u0007\u0002\u0000\u0000`c\u0003\u0006\u0003\u000eac\u0007\u0003\u0000"+
		"\u0000bB\u0001\u0000\u0000\u0000bY\u0001\u0000\u0000\u0000b]\u0001\u0000"+
		"\u0000\u0000b_\u0001\u0000\u0000\u0000ba\u0001\u0000\u0000\u0000c\u009d"+
		"\u0001\u0000\u0000\u0000de\n\r\u0000\u0000ef\u0007\u0004\u0000\u0000f"+
		"\u009c\u0003\u0006\u0003\u000egh\n\f\u0000\u0000hi\u0007\u0005\u0000\u0000"+
		"i\u009c\u0003\u0006\u0003\rjk\n\u000b\u0000\u0000kl\u0007\u0006\u0000"+
		"\u0000l\u009c\u0003\u0006\u0003\fmn\n\n\u0000\u0000no\u0007\u0007\u0000"+
		"\u0000o\u009c\u0003\u0006\u0003\u000bpq\n\t\u0000\u0000qr\u0007\b\u0000"+
		"\u0000r\u009c\u0003\u0006\u0003\nst\n\b\u0000\u0000tu\u0005\"\u0000\u0000"+
		"u\u009c\u0003\u0006\u0003\tvw\n\u0007\u0000\u0000wx\u0005$\u0000\u0000"+
		"x\u009c\u0003\u0006\u0003\byz\n\u0006\u0000\u0000z{\u0005#\u0000\u0000"+
		"{\u009c\u0003\u0006\u0003\u0007|}\n\u0005\u0000\u0000}~\u0005\u001d\u0000"+
		"\u0000~\u009c\u0003\u0006\u0003\u0006\u007f\u0080\n\u0004\u0000\u0000"+
		"\u0080\u0081\u0005\u001e\u0000\u0000\u0081\u009c\u0003\u0006\u0003\u0005"+
		"\u0082\u0083\n\u0003\u0000\u0000\u0083\u0084\u00058\u0000\u0000\u0084"+
		"\u0085\u0003\u0006\u0003\u0000\u0085\u0086\u00059\u0000\u0000\u0086\u0087"+
		"\u0003\u0006\u0003\u0004\u0087\u009c\u0001\u0000\u0000\u0000\u0088\u0089"+
		"\n\u0002\u0000\u0000\u0089\u008a\u0007\t\u0000\u0000\u008a\u009c\u0003"+
		"\u0006\u0003\u0003\u008b\u008c\n\u0013\u0000\u0000\u008c\u008d\u00053"+
		"\u0000\u0000\u008d\u009c\u0005A\u0000\u0000\u008e\u008f\n\u0012\u0000"+
		"\u0000\u008f\u0091\u00056\u0000\u0000\u0090\u0092\u0003\u0014\n\u0000"+
		"\u0091\u0090\u0001\u0000\u0000\u0000\u0091\u0092\u0001\u0000\u0000\u0000"+
		"\u0092\u0093\u0001\u0000\u0000\u0000\u0093\u009c\u00057\u0000\u0000\u0094"+
		"\u0095\n\u0011\u0000\u0000\u0095\u0096\u00054\u0000\u0000\u0096\u0097"+
		"\u0003\u0006\u0003\u0000\u0097\u0098\u00055\u0000\u0000\u0098\u009c\u0001"+
		"\u0000\u0000\u0000\u0099\u009a\n\u0010\u0000\u0000\u009a\u009c\u0007\u0002"+
		"\u0000\u0000\u009bd\u0001\u0000\u0000\u0000\u009bg\u0001\u0000\u0000\u0000"+
		"\u009bj\u0001\u0000\u0000\u0000\u009bm\u0001\u0000\u0000\u0000\u009bp"+
		"\u0001\u0000\u0000\u0000\u009bs\u0001\u0000\u0000\u0000\u009bv\u0001\u0000"+
		"\u0000\u0000\u009by\u0001\u0000\u0000\u0000\u009b|\u0001\u0000\u0000\u0000"+
		"\u009b\u007f\u0001\u0000\u0000\u0000\u009b\u0082\u0001\u0000\u0000\u0000"+
		"\u009b\u0088\u0001\u0000\u0000\u0000\u009b\u008b\u0001\u0000\u0000\u0000"+
		"\u009b\u008e\u0001\u0000\u0000\u0000\u009b\u0094\u0001\u0000\u0000\u0000"+
		"\u009b\u0099\u0001\u0000\u0000\u0000\u009c\u009f\u0001\u0000\u0000\u0000"+
		"\u009d\u009b\u0001\u0000\u0000\u0000\u009d\u009e\u0001\u0000\u0000\u0000"+
		"\u009e\u0007\u0001\u0000\u0000\u0000\u009f\u009d\u0001\u0000\u0000\u0000"+
		"\u00a0\u00a1\u0003\u0004\u0002\u0000\u00a1\u00a6\u0003\n\u0005\u0000\u00a2"+
		"\u00a3\u0005;\u0000\u0000\u00a3\u00a5\u0003\n\u0005\u0000\u00a4\u00a2"+
		"\u0001\u0000\u0000\u0000\u00a5\u00a8\u0001\u0000\u0000\u0000\u00a6\u00a4"+
		"\u0001\u0000\u0000\u0000\u00a6\u00a7\u0001\u0000\u0000\u0000\u00a7\t\u0001"+
		"\u0000\u0000\u0000\u00a8\u00a6\u0001\u0000\u0000\u0000\u00a9\u00ac\u0005"+
		"A\u0000\u0000\u00aa\u00ab\u0005&\u0000\u0000\u00ab\u00ad\u0003\u0006\u0003"+
		"\u0000\u00ac\u00aa\u0001\u0000\u0000\u0000\u00ac\u00ad\u0001\u0000\u0000"+
		"\u0000\u00ad\u000b\u0001\u0000\u0000\u0000\u00ae\u00af\u0005\u0006\u0000"+
		"\u0000\u00af\u00b0\u0005A\u0000\u0000\u00b0\u00b8\u0005<\u0000\u0000\u00b1"+
		"\u00b2\u0003\b\u0004\u0000\u00b2\u00b3\u0005:\u0000\u0000\u00b3\u00b7"+
		"\u0001\u0000\u0000\u0000\u00b4\u00b7\u0003\u0010\b\u0000\u00b5\u00b7\u0003"+
		"\u000e\u0007\u0000\u00b6\u00b1\u0001\u0000\u0000\u0000\u00b6\u00b4\u0001"+
		"\u0000\u0000\u0000\u00b6\u00b5\u0001\u0000\u0000\u0000\u00b7\u00ba\u0001"+
		"\u0000\u0000\u0000\u00b8\u00b6\u0001\u0000\u0000\u0000\u00b8\u00b9\u0001"+
		"\u0000\u0000\u0000\u00b9\u00bb\u0001\u0000\u0000\u0000\u00ba\u00b8\u0001"+
		"\u0000\u0000\u0000\u00bb\u00bc\u0005=\u0000\u0000\u00bc\r\u0001\u0000"+
		"\u0000\u0000\u00bd\u00be\u0005A\u0000\u0000\u00be\u00bf\u00056\u0000\u0000"+
		"\u00bf\u00c0\u00057\u0000\u0000\u00c0\u00c1\u0003\u0018\f\u0000\u00c1"+
		"\u000f\u0001\u0000\u0000\u0000\u00c2\u00c3\u0003\u0016\u000b\u0000\u00c3"+
		"\u00c4\u0005A\u0000\u0000\u00c4\u00c6\u00056\u0000\u0000\u00c5\u00c7\u0003"+
		"\u0012\t\u0000\u00c6\u00c5\u0001\u0000\u0000\u0000\u00c6\u00c7\u0001\u0000"+
		"\u0000\u0000\u00c7\u00c8\u0001\u0000\u0000\u0000\u00c8\u00c9\u00057\u0000"+
		"\u0000\u00c9\u00ca\u0003\u0018\f\u0000\u00ca\u0011\u0001\u0000\u0000\u0000"+
		"\u00cb\u00cc\u0003\u0004\u0002\u0000\u00cc\u00d3\u0003\n\u0005\u0000\u00cd"+
		"\u00ce\u0005;\u0000\u0000\u00ce\u00cf\u0003\u0004\u0002\u0000\u00cf\u00d0"+
		"\u0003\n\u0005\u0000\u00d0\u00d2\u0001\u0000\u0000\u0000\u00d1\u00cd\u0001"+
		"\u0000\u0000\u0000\u00d2\u00d5\u0001\u0000\u0000\u0000\u00d3\u00d1\u0001"+
		"\u0000\u0000\u0000\u00d3\u00d4\u0001\u0000\u0000\u0000\u00d4\u0013\u0001"+
		"\u0000\u0000\u0000\u00d5\u00d3\u0001\u0000\u0000\u0000\u00d6\u00db\u0003"+
		"\u0006\u0003\u0000\u00d7\u00d8\u0005;\u0000\u0000\u00d8\u00da\u0003\u0006"+
		"\u0003\u0000\u00d9\u00d7\u0001\u0000\u0000\u0000\u00da\u00dd\u0001\u0000"+
		"\u0000\u0000\u00db\u00d9\u0001\u0000\u0000\u0000\u00db\u00dc\u0001\u0000"+
		"\u0000\u0000\u00dc\u0015\u0001\u0000\u0000\u0000\u00dd\u00db\u0001\u0000"+
		"\u0000\u0000\u00de\u00df\u0003\u0004\u0002\u0000\u00df\u0017\u0001\u0000"+
		"\u0000\u0000\u00e0\u00e4\u0005<\u0000\u0000\u00e1\u00e3\u0003\u001a\r"+
		"\u0000\u00e2\u00e1\u0001\u0000\u0000\u0000\u00e3\u00e6\u0001\u0000\u0000"+
		"\u0000\u00e4\u00e2\u0001\u0000\u0000\u0000\u00e4\u00e5\u0001\u0000\u0000"+
		"\u0000\u00e5\u00e7\u0001\u0000\u0000\u0000\u00e6\u00e4\u0001\u0000\u0000"+
		"\u0000\u00e7\u00e8\u0005=\u0000\u0000\u00e8\u0019\u0001\u0000\u0000\u0000"+
		"\u00e9\u0101\u0003\u0018\f\u0000\u00ea\u0101\u0003\u001c\u000e\u0000\u00eb"+
		"\u0101\u0003\u001e\u000f\u0000\u00ec\u0101\u0003 \u0010\u0000\u00ed\u00ee"+
		"\u0003\b\u0004\u0000\u00ee\u00ef\u0005:\u0000\u0000\u00ef\u0101\u0001"+
		"\u0000\u0000\u0000\u00f0\u00f1\u0003\f\u0006\u0000\u00f1\u00f2\u0005:"+
		"\u0000\u0000\u00f2\u0101\u0001\u0000\u0000\u0000\u00f3\u00f4\u0003\"\u0011"+
		"\u0000\u00f4\u00f5\u0005:\u0000\u0000\u00f5\u0101\u0001\u0000\u0000\u0000"+
		"\u00f6\u00f7\u0003$\u0012\u0000\u00f7\u00f8\u0005:\u0000\u0000\u00f8\u0101"+
		"\u0001\u0000\u0000\u0000\u00f9\u00fa\u0003&\u0013\u0000\u00fa\u00fb\u0005"+
		":\u0000\u0000\u00fb\u0101\u0001\u0000\u0000\u0000\u00fc\u00fd\u0003(\u0014"+
		"\u0000\u00fd\u00fe\u0005:\u0000\u0000\u00fe\u0101\u0001\u0000\u0000\u0000"+
		"\u00ff\u0101\u0005:\u0000\u0000\u0100\u00e9\u0001\u0000\u0000\u0000\u0100"+
		"\u00ea\u0001\u0000\u0000\u0000\u0100\u00eb\u0001\u0000\u0000\u0000\u0100"+
		"\u00ec\u0001\u0000\u0000\u0000\u0100\u00ed\u0001\u0000\u0000\u0000\u0100"+
		"\u00f0\u0001\u0000\u0000\u0000\u0100\u00f3\u0001\u0000\u0000\u0000\u0100"+
		"\u00f6\u0001\u0000\u0000\u0000\u0100\u00f9\u0001\u0000\u0000\u0000\u0100"+
		"\u00fc\u0001\u0000\u0000\u0000\u0100\u00ff\u0001\u0000\u0000\u0000\u0101"+
		"\u001b\u0001\u0000\u0000\u0000\u0102\u0103\u0005\u000b\u0000\u0000\u0103"+
		"\u0104\u00056\u0000\u0000\u0104\u0105\u0003\u0006\u0003\u0000\u0105\u0106"+
		"\u00057\u0000\u0000\u0106\u0109\u0003\u001a\r\u0000\u0107\u0108\u0005"+
		"\f\u0000\u0000\u0108\u010a\u0003\u001a\r\u0000\u0109\u0107\u0001\u0000"+
		"\u0000\u0000\u0109\u010a\u0001\u0000\u0000\u0000\u010a\u001d\u0001\u0000"+
		"\u0000\u0000\u010b\u010c\u0005\r\u0000\u0000\u010c\u010d\u00056\u0000"+
		"\u0000\u010d\u010e\u0003\u001a\r\u0000\u010e\u0110\u0003\u001a\r\u0000"+
		"\u010f\u0111\u0003(\u0014\u0000\u0110\u010f\u0001\u0000\u0000\u0000\u0110"+
		"\u0111\u0001\u0000\u0000\u0000\u0111\u0112\u0001\u0000\u0000\u0000\u0112"+
		"\u0113\u00057\u0000\u0000\u0113\u0114\u0003\u001a\r\u0000\u0114\u001f"+
		"\u0001\u0000\u0000\u0000\u0115\u0116\u0005\u000e\u0000\u0000\u0116\u0117"+
		"\u00056\u0000\u0000\u0117\u0118\u0003\u0006\u0003\u0000\u0118\u0119\u0005"+
		"7\u0000\u0000\u0119\u011a\u0003\u001a\r\u0000\u011a!\u0001\u0000\u0000"+
		"\u0000\u011b\u011c\u0005\u0010\u0000\u0000\u011c#\u0001\u0000\u0000\u0000"+
		"\u011d\u011e\u0005\u000f\u0000\u0000\u011e%\u0001\u0000\u0000\u0000\u011f"+
		"\u0121\u0005\u0011\u0000\u0000\u0120\u0122\u0003\u0006\u0003\u0000\u0121"+
		"\u0120\u0001\u0000\u0000\u0000\u0121\u0122\u0001\u0000\u0000\u0000\u0122"+
		"\'\u0001\u0000\u0000\u0000\u0123\u0128\u0003\u0006\u0003\u0000\u0124\u0125"+
		"\u0005;\u0000\u0000\u0125\u0127\u0003\u0006\u0003\u0000\u0126\u0124\u0001"+
		"\u0000\u0000\u0000\u0127\u012a\u0001\u0000\u0000\u0000\u0128\u0126\u0001"+
		"\u0000\u0000\u0000\u0128\u0129\u0001\u0000\u0000\u0000\u0129)\u0001\u0000"+
		"\u0000\u0000\u012a\u0128\u0001\u0000\u0000\u0000\u001713?KRWb\u0091\u009b"+
		"\u009d\u00a6\u00ac\u00b6\u00b8\u00c6\u00d3\u00db\u00e4\u0100\u0109\u0110"+
		"\u0121\u0128";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}