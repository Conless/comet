package dev.conless.comet.frontend.ir;

import dev.conless.comet.frontend.ast.*;
import dev.conless.comet.frontend.ast.node.*;
import dev.conless.comet.frontend.ast.node.def.*;
import dev.conless.comet.frontend.ast.node.expr.*;
import dev.conless.comet.frontend.ast.node.expr.AtomExprNode.Type;
import dev.conless.comet.frontend.ast.node.global.ProgramNode;
import dev.conless.comet.frontend.ast.node.stmt.*;
import dev.conless.comet.frontend.ast.node.type.*;
import dev.conless.comet.frontend.utils.metadata.*;
import dev.conless.comet.frontend.utils.scope.*;
import dev.conless.comet.frontend.ir.entity.*;
import dev.conless.comet.frontend.ir.node.*;
import dev.conless.comet.frontend.ir.node.global.*;
import dev.conless.comet.frontend.ir.node.inst.*;
import dev.conless.comet.frontend.ir.node.utils.IRCommentNode;
import dev.conless.comet.frontend.ir.node.utils.IRExprNode;
import dev.conless.comet.frontend.ir.type.*;
import dev.conless.comet.frontend.ir.type.IRType.Case;
import dev.conless.comet.utils.container.Array;
import dev.conless.comet.utils.container.Map;
import dev.conless.comet.utils.container.Pair;
import dev.conless.comet.utils.error.*;

public class IRBuilder extends IRManager implements ASTVisitor<IRNode> {
  @Override
  public IRNode visit(ASTNode node) throws BaseError {
    throw new RuntimeError("IRBuilder.visit(ASTNode) should not be called");
  }

  @Override
  public IRNode visit(ProgramNode node) throws BaseError {
    enterASTNode(node);
    var program = new IRProgramNode();
    programNode = program;
    for (var def : node.getDefs()) {
      if (def instanceof ClassDefNode) {
        var defs = (IRExprNode) def.accept(this);
        program.addDef((IRGlobalDefNode) defs.getNodes().get(0));
      }
    }
    program.addDef(new IRGlobalDefNode(new IRVariable(GlobalScope.irArrayType, "%builtIn.Array")));
    var initFunc = new IRFuncNode("__global_var_init", new Array<>(), GlobalScope.irVoidType);
    program.addFunc(initFunc);
    initNode = initFunc;
    for (var def : node.getDefs()) {
      if (def instanceof VarDefNode) {
        var exprs = (IRExprNode) def.accept(this);
        program.addDef((IRGlobalDefNode) exprs.getNodes().get(0));
      }
    }
    for (var def : node.getDefs()) {
      if (def instanceof FuncDefNode) {
        program.addFunc((IRFuncNode) def.accept(this));
      }
    }
    exitASTNode(node);
    return program;
  }

  @Override
  public IRNode visit(FuncDefNode node) throws BaseError {
    resetCounter();
    enterASTNode(node);
    var paramNodes = new Array<IRVariable>();
    for (var param : node.getParams()) {
      paramNodes
          .add(new IRVariable(new IRType(param.getType(), Case.PARAM), getVarName(param.getName()) + ".param"));
    }
    var funcNode = new IRFuncNode(node.getName(), paramNodes, new IRType(node.getReturnType(), Case.PARAM));
    for (var stmt : node.getBlockedBody().getStmts()) {
      funcNode.getNodes().appendNodes((IRExprNode) stmt.accept(this));
    }
    exitASTNode(node);
    return funcNode;
  }

  @Override
  public IRNode visit(ClassDefNode node) throws BaseError {
    enterASTNode(node);
    var nodes = new IRExprNode();
    var vars = new Array<IRType>();
    for (var def : node.getVarDefs()) {
      vars.add(new IRType(def.getType(), Case.CTOR));
    }
    var type = new IRStructType(node.getName(), vars);
    var classNode = new IRGlobalDefNode(new IRVariable(type, "%class." + node.getName()));
    nodes.addNode(classNode);
    for (var def : node.getFuncDefs()) {
      def.getParams().add(0, VarDefNode.builder().info(new VarInfo("this", new TypeInfo(node.getName(), 0))).build());
      var irFunc = (IRFuncNode) def.accept(this);
      irFunc.setName(node.getName() + "::" + irFunc.getName());
      programNode.addFunc(irFunc);
    }
    exitASTNode(node);
    return nodes;
  }

