package dev.conless.comet.frontend.ir;

import dev.conless.comet.frontend.ast.*;
import dev.conless.comet.frontend.ast.node.*;
import dev.conless.comet.frontend.ast.node.def.*;
import dev.conless.comet.frontend.ast.node.expr.*;
import dev.conless.comet.frontend.ast.node.expr.ASTAtomExprNode.Type;
import dev.conless.comet.frontend.ast.node.stmt.*;
import dev.conless.comet.frontend.utils.metadata.*;
import dev.conless.comet.frontend.utils.scope.*;
import dev.conless.comet.frontend.ir.entity.*;
import dev.conless.comet.frontend.ir.node.*;
import dev.conless.comet.frontend.ir.node.def.*;
import dev.conless.comet.frontend.ir.node.inst.*;
import dev.conless.comet.frontend.ir.node.stmt.*;
import dev.conless.comet.frontend.ir.node.utils.IRCommentNode;
import dev.conless.comet.frontend.ir.node.utils.IRLabelNode;
import dev.conless.comet.frontend.ir.type.*;
import dev.conless.comet.frontend.ir.utils.IRCounter;
import dev.conless.comet.frontend.ir.utils.IRManager;
import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.container.Pair;
import dev.conless.comet.utils.error.*;

public class IRBuilder extends IRManager implements ASTVisitor<IRNode> {
  @Override
  public IRNode visit(ASTNode node) throws BaseError {
    throw new RuntimeError("IRBuilder.visit(ASTNode) should not be called");
  }

  @Override
  public IRNode visit(ASTRoot node) throws BaseError {
    enterASTNode(node);
    var program = new IRRoot();
    for (var def : node.getDefs()) {
      if (def instanceof ASTClassDefNode) {
        var classNode = (ASTClassDefNode) def;
        var vars = new Array<IRType>();
        for (var v : classNode.getVarDefs()) {
          vars.add(new IRType(v.getType()));
        }
        var typeName = "%class." + classNode.getName();
        initSize(typeName, vars);
        var type = new IRStructType(typeName, vars);
        program.addDef(new IRGlobalDefNode(new IRVariable(type, typeName)));
      }
    }
    for (var def : node.getDefs()) {
      if (def instanceof ASTClassDefNode) {
        var classDef = (IRClassDefNode) def.accept(this);
        for (var func : classDef.getFuncs()){
          program.addFunc(func);
        }
      }
    }
    for (var def : node.getDefs()) {
      if (def instanceof ASTVarDefNode) {
        program.addDef((IRGlobalDefNode) def.accept(this));
      }
    }
    for (var def : node.getDefs()) {
      if (def instanceof ASTFuncDefNode) {
        var func = (IRFuncDefNode) def.accept(this);
        if (def.getName().equals("main")) {
          func.getBlocks().get(0).addFront(new IRCallNode("global.var.init", new Array<>()));
        }
        program.addFunc(func);
      }
    }
    var initBlock = initNode.getBlocks().get(0);
    initBlock.setExitInst(new IRReturnNode());
    program.addFunc(initNode);
    for (var def : strDefs) {
      program.addDef(def);
    }
    exitASTNode(node);
    return program;
  }

  @Override
  public IRNode visit(ASTFuncDefNode node) throws BaseError {
    resetCounter();
    enterASTNode(node);
    var funcType = new IRType(node.getReturnType());
    var paramNodes = new Array<IRVariable>();
    for (var param : node.getParams()) {
      if (!param.getName().equals("this")) {
        currentScope.register(param.getName());
      }
      paramNodes
          .add(new IRVariable(new IRType(param.getType()), getVarName(param.getName(), currentScope) + ".param"));
    }
    var instList = new IRStmtNode();
    for (var stmt : node.getBlockedBody().getStmts()) {
      instList.appendInsts((IRStmtNode) stmt.accept(this));
    }
    var funcNode = new IRFuncDefNode(node.getName(), paramNodes, funcType, stmt2Block(instList, funcType));
    exitASTNode(node);
    return funcNode;
  }

