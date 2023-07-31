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
      if (def instanceof Comet.VarDefContext || def instanceof Comet.FuncDefContext
          || def instanceof Comet.ClassDefContext) {
        program.addDef(visit(def));
      }
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
    var constructor = ctx.classConstructor() != null ? ctx.classConstructor(0) : null;
    var classDef = new ClassDefNode(new Position(ctx.start), ctx.name.getText(),
        constructor != null ? new FuncDefNode(new Position(constructor.start), null, constructor.name.getText())
            : null);
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

  @Override
  public ASTNode visitStmt(Comet.StmtContext ctx) {
    var child = ctx.getChild(0);
    if (child instanceof Comet.VarDefContext) {
      return new VarDefStmtNode(new Position(ctx.start), (VarDefNode) visit(child));
    } else if (child instanceof Comet.ClassDefContext) {
      return new ClassDefStmtNode(new Position(ctx.start), (ClassDefNode) visit(child));
    } else if (child == ctx.Semi()) {
      return new EmptyStmtNode(new Position(ctx.start));
    }
    return visit(ctx.getChild(0));
  }

  @Override
  public ASTNode visitBlockStmt(Comet.BlockStmtContext ctx) {
    var blockStmt = new BlockStmtNode(new Position(ctx.start));
    for (var stmt : ctx.stmt()) {
      blockStmt.addStmt((StmtNode) visit(stmt));
    }
    return blockStmt;
  }

  @Override
  public ASTNode visitIfStmt(Comet.IfStmtContext ctx) {
    return new IfStmtNode(new Position(ctx.start), (ExprNode) visit(ctx.expr()), (StmtNode) visit(ctx.stmt(0)),
        ctx.stmt().size() == 2 ? (StmtNode) visit(ctx.stmt(1)) : null);
  }

  @Override
  public ASTNode visitForStmt(Comet.ForStmtContext ctx) {
    return new ForStmtNode(new Position(ctx.start), (StmtNode) visit(ctx.init), (StmtNode) visit(ctx.condition),
        (ExprStmtNode) visit(ctx.update), (StmtNode) visit(ctx.body));
  }

  @Override
  public ASTNode visitWhileStmt(Comet.WhileStmtContext ctx) {
    return new WhileStmtNode(new Position(ctx.start), (ExprNode) visit(ctx.expr()), (StmtNode) visit(ctx.stmt()));
  }

  @Override
  public ASTNode visitContinueStmt(Comet.ContinueStmtContext ctx) {
    return new ContinueStmtNode(new Position(ctx.start));
  }

  @Override
  public ASTNode visitBreakStmt(Comet.BreakStmtContext ctx) {
    return new BreakStmtNode(new Position(ctx.start));
  }

  @Override
  public ASTNode visitReturnStmt(Comet.ReturnStmtContext ctx) {
    return new ReturnStmtNode(new Position(ctx.start), ctx.expr() != null ? (ExprNode) visit(ctx.expr()) : null);
  }

  @Override
  public ASTNode visitExprStmt(Comet.ExprStmtContext ctx) {
    var exprStmt = new ExprStmtNode(new Position(ctx.start));
    for (var expr : ctx.expr()) {
      exprStmt.addExpr((ExprNode) visit(expr));
    }
    return exprStmt;
  }
}
