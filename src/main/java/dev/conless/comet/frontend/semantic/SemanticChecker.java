package dev.conless.comet.frontend.semantic;

import dev.conless.comet.frontend.ast.*;
import dev.conless.comet.frontend.ast.def.*;
import dev.conless.comet.frontend.ast.expr.*;
import dev.conless.comet.frontend.ast.stmt.*;
import dev.conless.comet.frontend.ast.type.*;
import dev.conless.comet.utils.AtomType;
import dev.conless.comet.utils.error.*;
import dev.conless.comet.utils.metadata.*;
import dev.conless.comet.utils.scope.BaseScope;
import dev.conless.comet.utils.scope.FuncScope;
import dev.conless.comet.utils.scope.GlobalScope;

public class SemanticChecker extends ScopeManager implements ASTVisitor {
  public void visit(ASTNode node) throws BaseError {
    throw new RuntimeError("SemanticChecker.visit(ASTNode) should not be called", node.getPosition());
  }

  public void visit(ProgramNode node) throws BaseError {
    node.addScope(null);
    enterScope(node.getScope());
    for (var def : node.defs) {
      def.accept(this);
    }
    exitScope();
  }

  public void visit(FuncDefNode node) throws BaseError {
    node.addScope(currentScope);
    enterScope(node.getScope());
    for (var stmt : node.getBody()) {
      stmt.accept(this);
    }
    if (!node.getReturnType().equals(GlobalScope.voidType) && !node.getInfo().getName().equals("main")) {
      if (!((FuncScope) currentScope).getIsExited()) {
        throw new CompileError("Function " + node.getName() + " doesn't have a return statement", node);
      }
    }
    exitScope();
  }

  public void visit(ClassDefNode node) throws BaseError {
    node.addScope(currentScope);
    enterScope(node.getScope());
    node.getConstructor().accept(this);
    for (var funcDef : node.getFuncDefs()) {
      funcDef.accept(this);
    }
    exitScope();
  }

  public void visit(VarDefNode node) throws BaseError {
    var v = (VarInfo) node.getInfo();
    if (!checkTypeValid(v.getType())) {
      throw new CompileError("Invalid type " + v.getType().getName() + " is used", node);
    }
    if (currentScope.get(node.getName()) != null) {
      throw new CompileError("Redefinition of " + node.getName(), node);
    } else {
      if (node.getInit() != null) {
        node.getInit().accept(this);
        BaseInfo initType = node.getInit().getInfo().getType();
        if (!(initType instanceof TypeInfo) || !v.getType().equals(initType)) {
          throw new CompileError("Cannot assign " + node.getInit().toString() + " to " + node.getName().toString(),
              node);
        }
      }
      currentScope.declare(new VarInfo(node.getName(), v.getType()));
    }
  }

  public void visit(TypeNameNode node) throws BaseError {
    throw new RuntimeError("SemanticChecker.visit(TypeNameNode) should not be called", node.getPosition());
  }

  public void visit(ExprNode node) throws BaseError {
    throw new RuntimeError("SemanticChecker.visit(ExprNode) should not be called", node.getPosition());
  }

  public void visit(NewExprNode node) throws BaseError {
    TypeInfo type = node.getType();
    if (!checkTypeValid(type) || (type.isBuiltIn && type.depth == 0)) {
      throw new CompileError(
          "Cannot initialize type " + type.getName(), node);
    }
    for (var expr : node.getLengths()) {
      expr.accept(this);
      BaseInfo exprType = expr.getInfo().getType();
      if (!(exprType instanceof TypeInfo) || !exprType.equals(GlobalScope.intType)) {
        throw new CompileError("Array size must be an integer", node);
      }
    }
    node.setInfo(new ExprInfo("newExpr", type, true));
  }

