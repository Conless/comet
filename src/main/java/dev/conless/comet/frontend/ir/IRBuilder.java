package dev.conless.comet.frontend.ir;

import dev.conless.comet.frontend.ast.*;
import dev.conless.comet.frontend.ast.node.*;
import dev.conless.comet.frontend.ast.node.def.*;
import dev.conless.comet.frontend.ast.node.expr.*;
import dev.conless.comet.frontend.ast.node.global.ProgramNode;
import dev.conless.comet.frontend.ast.node.stmt.*;
import dev.conless.comet.frontend.ast.node.type.*;
import dev.conless.comet.frontend.utils.metadata.*;
import dev.conless.comet.frontend.utils.scope.*;
import dev.conless.comet.frontend.ir.entity.*;
import dev.conless.comet.frontend.ir.node.*;
import dev.conless.comet.frontend.ir.node.global.*;
import dev.conless.comet.frontend.ir.node.inst.*;
import dev.conless.comet.frontend.ir.node.utils.IRExprNode;
import dev.conless.comet.frontend.ir.type.*;
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
    for (var def : node.getDefs()) {
      if (def instanceof ClassDefNode) {
        var defs = (IRExprNode) def.accept(this);
        program.addDef((IRGlobalDefNode) defs.getNodes().get(0));
        defs.getNodes().remove(0);
        for (var func : defs.getNodes()) {
          program.addFunc((IRFuncNode) func);
        }
      }
    }
    program.addDef(new IRGlobalDefNode(new IRVariable(GlobalScope.irArrayType, "builtIn.Array", false)));
    program.addDef(new IRGlobalDefNode(new IRVariable(GlobalScope.irStringType, "builtIn.String", false)));
    var initFunc = new IRFuncNode("__global_var_init", new Array<>(), GlobalScope.irVoidType);
    program.addFunc(initFunc);
    for (var def : node.getDefs()) {
      if (def instanceof VarDefNode) {
        var exprs = (IRExprNode) def.accept(this);
        program.addDef((IRGlobalDefNode) exprs.getNodes().get(0));
        exprs.getNodes().remove(0);
        for (var expr : exprs.getNodes()) {
          initFunc.addNode(expr);
        }

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
      paramNodes.add(new IRVariable(new IRType(param.getType()), getVarName(param.getName()) + ".param", false));
    }
    var funcNode = new IRFuncNode(node.getName(), paramNodes, new IRType(node.getReturnType()));
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
      vars.add(new IRType(def.getType()));
    }
    var type = new IRStructType(node.getName(), vars);
    var classNode = new IRGlobalDefNode(new IRVariable(type, "class." + node.getName(), false));
    nodes.addNode(classNode);
    for (var def : node.getFuncDefs()) {
      def.getParams().add(0, VarDefNode.builder().info(new VarInfo("this", new TypeInfo(node.getName(), 0))).build());
      var irFunc = (IRFuncNode) def.accept(this);
      irFunc.setName(node.getName() + "::" + irFunc.getName());
      nodes.addNode(irFunc);
    }
    exitASTNode(node);
    return nodes;
  }

  @Override
  public IRNode visit(VarDefNode node) throws BaseError {
    enterASTNode(node);
    var instList = new IRExprNode();
    boolean isGlobal = currentScope instanceof GlobalScope;
    var var = new IRVariable(new IRType(node.getType()), getVarName(node.getName()), isGlobal);
    if (isGlobal) {
      instList.addNode(new IRGlobalDefNode(var));
    } else {
      instList.addNode(new IRAllocaNode(var, new IRType(node.getType())));
    }
    if (node.getInit() != null) {
      var init = (IRExprNode) node.getInit().accept(this);
      instList.appendNodes(init);
      if (!(init.getDest() instanceof IRVariable)) {
        throw new RuntimeError("IRBuilder.visit(VarDefNode) init.getDest() should be IRVariable");
      }
      instList.addNode(new IRStoreNode(var, (IRVariable) init.getDest()));
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
    var instList = new IRExprNode();
    var objectType = (TypeInfo) node.getObject().getInfo().getType();
    var objectInst = (IRExprNode) node.getObject().accept(this);
    instList.appendNodes(objectInst);
    var object = objectInst.getDest();
    if (infoType instanceof FuncInfo) {
      instList.setDest(new IRFunc(null));
    }
  }

  @Override
  public IRNode visit(CallExprNode node) throws BaseError {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'visit'");
  }

  @Override
  public IRNode visit(ArrayExprNode node) throws BaseError {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'visit'");
  }

  @Override
  public IRNode visit(PostUnaryExprNode node) throws BaseError {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'visit'");
  }

  @Override
  public IRNode visit(PreUnaryExprNode node) throws BaseError {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'visit'");
  }

  @Override
  public IRNode visit(BinaryExprNode node) throws BaseError {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'visit'");
  }

  @Override
  public IRNode visit(ConditionalExprNode node) throws BaseError {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'visit'");
  }

  @Override
  public IRNode visit(AssignExprNode node) throws BaseError {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'visit'");
  }

  @Override
  public IRNode visit(AtomExprNode node) throws BaseError {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'visit'");
  }

  @Override
  public IRNode visit(StmtNode node) throws BaseError {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'visit'");
  }

  @Override
  public IRNode visit(BlockStmtNode node) throws BaseError {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'visit'");
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
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'visit'");
  }

  @Override
  public IRNode visit(ExprStmtNode node) throws BaseError {
    var instList = new IRExprNode();
    for (var expr : node.getExprs()) {
      instList.appendNodes((IRExprNode) expr.accept(this));
    }
    return instList;
  }

  @Override
  public IRNode visit(VarDefStmtNode node) throws BaseError {
    var instList = new IRExprNode();
    for (var def : node.getDefs()) {
      instList.appendNodes((IRExprNode) def.accept(this));
    }
    return instList;
  }

  @Override
  public IRNode visit(EmptyStmtNode node) throws BaseError {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'visit'");
  }
}