  @Override
  public IRNode visit(VarDefNode node) throws BaseError {
    enterASTNode(node);
    var instList = new IRExprNode();
    var var = new IRVariable(new IRType(node.getType(), Case.CTOR), getVarName(node.getName()));
    if (currentScope instanceof GlobalScope) {
      instList.addNode(new IRGlobalDefNode(var));
    } else {
      instList.addNode(new IRAllocaNode(var, new IRType(node.getType(), Case.CTOR)));
    }
    if (node.getInit() != null) {
      var init = (IRExprNode) node.getInit().accept(this);
      instList.appendNodes(init);
      if (!(init.getDest() instanceof IRVariable)) {
        throw new RuntimeError("IRBuilder.visit(VarDefNode) init.getDest() should be IRVariable");
      }
    }
    exitASTNode(node);
    return instList;
  }

  @Override
  public IRNode visit(TypeNameNode node) throws BaseError {
    throw new RuntimeError("IRBuilder.visit(TypeNameNode) should not be called");
  }

  @Override
  public IRNode visit(ExprNode node) throws BaseError {
    throw new RuntimeError("IRBuilder.visit(ExprNode) should not be called");
  }

  @Override
  public IRNode visit(NewExprNode node) throws BaseError {
    return allocaHelper(node.getType());
  }

  @Override
  public IRNode visit(MemberExprNode node) throws BaseError {
    var infoType = node.getInfo().getType();
    var instList = new IRExprNode();
    var objectInst = (IRExprNode) node.getObject().accept(this);
    instList.appendNodes(objectInst);
    var object = (IRVariable) objectInst.getDestAddr(); // Object should be a pointer pointed to a class
    var objectType = (TypeInfo) node.getObject().getInfo().getType();
    if (!objectType.depth.equals(0)) {
      instList.setDest(new IRFunc("builtIn.Array" + "::" + infoType.getName(), object, GlobalScope.irIntType));
    } else {
      var classInfo = (ClassInfo) globalScope.get(objectType.getName(), "class");
      if (infoType instanceof FuncInfo) {
        instList.setDest(new IRFunc(classInfo.getName() + "::" + infoType.getName(), object, new IRType(((FuncInfo) infoType).getType(), Case.PARAM)));
      } else {
        var offset = classInfo.getOffset(node.getMember());
        var destAddr = new IRVariable(GlobalScope.irPtrType, "%__element_" + String.valueOf(counter.elementCount++));
        instList.addNode(new IRGetElementPtrNode(destAddr, object, "%class." + objectType.getName(), new Array<IREntity>(
            new IRLiteral(GlobalScope.irIntType, 0), new IRLiteral(GlobalScope.irIntType, offset))));
        var dest = new IRVariable(new IRType((TypeInfo) infoType, Case.USE),
            "%__load_" + String.valueOf(counter.loadCount++));
        instList.addNode(new IRLoadNode(dest, destAddr, dest.getType()));
        instList.setDest(dest);
        instList.setDestAddr(destAddr);
      }
    }
    return instList;
  }

  @Override
  public IRNode visit(CallExprNode node) throws BaseError {
    var instList = new IRExprNode();
    var destList = new Array<IREntity>();
    for (var arg : node.getArgs()) {
      var argInst = (IRExprNode) arg.accept(this);
      instList.appendNodes(argInst);
      destList.add(argInst.getDest());
    }
    var funcInst = (IRExprNode) node.getFunc().accept(this);
    instList.appendNodes(funcInst);
    var func = (IRFunc) funcInst.getDest();
    if (func.getCaller() != null) {
      destList.add(0, func.getCaller());
    }
    if (func.getReturnType().equals(GlobalScope.irVoidType)) {
      instList.addNode(new IRCallNode(func.getValue(), destList));
    } else {
      var dest = new IRVariable(func.getReturnType(), "%__call_" + String.valueOf(counter.callCount++));
      instList.addNode(new IRCallNode(dest, func.getReturnType(), func.getValue(), destList));
      instList.setDestAddr(dest);
    }
    return instList;
  }

  @Override
  public IRNode visit(ArrayExprNode node) throws BaseError {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'visit'");
  }