  @Override
  public IRNode visit(ASTClassDefNode node) throws BaseError {
    enterASTNode(node);
    var vars = new Array<IRType>();
    for (var v : node.getVarDefs()) {
      vars.add(new IRType(v.getType()));
    }
    var funcs = new Array<IRFuncDefNode>();
    var ctorDef = node.getConstructor();
    ctorDef.getParams().add(0,
        ASTVarDefNode.builder().info(new VarInfo("this", new TypeInfo(node.getName(), 0))).build());
    var irCtor = (IRFuncDefNode) ctorDef.accept(this);
    irCtor.setName("__class." + node.getName());
    funcs.add(irCtor);
    for (var def : node.getFuncDefs()) {
      def.getParams().add(0,
          ASTVarDefNode.builder().info(new VarInfo("this", new TypeInfo(node.getName(), 0))).build());
      var irFunc = (IRFuncDefNode) def.accept(this);
      irFunc.setName("__" + node.getName() + "_" + irFunc.getName());
      funcs.add(irFunc);
    }
    exitASTNode(node);
    return new IRClassDefNode(vars, funcs);
  }

  @Override
  public IRNode visit(ASTVarDefNode node) throws BaseError {
    enterASTNode(node);
    var instList = new IRStmtNode();
    var var = new IRVariable(new IRType(node.getType()), getVarName(node.getName(), currentScope));
    currentScope.register(node.getName());
    if (node.getInit() != null) {
      var initExpr = ASTAssignExprNode.builder()
          .position(node.getPosition())
          .lhs(
              ASTAtomExprNode.builder().info(new ExprInfo("atomExpr", node.getType(), true)).atomType(Type.CUSTOM)
                  .value(node.getName())
                  .build())
          .rhs(node.getInit())
          .op("=")
          .build();
      var initInst = (IRStmtNode) initExpr.accept(this);
      if (currentScope instanceof GlobalScope) {
        initNode.getBlocks().get(0).appendInsts(initInst);
      } else {
        instList.appendInsts(initInst);
      }
    }
    if (currentScope instanceof GlobalScope) {
      exitASTNode(node);
      return new IRGlobalDefNode(var);
    }
    instList.addFront(new IRAllocaNode(var, new IRType(node.getType())));
    exitASTNode(node);
    return instList;
  }

  @Override
  public IRNode visit(ASTNewExprNode node) throws BaseError {
    enterASTNode(node);
    var instList = new IRStmtNode();
    var type = (TypeInfo) node.getInfo().getType();
    if (type.getDepth() == 0) {
      var allocaInst = allocaHelper(type, new Array<>());
      instList.appendInsts(allocaInst);
      instList.setDest(allocaInst.getDest());
    } else {
      var dest = new IRVariable(GlobalScope.irPtrType, "%.alloca." + String.valueOf(counter.allocaCount++));
      var sizes = new Array<IREntity>();
      for (var size : node.getLengths()) {
        var sizeInst = (IRStmtNode) size.accept(this);
        instList.appendInsts(sizeInst);
        sizes.add(sizeInst.getDest());
      }
      instList.addInst(new IRCommentNode(String.format("%s = malloc %s%s", dest.getValue(), type.getName(),
          "*".repeat(type.getDepth()))));
      var eleType = new TypeInfo(type.getName(), 0);
      var args = new Array<IREntity>(
          new IRLiteral(GlobalScope.irIntType, name2Size.get(new IRType(eleType).getTypeName())),
          new IRLiteral(GlobalScope.irIntType, type.getDepth()),
          new IRLiteral(GlobalScope.irIntType, sizes.size()));
      args.addAll(sizes);
      instList.addInst(new IRCallNode(dest, GlobalScope.irPtrType, "__array_alloca", args));
      instList.setDest(dest);
    }
    exitASTNode(node);
    return instList;
  }

