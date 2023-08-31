package dev.conless.comet.frontend.ast;

import dev.conless.comet.frontend.grammar.*;
import dev.conless.comet.frontend.utils.metadata.ClassInfo;
import dev.conless.comet.frontend.utils.metadata.FuncInfo;
import dev.conless.comet.frontend.utils.metadata.TypeInfo;
import dev.conless.comet.frontend.utils.metadata.VarInfo;
import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.container.Position;
import dev.conless.comet.utils.error.CompileError;

import java.util.Comparator;

import dev.conless.comet.frontend.ast.node.ASTNode;
import dev.conless.comet.frontend.ast.node.ASTRoot;
import dev.conless.comet.frontend.ast.node.def.*;
import dev.conless.comet.frontend.ast.node.expr.*;
import dev.conless.comet.frontend.ast.node.stmt.*;
import dev.conless.comet.frontend.ast.node.type.*;

public class ASTBuilder extends CometBaseVisitor<ASTNode> {
  @Override
  public ASTNode visitProgram(Comet.ProgramContext ctx) {
    var defs = new Array<ASTDefNode>();
    for (var def : ctx.children) {
      if ((def instanceof Comet.FuncDefContext) || (def instanceof Comet.ClassDefContext)) {
        defs.add((ASTDefNode) visit(def));
      } else if (def instanceof Comet.VarDefContext) {
        var varDef = (ASTVarDefStmtNode) visit(def);
        for (var var : varDef.getDefs()) {
          defs.add(var);
        }
      }
    }
    return ASTRoot.builder()
        .parent(null)
        .position(new Position(ctx.start))
        .defs(defs)
        .build();
  }

  @Override
  public ASTNode visitVarDef(Comet.VarDefContext ctx) {
    var typeName = (ASTTypeNode) visit(ctx.typeName());
    var vars = new Array<ASTVarDefNode>();
    for (var v : ctx.varConstructor()) {
      var varDef = ASTVarDefNode.builder()
          .position(new Position(ctx.start))
          .info(new VarInfo(v.name.getText(), typeName.getInfo()))
          .init(v.expr() != null ? (ASTExprNode) visit(v.expr()) : null)
          .build();
      if (varDef.getInit() != null) {
        varDef.getInit().setParent(varDef);
      }
      vars.add(varDef);
    }
    var varDefStmt = ASTVarDefStmtNode.builder()
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
    ASTFuncDefNode constructor = null;
    if (ctx.classConstructor().size() == 0) {
      constructor = ASTFuncDefNode.builder()
          .position(new Position(ctx.start))
          .info(new FuncInfo(ctx.name.getText(), new TypeInfo("void", 0), new Array<>()))
          .params(new Array<>())
          .blockedBody(ASTBlockStmtNode.builder().position(new Position(ctx.start)).stmts(new Array<>()).build())
          .build();
    } else if (ctx.classConstructor().size() == 1) {
      var ctor = ctx.classConstructor(0);
      if (!ctor.name.getText().equals(ctx.name.getText())) {
        throw new CompileError("Class constructor has a different name to class " + ctx.name.getText(), new Position(ctx.start));
      }
      constructor = ASTFuncDefNode.builder()
          .position(new Position(ctor.start))
          .info(new FuncInfo(ctor.name.getText(), new TypeInfo("void", 0), new Array<>()))
          .params(new Array<>())
          .blockedBody((ASTBlockStmtNode) visit(ctor.blockStmt()))
          .build();
    } else {
      throw new CompileError("More than one class constructor is not allowed in class " + ctx.name.getText(), new Position(ctx.start));
    }
    var vars = new Array<ASTVarDefNode>();
    for (var def : ctx.varDef()) {
      var varDef = (ASTVarDefStmtNode) visit(def);
      for (var v : varDef.getDefs()) {
        vars.add(v);
      }
    }
    vars.sort(new Comparator<ASTVarDefNode>() {
      @Override
      public int compare(ASTVarDefNode o1, ASTVarDefNode o2) {
        return o1.getInfo().getName().compareTo(o2.getInfo().getName());
      }
    });
    var funcs = new Array<ASTFuncDefNode>();
    for (var def : ctx.funcDef()) {
      if (def.name.getText() == ctx.name.getText()) {
        throw new CompileError("Functions cannot have the same name as class " + ctx.name.getText(),
            new Position(def.start));
      }
      funcs.add((ASTFuncDefNode) visit(def));
    }
    funcs.sort(new Comparator<ASTFuncDefNode>() {
      @Override
      public int compare(ASTFuncDefNode o1, ASTFuncDefNode o2) {
        return o1.getInfo().getName().compareTo(o2.getInfo().getName());
      }
    });
    var classDef = ASTClassDefNode.builder()
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
    var params = new Array<ASTVarDefNode>();
    if (paramList != null) {
      for (var param : paramList.funcParam()) {
        var constructor = param.varConstructor();
        params.add(ASTVarDefNode.builder()
            .position(new Position(param.start))
            .info(new VarInfo(constructor.name.getText(), ((ASTTypeNode) visit(param.typeName())).getInfo()))
            .init(constructor.expr() != null ? (ASTExprNode) visit(constructor.expr()) : null)
            .build());
      }
    }
    var funcDef = ASTFuncDefNode.builder()
        .position(new Position(ctx.start))
        .info(new FuncInfo(ctx.name.getText(), ((ASTTypeNode) visit(ctx.typeName())).getInfo(), params))
        .params(params)
        .blockedBody((ASTBlockStmtNode) visit(ctx.blockStmt()))
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
    return ASTTypeNode.builder()
        .position(new Position(ctx.start))
        .info(new TypeInfo(ctx.type().getText(), ctx.arrayUnit().size()))
        .build();
  }

