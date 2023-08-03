package dev.conless.comet.frontend.ast;

import dev.conless.comet.frontend.grammar.*;
import dev.conless.comet.utils.Type;
import dev.conless.comet.utils.container.Position;
import dev.conless.comet.utils.metadata.TypeInfo;
import dev.conless.comet.frontend.ast.def.*;
import dev.conless.comet.frontend.ast.expr.*;
import dev.conless.comet.frontend.ast.stmt.*;
import dev.conless.comet.frontend.ast.type.*;

public class ASTBuilder extends CometBaseVisitor<ASTNode> {
  @Override
  public ASTNode visitProgram(Comet.ProgramContext ctx) {
    var program = new ProgramNode(new Position(ctx.start));
    for (var def : ctx.children) {
      if (def instanceof Comet.VarDefContext || def instanceof Comet.FuncDefContext
          || def instanceof Comet.ClassDefContext) {
        program.addDef((BaseDefNode) visit(def));
      }
    }
    return program;
  }

  @Override
  public ASTNode visitVarDef(Comet.VarDefContext ctx) {
    var varDef = new VarDefNode(new Position(ctx.start), (TypeNameNode) visit(ctx.typeName()));
    for (var v : ctx.varConstructor()) {
      varDef.addVar(v.name.getText(), v.expr() != null ? (ExprNode) visit(v.expr()) : null);
    }
    return varDef;
  }

  @Override
  public ASTNode visitClassDef(Comet.ClassDefContext ctx) {
    FuncDefNode constructor = null;
    if (ctx.classConstructor().size() == 0) {
      constructor = new FuncDefNode(new Position(ctx.start), new TypeInfo("void", 0), ctx.name.getText(), new BlockStmtNode(new Position(ctx.start)));
    } else if (ctx.classConstructor().size() == 1) {
      var ctor = ctx.classConstructor(0);
      constructor = new FuncDefNode(new Position(ctx.start), new TypeInfo("void", 0), ctor.name.getText(), (BlockStmtNode) visit(ctor.blockStmt()));
    }
    var classDef = new ClassDefNode(new Position(ctx.start), ctx.name.getText(), constructor);
    for (var def : ctx.varDef()) {
      classDef.addVarDef((VarDefNode) visit(def));
    }
    for (var def : ctx.funcDef()) {
      if (def.name.getText() == ctx.name.getText()) {
        throw new RuntimeException("constructor cannot have the same name as class");
      }
      classDef.addFuncDef((FuncDefNode) visit(def));
    }
    return classDef;
  }

  @Override
  public ASTNode visitFuncDef(Comet.FuncDefContext ctx) {
    var funcDef = new FuncDefNode(new Position(ctx.start), ((TypeNameNode) visit(ctx.typeName())).type, ctx.name.getText(), (BlockStmtNode) visit(ctx.blockStmt()));
    var paramList = ctx.funcParamList();
    if (paramList != null) {
      for (var param : paramList.funcParam()) {
        var constructor = param.varConstructor();
        funcDef.addParam(new VarDefNode(new Position(param.start), (TypeNameNode) visit(param.typeName()),
            constructor.name.getText(), constructor.expr() != null ? (ExprNode) visit(constructor.expr()) : null));
        // TODO(Conless): check init value type
      }
    }
    return funcDef;
  }

  @Override
  public ASTNode visitTypeName(Comet.TypeNameContext ctx) {
    for (var unit : ctx.arrayUnit()) {
      if (unit.expr() != null) {
        throw new RuntimeException("array definition shouldn't contain length");
      }
    }
    return new TypeNameNode(new Position(ctx.start), ctx.type().getText(), ctx.arrayUnit().size());
  }

  @Override
  public ASTNode visitNewExpr(Comet.NewExprContext ctx) {
    var newExpr = new NewExprNode(new Position(ctx.start), ctx.type().getText(), ctx.arrayUnit().size());
    boolean initFinished = false;
    for (var unit : ctx.arrayUnit()) {
      if (unit.expr() == null) {
        initFinished = true;
      } else {
        if (initFinished) {
          throw new RuntimeException("The shape of multidimensional array must be specified from left to right");
        }
        newExpr.addLength((ExprNode) visit(unit.expr()));
      }
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
    Type atomType;
    if (ctx.atom().IntegerLiteral() != null) {
      atomType = Type.INT;
    } else if (ctx.atom().StringLiteral() != null) {
      atomType = Type.STRING;
    } else if (ctx.atom().True() != null || ctx.atom().False() != null) {
      atomType = Type.BOOL;
    } else if (ctx.atom().Null() != null) {
      atomType = Type.NULL;
    } else if (ctx.atom().This() != null) {
      atomType = Type.THIS;
    } else {
      atomType = Type.CUSTOM;
    }
    return new AtomExprNode(new Position(ctx.start), atomType, ctx.getText());
  }

  @Override
  public ASTNode visitStmt(Comet.StmtContext ctx) {
    var child = ctx.getChild(0);
    if (child instanceof Comet.VarDefContext) {
      return new VarDefStmtNode(new Position(ctx.start), (VarDefNode) visit(child));
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
    return new ForStmtNode(new Position(ctx.start), (StmtNode) visit(ctx.init), (ExprNode) visit(ctx.condition),
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