  @Override
  public IRNode visit(ASTMemberExprNode node) throws BaseError {
    enterASTNode(node);
    var infoType = node.getInfo().getType();
    var instList = new IRStmtNode();
    var objectInst = (IRStmtNode) node.getObject().accept(this);
    instList.appendInsts(objectInst);
    var object = (IRVariable) objectInst.getDest(); // Object should be a pointer pointed to a class
    var objectType = (TypeInfo) node.getObject().getInfo().getType();
    if (objectType.getDepth() != 0) {
      instList.setDest(new IRFunc("__builtin_array_size", object, GlobalScope.irIntType));
    } else if (objectType.equals(GlobalScope.stringType)) {
      instList.setDest(new IRFunc("__string" + "_" + infoType.getName(), object,
          infoType.getName().equals("substring") ? GlobalScope.irPtrType : GlobalScope.irIntType));
    } else {
      var classInfo = (ClassInfo) globalScope.get(objectType.getName(), "class");
      if (infoType instanceof FuncInfo) {
        instList.setDest(new IRFunc("__" + classInfo.getName() + "_" + infoType.getName(), object,
            new IRType(((FuncInfo) infoType).getType())));
      } else {
        var offset = classInfo.getOffset(node.getMember());
        var destAddr = new IRVariable(GlobalScope.irPtrType, "%.element." + String.valueOf(counter.elementCount++));
        instList
            .addInst(new IRGetElementPtrNode(destAddr, object, "%class." + objectType.getName(), new Array<IREntity>(
                new IRLiteral(GlobalScope.irIntType, 0), new IRLiteral(GlobalScope.irIntType, offset))));
        var dest = new IRVariable(new IRType((TypeInfo) infoType),
            "%.load." + String.valueOf(counter.loadCount++));
        instList.addInst(new IRLoadNode(dest, destAddr));
        instList.setDest(dest);
        instList.setDestAddr(destAddr);
      }
    }
    exitASTNode(node);
    return instList;
  }

  @Override
  public IRNode visit(ASTCallExprNode node) throws BaseError {
    enterASTNode(node);
    var instList = new IRStmtNode();
    var destList = new Array<IREntity>();
    for (var arg : node.getArgs()) {
      var argInst = (IRStmtNode) arg.accept(this);
      instList.appendInsts(argInst);
      destList.add(argInst.getDest());
    }
    var funcInst = (IRStmtNode) node.getFunc().accept(this);
    instList.appendInsts(funcInst);
    var func = (IRFunc) funcInst.getDest();
    if (func.getCaller() != null) {
      destList.add(0, func.getCaller());
    }
    if (func.getReturnType().equals(GlobalScope.irVoidType)) {
      instList.addInst(new IRCallNode(func.getValue(), destList));
    } else {
      var dest = new IRVariable(func.getReturnType(), "%call." + String.valueOf(counter.callCount++));
      instList.addInst(new IRCallNode(dest, func.getReturnType(), func.getValue(), destList));
      instList.setDest(dest);
    }
    exitASTNode(node);
    return instList;
  }

  @Override
  public IRNode visit(ASTArrayExprNode node) throws BaseError {
    enterASTNode(node);
    var instList = new IRStmtNode();
    var arrayInst = (IRStmtNode) node.getArray().accept(this);
    instList.appendInsts(arrayInst);
    var array = (IRVariable) arrayInst.getDest();
    var astElementType = (TypeInfo) node.getInfo().getType();
    var elementType = new IRType(astElementType);
    var indexInst = (IRStmtNode) node.getSubscript().accept(this);
    instList.appendInsts(indexInst);
    var index = (IREntity) indexInst.getDest();
    var destAddr = new IRVariable(GlobalScope.irPtrType, "%.element." + String.valueOf(counter.elementCount++));
    instList.addInst(new IRGetElementPtrNode(destAddr, array, elementType.getTypeName(), new Array<>(index)));
    var dest = new IRVariable(elementType, "%.load." + String.valueOf(counter.loadCount++));
    instList.addInst(new IRLoadNode(dest, destAddr));
    instList.setDest(dest);
    instList.setDestAddr(destAddr);
    exitASTNode(node);
    return instList;
  }

