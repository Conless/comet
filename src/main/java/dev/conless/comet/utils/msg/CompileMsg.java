package dev.conless.comet.utils.msg;

import dev.conless.comet.frontend.ast.node.ASTNode;
import dev.conless.comet.utils.container.Position;

public class CompileMsg {
  private String content;

  public CompileMsg() {
    this.content = "";
  }

  public CompileMsg(String content) {
    if (!content.equals(" ")) {
      this.content = "Compile Error: " + content;
    } else {
      this.content = "";
    }
  }

  public CompileMsg(String msg, Position pos) {
    this.content = "Compile Error: " + msg + " at " + pos.toString() + ".";
  }

  public CompileMsg(String msg, ASTNode node) {
    this.content = "Compile Error: " + msg + " in " + node.toString() + " at " + node.getPosition().toString() + ".";
  }

  public void append(CompileMsg msg) {
    if (this.content.equals("")) {
      this.content = msg.content;
    } else {
      if (!this.content.endsWith("\n")) {
        this.content += "\n";
      }
      this.content += msg.content;
    }
  }

  public boolean isEmpty() {
    return this.content.equals("");
  }

  @Override
  public String toString() {
    return content;
  }
}
