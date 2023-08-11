package dev.conless.comet.frontend.ast;

import dev.conless.comet.frontend.grammar.*;
import dev.conless.comet.frontend.utils.metadata.ClassInfo;
import dev.conless.comet.frontend.utils.metadata.FuncInfo;
import dev.conless.comet.frontend.utils.metadata.TypeInfo;
import dev.conless.comet.frontend.utils.metadata.VarInfo;
import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.container.Position;
import dev.conless.comet.utils.error.CompileError;
import dev.conless.comet.frontend.ast.node.ASTNode;
import dev.conless.comet.frontend.ast.node.def.*;
import dev.conless.comet.frontend.ast.node.expr.*;
import dev.conless.comet.frontend.ast.node.special.ProgramNode;
import dev.conless.comet.frontend.ast.node.stmt.*;
import dev.conless.comet.frontend.ast.node.type.*;

public class ASTBuilder extends CometBaseVisitor<ASTNode> {
  @Override
  public ASTNode visitProgram(Comet.ProgramContext ctx) {
    var defs = new Array<BaseDefNode>();
    for (var def : ctx.children) {
      if ((def instanceof Comet.FuncDefContext) || (def instanceof Comet.ClassDefContext)) {
        defs.add((BaseDefNode) visit(def));
      } else if (def instanceof Comet.VarDefContext) {
        var varDef = (VarDefStmtNode) visit(def);
        for (var var : varDef.getDefs()) {
          defs.add(var);
        }
      }
    }
    return ProgramNode.builder()
        .parent(null)
        .position(new Position(ctx.start))
        .defs(defs)
        .build();
  }

  @Override
  public ASTNode visitVarDef(Comet.VarDefContext ctx) {
    var typeName = (TypeNameNode) visit(ctx.typeName());
    var vars = new Array<VarDefNode>();
    for (var v : ctx.varConstructor()) {
      var varDef = VarDefNode.builder()
          .position(new Position(ctx.start))
          .info(new VarInfo(v.name.getText(), typeName.getInfo()))
          .init(v.expr() != null ? (ExprNode) visit(v.expr()) : null)
          .build();
      vars.add(varDef);
    }
    var varDefStmt = VarDefStmtNode.builder()
        .position(new Position(ctx.start))
        .defs(vars)
        .build();
    for (var v : vars) {
      v.setParent(varDefStmt);
    }
    return varDefStmt;
  }

  @Override
  public ASTNode visitClassDef(Comet.ClassDefContext ctx) {
    FuncDefNode constructor = null;
    if (ctx.classConstructor().size() == 0) {
      constructor = FuncDefNode.builder()
          .position(new Position(ctx.start))
          .info(new FuncInfo(ctx.name.getText(), new TypeInfo("void", 0), new Array<>()))
          .params(new Array<>())
          .blockedBody(BlockStmtNode.builder().position(new Position(ctx.start)).stmts(new Array<>()).build())
          .build();
    } else if (ctx.classConstructor().size() == 1) {
      var ctor = ctx.classConstructor(0);
      if (!ctor.name.getText().equals(ctx.name.getText())) {
        throw new CompileError("Class constructor has a different name to class " + ctx.name.getText(), new Position(ctx.start));
      }
      constructor = FuncDefNode.builder()
          .position(new Position(ctor.start))
          .info(new FuncInfo(ctor.name.getText(), new TypeInfo("void", 0), new Array<>()))
          .blockedBody((BlockStmtNode) visit(ctor.blockStmt()))
          .build();
    } else {
      throw new CompileError("More than one class constructor is not allowed in class " + ctx.name.getText(), new Position(ctx.start));
    }
    var vars = new Array<VarDefNode>();
    for (var def : ctx.varDef()) {
      var varDef = (VarDefStmtNode) visit(def);
      for (var v : varDef.getDefs()) {
        vars.add(v);
      }
    }
    var funcs = new Array<FuncDefNode>();
    for (var def : ctx.funcDef()) {
      if (def.name.getText() == ctx.name.getText()) {
        throw new CompileError("Functions cannot have the same name as class " + ctx.name.getText(), new Position(def.start));
      }
      funcs.add((FuncDefNode) visit(def));
    }
    var classDef = ClassDefNode.builder()
        .info(new ClassInfo(ctx.name.getText(), vars, funcs))
        .constructor(constructor)
        .varDefs(vars)
        .funcDefs(funcs)
        .build();
    constructor.setParent(classDef);
    for (var v : vars) {
      v.setParent(classDef);
    }
    for (var f : funcs) {
      f.setParent(classDef);
    }
    return classDef;
  }