  @Override
  public IRNode visit(ASTPostUnaryExprNode node) throws BaseError {
    enterASTNode(node);
    var instList = new IRStmtNode();
    var exprInst = (IRStmtNode) node.getExpr().accept(this);
    instList.appendInsts(exprInst);
    var exprDest = (IRVariable) exprInst.getDest(); // exprDest is the result of last expr
    var exprDestAddr = (IRVariable) exprInst.getDestAddr(); // exprDestAddr is the address of exprDest
    var dest = new IRVariable(exprDest.getType(), "%.arith." + String.valueOf(counter.arithCount++)); // dest is the
                                                                                                      // result of
                                                                                                      // current expr
    if (node.getOp().equals("++")) {
      instList
          .addInst(new IRArithNode(dest, exprDest, new IRLiteral(GlobalScope.irIntType, 1), "add"));
    } else if (node.getOp().equals("--")) {
      instList
          .addInst(new IRArithNode(dest, exprDest, new IRLiteral(GlobalScope.irIntType, 1), "sub"));
    } else {
      throw new RuntimeError("IRBuilder.visit(PostUnaryExprNode) unknown op");
    }
    instList.addInst(new IRStoreNode(exprDestAddr, dest));
    instList.setDest(exprDest);
    exitASTNode(node);
    return instList;
  }

  @Override
  public IRNode visit(ASTPreUnaryExprNode node) throws BaseError {
    enterASTNode(node);
    var instList = new IRStmtNode();
    var exprInst = (IRStmtNode) node.getExpr().accept(this);
    instList.appendInsts(exprInst);
    var exprDest = exprInst.getDest(); // exprDest is the result of last expr
    var exprDestAddr = (IRVariable) exprInst.getDestAddr(); // exprDestAddr is the address of exprDest
    var dest = new IRVariable(exprDest.getType(), "%.arith." + String.valueOf(counter.arithCount++)); // dest is the
                                                                                                      // result of
                                                                                                      // current expr
    if (node.getOp().equals("++")) {
      instList
          .addInst(new IRArithNode(dest, exprDest, new IRLiteral(GlobalScope.irIntType, 1), "add"));
      instList.addInst(new IRStoreNode(exprDestAddr, dest));
      instList.setDestAddr(exprDestAddr);
    } else if (node.getOp().equals("--")) {
      instList
          .addInst(new IRArithNode(dest, exprDest, new IRLiteral(GlobalScope.irIntType, 1), "sub"));
      instList.addInst(new IRStoreNode(exprDestAddr, dest));
      instList.setDestAddr(exprDestAddr);
    } else if (node.getOp().equals("~")) {
      instList.addInst(
          new IRArithNode(dest, exprDest, new IRLiteral(GlobalScope.irIntType, -1), "xor"));
    } else if (node.getOp().equals("!")) {
      instList.addInst(
          new IRArithNode(dest, exprDest, new IRLiteral(GlobalScope.irBoolType, 1), "xor"));
    } else if (node.getOp().equals("+")) {
      instList.addInst(new IRArithNode(dest, new IRLiteral(GlobalScope.irIntType, 0), exprDest, "add"));
    } else if (node.getOp().equals("-")) {
      instList.addInst(new IRArithNode(dest, new IRLiteral(GlobalScope.irIntType, 0), exprDest, "sub"));
    } else {
      throw new RuntimeError("IRBuilder.visit(PostUnaryExprNode) unknown op");
    }
    instList.setDest(dest);
    exitASTNode(node);
    return instList;
  }

