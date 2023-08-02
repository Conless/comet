package dev.conless.comet.frontend.semantic;

import dev.conless.comet.frontend.ast.*;
import dev.conless.comet.frontend.ast.def.*;
import dev.conless.comet.frontend.ast.expr.*;
import dev.conless.comet.frontend.ast.stmt.*;
import dev.conless.comet.frontend.ast.type.*;
import dev.conless.comet.utils.Type;
import dev.conless.comet.utils.metadata.*;
import dev.conless.comet.utils.scope.ClassScope;

public class SemanticChecker extends ScopeManager implements ASTVisitor {
  public void visit(ASTNode node) throws Exception {
    throw new Exception("SemanticChecker.visit(ASTNode) should not be called");
  }

  public void visit(ProgramNode node) throws Exception {
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
    if (!node.getReturnType().equals(new TypeInfo("void", 0)) && !node.getInfo().getName().equals("main")) {
      if (!((FuncInfo) currentScope.getInfo()).isExited()) {
        throw new Exception("Function " + node.getName() + " should have a return statement");
      }
    }
    exitScope();
  }

  public void visit(ClassDefNode node) throws Exception {
    node.addScope(currentScope);
    enterScope(node.getScope());
    for (var funcDef : node.getFuncDefs()) {
      funcDef.accept(this);
    }
    exitScope();
  }

