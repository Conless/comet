package dev.conless.comet.frontend.semantic;

import dev.conless.comet.frontend.ast.*;
import dev.conless.comet.frontend.ast.def.*;
import dev.conless.comet.frontend.ast.expr.*;
import dev.conless.comet.frontend.ast.stmt.*;
import dev.conless.comet.frontend.ast.type.*;
import dev.conless.comet.utils.Type;
import dev.conless.comet.utils.metadata.*;
import dev.conless.comet.utils.scope.BaseScope;
import dev.conless.comet.utils.scope.GlobalScope;

public class SemanticChecker extends ScopeManager implements ASTVisitor {
  public void visit(ASTNode node) throws Exception {
    throw new Exception("SemanticChecker.visit(ASTNode) should not be called");
  }

  public void visit(ProgramNode node) throws Exception {
    node.addScope(null);
    enterScope(node.getScope());
    for (var def : node.defs) {
      def.accept(this);
    }
    exitScope();
  }

  public void visit(FuncDefNode node) throws Exception {
    node.addScope(currentScope);
    enterScope(node.getScope());
    for (var stmt : node.getBody()) {
      stmt.accept(this);
    }
    if (!node.getReturnType().equals(GlobalScope.voidType) && !node.getInfo().getName().equals("main")) {
      if (!((FuncInfo) currentScope.getInfo()).isExited()) {
        throw new Exception("Function " + node.getName() + " doesn't have a return statement " + node.position.toString());
      }
    }
    exitScope();
  }

  public void visit(ClassDefNode node) throws Exception {
    node.addScope(currentScope);
    enterScope(node.getScope());
    node.constructor.accept(this);
    for (var funcDef : node.getFuncDefs()) {
      funcDef.accept(this);
    }
    exitScope();
  }

  public void visit(VarDefNode node) throws Exception {
    TypeInfo type = (TypeInfo) node.getInfo();
    if (!checkTypeValid(type)) {
      throw new Exception(
          "Invalid type " + type.getName() + " is used at " + node.toString() + " " + node.position.toString());
    }
    for (var v : node.vars) {
      if (currentScope.get(v.a) != null) {
        throw new Exception("Redefinition of " + v.a + " at " + node.toString() + " " + node.position.toString());
      } else {
        if (v.b != null) {
          v.b.accept(this);
          TypeInfo initType = (TypeInfo) v.b.getInfo();
          if (!type.equals(initType)) {
            throw new Exception("Cannot assign " + v.b.toString() + " to " + v.a.toString() + " at " + node.toString() + " " + node.position.toString());
          }
        }
        currentScope.declare(new VarInfo(v.a, (TypeInfo) node.info));
      }
    }
  }

  public void visit(TypeNameNode node) throws Exception {
    throw new RuntimeException("SemanticChecker.visit(TypeNameNode) should not be called");
  }

  public void visit(ExprNode node) throws Exception {
    throw new RuntimeException("SemanticChecker.visit(ExprNode) should not be called");
  }

  public void visit(NewExprNode node) throws Exception {
    TypeInfo type = (TypeInfo) node.getInfo();
    if (!checkTypeValid(type) || (type.isBuiltIn && type.depth == 0)) {
      throw new RuntimeException(
          "Cannot initialize type " + type.getName() + " at " + node.toString() + " " + node.position.toString());
    }
    for (var expr : node.getLengths()) {
      expr.accept(this);
      TypeInfo exprType = (TypeInfo) expr.getInfo();
      if (!exprType.equals(GlobalScope.intType)) {
        throw new RuntimeException("Array size must be an integer at " + node.toString() + " " + node.position.toString());
      }
    }
    node.setEditable(true);
  }

  public void visit(MemberExprNode node) throws Exception {
    node.object.accept(this);
    TypeInfo objectType = (TypeInfo) node.object.getInfo();
    if (objectType.depth > 0) {
      if (node.member.equals("size")) {
        node.setInfo(GlobalScope.arraySizeFunc);
      } else {
        throw new RuntimeException("Call to undefined member " + node.member + " of array type " + objectType.getName() + " at " + node.toString() + " " + node.position.toString());
      }
    } else {
      ClassInfo classInfo = (ClassInfo) globalScope.get(objectType.getName(), "class");
      if (classInfo == null) {
        throw new RuntimeException("Call to undefined class " + objectType.getName() + " at " + node.toString() + " " + node.position.toString());
      }
      BaseInfo memberInfo = classInfo.get(node.member);
      if (memberInfo == null) {
        throw new RuntimeException("Call to undefined member " + node.member + " of type " + objectType.getName() + " at " + node.toString() + " " + node.position.toString());
      }
      if (memberInfo instanceof VarInfo) {
        node.setInfo(((VarInfo) memberInfo).getType());
        node.setEditable(true);
      } else {
        node.setInfo((FuncInfo) memberInfo);
      }
    }
  }