  @Override
  public IRNode visit(ASTBinaryExprNode node) throws BaseError {
    enterASTNode(node);
    var instList = new IRStmtNode();
    var resultType = new IRType((TypeInfo) node.getInfo().getType());
    var dest = new IRVariable(resultType, "%.arith." + String.valueOf(counter.arithCount++));
    if (node.getOp().equals("&&") || node.getOp().equals("||")) { // circuiting
      var count = IRIfStmtNode.addCount();
      // var lhsLabel = new IRLabelNode("if." + count + ".cond");
      // var rhsLabel = new IRLabelNode("if." + count + ".body");
      // var endLabel = new IRLabelNode("if." + count + ".end");
      // instList.addInst(new IRJumpNode(lhsLabel.getName()));
      var lhsInst = (IRStmtNode) node.getLhs().accept(this);
      // lhsInst.addFront(lhsLabel);
      // var lhsLastBlock = getLastLabel(lhsInst);
      // instList.appendInsts(lhsInst);
      // if (node.getOp().equals("&&")) {
      //   instList.addInst(new IRBranchNode(lhsInst.getDest(), rhsLabel.getName(), endLabel.getName()));
      // } else {
      //   instList.addInst(new IRBranchNode(lhsInst.getDest(), endLabel.getName(), rhsLabel.getName()));
      // }
      var rhsInst = (IRStmtNode) node.getRhs().accept(this);
      // rhsInst.addFront(rhsLabel);
      // var rhsLastBlock = getLastLabel(rhsInst);
      // instList.appendInsts(rhsInst);
      // instList.addInst(new IRJumpNode(endLabel.getName()));
      var rhsDest = rhsInst.getDest();
      IRIfStmtNode stmt;
      if (node.getOp().equals("&&")) {
        stmt = new IRIfStmtNode(count, lhsInst, rhsInst, null);
      } else {
        stmt = new IRIfStmtNode(count, lhsInst, null, rhsInst);
      }
      instList.appendInsts(stmt);
      var trueLiteral = new IRLiteral(GlobalScope.irBoolType, 1);
      var falseLiteral = new IRLiteral(GlobalScope.irBoolType, 0);
      if (node.getOp().equals("&&")) {
        instList.addInst(new IRPhiNode(dest, GlobalScope.irBoolType, new Array<Pair<IREntity, String>>(new Pair<>(rhsDest, stmt.getBodyLabel()), new Pair<>(falseLiteral, stmt.getCondLabel()))));
      } else {
        instList.addInst(new IRPhiNode(dest, GlobalScope.irBoolType, new Array<Pair<IREntity, String>>(new Pair<>(trueLiteral, stmt.getCondLabel()), new Pair<>(rhsDest, stmt.getElseLabel()))));
      }
      instList.setDest(dest);
      exitASTNode(node);
      return instList;
    }
    var lhsInst = (IRStmtNode) node.getLhs().accept(this);
    var rhsInst = (IRStmtNode) node.getRhs().accept(this);
    var lhsDest = lhsInst.getDest();
    var rhsDest = rhsInst.getDest();
    var operandType = (TypeInfo) node.getLhs().getInfo().getType();
    instList.appendInsts(lhsInst);
    instList.appendInsts(rhsInst);
    instList.setDest(dest);
    if (operandType.equals(GlobalScope.stringType)) {
      if (node.getOp().equals("+")) {
        instList.addInst(new IRCallNode(dest, resultType, "__string_concat",
            new Array<>(lhsDest, rhsDest)));
      } else {
        var cmpResult = new IRVariable(GlobalScope.irIntType, "%.arith." + String.valueOf(counter.arithCount++));
        instList.addInst(new IRCallNode(cmpResult, GlobalScope.irIntType, "__string_compare",
            new Array<>(lhsDest, rhsDest)));
        switch (node.getOp()) {
          case "==" ->
            instList.addInst(new IRArithNode(dest, cmpResult, new IRLiteral(GlobalScope.irIntType, 0), "eq"));
          case "!=" ->
            instList.addInst(new IRArithNode(dest, cmpResult, new IRLiteral(GlobalScope.irIntType, 0), "ne"));
          case "<" ->
            instList.addInst(new IRArithNode(dest, cmpResult, new IRLiteral(GlobalScope.irIntType, 0), "slt"));
          case "<=" ->
            instList.addInst(new IRArithNode(dest, cmpResult, new IRLiteral(GlobalScope.irIntType, 0), "sle"));
          case ">" ->
            instList.addInst(new IRArithNode(dest, cmpResult, new IRLiteral(GlobalScope.irIntType, 0), "sgt"));
          case ">=" -> instList.addInst(new IRArithNode(dest, cmpResult, new IRLiteral(GlobalScope.irIntType, 0),
              "sge"));
          default ->
            throw new RuntimeError("IRBuilder.visit(BinaryExprNode) unknown op");
        }
      }
    } else {
      switch (node.getOp()) {
        case "+" -> instList.addInst(new IRArithNode(dest, lhsDest, rhsDest, "add"));
        case "-" -> instList.addInst(new IRArithNode(dest, lhsDest, rhsDest, "sub"));
        case "*" -> instList.addInst(new IRArithNode(dest, lhsDest, rhsDest, "mul"));
        case "/" -> instList.addInst(new IRArithNode(dest, lhsDest, rhsDest, "sdiv"));
        case "%" -> instList.addInst(new IRArithNode(dest, lhsDest, rhsDest, "srem"));
        case "<<" -> instList.addInst(new IRArithNode(dest, lhsDest, rhsDest, "shl"));
        case ">>" -> instList.addInst(new IRArithNode(dest, lhsDest, rhsDest, "ashr"));
        case "&" -> instList.addInst(new IRArithNode(dest, lhsDest, rhsDest, "and"));
        case "|" -> instList.addInst(new IRArithNode(dest, lhsDest, rhsDest, "or"));
        case "^" -> instList.addInst(new IRArithNode(dest, lhsDest, rhsDest, "xor"));
        case "==" -> instList.addInst(new IRArithNode(dest, lhsDest, rhsDest, "eq"));
        case "!=" -> instList.addInst(new IRArithNode(dest, lhsDest, rhsDest, "ne"));
        case "<" -> instList.addInst(new IRArithNode(dest, lhsDest, rhsDest, "slt"));
        case "<=" -> instList.addInst(new IRArithNode(dest, lhsDest, rhsDest, "sle"));
        case ">" -> instList.addInst(new IRArithNode(dest, lhsDest, rhsDest, "sgt"));
        case ">=" -> instList.addInst(new IRArithNode(dest, lhsDest, rhsDest, "sge"));
        default -> throw new RuntimeError("IRBuilder.visit(BinaryExprNode) unknown op");
      }
    }
    exitASTNode(node);
    return instList;
  }

