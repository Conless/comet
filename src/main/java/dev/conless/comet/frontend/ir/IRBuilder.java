package dev.conless.comet.frontend.ir;

import dev.conless.comet.frontend.ast.*;
import dev.conless.comet.frontend.ast.node.*;
import dev.conless.comet.frontend.ast.node.def.*;
import dev.conless.comet.frontend.ast.node.expr.*;
import dev.conless.comet.frontend.ast.node.special.ProgramNode;
import dev.conless.comet.frontend.ast.node.stmt.*;
import dev.conless.comet.frontend.ast.node.type.*;
import dev.conless.comet.frontend.utils.metadata.*;
import dev.conless.comet.frontend.utils.scope.*;
import dev.conless.comet.frontend.ir.entity.*;
import dev.conless.comet.frontend.ir.node.*;
import dev.conless.comet.frontend.ir.node.inst.*;
import dev.conless.comet.frontend.ir.node.module.*;
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
    programNode = new IRProgramNode();
    for (var def : node.getDefs()) {
      if (def instanceof ClassDefNode) {
        programNode.addModule((IRModuleNode) def.accept(this));
      }
    }
    var globalDefModule = new IRGlobalDefNode();
    programNode.addModule(globalDefModule);
    var initModule = new IRFuncNode("init", new Array<>(), GlobalScope.irVoidType);
    programNode.addModule(initModule);
    for (var def : node.getDefs()) {
      if (def instanceof VarDefNode) {
        var instList = (IRInstListNode) def.accept(this);
        var first = false;
        for (var inst : instList.getInsts()) {
          if (!first) {
            first = true;
            ((IRGlobalDefNode) programNode.getModule("globalDef")).addInst(inst);
            continue;
          }
          programNode.getModule("init").getBlock("entry").addInst(inst);
        }
      }
    }
    for (var def : node.getDefs()) {
      if (def instanceof FuncDefNode) {
        programNode.addModule((IRModuleNode) def.accept(this));
      }
    }
    exitASTNode(node);
    return programNode;
  }

  @Override
  public IRNode visit(FuncDefNode node) throws BaseError {
    enterASTNode(node);
    var paramNodes = new Array<IRVariable>();
    for (var param : node.getParams()) {
      paramNodes.add(new IRVariable(new IRType(param.getType()), param.getName() + ".param", false));
    }
    var funcNode = new IRFuncNode(node.getName(), paramNodes, new IRType(node.getReturnType()));
    exitASTNode(node);
    return funcNode;
  }

  @Override
  public IRNode visit(ClassDefNode node) throws BaseError {
    enterASTNode(node);
    var vars = new Array<IRVariable>();
    for (var def : node.getVarDefs()) {
      vars.add(new IRVariable(new IRType(def.getType()), def.getName(), false));
    }
    var funcs = new Array<IRFuncNode>();
    for (var def : node.getFuncDefs()) {
      def.getParams().add(0, VarDefNode.builder().info(new VarInfo("this", new TypeInfo(node.getName(), 0))).build());
      var irFunc = (IRFuncNode) def.accept(this);
      irFunc.setName(node.getName() + "::" + irFunc.getName());
      funcs.add(irFunc);
    }
    var classNode = new IRClassDefNode(node.getName(), vars, funcs);
    exitASTNode(node);
    return classNode;
  }

  @Override
  public IRNode visit(VarDefNode node) throws BaseError {
    return null;
  }

  @Override
  public IRNode visit(TypeNameNode node) throws BaseError {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'visit'");
  }

  @Override
  public IRNode visit(ExprNode node) throws BaseError {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'visit'");
  }

  @Override
  public IRNode visit(NewExprNode node) throws BaseError {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'visit'");
  }

  @Override
  public IRNode visit(MemberExprNode node) throws BaseError {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'visit'");
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
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'visit'");
  }

  @Override
  public IRNode visit(VarDefStmtNode node) throws BaseError {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'visit'");
  }

  @Override
  public IRNode visit(EmptyStmtNode node) throws BaseError {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'visit'");
  } 
}