  public void visit(CallExprNode node) throws Exception {
    node.func.accept(this);
    for (var arg : node.args) {
      arg.accept(this);
    }
    if (!(node.func.getInfo() instanceof FuncInfo)) {
      throw new RuntimeException("Call to undefined function " + node.func.getInfo().getName() + " at " + node.toString() + " " + node.position.toString());
    }
    FuncInfo funcInfo = (FuncInfo) node.func.getInfo();
    if (funcInfo.getParams().size() != node.args.size()) { // TODO: add support for default parameters
      throw new RuntimeException(
          "Function " + funcInfo.toString() + " expected to have " + funcInfo.getParams().size() + " arguments, got " + node.args.size() + " at " + node.toString() + " " + node.position.toString());
    }
    for (int i = 0; i < node.args.size(); i++) {
      TypeInfo argType = (TypeInfo) node.args.get(i).getInfo();
      TypeInfo paramType = funcInfo.getParams().get(i);
      if (!argType.equals(paramType)) {
        throw new RuntimeException("Function " + funcInfo.toString() + " expected argument " + (i + 1) + " to be of type " + paramType.getName() + ", got " + argType.getName() + " at " + node.toString() + " " + node.position.toString());
      }
    }
    node.setInfo(funcInfo.getReturnType());
    node.setEditable(false);
  }

  public void visit(IndexExprNode node) throws Exception {
    node.array.accept(this);
    TypeInfo arrayType = (TypeInfo) node.array.getInfo();
    if (arrayType.depth == 0) {
      throw new RuntimeException("Index call to an non-array variable " + node.array.toString() + " at " + node.toString() + " " + node.position.toString());
    }
    node.index.accept(this);
    TypeInfo indexType = (TypeInfo) node.index.getInfo();
    if (!indexType.equals(GlobalScope.intType)) {
      throw new RuntimeException("Cannot access array " + node.array.toString() + " by a non-integer index of " + indexType.toString() + " at " + node.toString() + " " + node.position.toString());
    }
    node.setInfo(new TypeInfo(arrayType.getName(), arrayType.depth - 1));
    node.setEditable(node.array.isEditable());
  }

  public void visit(PostUnaryExprNode node) throws Exception {
    node.expr.accept(this);
    TypeInfo type = (TypeInfo) node.expr.getInfo();
    if (!type.equals(GlobalScope.intType)) {
      throw new RuntimeException("Cannot apply " + node.op + " to a non-integer operand at " + node.toString() + " "
          + node.position.toString());
    }
    if (!node.expr.isEditable()) {
      throw new RuntimeException("Cannot apply " + node.op + " to a lvalue operand at " + node.toString() + " "
          + node.position.toString());
    }
    node.setInfo(GlobalScope.intType);
    node.setEditable(false);
  }

  public void visit(PreUnaryExprNode node) throws Exception {
    node.expr.accept(this);
    TypeInfo type = (TypeInfo) node.expr.getInfo();
    node.setEditable(false);
    if (node.op.equals("!")) {
      if (!type.equals(GlobalScope.boolType)) {
        throw new RuntimeException("Cannot apply " + node.op + " to a non-boolean operand at " + node.toString() + " " + node.position.toString());
      }
      node.setInfo(GlobalScope.boolType);
    } else {
      if (!type.equals(GlobalScope.intType)) {
        throw new RuntimeException("Cannot apply " + node.op + " to a non-integer operand at " + node.toString() + " " + node.position.toString());
      }
      node.setInfo(GlobalScope.intType);
      if (node.op.equals("++") || node.op.equals("--")) {
        if (!node.expr.isEditable()) {
          throw new RuntimeException("Cannot apply " + node.op + " to a rvalue operand at " + node.toString() + " " + node.position.toString());
        }
        node.setEditable(true);
      }
    }
  }