  @Override
  public IRNode visit(ASTConditionalExprNode node) throws BaseError {
    enterASTNode(node);
    var num = IRIfStmtNode.addCount();
    var instList = new IRStmtNode();
    var condInst = (IRStmtNode) node.getCondition().accept(this);
    var trueInst = (IRStmtNode) node.getLhs().accept(this);
    var falseInst = (IRStmtNode) node.getRhs().accept(this);
    if (trueInst.getDest() == null) {
      instList.appendInsts(new IRIfStmtNode(num, condInst, trueInst, falseInst));
    } else {
      var stmt = new IRIfStmtNode(num, condInst, trueInst, falseInst);
      var dest = new IRVariable(trueInst.getDest().getType(), "%.arith." + String.valueOf(counter.arithCount++));
      instList.appendInsts(stmt);
      instList.addInst(new IRPhiNode(dest, trueInst.getDest().getType(), new Array<Pair<IREntity, String>>(
          new Pair<>(trueInst.getDest(), stmt.getBodyLabel()), new Pair<>(falseInst.getDest(), stmt.getElseLabel()))));
      instList.setDest(dest);
    }
    exitASTNode(node);
    return instList;
  }

  @Override
  public IRNode visit(ASTAssignExprNode node) throws BaseError {
    enterASTNode(node);
    var instList = new IRStmtNode();
    var rhsInst = (IRStmtNode) node.getRhs().accept(this);
    var lhsInst = (IRStmtNode) node.getLhs().accept(this);
    instList.appendInsts(rhsInst);
    instList.appendInsts(lhsInst);
    var rhsType = ((TypeInfo) node.getRhs().getInfo().getType());
    var lhsDestAddr = (IRVariable) lhsInst.getDestAddr();
    var rhsDest = (IREntity) rhsInst.getDest();
    if (rhsType.equals(GlobalScope.stringType)) {
      instList.addInst(new IRCallNode("__string_copy", new Array<>(lhsDestAddr, rhsDest)));
    } else {
      instList.addInst(new IRStoreNode(lhsDestAddr, rhsDest));
    }
    instList.setDest(rhsDest);
    exitASTNode(node);
    return instList;
  }