  public void visit(MemberExprNode node) throws BaseError {
    node.getObject().accept(this);
    BaseInfo objectType = node.getObject().getInfo().getType();
    if (!(objectType instanceof TypeInfo)) {
      throw new CompileError("Cannot access member of non-array type " + objectType.getName(), node);
    }
    if (((TypeInfo) objectType).depth > 0) {
      if (node.getMember().equals("size")) {
        node.setInfo(new ExprInfo("memberExpr", GlobalScope.arraySizeFunc, false));
      } else {
        throw new CompileError("Call to undefined member " + node.getMember() + " of array type " + objectType.getName(),
            node);
      }
    } else {
      ClassInfo classInfo = (ClassInfo) globalScope.get(objectType.getName(), "class");
      if (classInfo == null) {
        throw new CompileError("Call to undefined class " + objectType.getName(), node);
      }
      BaseInfo memberInfo = classInfo.getMember(node.getMember());
      if (memberInfo == null) {
        throw new CompileError("Call to undefined member " + node.getMember() + " of type " + objectType.getName(), node);
      }
      if (memberInfo instanceof VarInfo) {
        node.setInfo(new ExprInfo("memberExpr", ((VarInfo) memberInfo).getType(), true));
      } else {
        node.setInfo(new ExprInfo("callExpr", memberInfo, false));
      }
    }
  }

  public void visit(CallExprNode node) throws BaseError {
    node.getFunc().accept(this);
    for (var arg : node.getArgs()) {
      arg.accept(this);
    }
    BaseInfo infoType = node.getFunc().getInfo().getType();
    if (!(infoType instanceof FuncInfo)) {
      throw new CompileError("Call to undefined function " + infoType.getName(), node);
    }
    FuncInfo funcInfo = (FuncInfo) infoType;
    if (funcInfo.getParams().size() != node.getArgs().size()) { // TODO: add support for default parameters
      throw new CompileError(
          "Function " + funcInfo.toString() + " expected to have " + funcInfo.getParams().size() + " arguments, got "
              + node.getArgs().size(), node);
    }
    for (int i = 0; i < node.getArgs().size(); i++) {
      BaseInfo argType = node.getArgs().get(i).getInfo().getType();
      TypeInfo paramType = funcInfo.getParams().get(i);
      if (!(argType instanceof TypeInfo) || !argType.equals(paramType)) {
        throw new CompileError("Function " + funcInfo.toString() + " expected argument " + (i + 1)
            + " to be of type " + paramType.getName() + ", got " + argType.getName(), node);
      }
    }
    node.setInfo(new ExprInfo("callExpr", funcInfo.getType(), false));
  }

  public void visit(ArrayExprNode node) throws BaseError {
    node.getArray().accept(this);
    BaseInfo arrayType = node.getArray().getInfo().getType();
    if (!(arrayType instanceof TypeInfo) || ((TypeInfo) arrayType).depth == 0) {
      throw new CompileError("Cannot access an non-array variable " + node.getArray().toString(), node);
    }
    node.getSubscript().accept(this);
    BaseInfo indexType = node.getSubscript().getInfo().getType();
    if (!(indexType instanceof TypeInfo) || !indexType.equals(GlobalScope.intType)) {
      throw new CompileError("Cannot access array " + node.getArray().toString() + " by a non-integer index of "
          + indexType.toString(), node);
    }
    node.setInfo(new ExprInfo("arrayExpr", new TypeInfo(arrayType.getName(), ((TypeInfo) arrayType).depth - 1), node.getArray().getInfo().isLValue()));
  }

  public void visit(PostUnaryExprNode node) throws BaseError {
    node.getExpr().accept(this);
    BaseInfo exprType = node.getExpr().getInfo().getType();
    if (!(exprType instanceof TypeInfo) || !exprType.equals(GlobalScope.intType)) {
      throw new CompileError("Cannot apply " + node.getOp() + " to a non-integer operand", node);
    }
    if (!node.getExpr().getInfo().isLValue()) {
      throw new CompileError("Cannot apply " + node.getOp() + " to a lvalue operand", node);
    }
    node.setInfo(new ExprInfo("postUnaryExpr", GlobalScope.intType, false));
  }