  public void visit(BinaryExprNode node) throws Exception {
    node.lhs.accept(this);
    node.rhs.accept(this);
    TypeInfo lhsType = (TypeInfo) node.lhs.getInfo();
    TypeInfo rhsType = (TypeInfo) node.rhs.getInfo();
    if (!lhsType.equals(rhsType)) {
      throw new RuntimeException("Cannot apply " + node.op + " to operands of different types at " + node.toString() + " " + node.position.toString());
    }
    if (node.op.equals("<") || node.op.equals(">") || node.op.equals("<=") || node.op.equals(">=") || node.op.equals("==") || node.op.equals("!=")) {
      node.setInfo(GlobalScope.boolType);
    } else {
      node.setInfo(lhsType);
    }
    node.setEditable(false);
    if (lhsType.depth > 0 || lhsType.equals(GlobalScope.nullType)) { // TODO: compare two arrays?
      if (!node.op.equals("==") && !node.op.equals("!=")) {
        throw new RuntimeException("Operator " + node.op + " is not supported for arrays");
      }
      return;
    }
    if (lhsType.equals(GlobalScope.boolType)) {
      if (!node.op.equals("==") && !node.op.equals("!=") && !node.op.equals("&&") && !node.op.equals("||")) {
        throw new RuntimeException("Operator " + node.op + " is not supported for booleans");
      }
      return;
    }
    if (lhsType.equals(GlobalScope.stringType)) {
      if (!node.op.equals("+") && !node.op.equals("==") && !node.op.equals("!=") && !node.op.equals("<") && !node.op.equals("<=") && !node.op.equals(">")
          && !node.op.equals(">=")) {
        throw new RuntimeException("Operator " + node.op + " is not supported for strings");
      }
      return;
    }
    if (lhsType.equals(GlobalScope.intType)) {
      if (node.op.equals("!")) {
        throw new RuntimeException("Operator " + node.op + " is not supported for integers");
      }
      return;
    }
    throw new RuntimeException("Operator " + node.op + " is not supported for " + lhsType.getName());
  }

  public void visit(ConditionalExprNode node) throws Exception {
    node.condition.accept(this);
    node.lhs.accept(this);
    node.rhs.accept(this);
    TypeInfo conditionType = (TypeInfo) node.condition.getInfo();
    TypeInfo lhsType = (TypeInfo) node.lhs.getInfo();
    TypeInfo rhsType = (TypeInfo) node.rhs.getInfo();
    if (!conditionType.equals(GlobalScope.boolType)) {
      throw new RuntimeException("Condition should be of type bool");
    }
    if (!lhsType.equals(rhsType)) {
      throw new RuntimeException("Operands should be of the same type");
    }
    node.setInfo(lhsType);
    node.setEditable(false);
  }

  public void visit(AssignExprNode node) throws Exception {
    node.lhs.accept(this);
    node.rhs.accept(this);
    TypeInfo lhsType = (TypeInfo) node.lhs.getInfo();
    TypeInfo rhsType = (TypeInfo) node.rhs.getInfo();
    if (!lhsType.equals(rhsType)) {
      throw new RuntimeException("Cannot assign " + rhsType.toString() + " to " + lhsType.toString() + " at " + node.toString() + " " + node.position.toString());
    }
    if (!node.lhs.isEditable()) {
      throw new RuntimeException("Cannot assign " + rhsType.getName() + " to a lvalue " + node.lhs.toString() + " at " + node.toString() + " " + node.position.toString());
    }
    node.setInfo(lhsType);
    node.setEditable(true);
  }

  public void visit(AtomExprNode node) throws Exception {
    if (node.atomType == Type.CUSTOM) {
      BaseInfo info = currentScope.getRecur(node.toString());
      if (info instanceof VarInfo) {
        node.setInfo(((VarInfo) info).getType());
        node.setEditable(true);
      } else if (info instanceof FuncInfo) {
        node.setInfo((FuncInfo) info);
        node.setEditable(false);
      } else {
        throw new RuntimeException("Use of undefined identifier " + node.toString() + " at " + node.toString() + " " + node.position.toString());
      }
      return;
    }
    node.setEditable(false);
    if (node.atomType == Type.INT) {
      node.setInfo(GlobalScope.intType);
      return;
    }
    if (node.atomType == Type.STRING) {
      node.setInfo(GlobalScope.stringType);
      return;
    }
    if (node.atomType == Type.BOOL) {
      node.setInfo(GlobalScope.boolType);
      return;
    }
    if (node.atomType == Type.NULL) {
      node.setInfo(GlobalScope.nullType);
      return;
    }
    if (node.atomType == Type.THIS) {
      BaseScope lastClass = currentScope.getLastClass();
      if (lastClass == null) {
        throw new RuntimeException("Keyword this should be used in a class");
      }
      node.setInfo(new TypeInfo(lastClass.getInfo().getName(), 0));
      return;
    }
    throw new RuntimeException("Unknown atom type");
  }