  @Override
  public IRNode visit(PostUnaryExprNode node) throws BaseError {
    var instList = new IRExprNode();
    var exprInst = (IRExprNode) node.getExpr().accept(this);
    instList.appendNodes(exprInst);
    var exprDest = (IRVariable) exprInst.getDest(); // exprDest is the result of last expr
    var exprDestAddr = (IRVariable) exprInst.getDestAddr(); // exprDestAddr is the address of exprDest
    var dest = new IRVariable(exprDest.getType(), "%__arith_" + String.valueOf(counter.arithCount++)); // dest is the result of current expr
    if (node.getOp().equals("++")) {
      instList.addNode(new IRArithNode(dest, exprDest.getType(), exprDest, new IRLiteral(GlobalScope.irIntType, 1), "add"));
    } else if (node.getOp().equals("--")) {
      instList.addNode(new IRArithNode(dest, exprDest.getType(), exprDest, new IRLiteral(GlobalScope.irIntType, 1), "sub"));
    } else {
      throw new RuntimeError("IRBuilder.visit(PostUnaryExprNode) unknown op");
    }
    
    instList.addNode(new IRStoreNode(exprDestAddr, dest));
    instList.setDest(exprDest);
    return instList;
  }

  @Override
  public IRNode visit(PreUnaryExprNode node) throws BaseError {
    var instList = new IRExprNode();
    var exprInst = (IRExprNode) node.getExpr().accept(this);
    instList.appendNodes(exprInst);
    var exprDest = (IRVariable) exprInst.getDest(); // exprDest is the result of last expr
    var exprDestAddr = (IRVariable) exprInst.getDestAddr(); // exprDestAddr is the address of exprDest
    var dest = new IRVariable(exprDest.getType(), "%__arith_" + String.valueOf(counter.arithCount++)); // dest is the result of current expr
    if (node.getOp().equals("++")) {
      instList.addNode(new IRArithNode(dest, exprDest.getType(), exprDest, new IRLiteral(GlobalScope.irIntType, 1), "add"));
    } else if (node.getOp().equals("--")) {
      instList.addNode(new IRArithNode(dest, exprDest.getType(), exprDest, new IRLiteral(GlobalScope.irIntType, 1), "sub"));
    } else if (node.getOp().equals("~")) {
      instList.addNode(
          new IRArithNode(dest, exprDest.getType(), exprDest, new IRLiteral(GlobalScope.irIntType, -1), "xor"));
    } else if (node.getOp().equals("!")) {
      instList.addNode(
          new IRArithNode(dest, exprDest.getType(), exprDest, new IRLiteral(GlobalScope.irBoolType, 1), "xor"));
    } else if (node.getOp().equals("+")) {
      instList.addNode(new IRArithNode(dest, exprDest.getType(), new IRLiteral(GlobalScope.irIntType, 0), exprDest,
          "add"));
    } else if (node.getOp().equals("-")) {
      instList.addNode(new IRArithNode(dest, exprDest.getType(), new IRLiteral(GlobalScope.irIntType, 0), exprDest,
          "sub"));
    } else {
      throw new RuntimeError("IRBuilder.visit(PostUnaryExprNode) unknown op");
    }
    instList.addNode(new IRStoreNode(exprDestAddr, dest));
    instList.setDest(dest);
    instList.setDestAddr(exprDestAddr);
    return instList;
  }

