// Generated from Comet.g4 by ANTLR 4.13.0
package dev.conless.comet.frontend.grammar;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link Comet}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CometVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link Comet#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(Comet.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link Comet#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(Comet.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Comet#typeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeName(Comet.TypeNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newExpr}
	 * labeled alternative in {@link Comet#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewExpr(Comet.NewExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code indexExpr}
	 * labeled alternative in {@link Comet#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexExpr(Comet.IndexExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code postUnaryExpr}
	 * labeled alternative in {@link Comet#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostUnaryExpr(Comet.PostUnaryExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code preUnaryExpr}
	 * labeled alternative in {@link Comet#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreUnaryExpr(Comet.PreUnaryExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code memberExpr}
	 * labeled alternative in {@link Comet#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberExpr(Comet.MemberExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link Comet#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomExpr(Comet.AtomExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryExpr}
	 * labeled alternative in {@link Comet#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryExpr(Comet.BinaryExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code callExpr}
	 * labeled alternative in {@link Comet#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallExpr(Comet.CallExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignExpr}
	 * labeled alternative in {@link Comet#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignExpr(Comet.AssignExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link Comet#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpr(Comet.ParenExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code conditionalExpr}
	 * labeled alternative in {@link Comet#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalExpr(Comet.ConditionalExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link Comet#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(Comet.AtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link Comet#varDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDef(Comet.VarDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link Comet#varConstructor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarConstructor(Comet.VarConstructorContext ctx);
	/**
	 * Visit a parse tree produced by {@link Comet#classDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDef(Comet.ClassDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link Comet#classConstructor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassConstructor(Comet.ClassConstructorContext ctx);
	/**
	 * Visit a parse tree produced by {@link Comet#funcDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDef(Comet.FuncDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link Comet#funcParamList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncParamList(Comet.FuncParamListContext ctx);
	/**
	 * Visit a parse tree produced by {@link Comet#funcParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncParam(Comet.FuncParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link Comet#funcArgList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncArgList(Comet.FuncArgListContext ctx);
	/**
	 * Visit a parse tree produced by {@link Comet#blockStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStmt(Comet.BlockStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link Comet#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(Comet.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link Comet#ifStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(Comet.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link Comet#forStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStmt(Comet.ForStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link Comet#whileStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStmt(Comet.WhileStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link Comet#continueStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueStmt(Comet.ContinueStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link Comet#breakStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStmt(Comet.BreakStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link Comet#returnStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStmt(Comet.ReturnStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link Comet#exprStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprStmt(Comet.ExprStmtContext ctx);
}