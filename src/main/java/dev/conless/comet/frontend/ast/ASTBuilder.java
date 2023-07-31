package dev.conless.comet.frontend.ast;

import org.antlr.v4.runtime.tree.ParseTree;

import dev.conless.comet.frontend.grammar.*;
import dev.conless.comet.frontend.ast.def.*;
import dev.conless.comet.frontend.ast.expr.*;
import dev.conless.comet.frontend.ast.stmt.*;
import dev.conless.comet.frontend.ast.type.*;
import dev.conless.comet.utils.Position;

public class ASTBuilder extends CometBaseVisitor<ASTNode> {
  @Override
  public ASTNode visitProgram(Comet.ProgramContext ctx) {
    var program = new ProgramNode(new Position(ctx.start));
    for (ParseTree def : ctx.children) {
      program.addDef(visit(def));
    }
    return program;
  }

  @Override
  public ASTNode visitVarDef(Comet.VarDefContext ctx) {
    var varDef = new VarDefNode(new Position(ctx.start), (TypeNameNode) visit(ctx.typeName()));
    for (var variable : ctx.varConstructor()) {
      varDef.addVar(variable.name.getText(), variable.expr() != null ? (ExprNode) visit(variable.expr()) : null);
    }
    return varDef;
  }

  @Override
  public ASTNode visitClassDef(Comet.ClassDefContext ctx) {
    if (ctx.classConstructor().size() != 1) {
      System.out.println("Class can only have one constructor");
      System.exit(-1);
    }
    var constructor = ctx.classConstructor(0);
    var classDef = new ClassDefNode(new Position(ctx.start), ctx.name.getText(),
        new FuncDefNode(new Position(constructor.start), null, constructor.name.getText()));
    for (var def : ctx.varDef()) {
      classDef.addVarDef((VarDefNode) visit(def));
    }
    for (var def : ctx.funcDef()) {
      classDef.addFuncDef((FuncDefNode) visit(def));
    }
    return classDef;
  }

  @Override
  public ASTNode visitFuncDef(Comet.FuncDefContext ctx) {
    var funcDef = new FuncDefNode(new Position(ctx.start), (TypeNameNode) visit(ctx.typeName()), ctx.name.getText());
    var paramList = ctx.funcParamList();
    if (paramList != null) {
      for (var param : paramList.funcParam()) {
        var constructor = param.varConstructor();
        funcDef.addParam(new VarDefNode(new Position(param.start), (TypeNameNode) visit(param.typeName()),
            constructor.name.getText(), constructor.expr() != null ? (ExprNode) visit(constructor.expr()) : null));
        // TODO(Conless): check init value type
      }
    }
    funcDef.body = (BlockStmtNode) visit(ctx.blockStmt());
    return funcDef;
  }

  @Override
  public TypeNode visitType(Comet.TypeContext ctx) {
    return new TypeNode(new Position(ctx.start), ctx.getText());
  }

  @Override
  public ASTNode visitTypeName(Comet.TypeNameContext ctx) {
    return new TypeNameNode(new Position(ctx.start), (TypeNode) visit(ctx.type()), ctx.LBracket().size());
  }

  @Override
  public ASTNode visitNewExpr(Comet.NewExprContext ctx) {
    var newExpr = new NewExprNode(new Position(ctx.start), (TypeNode) visit(ctx.type()), ctx.LBracket().size());
    for (var expr : ctx.expr()) {
      newExpr.addLength((ExprNode) visit(expr));
    }
    return newExpr;
  }

  @Override
  public ASTNode visitParenExpr(Comet.ParenExprContext ctx) {
    return visit(ctx.expr());
  }

  @Override
  public ASTNode visitMemberExpr(Comet.MemberExprContext ctx) {
    return new MemberExprNode(new Position(ctx.start), (ExprNode) visit(ctx.expr()), ctx.member.getText());
  }

  @Override
  public ASTNode visitCallExpr(Comet.CallExprContext ctx) {
    var callExpr = new CallExprNode(new Position(ctx.start), (ExprNode) visit(ctx.expr()));
    if (ctx.funcArgList() != null) {
      for (var expr : ctx.funcArgList().expr()) {
        callExpr.addArg((ExprNode) visit(expr));
      }
    }
    return callExpr;
  }

  @Override
  public ASTNode visitIndexExpr(Comet.IndexExprContext ctx) {
    return new IndexExprNode(new Position(ctx.start), (ExprNode) visit(ctx.expr(0)), (ExprNode) visit(ctx.expr(1)));
  }

  @Override
  public ASTNode visitPostUnaryExpr(Comet.PostUnaryExprContext ctx) {
    return new PostUnaryExprNode(new Position(ctx.start), (ExprNode) visit(ctx.expr()), ctx.op.getText());
  }

  @Override
  public ASTNode visitPreUnaryExpr(Comet.PreUnaryExprContext ctx) {
    return new PreUnaryExprNode(new Position(ctx.start), (ExprNode) visit(ctx.expr()), ctx.op.getText());
  }

  @Override
  public ASTNode visitBinaryExpr(Comet.BinaryExprContext ctx) {
    return new BinaryExprNode(new Position(ctx.start), (ExprNode) visit(ctx.expr(0)), ctx.op.getText(),
        (ExprNode) visit(ctx.expr(1)));
  }

  @Override
  public ASTNode visitConditionalExpr(Comet.ConditionalExprContext ctx) {
    return new ConditionalExprNode(new Position(ctx.start), (ExprNode) visit(ctx.expr(0)),
        (ExprNode) visit(ctx.expr(1)),
        (ExprNode) visit(ctx.expr(2)));
  }
  
  @Override
  public ASTNode visitAssignExpr(Comet.AssignExprContext ctx) {
    return new AssignExprNode(new Position(ctx.start), (ExprNode) visit(ctx.expr(0)), ctx.op.getText(),
        (ExprNode) visit(ctx.expr(1)));
  }
  
  @Override
  public ASTNode visitAtomExpr(Comet.AtomExprContext ctx) {
    Type type;
    if (ctx.IntegerConst() != null) {
      type = Type.INT;
    } else if (ctx.StringConst() != null) {
      type = Type.STRING;
    } else if (ctx.True() != null || ctx.False() != null) {
      type = Type.BOOL;
    } else if (ctx.Null() != null) {
      type = Type.NULL;
    } else if (ctx.This() != null) {
      type = Type.THIS;
    } else {
      type = Type.CUSTOM;
    }
    return new AtomExprNode(new Position(ctx.start), type, ctx.getText());
  }
}