  @Override
  public ASTNode visitNewExpr(Comet.NewExprContext ctx) {
    boolean initFinished = false;
    var lengths = new Array<ASTExprNode>();
    for (var unit : ctx.arrayUnit()) {
      if (unit.expr() == null) {
        initFinished = true;
      } else {
        if (initFinished) {
          throw new CompileError("The shape of multidimensional array must be specified from left to right", new Position(ctx.start));
        }
        lengths.add((ASTExprNode) visit(unit.expr()));
      }
    }
    var newExpr = ASTNewExprNode.builder()
        .position(new Position(ctx.start))
        .type(new TypeInfo(ctx.type().getText(), ctx.arrayUnit().size()))
        .lengths(lengths)
        .build();
    for (var length : lengths) {
      length.setParent(newExpr);
    }
    return newExpr;
  }

  @Override
  public ASTNode visitParenExpr(Comet.ParenExprContext ctx) {
    return visit(ctx.expr());
  }

  @Override
  public ASTNode visitMemberExpr(Comet.MemberExprContext ctx) {
    var memberExpr = ASTMemberExprNode.builder()
        .position(new Position(ctx.start))
        .object((ASTExprNode) visit(ctx.expr()))
        .member(ctx.member.getText())
        .build();
    memberExpr.getObject().setParent(memberExpr);
    return memberExpr;
  }

  @Override
  public ASTNode visitCallExpr(Comet.CallExprContext ctx) {
    var args = new Array<ASTExprNode>();
    if (ctx.funcArgList() != null) {
      for (var expr : ctx.funcArgList().expr()) {
        args.add((ASTExprNode) visit(expr));
      }
    }
    var callExpr = ASTCallExprNode.builder()
        .position(new Position(ctx.start))
        .func((ASTExprNode) visit(ctx.expr()))
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
    var arrayExpr = ASTArrayExprNode.builder()
        .position(new Position(ctx.start))
        .array((ASTExprNode) visit(ctx.expr()))
        .subscript((ASTExprNode) visit(ctx.arrayUnit().expr()))
        .build();
    arrayExpr.getArray().setParent(arrayExpr);
    arrayExpr.getSubscript().setParent(arrayExpr);
    return arrayExpr;
  }

  @Override
  public ASTNode visitPostUnaryExpr(Comet.PostUnaryExprContext ctx) {
    var postUnaryExpr = ASTPostUnaryExprNode.builder()
        .position(new Position(ctx.start))
        .expr((ASTExprNode) visit(ctx.expr()))
        .op(ctx.op.getText())
        .build();
    postUnaryExpr.getExpr().setParent(postUnaryExpr);
    return postUnaryExpr;
  }

  @Override
  public ASTNode visitPreUnaryExpr(Comet.PreUnaryExprContext ctx) {
    var preUnaryExpr = ASTPreUnaryExprNode.builder()
        .position(new Position(ctx.start))
        .expr((ASTExprNode) visit(ctx.expr()))
        .op(ctx.op.getText())
        .build();
    preUnaryExpr.getExpr().setParent(preUnaryExpr);
    return preUnaryExpr;
  }

  @Override
  public ASTNode visitBinaryExpr(Comet.BinaryExprContext ctx) {
    var binaryExpr = ASTBinaryExprNode.builder()
        .position(new Position(ctx.start))
        .lhs((ASTExprNode) visit(ctx.expr(0)))
        .rhs((ASTExprNode) visit(ctx.expr(1)))
        .op(ctx.op.getText())
        .build();
    binaryExpr.getLhs().setParent(binaryExpr);
    binaryExpr.getRhs().setParent(binaryExpr);
    return binaryExpr;
  }

  @Override
  public ASTNode visitConditionalExpr(Comet.ConditionalExprContext ctx) {
    var conditionalExpr = ASTConditionalExprNode.builder()
        .position(new Position(ctx.start))
        .condition((ASTExprNode) visit(ctx.expr(0)))
        .lhs((ASTExprNode) visit(ctx.expr(1)))
        .rhs((ASTExprNode) visit(ctx.expr(2)))
        .build();
    conditionalExpr.getCondition().setParent(conditionalExpr);
    conditionalExpr.getLhs().setParent(conditionalExpr);
    conditionalExpr.getRhs().setParent(conditionalExpr);
    return conditionalExpr;
  }

