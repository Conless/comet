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
	 * Enter a parse tree produced by the {@code customType}
	 * labeled alternative in {@link Comet#typeName}.
	 * @param ctx the parse tree
	 */
	void enterCustomType(Comet.CustomTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code customType}
	 * labeled alternative in {@link Comet#typeName}.
	 * @param ctx the parse tree
	 */
	void exitCustomType(Comet.CustomTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayType}
	 * labeled alternative in {@link Comet#typeName}.
	 * @param ctx the parse tree
	 */
	void enterArrayType(Comet.ArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayType}
	 * labeled alternative in {@link Comet#typeName}.
	 * @param ctx the parse tree
	 */
	void exitArrayType(Comet.ArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code builtInType}
	 * labeled alternative in {@link Comet#typeName}.
	 * @param ctx the parse tree
	 */
	void enterBuiltInType(Comet.BuiltInTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code builtInType}
	 * labeled alternative in {@link Comet#typeName}.
	 * @param ctx the parse tree
	 */
	void exitBuiltInType(Comet.BuiltInTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code callExpression}
	 * labeled alternative in {@link Comet#expression}.
	 * @param ctx the parse tree
	 */
	void enterCallExpression(Comet.CallExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code callExpression}
	 * labeled alternative in {@link Comet#expression}.
	 * @param ctx the parse tree
	 */
	void exitCallExpression(Comet.CallExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryArithExpression}
	 * labeled alternative in {@link Comet#expression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryArithExpression(Comet.UnaryArithExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryArithExpression}
	 * labeled alternative in {@link Comet#expression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryArithExpression(Comet.UnaryArithExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atomExpression}
	 * labeled alternative in {@link Comet#expression}.
	 * @param ctx the parse tree
	 */
	void enterAtomExpression(Comet.AtomExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atomExpression}
	 * labeled alternative in {@link Comet#expression}.
	 * @param ctx the parse tree
	 */
	void exitAtomExpression(Comet.AtomExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code conditionalExpression}
	 * labeled alternative in {@link Comet#expression}.
	 * @param ctx the parse tree
	 */
	void enterConditionalExpression(Comet.ConditionalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code conditionalExpression}
	 * labeled alternative in {@link Comet#expression}.
	 * @param ctx the parse tree
	 */
	void exitConditionalExpression(Comet.ConditionalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newExpression}
	 * labeled alternative in {@link Comet#expression}.
	 * @param ctx the parse tree
	 */
	void enterNewExpression(Comet.NewExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newExpression}
	 * labeled alternative in {@link Comet#expression}.
	 * @param ctx the parse tree
	 */
	void exitNewExpression(Comet.NewExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignExpression}
	 * labeled alternative in {@link Comet#expression}.
	 * @param ctx the parse tree
	 */
	void enterAssignExpression(Comet.AssignExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignExpression}
	 * labeled alternative in {@link Comet#expression}.
	 * @param ctx the parse tree
	 */
	void exitAssignExpression(Comet.AssignExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code preSelfExpression}
	 * labeled alternative in {@link Comet#expression}.
	 * @param ctx the parse tree
	 */
	void enterPreSelfExpression(Comet.PreSelfExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code preSelfExpression}
	 * labeled alternative in {@link Comet#expression}.
	 * @param ctx the parse tree
	 */
	void exitPreSelfExpression(Comet.PreSelfExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenExpression}
	 * labeled alternative in {@link Comet#expression}.
	 * @param ctx the parse tree
	 */
	void enterParenExpression(Comet.ParenExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenExpression}
	 * labeled alternative in {@link Comet#expression}.
	 * @param ctx the parse tree
	 */
	void exitParenExpression(Comet.ParenExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code indexExpression}
	 * labeled alternative in {@link Comet#expression}.
	 * @param ctx the parse tree
	 */
	void enterIndexExpression(Comet.IndexExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code indexExpression}
	 * labeled alternative in {@link Comet#expression}.
	 * @param ctx the parse tree
	 */
	void exitIndexExpression(Comet.IndexExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryArithExpression}
	 * labeled alternative in {@link Comet#expression}.
	 * @param ctx the parse tree
	 */
	void enterBinaryArithExpression(Comet.BinaryArithExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryArithExpression}
	 * labeled alternative in {@link Comet#expression}.
	 * @param ctx the parse tree
	 */
	void exitBinaryArithExpression(Comet.BinaryArithExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code variableExpression}
	 * labeled alternative in {@link Comet#expression}.
	 * @param ctx the parse tree
	 */
	void enterVariableExpression(Comet.VariableExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code variableExpression}
	 * labeled alternative in {@link Comet#expression}.
	 * @param ctx the parse tree
	 */
	void exitVariableExpression(Comet.VariableExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Comet#variableDefinition}.
	 * @param ctx the parse tree
	 */
	void enterVariableDefinition(Comet.VariableDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Comet#variableDefinition}.
	 * @param ctx the parse tree
	 */
	void exitVariableDefinition(Comet.VariableDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Comet#variableConstructor}.
	 * @param ctx the parse tree
	 */
	void enterVariableConstructor(Comet.VariableConstructorContext ctx);
	/**
	 * Exit a parse tree produced by {@link Comet#variableConstructor}.
	 * @param ctx the parse tree
	 */
	void exitVariableConstructor(Comet.VariableConstructorContext ctx);
	/**
	 * Enter a parse tree produced by {@link Comet#classDefinition}.
	 * @param ctx the parse tree
	 */
	void enterClassDefinition(Comet.ClassDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Comet#classDefinition}.
	 * @param ctx the parse tree
	 */
	void exitClassDefinition(Comet.ClassDefinitionContext ctx);
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
	 * Enter a parse tree produced by {@link Comet#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDefinition(Comet.FunctionDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Comet#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDefinition(Comet.FunctionDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Comet#functionParaList}.
	 * @param ctx the parse tree
	 */
	void enterFunctionParaList(Comet.FunctionParaListContext ctx);
	/**
	 * Exit a parse tree produced by {@link Comet#functionParaList}.
	 * @param ctx the parse tree
	 */
	void exitFunctionParaList(Comet.FunctionParaListContext ctx);
	/**
	 * Enter a parse tree produced by {@link Comet#functionArgList}.
	 * @param ctx the parse tree
	 */
	void enterFunctionArgList(Comet.FunctionArgListContext ctx);
	/**
	 * Exit a parse tree produced by {@link Comet#functionArgList}.
	 * @param ctx the parse tree
	 */
	void exitFunctionArgList(Comet.FunctionArgListContext ctx);
	/**
	 * Enter a parse tree produced by {@link Comet#returnType}.
	 * @param ctx the parse tree
	 */
	void enterReturnType(Comet.ReturnTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Comet#returnType}.
	 * @param ctx the parse tree
	 */
	void exitReturnType(Comet.ReturnTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Comet#blockStatement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatement(Comet.BlockStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Comet#blockStatement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatement(Comet.BlockStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Comet#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(Comet.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Comet#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(Comet.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Comet#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(Comet.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Comet#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(Comet.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Comet#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(Comet.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Comet#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(Comet.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Comet#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(Comet.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Comet#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(Comet.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Comet#continueStatement}.
	 * @param ctx the parse tree
	 */
	void enterContinueStatement(Comet.ContinueStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Comet#continueStatement}.
	 * @param ctx the parse tree
	 */
	void exitContinueStatement(Comet.ContinueStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Comet#breakStatement}.
	 * @param ctx the parse tree
	 */
	void enterBreakStatement(Comet.BreakStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Comet#breakStatement}.
	 * @param ctx the parse tree
	 */
	void exitBreakStatement(Comet.BreakStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Comet#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(Comet.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Comet#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(Comet.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Comet#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStatement(Comet.ExpressionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Comet#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStatement(Comet.ExpressionStatementContext ctx);
}