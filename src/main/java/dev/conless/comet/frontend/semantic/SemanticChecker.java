package dev.conless.comet.frontend.semantic;

import dev.conless.comet.frontend.ast.*;
import dev.conless.comet.frontend.ast.node.ASTNode;
import dev.conless.comet.frontend.ast.node.ASTRoot;
import dev.conless.comet.frontend.ast.node.def.*;
import dev.conless.comet.frontend.ast.node.expr.*;
import dev.conless.comet.frontend.ast.node.stmt.*;
import dev.conless.comet.frontend.ast.node.utils.ASTNodeWithExpr;
import dev.conless.comet.frontend.utils.metadata.*;
import dev.conless.comet.frontend.utils.scope.BaseScope;
import dev.conless.comet.frontend.utils.scope.ClassScope;
import dev.conless.comet.frontend.utils.scope.FuncScope;
import dev.conless.comet.frontend.utils.scope.GlobalScope;
import dev.conless.comet.utils.error.*;
import dev.conless.comet.utils.msg.CompileMsg;

public class SemanticChecker extends ScopeManager implements ASTVisitor<CompileMsg> {
  public CompileMsg visit(ASTNode node) throws BaseError {
    throw new RuntimeError("SemanticChecker.visit(ASTNode) should not be called", node.getPosition());
  }

  public CompileMsg visit(ASTRoot node) throws BaseError {
    var msg = new SymbolCollector().visit(node);
    if (!msg.isEmpty()) {
      throw new CompileError(msg.toString());
    }
    node.addScope(null);
    enterScope(node.getScope());
    for (var def : node.defs) {
      msg.append(def.accept(this));
    }
    if (!msg.isEmpty()) {
      throw new CompileError(msg.toString());
    }
    exitScope();
    return new CompileMsg();
  }

  public CompileMsg visit(ASTFuncDefNode node) throws BaseError {
    node.addScope(currentScope);
    enterScope(node.getScope());
    var msg = new CompileMsg();
    for (var stmt : node.getBody()) {
      msg.append(stmt.accept(this));
    }
    if (!msg.isEmpty()) {
      return msg;
    }
    if (!node.getReturnType().equals(GlobalScope.voidType) && !node.getInfo().getName().equals("main")) {
      if (!((FuncScope) currentScope).getIsExited()) {
        msg.append(new CompileMsg("Function " + node.getName() + " doesn't have a return statement", node));
      }
    }
    if (!msg.isEmpty()) {
      return msg;
    }
    exitScope();
    return new CompileMsg();
  }

  public CompileMsg visit(ASTClassDefNode node) throws BaseError {
    node.addScope(currentScope);
    enterScope(node.getScope());
    var msg = new CompileMsg();
    msg.append(node.getConstructor().accept(this));
    for (var funcDef : node.getFuncDefs()) {
      msg.append(funcDef.accept(this));
    }
    if (!msg.isEmpty()) {
      return msg;
    }
    exitScope();
    return msg;
  }

  public CompileMsg visit(ASTVarDefNode node) throws BaseError {
    var v = (VarInfo) node.getInfo();
    var msg = new CompileMsg();
    if (!checkTypeValid(v.getType())) {
      return new CompileMsg("Invalid type " + v.getType().getName() + " is used", node);
    }
    if (currentScope.get(node.getName()) != null) {
      return new CompileMsg("Redefinition of " + node.getName(), node);
    } else {
      if (node.getInit() != null) {
        msg.append(node.getInit().accept(this));
        if (!msg.isEmpty()) {
          return msg;
        }
        BaseInfo initType = node.getInit().getInfo().getType();
        if (!(initType instanceof TypeInfo) || !v.getType().equals(initType)) {
          return new CompileMsg("Cannot assign " + node.getInit().toString() + " to " + node.getName().toString(),
              node);
        }
      }
      currentScope.declare(new VarInfo(node.getName(), v.getType()));
    }
    return msg;
  }

