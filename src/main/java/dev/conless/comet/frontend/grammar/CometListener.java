// Generated from Comet.g4 by ANTLR 4.13.0
package dev.conless.comet.frontend.grammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link Comet}.
 */
public interface CometListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link Comet#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(Comet.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link Comet#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(Comet.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link Comet#type}.
	 * @param ctx the parse tree
	 */
	void enterType(Comet.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Comet#type}.
	 * @param ctx the parse tree
	 */
	void exitType(Comet.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Comet#arrayUnit}.
	 * @param ctx the parse tree
	 */
	void enterArrayUnit(Comet.ArrayUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link Comet#arrayUnit}.
	 * @param ctx the parse tree
	 */
	void exitArrayUnit(Comet.ArrayUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link Comet#typeName}.
	 * @param ctx the parse tree
	 */
	void enterTypeName(Comet.TypeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link Comet#typeName}.
	 * @param ctx the parse tree
	 */
	void exitTypeName(Comet.TypeNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newExpr}
	 * labeled alternative in {@link Comet#expr}.
	 * @param ctx the parse tree
	 */
	void enterNewExpr(Comet.NewExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newExpr}
	 * labeled alternative in {@link Comet#expr}.
	 * @param ctx the parse tree
	 */
	void exitNewExpr(Comet.NewExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code indexExpr}
	 * labeled alternative in {@link Comet#expr}.
	 * @param ctx the parse tree
	 */
	void enterIndexExpr(Comet.IndexExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code indexExpr}
	 * labeled alternative in {@link Comet#expr}.
	 * @param ctx the parse tree
	 */
	void exitIndexExpr(Comet.IndexExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code postUnaryExpr}
	 * labeled alternative in {@link Comet#expr}.
	 * @param ctx the parse tree
	 */
	void enterPostUnaryExpr(Comet.PostUnaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code postUnaryExpr}
	 * labeled alternative in {@link Comet#expr}.
	 * @param ctx the parse tree
	 */
	void exitPostUnaryExpr(Comet.PostUnaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code preUnaryExpr}
	 * labeled alternative in {@link Comet#expr}.
	 * @param ctx the parse tree
	 */
	void enterPreUnaryExpr(Comet.PreUnaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code preUnaryExpr}
	 * labeled alternative in {@link Comet#expr}.
	 * @param ctx the parse tree
	 */
	void exitPreUnaryExpr(Comet.PreUnaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code memberExpr}
	 * labeled alternative in {@link Comet#expr}.
	 * @param ctx the parse tree
	 */
	void enterMemberExpr(Comet.MemberExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code memberExpr}
	 * labeled alternative in {@link Comet#expr}.
	 * @param ctx the parse tree
	 */
	void exitMemberExpr(Comet.MemberExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link Comet#expr}.
	 * @param ctx the parse tree
	 */
	void enterAtomExpr(Comet.AtomExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link Comet#expr}.
	 * @param ctx the parse tree
	 */
	void exitAtomExpr(Comet.AtomExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryExpr}
	 * labeled alternative in {@link Comet#expr}.
	 * @param ctx the parse tree
	 */
	void enterBinaryExpr(Comet.BinaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryExpr}
	 * labeled alternative in {@link Comet#expr}.
	 * @param ctx the parse tree
	 */
	void exitBinaryExpr(Comet.BinaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code callExpr}
	 * labeled alternative in {@link Comet#expr}.
	 * @param ctx the parse tree
	 */
	void enterCallExpr(Comet.CallExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code callExpr}
	 * labeled alternative in {@link Comet#expr}.
	 * @param ctx the parse tree
	 */
	void exitCallExpr(Comet.CallExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignExpr}
	 * labeled alternative in {@link Comet#expr}.
	 * @param ctx the parse tree
	 */
	void enterAssignExpr(Comet.AssignExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignExpr}
	 * labeled alternative in {@link Comet#expr}.
	 * @param ctx the parse tree
	 */
	void exitAssignExpr(Comet.AssignExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link Comet#expr}.
	 * @param ctx the parse tree
	 */
	void enterParenExpr(Comet.ParenExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link Comet#expr}.
	 * @param ctx the parse tree
	 */
	void exitParenExpr(Comet.ParenExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code conditionalExpr}
	 * labeled alternative in {@link Comet#expr}.
	 * @param ctx the parse tree
	 */
	void enterConditionalExpr(Comet.ConditionalExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code conditionalExpr}
	 * labeled alternative in {@link Comet#expr}.
	 * @param ctx the parse tree
	 */
	void exitConditionalExpr(Comet.ConditionalExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link Comet#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(Comet.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link Comet#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(Comet.AtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link Comet#varDef}.
	 * @param ctx the parse tree
	 */
	void enterVarDef(Comet.VarDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link Comet#varDef}.
	 * @param ctx the parse tree
	 */
	void exitVarDef(Comet.VarDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link Comet#varConstructor}.
	 * @param ctx the parse tree
	 */
	void enterVarConstructor(Comet.VarConstructorContext ctx);
	/**
	 * Exit a parse tree produced by {@link Comet#varConstructor}.
	 * @param ctx the parse tree
	 */
	void exitVarConstructor(Comet.VarConstructorContext ctx);
	/**
	 * Enter a parse tree produced by {@link Comet#classDef}.
	 * @param ctx the parse tree
	 */
	void enterClassDef(Comet.ClassDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link Comet#classDef}.
	 * @param ctx the parse tree
	 */
	void exitClassDef(Comet.ClassDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link Comet#classConstructor}.
	 * @param ctx the parse tree
	 */
	void enterClassConstructor(Comet.ClassConstructorContext ctx);
	/**
	 * Exit a parse tree produced by {@link Comet#classConstructor}.
	 * @param ctx the parse tree
	 */
	void exitClassConstructor(Comet.ClassConstructorContext ctx);
	/**
	 * Enter a parse tree produced by {@link Comet#funcDef}.
	 * @param ctx the parse tree
	 */
	void enterFuncDef(Comet.FuncDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link Comet#funcDef}.
	 * @param ctx the parse tree
	 */
	void exitFuncDef(Comet.FuncDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link Comet#funcParamList}.
	 * @param ctx the parse tree
	 */
	void enterFuncParamList(Comet.FuncParamListContext ctx);
	/**
	 * Exit a parse tree produced by {@link Comet#funcParamList}.
	 * @param ctx the parse tree
	 */
	void exitFuncParamList(Comet.FuncParamListContext ctx);
	/**
	 * Enter a parse tree produced by {@link Comet#funcParam}.
	 * @param ctx the parse tree
	 */
	void enterFuncParam(Comet.FuncParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link Comet#funcParam}.
	 * @param ctx the parse tree
	 */
	void exitFuncParam(Comet.FuncParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link Comet#funcArgList}.
	 * @param ctx the parse tree
	 */
	void enterFuncArgList(Comet.FuncArgListContext ctx);
	/**
	 * Exit a parse tree produced by {@link Comet#funcArgList}.
	 * @param ctx the parse tree
	 */
	void exitFuncArgList(Comet.FuncArgListContext ctx);
	/**
	 * Enter a parse tree produced by {@link Comet#blockStmt}.
	 * @param ctx the parse tree
	 */
	void enterBlockStmt(Comet.BlockStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Comet#blockStmt}.
	 * @param ctx the parse tree
	 */
	void exitBlockStmt(Comet.BlockStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Comet#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(Comet.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Comet#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(Comet.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Comet#ifStmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(Comet.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Comet#ifStmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(Comet.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Comet#forStmt}.
	 * @param ctx the parse tree
	 */
	void enterForStmt(Comet.ForStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Comet#forStmt}.
	 * @param ctx the parse tree
	 */
	void exitForStmt(Comet.ForStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Comet#whileStmt}.
	 * @param ctx the parse tree
	 */
	void enterWhileStmt(Comet.WhileStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Comet#whileStmt}.
	 * @param ctx the parse tree
	 */
	void exitWhileStmt(Comet.WhileStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Comet#continueStmt}.
	 * @param ctx the parse tree
	 */
	void enterContinueStmt(Comet.ContinueStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Comet#continueStmt}.
	 * @param ctx the parse tree
	 */
	void exitContinueStmt(Comet.ContinueStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Comet#breakStmt}.
	 * @param ctx the parse tree
	 */
	void enterBreakStmt(Comet.BreakStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Comet#breakStmt}.
	 * @param ctx the parse tree
	 */
	void exitBreakStmt(Comet.BreakStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Comet#returnStmt}.
	 * @param ctx the parse tree
	 */
	void enterReturnStmt(Comet.ReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Comet#returnStmt}.
	 * @param ctx the parse tree
	 */
	void exitReturnStmt(Comet.ReturnStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Comet#exprStmt}.
	 * @param ctx the parse tree
	 */
	void enterExprStmt(Comet.ExprStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Comet#exprStmt}.
	 * @param ctx the parse tree
	 */
	void exitExprStmt(Comet.ExprStmtContext ctx);
}