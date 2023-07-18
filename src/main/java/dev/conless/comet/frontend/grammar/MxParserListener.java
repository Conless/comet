// Generated from MxParser.g4 by ANTLR 4.13.0
package dev.conless.comet.frontend.grammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MxParser}.
 */
public interface MxParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MxParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MxParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MxParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code customType}
	 * labeled alternative in {@link MxParser#typeName}.
	 * @param ctx the parse tree
	 */
	void enterCustomType(MxParser.CustomTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code customType}
	 * labeled alternative in {@link MxParser#typeName}.
	 * @param ctx the parse tree
	 */
	void exitCustomType(MxParser.CustomTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayType}
	 * labeled alternative in {@link MxParser#typeName}.
	 * @param ctx the parse tree
	 */
	void enterArrayType(MxParser.ArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayType}
	 * labeled alternative in {@link MxParser#typeName}.
	 * @param ctx the parse tree
	 */
	void exitArrayType(MxParser.ArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code builtInType}
	 * labeled alternative in {@link MxParser#typeName}.
	 * @param ctx the parse tree
	 */
	void enterBuiltInType(MxParser.BuiltInTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code builtInType}
	 * labeled alternative in {@link MxParser#typeName}.
	 * @param ctx the parse tree
	 */
	void exitBuiltInType(MxParser.BuiltInTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryArithExpression}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryArithExpression(MxParser.UnaryArithExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryArithExpression}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryArithExpression(MxParser.UnaryArithExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code conditionalExpression}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterConditionalExpression(MxParser.ConditionalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code conditionalExpression}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitConditionalExpression(MxParser.ConditionalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newExpression}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNewExpression(MxParser.NewExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newExpression}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNewExpression(MxParser.NewExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignExpression}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAssignExpression(MxParser.AssignExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignExpression}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAssignExpression(MxParser.AssignExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code preSelfExpression}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPreSelfExpression(MxParser.PreSelfExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code preSelfExpression}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPreSelfExpression(MxParser.PreSelfExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryArithExpression}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBinaryArithExpression(MxParser.BinaryArithExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryArithExpression}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBinaryArithExpression(MxParser.BinaryArithExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code variableExpression}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterVariableExpression(MxParser.VariableExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code variableExpression}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitVariableExpression(MxParser.VariableExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code functionExpression}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFunctionExpression(MxParser.FunctionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functionExpression}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFunctionExpression(MxParser.FunctionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atomExpression}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAtomExpression(MxParser.AtomExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atomExpression}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAtomExpression(MxParser.AtomExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code memberAccessExpression}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMemberAccessExpression(MxParser.MemberAccessExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code memberAccessExpression}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMemberAccessExpression(MxParser.MemberAccessExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code indexAccessExpression}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIndexAccessExpression(MxParser.IndexAccessExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code indexAccessExpression}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIndexAccessExpression(MxParser.IndexAccessExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code subExpression}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSubExpression(MxParser.SubExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code subExpression}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSubExpression(MxParser.SubExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code methodAccessExpression}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMethodAccessExpression(MxParser.MethodAccessExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code methodAccessExpression}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMethodAccessExpression(MxParser.MethodAccessExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#variableDefinition}.
	 * @param ctx the parse tree
	 */
	void enterVariableDefinition(MxParser.VariableDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#variableDefinition}.
	 * @param ctx the parse tree
	 */
	void exitVariableDefinition(MxParser.VariableDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#variableConstructor}.
	 * @param ctx the parse tree
	 */
	void enterVariableConstructor(MxParser.VariableConstructorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#variableConstructor}.
	 * @param ctx the parse tree
	 */
	void exitVariableConstructor(MxParser.VariableConstructorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#classDefinition}.
	 * @param ctx the parse tree
	 */
	void enterClassDefinition(MxParser.ClassDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#classDefinition}.
	 * @param ctx the parse tree
	 */
	void exitClassDefinition(MxParser.ClassDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#classConstructor}.
	 * @param ctx the parse tree
	 */
	void enterClassConstructor(MxParser.ClassConstructorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#classConstructor}.
	 * @param ctx the parse tree
	 */
	void exitClassConstructor(MxParser.ClassConstructorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDefinition(MxParser.FunctionDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDefinition(MxParser.FunctionDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#functionParaList}.
	 * @param ctx the parse tree
	 */
	void enterFunctionParaList(MxParser.FunctionParaListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#functionParaList}.
	 * @param ctx the parse tree
	 */
	void exitFunctionParaList(MxParser.FunctionParaListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#functionArgList}.
	 * @param ctx the parse tree
	 */
	void enterFunctionArgList(MxParser.FunctionArgListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#functionArgList}.
	 * @param ctx the parse tree
	 */
	void exitFunctionArgList(MxParser.FunctionArgListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#returnType}.
	 * @param ctx the parse tree
	 */
	void enterReturnType(MxParser.ReturnTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#returnType}.
	 * @param ctx the parse tree
	 */
	void exitReturnType(MxParser.ReturnTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#suite}.
	 * @param ctx the parse tree
	 */
	void enterSuite(MxParser.SuiteContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#suite}.
	 * @param ctx the parse tree
	 */
	void exitSuite(MxParser.SuiteContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(MxParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(MxParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(MxParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(MxParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#forInitStatement}.
	 * @param ctx the parse tree
	 */
	void enterForInitStatement(MxParser.ForInitStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#forInitStatement}.
	 * @param ctx the parse tree
	 */
	void exitForInitStatement(MxParser.ForInitStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(MxParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(MxParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(MxParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(MxParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#continueStatement}.
	 * @param ctx the parse tree
	 */
	void enterContinueStatement(MxParser.ContinueStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#continueStatement}.
	 * @param ctx the parse tree
	 */
	void exitContinueStatement(MxParser.ContinueStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void enterBreakStatement(MxParser.BreakStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void exitBreakStatement(MxParser.BreakStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(MxParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(MxParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStatement(MxParser.ExpressionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStatement(MxParser.ExpressionStatementContext ctx);
}