  @Override
  public IRNode visit(BinaryExprNode node) throws BaseError {
    var instList = new IRExprNode();
    var lhsInst = (IRExprNode) node.getLhs().accept(this);
    var rhsInst = (IRExprNode) node.getRhs().accept(this);
    instList.appendNodes(lhsInst);
    instList.appendNodes(rhsInst);
    var lhsDest = (IRVariable) lhsInst.getDest();
    var rhsDest = (IRVariable) rhsInst.getDest();
    var resultType = new IRType((TypeInfo) node.getInfo().getType(), Case.USE);
    var dest = new IRVariable(resultType , "%__arith_" + String.valueOf(counter.arithCount++));
    if (node.getOp().equals("+")) {
      instList.addNode(new IRArithNode(dest, resultType, lhsDest, rhsDest, "add"));
    } else if (node.getOp().equals("-")) {
      instList.addNode(new IRArithNode(dest, resultType, lhsDest, rhsDest, "sub"));
    } else if (node.getOp().equals("*")) {
      instList.addNode(new IRArithNode(dest, resultType, lhsDest, rhsDest, "mul"));
    } else if (node.getOp().equals("/")) {
      instList.addNode(new IRArithNode(dest, resultType, lhsDest, rhsDest, "sdiv"));
    } else if (node.getOp().equals("%")) {
      instList.addNode(new IRArithNode(dest, resultType, lhsDest, rhsDest, "srem"));
    } else if (node.getOp().equals("<<")) {
      instList.addNode(new IRArithNode(dest, resultType, lhsDest, rhsDest, "shl"));
    } else if (node.getOp().equals(">>")) {
      instList.addNode(new IRArithNode(dest, resultType, lhsDest, rhsDest, "ashr"));
    } else if (node.getOp().equals("&")) {
      instList.addNode(new IRArithNode(dest, resultType, lhsDest, rhsDest, "and"));
    } else if (node.getOp().equals("|")) {
      instList.addNode(new IRArithNode(dest, resultType, lhsDest, rhsDest, "or"));
    } else if (node.getOp().equals("^")) {
      instList.addNode(new IRArithNode(dest, resultType, lhsDest, rhsDest, "xor"));
    } else if (node.getOp().equals("&&")) {
      instList.addNode(new IRArithNode(dest, resultType, lhsDest, rhsDest, "and"));
    } else if (node.getOp().equals("||")) {
      instList.addNode(new IRArithNode(dest, resultType, lhsDest, rhsDest, "or"));
    } else if (node.getOp().equals("<")) {
      instList.addNode(new IRArithNode(dest, resultType, lhsDest, rhsDest, "slt"));
    } else if (node.getOp().equals(">")) {
      instList.addNode(new IRArithNode(dest, resultType, lhsDest, rhsDest, "sgt"));
    } else if (node.getOp().equals("<=")) {
      instList.addNode(new IRArithNode(dest, resultType, lhsDest, rhsDest, "sle"));
    } else if (node.getOp().equals(">=")) {
      instList.addNode(new IRArithNode(dest, resultType, lhsDest, rhsDest, "sge"));
    } else if (node.getOp().equals("==")) {
      instList.addNode(new IRArithNode(dest, resultType, lhsDest, rhsDest, "eq"));
    } else if (node.getOp().equals("!=")) {
      instList.addNode(new IRArithNode(dest, resultType, lhsDest, rhsDest, "ne"));
    } else {
      throw new RuntimeError("IRBuilder.visit(BinaryExprNode) unknown op");
    }
    instList.setDest(dest);
    return instList;
  }

  @Override
  public IRNode visit(ConditionalExprNode node) throws BaseError {
    var instList = new IRExprNode();
    var condInst = (IRExprNode) node.getCondition().accept(this);
    var trueInst = (IRExprNode) node.getLhs().accept(this);
    var falseInst = (IRExprNode) node.getRhs().accept(this);
    instList.appendNodes(condInst);
    instList.appendNodes(trueInst);
    instList.appendNodes(falseInst);
    var condDest = (IRVariable) condInst.getDest();
    var trueDest = (IRVariable) trueInst.getDest();
    var falseDest = (IRVariable) falseInst.getDest();
    var resultType = new IRType((TypeInfo) node.getInfo().getType(), Case.USE);
    var dest = new IRVariable(resultType, "%__arith_" + String.valueOf(counter.arithCount++));
    instList.addNode(new IRSelectNode(dest, condDest, trueDest, falseDest));
    instList.setDest(dest);
    return instList;
  }

  @Override
  public IRNode visit(AssignExprNode node) throws BaseError {
    var instList = new IRExprNode();
    var rhsInst = (IRExprNode) node.getRhs().accept(this);
    var lhsInst = (IRExprNode) node.getLhs().accept(this);
    instList.appendNodes(rhsInst);
    instList.appendNodes(lhsInst);
    if (((TypeInfo) node.getRhs().getInfo().getType()).equals(GlobalScope.stringClass)) {
      
    }
    var lhsDestAddr = (IRVariable) lhsInst.getDestAddr();
    var rhsDest = (IREntity) rhsInst.getDest();
    instList.addNode(new IRStoreNode(lhsDestAddr, rhsDest));
    instList.setDest(rhsDest);
    instList.setDestAddr(lhsDestAddr);
    return instList;
  }