  @Override
  public IRNode visit(ASTAtomExprNode node) throws BaseError {
    enterASTNode(node);
    var instList = new IRStmtNode();
    if (node.getAtomType() == ASTAtomExprNode.Type.CUSTOM) {
      var info = currentScope.getRecur(node.getValue());
      if (info instanceof VarInfo) {
        var varInfo = currentScope.getRegWithScope(node.getValue());
        var irVarType = new IRType(((VarInfo) varInfo.a).getType());
        var src = new IRVariable(GlobalScope.irPtrType, getVarName(node.getValue(), varInfo.b));
        var dest = new IRVariable(irVarType, "%.load." + String.valueOf(counter.loadCount++));
        instList.addInst(new IRLoadNode(dest, src));
        instList.setDest(dest);
        instList.setDestAddr(src);
      } else if (info instanceof FuncInfo) {
        instList.setDest(new IRFunc(node.getValue(), null,
            new IRType(((FuncInfo) globalScope.get(node.getValue(), "func")).getType())));
      } else {
        throw new RuntimeError(node.toString() + " not found in scopes");
      }
    } else if (node.getAtomType() == ASTAtomExprNode.Type.INT) {
      instList.setDest(new IRLiteral(GlobalScope.irIntType, Integer.valueOf(node.getValue())));
    } else if (node.getAtomType() == ASTAtomExprNode.Type.BOOL) {
      instList.setDest(new IRLiteral(GlobalScope.irBoolType, node.getValue().equals("true") ? 1 : 0));
    } else if (node.getAtomType() == ASTAtomExprNode.Type.STRING) {
      var dest = new IRVariable(GlobalScope.irPtrType, "@.string." + String.valueOf(++IRCounter.strCount));
      var str = node.getValue();
      strDefs.add(new IRStrDefNode(dest, str));
      instList.setDest(dest);
    } else if (node.getAtomType() == ASTAtomExprNode.Type.NULL) {
      instList.setDest(new IRLiteral(GlobalScope.irPtrType, 0));
    } else if (node.getAtomType() == ASTAtomExprNode.Type.THIS) {
      var src = new IRVariable(GlobalScope.irPtrType, "%this");
      var dest = new IRVariable(GlobalScope.irPtrType, "%.load." + String.valueOf(counter.loadCount++));
      instList.addInst(new IRLoadNode(dest, src));
      instList.setDest(dest);
    } else {
      throw new RuntimeError("IRBuilder.visit(AtomExprNode) unknown atom type");
    }
    exitASTNode(node);
    return instList;
  }

  @Override
  public IRNode visit(ASTBlockStmtNode node) throws BaseError {
    enterASTNode(node);
    var instList = new IRStmtNode();
    for (var stmt : node.getStmts()) {
      instList.appendInsts((IRStmtNode) stmt.accept(this));
    }
    exitASTNode(node);
    return instList;
  }

  @Override
  public IRNode visit(ASTIfStmtNode node) throws BaseError {
    var instList = new IRStmtNode();
    var num = IRIfStmtNode.addCount();
    instList.addInst(new IRCommentNode("if " + node.getCondition().toString()));
    var condInst = (IRStmtNode) node.getCondition().accept(this);
    enterASTNode(node, "then");
    var trueInst = (IRStmtNode) node.getThenStmt().accept(this);
    exitASTNode(node, "then");
    enterASTNode(node, "else");
    var falseInst = node.getElseStmt() == null ? null : (IRStmtNode) node.getElseStmt().accept(this);
    exitASTNode(node, "else");
    instList.appendInsts(new IRIfStmtNode(num, condInst, trueInst, falseInst));
    return instList;
  }

