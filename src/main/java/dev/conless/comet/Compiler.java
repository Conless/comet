package dev.conless.comet;

import java.io.*;

import org.antlr.v4.runtime.*;

import dev.conless.comet.frontend.ast.*;
import dev.conless.comet.frontend.ast.node.*;
import dev.conless.comet.frontend.ast.node.special.ProgramNode;
import dev.conless.comet.frontend.grammar.*;
import dev.conless.comet.frontend.ir.*;
import dev.conless.comet.frontend.ir.node.*;
import dev.conless.comet.frontend.semantic.*;
import dev.conless.comet.utils.error.*;

public class Compiler {
  public static void main(String[] args) throws Exception {
    var input = CharStreams.fromStream(new FileInputStream("./src/test/mx/input.mx"));
    // var input = CharStreams.fromStream(System.in);
    // var output = new FileOutputStream("./src/test/mx/output.mx");
    Meteor lexer = new Meteor(input);
    lexer.removeErrorListeners();
    lexer.addErrorListener(new CometErrorListener());
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    Comet parser = new Comet(tokens);
    parser.removeErrorListeners();
    parser.addErrorListener(new CometErrorListener());
    ASTNode astProgram = new ASTBuilder().visit(parser.program());
    new SemanticChecker().visit((ProgramNode) astProgram);
    // output.write(astProgram.toString().getBytes());
    // System.exit(0);
    IRNode irProgram = new IRBuilder().visit((ProgramNode) astProgram);
    var output = new FileOutputStream("./src/test/mx/output.ll");
    output.write(irProgram.toString().getBytes());
    output.close();
  }
}