  @Override
  public IRNode visit(AtomExprNode node) throws BaseError {
    var instList = new IRExprNode();
    if (node.getAtomType() == AtomExprNode.Type.CUSTOM) {
      var info = currentScope.getRecur(node.getValue());
      if (info instanceof VarInfo) {
        var varType = ((VarInfo) info).getType();
        var dest = new IRVariable(new IRType(varType, Case.USE), "%__load_" + String.valueOf(counter.loadCount++));
        var src = new IRVariable(GlobalScope.irPtrType, getVarName(node.getValue()));
        instList.addNode(new IRLoadNode(dest, src, new IRType(varType, Case.USE)));
        instList.setDest(dest);
        instList.setDestAddr(src);
      } else {
        instList.setDest(new IRFunc(node.getValue(), null, new IRType(((FuncInfo) globalScope.get(node.getValue(), "func")).getType(), Case.PARAM)));
      }
    } else if (node.getAtomType() == AtomExprNode.Type.INT) {
      instList.setDest(new IRLiteral(GlobalScope.irIntType, Integer.valueOf(node.getValue())));
    } else if (node.getAtomType() == AtomExprNode.Type.STRING) {
      var dest = new IRVariable(GlobalScope.irPtrType, "@__string_" + String.valueOf(IRCounter.strCount++));
      programNode.addDef(new IRStrDefNode(dest, node.getValue()));
      instList.setDest(dest);
    } else if (node.getAtomType() == AtomExprNode.Type.NULL) {
      instList.setDest(new IRLiteral(GlobalScope.irPtrType, 0));
    } else if (node.getAtomType() == AtomExprNode.Type.THIS) {
      instList.setDestAddr(new IRVariable(GlobalScope.irPtrType, "%this"));
    } else {
      throw new RuntimeError("IRBuilder.visit(AtomExprNode) unknown atom type");
    }
    return instList;
  }

  @Override
  public IRNode visit(StmtNode node) throws BaseError {
    throw new RuntimeError("IRBuilder.visit(StmtNode) should not be called");
  }

  @Override
  public IRNode visit(BlockStmtNode node) throws BaseError {
    var instList = new IRExprNode();
    for (var stmt : node.getStmts()) {
      instList.appendNodes((IRExprNode) stmt.accept(this));
    }
    return instList;
  }

  @Override
  public IRNode visit(IfStmtNode node) throws BaseError {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'visit'");
  }

  @Override
  public IRNode visit(ForStmtNode node) throws BaseError {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'visit'");
  }

  @Override
  public IRNode visit(WhileStmtNode node) throws BaseError {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'visit'");
  }

  @Override
  public IRNode visit(ContinueStmtNode node) throws BaseError {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'visit'");
  }

  @Override
  public IRNode visit(BreakStmtNode node) throws BaseError {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'visit'");
  }

  @Override
  public IRNode visit(ReturnStmtNode node) throws BaseError {
    var instList = new IRExprNode();
    instList.addNode(new IRCommentNode(node.toString()));
    if (node.getExpr() != null) {
      var exprInst = (IRExprNode) node.getExpr().accept(this);
      instList.appendNodes(exprInst);
      instList.addNode(new IRReturnNode(exprInst.getDest()));
    } else {
      instList.addNode(new IRReturnNode(null));
    }
    return instList;
  }

  @Override
  public IRNode visit(ExprStmtNode node) throws BaseError {
    var instList = new IRExprNode();
    instList.addNode(new IRCommentNode(node.toString()));
    for (var expr : node.getExprs()) {
      instList.appendNodes((IRExprNode) expr.accept(this));
    }
    return instList;
  }

  @Override
  public IRNode visit(VarDefStmtNode node) throws BaseError {
    var instList = new IRExprNode();
    instList.addNode(new IRCommentNode(node.toString()));
    for (var def : node.getDefs()) {
      instList.appendNodes((IRExprNode) def.accept(this));
    }
    return instList;
  }

  @Override
  public IRNode visit(EmptyStmtNode node) throws BaseError {
    var instList = new IRExprNode();
    instList.addNode(new IRCommentNode(node.toString()));
    return instList;
  }
}
