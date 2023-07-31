package dev.conless.comet.frontend.ast.expr;

import java.util.ArrayList;

import dev.conless.comet.frontend.ast.TypeNameNode;
import dev.conless.comet.utils.Position;

public class NewExprNode extends ExprNode {
  public TypeNameNode typename;
  public ArrayList<Integer> lengths;

  public NewExprNode(Position position) {
    super(position);
    lengths = new ArrayList<Integer>();
  }

  @Override
  public String toString() {
    return "new " + typename.toString() + "(" + lengths.toString() + ")";
  }
}