  public void visit(PreUnaryExprNode node) throws BaseError {
    node.getExpr().accept(this);
    BaseInfo exprType = node.getExpr().getInfo().getType();
    if (!(exprType instanceof TypeInfo)) {
      throw new CompileError("Cannot apply " + node.getOp() + " to a non-integer operand", node);
    }
    if (node.getOp().equals("!")) {
      if (!exprType.equals(GlobalScope.boolType)) {
        throw new CompileError("Cannot apply " + node.getOp() + " to a non-boolean operand", node);
      }
      node.setInfo(new ExprInfo("preUnaryExpr", GlobalScope.boolType, false));
    } else {
      if (!exprType.equals(GlobalScope.intType)) {
        throw new CompileError("Cannot apply " + node.getOp() + " to a non-integer operand", node);
      }
      if (node.getOp().equals("++") || node.getOp().equals("--")) {
        if (!node.getExpr().getInfo().isLValue()) {
          throw new CompileError("Cannot apply " + node.getOp() + " to a right value operand", node);
        }
        node.setInfo(new ExprInfo("preUnaryExpr", GlobalScope.intType, true));
      } else {
        node.setInfo(new ExprInfo("preUnaryExpr", GlobalScope.intType, true));
      }
    }
  }

  public void visit(BinaryExprNode node) throws BaseError {
    node.getLhs().accept(this);
    node.getRhs().accept(this);
    BaseInfo lhsType = node.getLhs().getInfo().getType();
    BaseInfo rhsType = node.getRhs().getInfo().getType();
    if (!(lhsType instanceof TypeInfo) || !(rhsType instanceof TypeInfo)) {
      throw new CompileError("Cannot apply " + node.getOp() + " to non-integer operands", node);
    }
    if (!lhsType.equals(rhsType)) {
      throw new CompileError("Cannot apply " + node.getOp() + " to operands of different types", node);
    }
    if (((TypeInfo) lhsType).getDepth() > 0 || lhsType.equals(GlobalScope.nullType)) { // TODO: compare two arrays?
      if (!node.getOp().equals("==") && !node.getOp().equals("!=")) {
        throw new CompileError("Operator " + node.getOp() + " is not supported for arrays", node);
      }
    } else if (lhsType.equals(GlobalScope.boolType)) {
      if (!node.getOp().equals("==") && !node.getOp().equals("!=") && !node.getOp().equals("&&") && !node.getOp().equals("||")) {
        throw new CompileError("Operator " + node.getOp() + " is not supported for booleans", node);
      }
    } else if (lhsType.equals(GlobalScope.stringType)) {
      if (!node.getOp().equals("+") && !node.getOp().equals("==") && !node.getOp().equals("!=") && !node.getOp().equals("<")
          && !node.getOp().equals("<=") && !node.getOp().equals(">")
          && !node.getOp().equals(">=")) {
        throw new CompileError("Operator " + node.getOp() + " is not supported for strings", node);
      }
    } else if (lhsType.equals(GlobalScope.intType)) {
      if (node.getOp().equals("!")) {
        throw new CompileError("Operator " + node.getOp() + " is not supported for integers", node);
      }
    } else {
      throw new CompileError("Operator " + node.getOp() + " is not supported for " + lhsType.getName(), node);
    }
    if (node.getOp().equals("<") || node.getOp().equals(">") || node.getOp().equals("<=") || node.getOp().equals(">=")
        || node.getOp().equals("==")|| node.getOp().equals("!=")) {
      node.setInfo(new ExprInfo("binaryExpr", GlobalScope.boolType, false));
    } else {
      node.setInfo(new ExprInfo("binaryExpr", lhsType, false));
    }
  }