  public CompileMsg visit(ASTNewExprNode node) throws BaseError {
    TypeInfo type = node.getType();
    var msg = new CompileMsg();
    if (!checkTypeValid(type) || (type.getIsBuiltIn() && type.getDepth() == 0)) {
      return new CompileMsg(
          "Cannot initialize type " + type.getName(), node);
    }
    for (var expr : node.getLengths()) {
      msg.append(expr.accept(this));
      if (!msg.isEmpty()) {
        return msg;
      }
      BaseInfo exprType = expr.getInfo().getType();
      if (!(exprType instanceof TypeInfo) || !exprType.equals(GlobalScope.intType)) {
        return new CompileMsg("Array size must be an integer", node);
      }
    }
    node.setInfo(new ExprInfo("newExpr", type, true));
    return msg;
  }

  public CompileMsg visit(ASTMemberExprNode node) throws BaseError {
    var msg = node.getObject().accept(this);
    var objectType = node.getObject().getInfo().getType();
    if (!(objectType instanceof TypeInfo)) {
      return new CompileMsg("Cannot access member of non-array type " + objectType.getName(), node);
    }
    if (((TypeInfo) objectType).getDepth() > 0) {
      if (node.getMember().equals("size")) {
        node.setInfo(new ExprInfo("memberExpr", GlobalScope.arraySizeFunc, false));
      } else {
        return new CompileMsg("Call to undefined member " + node.getMember() + " of array type " + objectType.getName(),
            node);
      }
    } else {
      var classInfo = (ClassInfo) globalScope.get(objectType.getName(), "class");
      if (classInfo == null) {
        return new CompileMsg("Call to undefined class " + objectType.getName(), node);
      }
      var memberInfo = classInfo.getMember(node.getMember());
      if (memberInfo == null) {
        return new CompileMsg("Call to undefined member " + node.getMember() + " of type " + objectType.getName(),
            node);
      }
      if (memberInfo instanceof VarInfo) {
        node.setInfo(new ExprInfo("memberExpr", ((VarInfo) memberInfo).getType(), true));
      } else {
        node.setInfo(new ExprInfo("callExpr", memberInfo, false));
      }
    }
    return msg;
  }

  public CompileMsg visit(ASTCallExprNode node) throws BaseError {
    var msg = new CompileMsg();
    msg.append(node.getFunc().accept(this));
    for (var arg : node.getArgs()) {
      msg.append(arg.accept(this));
    }
    if (!msg.isEmpty()) {
      return msg;
    }
    BaseInfo infoType = node.getFunc().getInfo().getType();
    if (!(infoType instanceof FuncInfo)) {
      return new CompileMsg("Call to undefined function " + infoType.getName(), node);
    }
    FuncInfo funcInfo = (FuncInfo) infoType;
    if (funcInfo.getParams().size() != node.getArgs().size()) { // TODO: add support for default parameters
      return new CompileMsg(
          "Function " + funcInfo.toString() + " expected to have " + funcInfo.getParams().size() + " arguments, got "
              + node.getArgs().size(),
          node);
    }
    for (int i = 0; i < node.getArgs().size(); i++) {
      BaseInfo argType = node.getArgs().get(i).getInfo().getType();
      TypeInfo paramType = funcInfo.getParams().get(i);
      if (!(argType instanceof TypeInfo) || !argType.equals(paramType)) {
        return new CompileMsg("Function " + funcInfo.toString() + " expected argument " + (i + 1)
            + " to be of type " + paramType.getName() + ", got " + argType.getName(), node);
      }
    }
    node.setInfo(new ExprInfo("callExpr", funcInfo.getType(), false));
    return msg;
  }

