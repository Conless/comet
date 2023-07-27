package dev.conless.comet;

import org.antlr.v4.runtime.*;

import dev.conless.comet.frontend.grammar.*;

public class Compiler {
  public static void main(String[] args) {
    CharStream input = CharStreams.fromString("");
    Meteor lexer = new Meteor(input);
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    Comet parser = new Comet(tokens);
  }
}
