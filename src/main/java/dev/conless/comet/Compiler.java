package dev.conless.comet;

import org.antlr.v4.runtime.*;

import dev.conless.comet.frontend.ast.*;
import dev.conless.comet.frontend.grammar.*;
import dev.conless.comet.frontend.semantic.*;
import dev.conless.comet.utils.error.*;

public class Compiler {
  public static void main(String[] args) throws Exception {
    try {
      // var input = CharStreams.fromStream(new FileInputStream("./src/test/mx/input.mx"));
      var input = CharStreams.fromStream(System.in);
      Meteor lexer = new Meteor(input);
      lexer.removeErrorListeners();
      lexer.addErrorListener(new CometErrorListener());
      CommonTokenStream tokens = new CommonTokenStream(lexer);
      Comet parser = new Comet(tokens);
      parser.removeErrorListeners();
      parser.addErrorListener(new CometErrorListener());
      ASTNode program = new ASTBuilder().visit(parser.program());
      // var output = new FileOutputStream("./src/test/mx/output.mx");
      // output.write(program.toString().getBytes());
      SymbolCollector collector = new SymbolCollector();
      collector.visit((ProgramNode) program);
      // output.write(((ProgramNode) program).scope.toString().getBytes());
      SemanticChecker checker = new SemanticChecker();
      checker.visit((ProgramNode) program);
      // output.close();
    } catch (Exception e) {
      System.out.println(e.toString());
      System.exit(1);
    } finally {
      System.out.println("Compile successfully");
      System.exit(0);
    }
  }
}