  public CompileMsg visit(ASTArrayExprNode node) throws BaseError {
    var msg = new CompileMsg();
    msg.append(node.getArray().accept(this));
    if (!msg.isEmpty()) {
      return msg;
    }
    BaseInfo arrayType = node.getArray().getInfo().getType();
    if (!(arrayType instanceof TypeInfo) || ((TypeInfo) arrayType).getDepth() == 0) {
      return new CompileMsg("Cannot access an non-array variable " + node.getArray().toString(), node);
    }
    msg.append(node.getSubscript().accept(this));
    if (!msg.isEmpty()) {
      return msg;
    }
    BaseInfo indexType = node.getSubscript().getInfo().getType();
    if (!(indexType instanceof TypeInfo) || !indexType.equals(GlobalScope.intType)) {
      return new CompileMsg("Cannot access array " + node.getArray().toString() + " by a non-integer index of "
          + indexType.toString(), node);
    }
    node.setInfo(new ExprInfo("arrayExpr", new TypeInfo(arrayType.getName(), ((TypeInfo) arrayType).getDepth() - 1), true));
    return msg;
  }

  public CompileMsg visit(ASTPostUnaryExprNode node) throws BaseError {
    var msg = node.getExpr().accept(this);
    BaseInfo exprType = node.getExpr().getInfo().getType();
    if (!(exprType instanceof TypeInfo) || !exprType.equals(GlobalScope.intType)) {
      return new CompileMsg("Cannot apply " + node.getOp() + " to a non-integer operand", node);
    }
    if (!node.getExpr().getInfo().isLValue()) {
      return new CompileMsg("Cannot apply " + node.getOp() + " to a lvalue operand", node);
    }
    node.setInfo(new ExprInfo("postUnaryExpr", GlobalScope.intType, false));
    return msg;
  }

  public CompileMsg visit(ASTPreUnaryExprNode node) throws BaseError {
    var msg = node.getExpr().accept(this);
    BaseInfo exprType = node.getExpr().getInfo().getType();
    if (!(exprType instanceof TypeInfo)) {
      return new CompileMsg("Cannot apply " + node.getOp() + " to a non-integer operand", node);
    }
    if (node.getOp().equals("!")) {
      if (!exprType.equals(GlobalScope.boolType)) {
        return new CompileMsg("Cannot apply " + node.getOp() + " to a non-boolean operand", node);
      }
      node.setInfo(new ExprInfo("preUnaryExpr", GlobalScope.boolType, false));
    } else {
      if (!exprType.equals(GlobalScope.intType)) {
        return new CompileMsg("Cannot apply " + node.getOp() + " to a non-integer operand", node);
      }
      if (node.getOp().equals("++") || node.getOp().equals("--")) {
        if (!node.getExpr().getInfo().isLValue()) {
          return new CompileMsg("Cannot apply " + node.getOp() + " to a right value operand", node);
        }
        node.setInfo(new ExprInfo("preUnaryExpr", GlobalScope.intType, true));
      } else {
        node.setInfo(new ExprInfo("preUnaryExpr", GlobalScope.intType, true));
      }
    }
    return msg;
  }

  public CompileMsg visit(ASTBinaryExprNode node) throws BaseError {
    var msg = new CompileMsg();
    msg.append(node.getLhs().accept(this));
    msg.append(node.getRhs().accept(this));
    if (!msg.isEmpty()) {
      return msg;
    }
    BaseInfo lhsType = node.getLhs().getInfo().getType();
    BaseInfo rhsType = node.getRhs().getInfo().getType();
    if (!(lhsType instanceof TypeInfo) || !(rhsType instanceof TypeInfo)) {
      return new CompileMsg("Cannot apply " + node.getOp() + " to non-integer operands", node);
    }
    if (!lhsType.equals(rhsType)) {
      return new CompileMsg("Cannot apply " + node.getOp() + " to operands of different types", node);
    }
    if (((TypeInfo) lhsType).getDepth() > 0 || lhsType.equals(GlobalScope.nullType)) { // TODO: compare two arrays?
      if (!node.getOp().equals("==") && !node.getOp().equals("!=")) {
        return new CompileMsg("Operator " + node.getOp() + " is not supported for arrays", node);
      }
    } else if (lhsType.equals(GlobalScope.boolType)) {
      if (!node.getOp().equals("==") && !node.getOp().equals("!=") && !node.getOp().equals("&&")
          && !node.getOp().equals("||")) {
        return new CompileMsg("Operator " + node.getOp() + " is not supported for booleans", node);
      }
    } else if (lhsType.equals(GlobalScope.stringType)) {
      if (!node.getOp().equals("+") && !node.getOp().equals("==") && !node.getOp().equals("!=")
          && !node.getOp().equals("<")
          && !node.getOp().equals("<=") && !node.getOp().equals(">")
          && !node.getOp().equals(">=")) {
        return new CompileMsg("Operator " + node.getOp() + " is not supported for strings", node);
      }
    } else if (lhsType.equals(GlobalScope.intType)) {
      if (node.getOp().equals("!")) {
        return new CompileMsg("Operator " + node.getOp() + " is not supported for integers", node);
      }
    } else {
      return new CompileMsg("Operator " + node.getOp() + " is not supported for " + lhsType.getName(), node);
    }
    if (node.getOp().equals("<") || node.getOp().equals(">") || node.getOp().equals("<=") || node.getOp().equals(">=")
        || node.getOp().equals("==") || node.getOp().equals("!=")) {
      node.setInfo(new ExprInfo("binaryExpr", GlobalScope.boolType, false));
    } else {
      node.setInfo(new ExprInfo("binaryExpr", lhsType, false));
    }
    return msg;
  }