  @Override
  public ASTNode visitFuncDef(Comet.FuncDefContext ctx) {
    var paramList = ctx.funcParamList();
    var params = new Array<VarDefNode>();
    if (paramList != null) {
      for (var param : paramList.funcParam()) {
        var constructor = param.varConstructor();
        params.add(VarDefNode.builder()
            .position(new Position(param.start))
            .info(new VarInfo(constructor.name.getText(), ((TypeNameNode) visit(param.typeName())).getInfo()))
            .init(constructor.expr() != null ? (ExprNode) visit(constructor.expr()) : null)
            .build());
      }
    }
    var funcDef = FuncDefNode.builder()
        .position(new Position(ctx.start))
        .info(new FuncInfo(ctx.name.getText(), ((TypeNameNode) visit(ctx.typeName())).getInfo(), params))
        .params(params)
        .blockedBody((BlockStmtNode) visit(ctx.blockStmt()))
        .build();
    for (var p : params) {
      p.setParent(funcDef);
    }
    for (var stmt : funcDef.getBody()) {
      stmt.setParent(funcDef);
    }
    return funcDef;

  }

  @Override
  public ASTNode visitTypeName(Comet.TypeNameContext ctx) {
    for (var unit : ctx.arrayUnit()) {
      if (unit.expr() != null) {
        throw new CompileError("The definition of array shouldn't contain length", new Position(ctx.start));
      }
    }
    return TypeNameNode.builder()
        .position(new Position(ctx.start))
        .info(new TypeInfo(ctx.type().getText(), ctx.arrayUnit().size()))
        .build();
  }

  @Override
  public ASTNode visitNewExpr(Comet.NewExprContext ctx) {
    boolean initFinished = false;
    var lengths = new Array<ExprNode>();
    for (var unit : ctx.arrayUnit()) {
      if (unit.expr() == null) {
        initFinished = true;
      } else {
        if (initFinished) {
          throw new CompileError("The shape of multidimensional array must be specified from left to right", new Position(ctx.start));
        }
        lengths.add((ExprNode) visit(unit.expr()));
      }
    }
    return NewExprNode.builder()
        .position(new Position(ctx.start))
        .type(new TypeInfo(ctx.type().getText(), ctx.arrayUnit().size()))
        .lengths(lengths)
        .build();
  }

  @Override
  public ASTNode visitParenExpr(Comet.ParenExprContext ctx) {
    return visit(ctx.expr());
  }

  @Override
  public ASTNode visitMemberExpr(Comet.MemberExprContext ctx) {
    var memberExpr = MemberExprNode.builder()
        .position(new Position(ctx.start))
        .object((ExprNode) visit(ctx.expr()))
        .member(ctx.member.getText())
        .build();
    memberExpr.getObject().setParent(memberExpr);
    return memberExpr;
  }

  @Override
  public ASTNode visitCallExpr(Comet.CallExprContext ctx) {
    var args = new Array<ExprNode>();
    if (ctx.funcArgList() != null) {
      for (var expr : ctx.funcArgList().expr()) {
        args.add((ExprNode) visit(expr));
      }
    }
    var callExpr = CallExprNode.builder()
        .position(new Position(ctx.start))
        .func((ExprNode) visit(ctx.expr()))
        .args(args)
        .build();
    callExpr.getFunc().setParent(callExpr);
    for (var arg : args) {
      arg.setParent(callExpr);
    }
    return callExpr;
  }