  @Override
  public IRNode visit(ASTForStmtNode node) throws BaseError {
    enterASTNode(node);
    var instList = new IRStmtNode();
    node.getScope().setLoopCount(IRLoopStmtNode.addCount());
    instList.addInst(new IRCommentNode(
        "for ("
            + (node.getInit() == null ? ";" : node.getInit().toString()) + " "
            + (node.getCondition() == null ? "" : node.getCondition().toString()) + "; "
            + (node.getUpdate() == null ? "" : node.getUpdate().toString()) + ")"));
    var initStmt = node.getInit() == null ? null : (IRStmtNode) node.getInit().accept(this);
    var condStmt = node.getCondition() == null ? null : (IRStmtNode) node.getCondition().accept(this);
    var updateStmt = node.getUpdate() == null ? null : (IRStmtNode) node.getUpdate().accept(this);
    var bodyStmt = (IRStmtNode) node.getBody().accept(this);
    instList.appendInsts(new IRLoopStmtNode(node.getScope().getLoopCount(), initStmt, condStmt, updateStmt, bodyStmt));
    exitASTNode(node);
    return instList;
  }

  @Override
  public IRNode visit(ASTWhileStmtNode node) throws BaseError {
    enterASTNode(node);
    var instList = new IRStmtNode();
    node.getScope().setLoopCount(IRLoopStmtNode.addCount());
    instList.addInst(new IRCommentNode("while " + node.getCondition().toString()));
    currentScope.getLastLoop().setLoopCount(IRLoopStmtNode.count);
    var condInst = (IRStmtNode) node.getCondition().accept(this);
    var bodyInst = (IRStmtNode) node.getBody().accept(this);
    instList.appendInsts(new IRLoopStmtNode(node.getScope().getLoopCount(), null, condInst, null, bodyInst));
    exitASTNode(node);
    return instList;
  }

  @Override
  public IRNode visit(ASTContinueStmtNode node) throws BaseError {
    enterASTNode(node);
    var instList = new IRStmtNode();
    instList.addInst(new IRCommentNode(node.toString()));
    instList.addInst(new IRJumpNode("loop." + String.valueOf(currentScope.getLastLoop().getLoopCount()) + ".update"));
    exitASTNode(node);
    return instList;
  }

  @Override
  public IRNode visit(ASTBreakStmtNode node) throws BaseError {
    enterASTNode(node);
    var instList = new IRStmtNode();
    instList.addInst(new IRCommentNode(node.toString()));
    instList.addInst(new IRJumpNode("loop." + String.valueOf(currentScope.getLastLoop().getLoopCount()) + ".end"));
    exitASTNode(node);
    return instList;
  }

  @Override
  public IRNode visit(ASTReturnStmtNode node) throws BaseError {
    enterASTNode(node);
    var instList = new IRStmtNode();
    instList.addInst(new IRCommentNode(node.toString()));
    if (node.getExpr() != null) {
      var exprInst = (IRStmtNode) node.getExpr().accept(this);
      instList.appendInsts(exprInst);
      instList.addInst(new IRReturnNode(exprInst.getDest()));
    } else {
      instList.addInst(new IRReturnNode());
    }
    exitASTNode(node);
    return instList;
  }

  @Override
  public IRNode visit(ASTExprStmtNode node) throws BaseError {
    enterASTNode(node);
    var instList = new IRStmtNode();
    instList.addInst(new IRCommentNode(node.toString()));
    for (var expr : node.getExprs()) {
      instList.appendInsts((IRStmtNode) expr.accept(this));
    }
    exitASTNode(node);
    return instList;
  }

  @Override
  public IRNode visit(ASTVarDefStmtNode node) throws BaseError {
    exitASTNode(node);
    var instList = new IRStmtNode();
    instList.addInst(new IRCommentNode(node.toString()));
    for (var def : node.getDefs()) {
      instList.appendInsts((IRStmtNode) def.accept(this));
    }
    exitASTNode(node);
    return instList;
  }

  @Override
  public IRNode visit(ASTEmptyStmtNode node) throws BaseError {
    enterASTNode(node);
    var instList = new IRStmtNode();
    instList.addInst(new IRCommentNode(node.toString()));
    exitASTNode(node);
    return instList;
  }
}