  @Override
  public ASTNode visitAssignExpr(Comet.AssignExprContext ctx) {
    var assignExpr = ASTAssignExprNode.builder()
        .position(new Position(ctx.start))
        .lhs((ASTExprNode) visit(ctx.expr(0)))
        .rhs((ASTExprNode) visit(ctx.expr(1)))
        .op(ctx.op.getText())
        .build();
    assignExpr.getLhs().setParent(assignExpr);
    assignExpr.getRhs().setParent(assignExpr);
    return assignExpr;
  }

  @Override
  public ASTNode visitAtomExpr(Comet.AtomExprContext ctx) {
    ASTAtomExprNode.Type atomType;
    var value = "";
    if (ctx.atom().IntegerLiteral() != null) {
      atomType = ASTAtomExprNode.Type.INT;
    } else if (ctx.atom().StringLiteral() != null) {
      atomType = ASTAtomExprNode.Type.STRING;
      String str = ctx.atom().getText();
      str = str.substring(1, str.length() - 1);
      for (int i = 0; i < str.length(); ++i) {
        char c = str.charAt(i);
        if (c == '\\') {
          ++i;
          switch (str.charAt(i)) {
            case 'n' -> value += '\n';
            case '\"' -> value += '\"';
            default -> value += '\\';
          }
        } else {
          value += c;
        }
      }
    } else if (ctx.atom().True() != null || ctx.atom().False() != null) {
      atomType = ASTAtomExprNode.Type.BOOL;
    } else if (ctx.atom().Null() != null) {
      atomType = ASTAtomExprNode.Type.NULL;
    } else if (ctx.atom().This() != null) {
      atomType = ASTAtomExprNode.Type.THIS;
    } else {
      atomType = ASTAtomExprNode.Type.CUSTOM;
    }
    return ASTAtomExprNode.builder()
        .position(new Position(ctx.start))
        .atomType(atomType)
        .value(atomType.equals(ASTAtomExprNode.Type.STRING) ? value : ctx.atom().getText())
        .build();
  }

  @Override
  public ASTNode visitStmt(Comet.StmtContext ctx) {
    return visitChildren(ctx);
  }

  @Override
  public ASTNode visitBlockStmt(Comet.BlockStmtContext ctx) {
    var stmts = new Array<ASTStmtNode>();
    for (var stmt : ctx.stmt()) {
      stmts.add((ASTStmtNode) visit(stmt));
    }
    var blockStmt = ASTBlockStmtNode.builder()
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
    var ifStmt = ASTIfStmtNode.builder()
        .position(new Position(ctx.start))
        .condition((ASTExprNode) visit(ctx.expr()))
        .thenStmt((ASTStmtNode) visit(ctx.stmt(0)))
        .elseStmt(ctx.stmt().size() == 2 ? (ASTStmtNode) visit(ctx.stmt(1)) : null)
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
    var forStmt = ASTForStmtNode.builder()
        .position(new Position(ctx.start))
        .init((ASTStmtNode) visit(ctx.init))
        .condition(ctx.condition == null ? null : (ASTExprNode) visit(ctx.condition))
        .update(ctx.update == null ? null : (ASTExprNode) visit(ctx.update))
        .body((ASTStmtNode) visit(ctx.body))
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
    var whileStmt = ASTWhileStmtNode.builder()
        .position(new Position(ctx.start))
        .condition((ASTExprNode) visit(ctx.expr()))
        .body((ASTStmtNode) visit(ctx.stmt()))
        .build();
    whileStmt.getCondition().setParent(whileStmt);
    whileStmt.getBody().setParent(whileStmt);
    return whileStmt;
  }

  @Override
  public ASTNode visitContinueStmt(Comet.ContinueStmtContext ctx) {
    return ASTContinueStmtNode.builder()
        .position(new Position(ctx.start))
        .build();
  }

  @Override
  public ASTNode visitBreakStmt(Comet.BreakStmtContext ctx) {
    return ASTBreakStmtNode.builder()
        .position(new Position(ctx.start))
        .build();
  }

  @Override
  public ASTNode visitReturnStmt(Comet.ReturnStmtContext ctx) {
    var returnStmt = ASTReturnStmtNode.builder()
        .position(new Position(ctx.start))
        .expr(ctx.expr() == null ? null : (ASTExprNode) visit(ctx.expr()))
        .build();
    if (returnStmt.getExpr() != null) {
      returnStmt.getExpr().setParent(returnStmt);
    }
    return returnStmt;
  }

  @Override
  public ASTNode visitExprStmt(Comet.ExprStmtContext ctx) {
    var exprs = new Array<ASTExprNode>();
    for (var expr : ctx.expr()) {
      exprs.add((ASTExprNode) visit(expr));
    }
    var exprStmt = ASTExprStmtNode.builder()
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
    return ASTEmptyStmtNode.builder()
        .position(new Position(ctx.start))
        .build();
  }
}
