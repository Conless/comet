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
	 * Visit a parse tree produced by the {@code customType}
	 * labeled alternative in {@link Comet#typeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCustomType(Comet.CustomTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayType}
	 * labeled alternative in {@link Comet#typeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayType(Comet.ArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code builtInType}
	 * labeled alternative in {@link Comet#typeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuiltInType(Comet.BuiltInTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code callExpression}
	 * labeled alternative in {@link Comet#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallExpression(Comet.CallExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryArithExpression}
	 * labeled alternative in {@link Comet#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryArithExpression(Comet.UnaryArithExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atomExpression}
	 * labeled alternative in {@link Comet#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomExpression(Comet.AtomExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code conditionalExpression}
	 * labeled alternative in {@link Comet#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalExpression(Comet.ConditionalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newExpression}
	 * labeled alternative in {@link Comet#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewExpression(Comet.NewExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignExpression}
	 * labeled alternative in {@link Comet#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignExpression(Comet.AssignExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code preSelfExpression}
	 * labeled alternative in {@link Comet#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreSelfExpression(Comet.PreSelfExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenExpression}
	 * labeled alternative in {@link Comet#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpression(Comet.ParenExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code indexExpression}
	 * labeled alternative in {@link Comet#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexExpression(Comet.IndexExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryArithExpression}
	 * labeled alternative in {@link Comet#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryArithExpression(Comet.BinaryArithExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code variableExpression}
	 * labeled alternative in {@link Comet#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableExpression(Comet.VariableExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Comet#variableDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDefinition(Comet.VariableDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Comet#variableConstructor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableConstructor(Comet.VariableConstructorContext ctx);
	/**
	 * Visit a parse tree produced by {@link Comet#classDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDefinition(Comet.ClassDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Comet#classConstructor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassConstructor(Comet.ClassConstructorContext ctx);
	/**
	 * Visit a parse tree produced by {@link Comet#functionDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDefinition(Comet.FunctionDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Comet#functionParaList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionParaList(Comet.FunctionParaListContext ctx);
	/**
	 * Visit a parse tree produced by {@link Comet#functionArgList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionArgList(Comet.FunctionArgListContext ctx);
	/**
	 * Visit a parse tree produced by {@link Comet#returnType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnType(Comet.ReturnTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Comet#blockStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStatement(Comet.BlockStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Comet#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(Comet.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Comet#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(Comet.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Comet#forStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(Comet.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Comet#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(Comet.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Comet#continueStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueStatement(Comet.ContinueStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Comet#breakStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStatement(Comet.BreakStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Comet#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(Comet.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Comet#expressionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionStatement(Comet.ExpressionStatementContext ctx);
}