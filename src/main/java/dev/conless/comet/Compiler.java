package dev.conless.comet;

import java.io.*;

import org.antlr.v4.runtime.*;

import dev.conless.comet.backend.asm.InstSelector;
import dev.conless.comet.backend.asm.node.ASMNode;
import dev.conless.comet.backend.asm.node.ASMRoot;
import dev.conless.comet.backend.asm.utils.BasicAllocator;
import dev.conless.comet.frontend.ast.*;
import dev.conless.comet.frontend.ast.node.*;
import dev.conless.comet.frontend.grammar.*;
import dev.conless.comet.frontend.ir.*;
import dev.conless.comet.frontend.ir.node.*;
import dev.conless.comet.frontend.semantic.*;
import dev.conless.comet.utils.error.*;

public class Compiler {
  public static void main(String[] args) throws Exception {
  // try {
    var input = CharStreams.fromStream(new FileInputStream("./src/test/mx/input.mx"));
    // var input = CharStreams.fromStream(System.in);
    Meteor lexer = new Meteor(input);
    lexer.removeErrorListeners();
    lexer.addErrorListener(new CometErrorListener());
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    Comet parser = new Comet(tokens);
    parser.removeErrorListeners();
    parser.addErrorListener(new CometErrorListener());
    ASTNode astProgram = new ASTBuilder().visit(parser.program());
    new SemanticChecker().visit((ASTRoot) astProgram);
    var output = new FileOutputStream("./src/test/mx/output.mx");
    output.write(astProgram.toString().getBytes());
    output.close();
    IRNode irProgram = new IRBuilder().visit((ASTRoot) astProgram);
    output = new FileOutputStream("./src/test/mx/output.ll");
    output.write(irProgram.toString().getBytes());
    output.close();
    ASMNode asmProgram = new InstSelector().visit((IRRoot) irProgram);
    output = new FileOutputStream("./src/test/mx/output.raw.s");
    output.write(asmProgram.toString().getBytes());
    output.close();
    new BasicAllocator().visit((ASMRoot) asmProgram);
    output = new FileOutputStream("./src/test/mx/output.s");
    output.write(asmProgram.toString().getBytes());
    output.close();
  // } catch (BaseError e) {
  //   System.err.println(e.getMessage());
  //   System.exit(1);
  // }
  }
}