  public CompileMsg visit(ASTConditionalExprNode node) throws BaseError {
    var msg = new CompileMsg();
    msg.append(node.getCondition().accept(this));
    msg.append(node.getLhs().accept(this));
    msg.append(node.getRhs().accept(this));
    if (!msg.isEmpty()) {
      return msg;
    }
    BaseInfo conditionType = node.getCondition().getInfo().getType();
    BaseInfo lhsType = node.getLhs().getInfo().getType();
    BaseInfo rhsType = node.getRhs().getInfo().getType();
    if (!(conditionType instanceof TypeInfo) || !conditionType.equals(GlobalScope.boolType)) {
      return new CompileMsg("Condition should be of type bool", node);
    }
    if (!(lhsType instanceof TypeInfo) || !(rhsType instanceof TypeInfo) || !lhsType.equals(rhsType)) {
      return new CompileMsg("Operands should be of the same type", node);
    }
    node.setInfo(new ExprInfo("conditionalExpr", lhsType, false));
    return msg;
  }

  public CompileMsg visit(ASTAssignExprNode node) throws BaseError {
    var msg = new CompileMsg();
    msg.append(node.getLhs().accept(this));
    msg.append(node.getRhs().accept(this));
    if (!msg.isEmpty()) {
      return msg;
    }
    BaseInfo lhsType = node.getLhs().getInfo().getType();
    BaseInfo rhsType = node.getRhs().getInfo().getType();
    if (!(lhsType instanceof TypeInfo) || !(rhsType instanceof TypeInfo) || !lhsType.equals(rhsType)) {
      return new CompileMsg("Cannot assign " + rhsType.toString() + " to " + lhsType.toString(), node);
    }
    if (!node.getLhs().getInfo().isLValue()) {
      return new CompileMsg("Cannot assign " + rhsType.getName() + " to a left value " + node.getLhs().toString(),
          node);
    }
    node.setInfo(new ExprInfo("assignExpr", lhsType, true));
    return msg;
  }

