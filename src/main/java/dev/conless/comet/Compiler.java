package dev.conless.comet;

import java.io.*;

import org.antlr.v4.runtime.*;

import dev.conless.comet.frontend.ast.*;
import dev.conless.comet.frontend.grammar.*;

public class Compiler {
  public static void main(String[] args) throws Exception {
    var input = CharStreams.fromStream(new FileInputStream("./src/test/mx/input.mx"));
    Meteor lexer = new Meteor(input);
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    Comet parser = new Comet(tokens);
    ASTNode program = new ASTBuilder().visit(parser.program());
    var output = new FileOutputStream("./src/test/mx/output.mx");
    output.write(program.toString().getBytes());
    output.close();
  }
}