  @Override
  public ASTNode visitArrayExpr(Comet.ArrayExprContext ctx) {
    if (ctx.arrayUnit().expr() == null) {
      throw new CompileError("Cannot access an array without index", new Position(ctx.start));
    }
    var arrayExpr = ArrayExprNode.builder()
        .position(new Position(ctx.start))
        .array((ExprNode) visit(ctx.expr()))
        .subscript((ExprNode) visit(ctx.arrayUnit().expr()))
        .build();
    arrayExpr.getArray().setParent(arrayExpr);
    arrayExpr.getSubscript().setParent(arrayExpr);
    return arrayExpr;
  }

  @Override
  public ASTNode visitPostUnaryExpr(Comet.PostUnaryExprContext ctx) {
    var postUnaryExpr = PostUnaryExprNode.builder()
        .position(new Position(ctx.start))
        .expr((ExprNode) visit(ctx.expr()))
        .op(ctx.op.getText())
        .build();
    postUnaryExpr.getExpr().setParent(postUnaryExpr);
    return postUnaryExpr;
  }

  @Override
  public ASTNode visitPreUnaryExpr(Comet.PreUnaryExprContext ctx) {
    var preUnaryExpr = PreUnaryExprNode.builder()
        .position(new Position(ctx.start))
        .expr((ExprNode) visit(ctx.expr()))
        .op(ctx.op.getText())
        .build();
    preUnaryExpr.getExpr().setParent(preUnaryExpr);
    return preUnaryExpr;
  }

  @Override
  public ASTNode visitBinaryExpr(Comet.BinaryExprContext ctx) {
    var binaryExpr = BinaryExprNode.builder()
        .position(new Position(ctx.start))
        .lhs((ExprNode) visit(ctx.expr(0)))
        .rhs((ExprNode) visit(ctx.expr(1)))
        .op(ctx.op.getText())
        .build();
    binaryExpr.getLhs().setParent(binaryExpr);
    binaryExpr.getRhs().setParent(binaryExpr);
    return binaryExpr;
  }

  @Override
  public ASTNode visitConditionalExpr(Comet.ConditionalExprContext ctx) {
    var conditionalExpr = ConditionalExprNode.builder()
        .position(new Position(ctx.start))
        .condition((ExprNode) visit(ctx.expr(0)))
        .lhs((ExprNode) visit(ctx.expr(1)))
        .rhs((ExprNode) visit(ctx.expr(2)))
        .build();
    conditionalExpr.getCondition().setParent(conditionalExpr);
    conditionalExpr.getLhs().setParent(conditionalExpr);
    conditionalExpr.getRhs().setParent(conditionalExpr);
    return conditionalExpr;
  }

  @Override
  public ASTNode visitAssignExpr(Comet.AssignExprContext ctx) {
    var assignExpr = AssignExprNode.builder()
        .position(new Position(ctx.start))
        .lhs((ExprNode) visit(ctx.expr(0)))
        .rhs((ExprNode) visit(ctx.expr(1)))
        .op(ctx.op.getText())
        .build();
    assignExpr.getLhs().setParent(assignExpr);
    assignExpr.getRhs().setParent(assignExpr);
    return assignExpr;
  }

  @Override
  public ASTNode visitAtomExpr(Comet.AtomExprContext ctx) {
    AtomExprNode.Type atomType;
    if (ctx.atom().IntegerLiteral() != null) {
      atomType = AtomExprNode.Type.INT;
    } else if (ctx.atom().StringLiteral() != null) {
      atomType = AtomExprNode.Type.STRING;
    } else if (ctx.atom().True() != null || ctx.atom().False() != null) {
      atomType = AtomExprNode.Type.BOOL;
    } else if (ctx.atom().Null() != null) {
      atomType = AtomExprNode.Type.NULL;
    } else if (ctx.atom().This() != null) {
      atomType = AtomExprNode.Type.THIS;
    } else {
      atomType = AtomExprNode.Type.CUSTOM;
    }
    return AtomExprNode.builder()
        .position(new Position(ctx.start))
        .atomType(atomType)
        .value(ctx.atom().getText())
        .build();
  }

  @Override
  public ASTNode visitStmt(Comet.StmtContext ctx) {
    return visitChildren(ctx);
  }