  public CompileMsg visit(ASTAtomExprNode node) throws BaseError {
    if (node.getAtomType() == ASTAtomExprNode.Type.CUSTOM) {
      var info = currentScope.getRecurWithScope(node.getValue());
      if (info == null) {
        return new CompileMsg("Use of undefined identifier " + node.toString(), node);
      }
      if (info.a instanceof VarInfo) {
        node.setInfo(new ExprInfo("atomExpr", ((VarInfo) info.a).getType(), true));
      } else if (info.a instanceof FuncInfo) {
        node.setInfo(new ExprInfo("atomExpr", info.a, false));
      } else {
        return new CompileMsg("Use of undefined identifier " + node.toString(), node);
      }
      if (info.b instanceof ClassScope) {
        var parent = node.getParent();
        var replaceNode = ASTMemberExprNode.builder()
            .position(node.getPosition())
            .parent(parent)
            .object(ASTAtomExprNode.builder().atomType(ASTAtomExprNode.Type.THIS).value("this").build())
            .member(node.getValue())
            .build();
        replaceNode.accept(this);
        ((ASTNodeWithExpr) parent).replaceExpr(node, replaceNode);
      }
    } else if (node.getAtomType() == ASTAtomExprNode.Type.INT) {
      node.setInfo(new ExprInfo("atomExpr", GlobalScope.intType, false));
    } else if (node.getAtomType() == ASTAtomExprNode.Type.STRING) {
      node.setInfo(new ExprInfo("atomExpr", GlobalScope.stringType, false));
    } else if (node.getAtomType() == ASTAtomExprNode.Type.BOOL) {
      node.setInfo(new ExprInfo("atomExpr", GlobalScope.boolType, false));
    } else if (node.getAtomType() == ASTAtomExprNode.Type.NULL) {
      node.setInfo(new ExprInfo("atomExpr", GlobalScope.nullType, false));
    } else if (node.getAtomType() == ASTAtomExprNode.Type.THIS) {
      BaseScope lastClass = currentScope.getLastClass();
      if (lastClass == null) {
        return new CompileMsg("Keyword this should be used in a class", node);
      }
      node.setInfo(new ExprInfo("atomExpr", new TypeInfo(lastClass.getInfo().getName(), 0), false));
    } else {
      return new CompileMsg("Unknown atom type", node);
    }
    return new CompileMsg();
  }

  public CompileMsg visit(ASTBlockStmtNode node) throws BaseError {
    node.addScope(currentScope);
    enterScope(node.getScope());
    var msg = new CompileMsg();
    for (ASTStmtNode stmt : node.getStmts()) {
      msg.append(stmt.accept(this));
    }
    if (!msg.isEmpty()) {
      return msg;
    }
    exitScope();
    return new CompileMsg();
  }

  public CompileMsg visit(ASTIfStmtNode node) throws BaseError {
    var msg = new CompileMsg();
    msg.append(node.getCondition().accept(this));
    if (!msg.isEmpty()) {
      return msg;
    }
    BaseInfo conditionType = node.getCondition().getInfo().getType();
    if (!(conditionType instanceof TypeInfo) || !conditionType.equals(GlobalScope.boolType)) {
      return new CompileMsg("Condition should be of type bool", node);
    }
    node.addScope(currentScope);
    enterScope(node.getScope("then"));
    if (node.getThenStmt() instanceof ASTBlockStmtNode) {
      for (ASTStmtNode stmt : ((ASTBlockStmtNode) node.getThenStmt()).getStmts()) {
        msg.append(stmt.accept(this));
      }
    } else {
      msg.append(node.getThenStmt().accept(this));
    }
    if (!msg.isEmpty()) {
      return msg;
    }
    exitScope();
    if (node.getElseStmt() != null) {
      enterScope(node.getScope("else"));
      if (node.getElseStmt() instanceof ASTBlockStmtNode) {
        for (ASTStmtNode stmt : ((ASTBlockStmtNode) node.getElseStmt()).getStmts()) {
          msg.append(stmt.accept(this));
        }
      } else {
        msg.append(node.getElseStmt().accept(this));
      }
      if (!msg.isEmpty()) {
        return msg;
      }
      exitScope();
    }
    return msg;
  }