  public void visit(StmtNode node) throws Exception {
    throw new Exception("SemanticChecker.visit(StmtNode) should not be called");
  }

  public void visit(BlockStmtNode node) throws Exception {
    node.addScope(currentScope);
    enterScope(node.getScope());
    for (StmtNode stmt : node.stmts) {
      stmt.accept(this);
    }
    exitScope();
  }

  public void visit(IfStmtNode node) throws Exception {
    node.condition.accept(this);
    TypeInfo conditionType = (TypeInfo) node.condition.getInfo();
    if (!conditionType.equals(GlobalScope.boolType)) {
      throw new RuntimeException("Condition should be of type bool");
    }
    node.addScope(currentScope);
    enterScope(node.getScope("then"));
    if (node.thenStmt instanceof BlockStmtNode) {
      for (StmtNode stmt : ((BlockStmtNode) node.thenStmt).getStmts()) {
        stmt.accept(this);
      }
    } else {
      node.thenStmt.accept(this);
    }
    exitScope();
    if (node.elseStmt != null) {
      enterScope(node.getScope("else"));
      if (node.elseStmt instanceof BlockStmtNode) {
        for (StmtNode stmt : ((BlockStmtNode) node.elseStmt).getStmts()) {
          stmt.accept(this);
        }
      } else {
        node.elseStmt.accept(this);
      }
      exitScope();
    }
  }

  public void visit(ForStmtNode node) throws Exception {
    node.addScope(currentScope);
    enterScope(node.getScope());
    if (node.init != null) {
      node.init.accept(this);
    }
    if (node.condition != null) {
      node.condition.accept(this);
      TypeInfo conditionType = (TypeInfo) node.condition.getInfo();
      if (!conditionType.equals(GlobalScope.boolType)) {
        throw new RuntimeException("Condition should be of type bool");
      }
    }
    if (node.update != null) {
      node.update.accept(this);
    }
    if (node.body instanceof BlockStmtNode) {
      for (StmtNode stmt : ((BlockStmtNode) node.body).getStmts()) {
        stmt.accept(this);
      }
    } else {
      node.body.accept(this);
    }
    exitScope();
  }

  public void visit(WhileStmtNode node) throws Exception {
    node.addScope(currentScope);
    enterScope(node.getScope());
    node.condition.accept(this);
    TypeInfo conditionType = (TypeInfo) node.condition.getInfo();
    if (!conditionType.equals(GlobalScope.boolType)) {
      throw new RuntimeException("Condition should be of type bool");
    }
    if (node.body instanceof BlockStmtNode) {
      for (StmtNode stmt : ((BlockStmtNode) node.body).getStmts()) {
        stmt.accept(this);
      }
    } else {
      node.body.accept(this);
    }
    exitScope();
  }

  public void visit(ContinueStmtNode node) throws Exception {
    if (currentScope.getLastLoop() == null) {
      throw new RuntimeException("Keyword continue should be used in a loop");
    }
  }

  public void visit(BreakStmtNode node) throws Exception {
    if (currentScope.getLastLoop() == null) {
      throw new RuntimeException("Keyword continue should be used in a loop");
    }
  }

  public void visit(ReturnStmtNode node) throws Exception {
    var scope = currentScope.getLastFunc();
    if (scope == null) {
      throw new RuntimeException("Keyword return should be used in a function");
    }
    TypeInfo returnType = ((FuncInfo) scope.getInfo()).getReturnType();
    if (node.getExpr() == null) {
      if (!returnType.equals(GlobalScope.voidType)) {
        throw new RuntimeException("Function should return a value");
      }
    } else {
      node.getExpr().accept(this);
      TypeInfo exprType = (TypeInfo) node.getExpr().getInfo();
      if (!returnType.equals(exprType)) {
        throw new RuntimeException("Function should return a value of type " + returnType.getName() + ", but got " + exprType.getName() + " instead at " + node.toString() + " " + node.position.toString());
      }
      ((FuncInfo) scope.getInfo()).exit();
    }
  }

  public void visit(ExprStmtNode node) throws Exception {
    for (ExprNode expr : node.exprs) {
      expr.accept(this);
      BaseInfo type = (TypeInfo) expr.getInfo();
      if (type instanceof FuncInfo) {
        throw new RuntimeException("Function call is not complete");
      }
    }
  }

  public void visit(VarDefStmtNode node) throws Exception {
    node.getDef().accept(this);
  }

  public void visit(EmptyStmtNode node) throws Exception {
  }
}