  public void visit(ConditionalExprNode node) throws BaseError {
    node.getCondition().accept(this);
    node.getLhs().accept(this);
    node.getRhs().accept(this);
    BaseInfo conditionType = node.getCondition().getInfo().getType();
    BaseInfo lhsType = node.getLhs().getInfo().getType();
    BaseInfo rhsType = node.getRhs().getInfo().getType();
    if (!(conditionType instanceof TypeInfo) || !conditionType.equals(GlobalScope.boolType)) {
      throw new CompileError("Condition should be of type bool", node);
    }
    if (!(lhsType instanceof TypeInfo) || !(rhsType instanceof TypeInfo) || !lhsType.equals(rhsType)) {
      throw new CompileError("Operands should be of the same type", node);
    }
    node.setInfo(new ExprInfo("conditionalExpr", lhsType, false));
  }

  public void visit(AssignExprNode node) throws BaseError {
    node.getLhs().accept(this);
    node.getRhs().accept(this);
    BaseInfo lhsType = node.getLhs().getInfo().getType();
    BaseInfo rhsType = node.getRhs().getInfo().getType();
    if (!(lhsType instanceof TypeInfo) || !(rhsType instanceof TypeInfo) || !lhsType.equals(rhsType)) {
      throw new CompileError("Cannot assign " + rhsType.toString() + " to " + lhsType.toString(), node);
    }
    if (!node.getLhs().getInfo().isLValue()) {
      throw new CompileError("Cannot assign " + rhsType.getName() + " to a left value " + node.getLhs().toString(), node);
    }
    node.setInfo(new ExprInfo("assignExpr", lhsType, true));
  }

  public void visit(AtomExprNode node) throws BaseError {
    if (node.getAtomType() == AtomType.CUSTOM) {
      BaseInfo info = currentScope.getRecur(node.toString());
      if (info instanceof VarInfo) {
        node.setInfo(new ExprInfo("atomExpr", ((VarInfo) info).getType(), true));
      } else if (info instanceof FuncInfo) {
        node.setInfo(new ExprInfo("atomExpr", info, false));
      } else {
        throw new CompileError("Use of undefined identifier " + node.toString(), node);
      }
      return;
    }
    if (node.getAtomType() == AtomType.INT) {
      node.setInfo(new ExprInfo("atomExpr", GlobalScope.intType, false));
      return;
    }
    if (node.getAtomType() == AtomType.STRING) {
      node.setInfo(new ExprInfo("atomExpr", GlobalScope.stringType, false));
      return;
    }
    if (node.getAtomType() == AtomType.BOOL) {
      node.setInfo(new ExprInfo("atomExpr", GlobalScope.boolType, false));
      return;
    }
    if (node.getAtomType() == AtomType.NULL) {
      node.setInfo(new ExprInfo("atomExpr", GlobalScope.nullType, false));
      return;
    }
    if (node.getAtomType() == AtomType.THIS) {
      BaseScope lastClass = currentScope.getLastClass();
      if (lastClass == null) {
        throw new CompileError("Keyword this should be used in a class", node);
      }
      node.setInfo(new ExprInfo("atomExpr", new TypeInfo(lastClass.getInfo().getName(), 0), false));
      return;
    }
    throw new CompileError("Unknown atom type", node);
  }

  public void visit(StmtNode node) throws BaseError {
    throw new RuntimeError("SemanticChecker.visit(StmtNode) should not be called", node.getPosition());
  }

  public void visit(BlockStmtNode node) throws BaseError {
    node.addScope(currentScope);
    enterScope(node.getScope());
    for (StmtNode stmt : node.getStmts()) {
      stmt.accept(this);
    }
    exitScope();
  }