  public CompileMsg visit(ASTForStmtNode node) throws BaseError {
    node.addScope(currentScope);
    enterScope(node.getScope());
    var msg = new CompileMsg();
    if (node.getInit() != null) {
      msg.append(node.getInit().accept(this));
    }
    if (!msg.isEmpty()) {
      return msg;
    }
    if (node.getCondition() != null) {
      msg.append(node.getCondition().accept(this));
      if (!msg.isEmpty()) {
        return msg;
      }
      BaseInfo conditionType = node.getCondition().getInfo().getType();
      if (!(conditionType instanceof TypeInfo) || !conditionType.equals(GlobalScope.boolType)) {
        return new CompileMsg("Condition should be of type bool", node);
      }
    }
    if (node.getUpdate() != null) {
      msg.append(node.getUpdate().accept(this));
    }
    if (!msg.isEmpty()) {
      return msg;
    }
    if (node.getBody() instanceof ASTBlockStmtNode) {
      for (ASTStmtNode stmt : ((ASTBlockStmtNode) node.getBody()).getStmts()) {
        msg.append(stmt.accept(this));
      }
    } else {
      msg.append(node.getBody().accept(this));
    }
    if (!msg.isEmpty()) {
      return msg;
    }
    exitScope();
    return new CompileMsg();
  }

  public CompileMsg visit(ASTWhileStmtNode node) throws BaseError {
    node.addScope(currentScope);
    enterScope(node.getScope());
    var msg = new CompileMsg();
    msg.append(node.getCondition().accept(this));
    if (!msg.isEmpty()) {
      return msg;
    }
    BaseInfo conditionType = node.getCondition().getInfo().getType();
    if (!(conditionType instanceof TypeInfo) || !conditionType.equals(GlobalScope.boolType)) {
      return new CompileMsg("Condition should be of type bool", node);
    }
    if (node.getBody() instanceof ASTBlockStmtNode) {
      for (ASTStmtNode stmt : ((ASTBlockStmtNode) node.getBody()).getStmts()) {
        msg.append(stmt.accept(this));
      }
    } else {
      msg.append(node.getBody().accept(this));
    }
    if (!msg.isEmpty()) {
      return msg;
    }
    exitScope();
    return new CompileMsg();
  }

  public CompileMsg visit(ASTContinueStmtNode node) throws BaseError {
    if (currentScope.getLastLoop() == null) {
      return new CompileMsg("Keyword continue should be used in a loop", node);
    }
    return new CompileMsg();
  }

  public CompileMsg visit(ASTBreakStmtNode node) throws BaseError {
    if (currentScope.getLastLoop() == null) {
      return new CompileMsg("Keyword continue should be used in a loop", node);
    }
    return new CompileMsg();
  }

  public CompileMsg visit(ASTReturnStmtNode node) throws BaseError {
    var scope = currentScope.getLastFunc();
    var msg = new CompileMsg();
    if (scope == null) {
      return new CompileMsg("Keyword return should be used in a function", node);
    }
    TypeInfo returnType = ((FuncInfo) scope.getInfo()).getType();
    if (node.getExpr() == null) {
      if (!returnType.equals(GlobalScope.voidType)) {
        return new CompileMsg("Function should return a value", node);
      }
    } else {
      msg.append(node.getExpr().accept(this));
      if (!msg.isEmpty()) {
        return msg;
      }
      BaseInfo exprType = node.getExpr().getInfo().getType();
      if (!(exprType instanceof TypeInfo) || !returnType.equals(exprType)) {
        return new CompileMsg("Function should return a value of type " + returnType.getName() + ", but got "
            + exprType.getName() + " instead", node);
      }
      ((FuncScope) scope).setIsExited(true);
    }
    return msg;
  }

  public CompileMsg visit(ASTExprStmtNode node) throws BaseError {
    var msg = new CompileMsg();
    for (ASTExprNode expr : node.getExprs()) {
      msg.append(expr.accept(this));
      if (!msg.isEmpty()) {
        return msg;
      }
      BaseInfo type = expr.getInfo().getType();
      if (type instanceof FuncInfo) {
        return new CompileMsg("Function call is not complete", node);
      }
    }
    return msg;
  }

  public CompileMsg visit(ASTVarDefStmtNode node) throws BaseError {
    var msg = new CompileMsg();
    for (ASTVarDefNode varDef : node.getDefs()) {
      msg.append(varDef.accept(this));
    }
    return msg;
  }

  public CompileMsg visit(ASTEmptyStmtNode node) throws BaseError {
    return new CompileMsg();
  }
}
