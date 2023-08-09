package dev.conless.comet.frontend.ast.node.expr;

import dev.conless.comet.frontend.ast.node.ASTNode;
import dev.conless.comet.frontend.utils.metadata.ExprInfo;
import lombok.experimental.SuperBuilder;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;

/**
 * The `ExprNode` class is an abstract class that extends `ASTNode` and includes a `BaseInfo` object.
 */
@SuperBuilder
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public abstract class ExprNode extends ASTNode {
  private ExprInfo info;
}