  public void visit(IfStmtNode node) throws BaseError {
    node.getCondition().accept(this);
    BaseInfo conditionType = node.getCondition().getInfo().getType();
    if (!(conditionType instanceof TypeInfo) || !conditionType.equals(GlobalScope.boolType)) {
      throw new CompileError("Condition should be of type bool", node);
    }
    node.addScope(currentScope);
    enterScope(node.getScope("then"));
    if (node.getThenStmt() instanceof BlockStmtNode) {
      for (StmtNode stmt : ((BlockStmtNode) node.getThenStmt()).getStmts()) {
        stmt.accept(this);
      }
    } else {
      node.getThenStmt().accept(this);
    }
    exitScope();
    if (node.getElseStmt() != null) {
      enterScope(node.getScope("else"));
      if (node.getElseStmt() instanceof BlockStmtNode) {
        for (StmtNode stmt : ((BlockStmtNode) node.getElseStmt()).getStmts()) {
          stmt.accept(this);
        }
      } else {
        node.getElseStmt().accept(this);
      }
      exitScope();
    }
  }

  public void visit(ForStmtNode node) throws BaseError {
    node.addScope(currentScope);
    enterScope(node.getScope());
    if (node.getInit() != null) {
      node.getInit().accept(this);
    }
    if (node.getCondition() != null) {
      node.getCondition().accept(this);
      BaseInfo conditionType = node.getCondition().getInfo().getType();
      if (!(conditionType instanceof TypeInfo) || !conditionType.equals(GlobalScope.boolType)) {
        throw new RuntimeException("Condition should be of type bool");
      }
    }
    if (node.getUpdate() != null) {
      node.getUpdate().accept(this);
    }
    if (node.getBody() instanceof BlockStmtNode) {
      for (StmtNode stmt : ((BlockStmtNode) node.getBody()).getStmts()) {
        stmt.accept(this);
      }
    } else {
      node.getBody().accept(this);
    }
    exitScope();
  }

  public void visit(WhileStmtNode node) throws BaseError {
    node.addScope(currentScope);
    enterScope(node.getScope());
    node.getCondition().accept(this);
    BaseInfo conditionType = node.getCondition().getInfo().getType();
    if (!(conditionType instanceof TypeInfo) || !conditionType.equals(GlobalScope.boolType)) {
      throw new CompileError("Condition should be of type bool", node);
    }
    if (node.getBody() instanceof BlockStmtNode) {
      for (StmtNode stmt : ((BlockStmtNode) node.getBody()).getStmts()) {
        stmt.accept(this);
      }
    } else {
      node.getBody().accept(this);
    }
    exitScope();
  }

  public void visit(ContinueStmtNode node) throws BaseError {
    if (currentScope.getLastLoop() == null) {
      throw new CompileError("Keyword continue should be used in a loop", node);
    }
  }

  public void visit(BreakStmtNode node) throws BaseError {
    if (currentScope.getLastLoop() == null) {
      throw new CompileError("Keyword continue should be used in a loop", node);
    }
  }

  public void visit(ReturnStmtNode node) throws BaseError {
    var scope = currentScope.getLastFunc();
    if (scope == null) {
      throw new CompileError("Keyword return should be used in a function", node);
    }
    TypeInfo returnType = ((FuncInfo) scope.getInfo()).getType();
    if (node.getExpr() == null) {
      if (!returnType.equals(GlobalScope.voidType)) {
        throw new CompileError("Function should return a value", node);
      }
    } else {
      node.getExpr().accept(this);
      BaseInfo exprType = node.getExpr().getInfo().getType();
      if (!(exprType instanceof TypeInfo) || !returnType.equals(exprType)) {
        throw new CompileError("Function should return a value of type " + returnType.getName() + ", but got "
            + exprType.getName() + " instead", node);
      }
      ((FuncScope) scope).setIsExited(true);
    }
  }

  public void visit(ExprStmtNode node) throws BaseError {
    for (ExprNode expr : node.getExprs()) {
      expr.accept(this);
      BaseInfo type = expr.getInfo().getType();
      if (type instanceof FuncInfo) {
        throw new CompileError("Function call is not complete", node);
      }
    }
  }

  public void visit(VarDefStmtNode node) throws BaseError {
    for (VarDefNode varDef : node.getDefs()) {
      varDef.accept(this);
    }
  }

  public void visit(EmptyStmtNode node) throws BaseError {
  }
}
