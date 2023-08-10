package dev.conless.comet.frontend.ast.node.type;

import dev.conless.comet.frontend.ast.ASTVisitor;
import dev.conless.comet.frontend.ast.node.ASTNode;
import dev.conless.comet.frontend.utils.metadata.TypeInfo;
import dev.conless.comet.utils.error.BaseError;

import lombok.experimental.SuperBuilder;
import lombok.Value;
import lombok.EqualsAndHashCode;

/**
 * The TypeNameNode class represents a node in an abstract syntax tree (AST) that contains information
 * about a type name.
 */
@SuperBuilder
@Value
@EqualsAndHashCode(callSuper = true)
public final class TypeNameNode extends ASTNode {
  private TypeInfo info;

  public String getName() {
    return info.getName();
  }

  @Override
  public String toString() {
    String str = info.getName();
    for (int i = 1; i <= info.depth; i++) {
      str += "[]";
    }
    return str;
  }

  @Override
  public <T> T accept(ASTVisitor<T> visitor) throws BaseError {
    return visitor.visit(this);
  }
}