  public void visit(VarDefNode node) throws Exception {
    TypeInfo type = (TypeInfo) node.getInfo();
    if (!type.isBuiltIn && globalScope.get(type.getName(), "class") == null) {
      throw new Exception("Type " + type.getName() + " is not defined");
    }
    for (var v : node.vars) {
      if (currentScope.get(v.a) != null) {
        throw new Exception(v.a + " is already defined");
      } else {
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
    TypeInfo type = (TypeInfo)node.getInfo();
    if (!checkTypeValid(type)) {
      throw new RuntimeException("Type " + type.getName() + " is not defined");
    }
    node.setEditable(false);
  }

  public void visit(MemberExprNode node) throws Exception {
    node.object.accept(this);
    TypeInfo objectType = (TypeInfo) node.object.getInfo();
    if (objectType.depth > 0) {
      if (node.member.equals("length")) {
        node.setInfo(new TypeInfo("int", 0));
      } else {
        throw new RuntimeException("Type " + objectType.getName() + " does not have member " + node.member);
      }
    } else {
      ClassInfo classInfo = (ClassInfo) globalScope.get(objectType.getName(), "class");
      if (classInfo == null) {
        throw new RuntimeException("Type " + objectType.getName() + " is not a valid class");
      }
      BaseInfo memberInfo = classInfo.get(node.member);
      if (memberInfo == null) {
        throw new RuntimeException("Type " + objectType.getName() + " does not have member " + node.member);
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
      throw new RuntimeException("Type " + node.func.getInfo().getName() + " is not callable");
    }
    FuncInfo funcInfo = (FuncInfo) node.func.getInfo();
    if (funcInfo.getParams().size() != node.args.size()) { // TODO: add support for default parameters
      throw new RuntimeException(
          "Function " + funcInfo.getName() + " should have " + funcInfo.getParams().size() + " arguments");
    }
    for (int i = 0; i < node.args.size(); i++) {
      TypeInfo argType = (TypeInfo) node.args.get(i).getInfo();
      TypeInfo paramType = funcInfo.getParams().get(i);
      if (!argType.equals(paramType)) {
        throw new RuntimeException("Argument " + i + " should be of type " + paramType.getName());
      }
    }
    node.setInfo(funcInfo.getReturnType());
    node.setEditable(false);
  }

  public void visit(IndexExprNode node) throws Exception {
    node.array.accept(this);
    TypeInfo arrayType = (TypeInfo) node.array.getInfo();
    if (arrayType.depth == 0) {
      throw new RuntimeException("Type " + arrayType.getName() + " is not an array");
    }
    node.index.accept(this);
    TypeInfo indexType = (TypeInfo) node.index.getInfo();
    if (indexType.equals(new TypeInfo("int", 0))) {
      throw new RuntimeException("Index should be of type int");
    }
    node.setInfo(new TypeInfo(arrayType.getName(), arrayType.depth - 1));
    node.setEditable(node.array.isEditable());
  }

  public void visit(PostUnaryExprNode node) throws Exception {
    node.expr.accept(this);
    TypeInfo type = (TypeInfo) node.expr.getInfo();
    if (!type.equals(new TypeInfo("int", 0))) {
      throw new RuntimeException("Operand should be of type int");
    }
    node.setInfo(new TypeInfo("int", 0));
    node.setEditable(false);
  }

  public void visit(PreUnaryExprNode node) throws Exception {
    node.expr.accept(this);
    TypeInfo type = (TypeInfo) node.expr.getInfo();
    node.setEditable(false);
    if (node.op.equals("!")) {
      if (!type.equals(new TypeInfo("bool", 0))) {
        throw new RuntimeException("Operand should be of type bool");
      }
      node.setInfo(new TypeInfo("bool", 0));
    } else {
      if (!type.equals(new TypeInfo("int", 0))) {
        throw new RuntimeException("Operand should be of type int");
      }
      node.setInfo(new TypeInfo("int", 0));
      if (node.op.equals("++") || node.op.equals("--")) {
        if (!node.expr.isEditable()) {
          throw new RuntimeException("Operand should be a lvalue");
        }
        node.expr.setEditable(true);
      }
    }
  }

  public void visit(BinaryExprNode node) throws Exception {
    node.lhs.accept(this);
    node.rhs.accept(this);
    TypeInfo lhsType = (TypeInfo) node.lhs.getInfo();
    TypeInfo rhsType = (TypeInfo) node.rhs.getInfo();
    if (!lhsType.equals(rhsType)) {
      throw new RuntimeException("Operands should be of the same type");
    }
    if (node.op.equals("<") || node.op.equals(">") || node.op.equals("<=") || node.op.equals(">=") || node.op.equals("==") || node.op.equals("!=")) {
      node.setInfo(new TypeInfo("bool", 0));
    } else {
      node.setInfo(lhsType);
    }
    node.setEditable(false);
    if (lhsType.depth > 0) { // TODO: compare two arrays?
      if (!node.op.equals("==") && !node.op.equals("!=")) {
        throw new RuntimeException("Operator " + node.op + " is not supported for arrays");
      }
      return;
    }
    if (lhsType.equals(new TypeInfo("bool", 0))) {
      if (!node.op.equals("==") && !node.op.equals("!=")) {
        throw new RuntimeException("Operator " + node.op + " is not supported for booleans");
      }
      return;
    }
    if (lhsType.equals(new TypeInfo("string", 0))) {
      if (!node.op.equals("+") && !node.op.equals("==") && !node.op.equals("!=") && !node.op.equals("<") && !node.op.equals("<=") && !node.op.equals(">")
          && !node.op.equals(">=")) {
        throw new RuntimeException("Operator " + node.op + " is not supported for strings");
      }
      return;
    }
    if (lhsType.equals(new TypeInfo("int", 0))) {
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
    if (!conditionType.equals(new TypeInfo("bool", 0))) {
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
      throw new RuntimeException("Operands should be of the same type");
    }
    if (!node.lhs.isEditable()) {
      throw new RuntimeException("Operand should be a lvalue");
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
        throw new RuntimeException("Unknown identifier " + node.toString());
      }
      return;
    }
    node.setEditable(false);
    if (node.atomType == Type.INT) {
      node.setInfo(new TypeInfo("int", 0));
      return;
    }
    if (node.atomType == Type.STRING) {
      node.setInfo(new TypeInfo("string", 0));
      return;
    }
    if (node.atomType == Type.BOOL) {
      node.setInfo(new TypeInfo("bool", 0));
      return;
    }
    if (node.atomType == Type.NULL) {
      node.setInfo(new TypeInfo("null", 0));
      return;
    }
    if (node.atomType == Type.THIS) {
      if (currentScope instanceof ClassScope) {
        node.setInfo(new TypeInfo(currentScope.getInfo().getName(), 0));
      } else {
        throw new RuntimeException("Keyword this should be used in a class");
      }
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
    if (!conditionType.equals(new TypeInfo("bool", 0))) {
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
    }
  }

  public void visit(ForStmtNode node) throws Exception {
    node.addScope(currentScope);
    enterScope(node.getScope());
    node.init.accept(this);
    node.condition.accept(this);
    TypeInfo conditionType = (TypeInfo) node.condition.getInfo();
    if (!conditionType.equals(new TypeInfo("bool", 0))) {
      throw new RuntimeException("Condition should be of type bool");
    }
    node.update.accept(this);
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
    enterScope(currentScope);
    node.condition.accept(this);
    TypeInfo conditionType = (TypeInfo) node.condition.getInfo();
    if (!conditionType.equals(new TypeInfo("bool", 0))) {
      throw new RuntimeException("Condition should be of type bool");
    }
    if (node.body instanceof BlockStmtNode) {
      for (StmtNode stmt : ((BlockStmtNode) node.body).getStmts()) {
        stmt.accept(this);
      }
    } else {
      node.body.accept(this);
    }
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
      if (!returnType.equals(new TypeInfo("void", 0))) {
        throw new RuntimeException("Function should return a value");
      }
    } else {
      node.getExpr().accept(this);
      TypeInfo exprType = (TypeInfo) node.getExpr().getInfo();
      if (!returnType.equals(exprType)) {
        throw new RuntimeException("Function should return a value of type " + returnType.getName());
      }
      ((FuncInfo) scope.getInfo()).exit();
    }
  }

  public void visit(ExprStmtNode node) throws Exception {
    for (ExprNode expr : node.exprs) {
      expr.accept(this);
    }
  }

  public void visit(VarDefStmtNode node) throws Exception {
    node.getDef().accept(this);
  }

  public void visit(EmptyStmtNode node) throws Exception {
  }
}