  @Override
  public ASTNode visitBlockStmt(Comet.BlockStmtContext ctx) {
    var stmts = new Array<StmtNode>();
    for (var stmt : ctx.stmt()) {
      stmts.add((StmtNode) visit(stmt));
    }
    var blockStmt = BlockStmtNode.builder()
        .position(new Position(ctx.start))
        .stmts(stmts)
        .build();
    for (var stmt : stmts) {
      stmt.setParent(blockStmt);
    }
    return blockStmt;
  }

  @Override
  public ASTNode visitIfStmt(Comet.IfStmtContext ctx) {
    var ifStmt = IfStmtNode.builder()
        .position(new Position(ctx.start))
        .condition((ExprNode) visit(ctx.expr()))
        .thenStmt((StmtNode) visit(ctx.stmt(0)))
        .elseStmt(ctx.stmt().size() == 2 ? (StmtNode) visit(ctx.stmt(1)) : null)
        .build();
    ifStmt.getCondition().setParent(ifStmt);
    ifStmt.getThenStmt().setParent(ifStmt);
    if (ifStmt.getElseStmt() != null) {
      ifStmt.getElseStmt().setParent(ifStmt);
    }
    return ifStmt;
  }

  @Override
  public ASTNode visitForStmt(Comet.ForStmtContext ctx) {
    var forStmt = ForStmtNode.builder()
        .position(new Position(ctx.start))
        .init((StmtNode) visit(ctx.init))
        .condition(ctx.condition == null ? null : (ExprNode) visit(ctx.condition))
        .update(ctx.update == null ? null : (ExprNode) visit(ctx.update))
        .body((StmtNode) visit(ctx.body))
        .build();
    forStmt.getInit().setParent(forStmt);
    if (forStmt.getCondition() != null) {
      forStmt.getCondition().setParent(forStmt);
    }
    if (forStmt.getUpdate() != null) {
      forStmt.getUpdate().setParent(forStmt);
    }
    forStmt.getBody().setParent(forStmt);
    return forStmt;
  }

  @Override
  public ASTNode visitWhileStmt(Comet.WhileStmtContext ctx) {
    var whileStmt = WhileStmtNode.builder()
        .position(new Position(ctx.start))
        .condition((ExprNode) visit(ctx.expr()))
        .body((StmtNode) visit(ctx.stmt()))
        .build();
    whileStmt.getCondition().setParent(whileStmt);
    whileStmt.getBody().setParent(whileStmt);
    return whileStmt;
  }

  @Override
  public ASTNode visitContinueStmt(Comet.ContinueStmtContext ctx) {
    return ContinueStmtNode.builder()
        .position(new Position(ctx.start))
        .build();
  }

  @Override
  public ASTNode visitBreakStmt(Comet.BreakStmtContext ctx) {
    return BreakStmtNode.builder()
        .position(new Position(ctx.start))
        .build();
  }

  @Override
  public ASTNode visitReturnStmt(Comet.ReturnStmtContext ctx) {
    var returnStmt = ReturnStmtNode.builder()
        .position(new Position(ctx.start))
        .expr(ctx.expr() == null ? null : (ExprNode) visit(ctx.expr()))
        .build();
    if (returnStmt.getExpr() != null) {
      returnStmt.getExpr().setParent(returnStmt);
    }
    return returnStmt;
  }

  @Override
  public ASTNode visitExprStmt(Comet.ExprStmtContext ctx) {
    var exprs = new Array<ExprNode>();
    for (var expr : ctx.expr()) {
      exprs.add((ExprNode) visit(expr));
    }
    var exprStmt = ExprStmtNode.builder()
        .position(new Position(ctx.start))
        .exprs(exprs)
        .build();
    for (var expr : exprs) {
      expr.setParent(exprStmt);
    }
    return exprStmt;
  }

  @Override
  public ASTNode visitEmptyStmt(Comet.EmptyStmtContext ctx) {
    return EmptyStmtNode.builder()
        .position(new Position(ctx.start))
        .build();
  }
}
