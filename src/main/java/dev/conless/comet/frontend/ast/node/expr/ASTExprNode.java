package dev.conless.comet.frontend.ast.node.expr;

import dev.conless.comet.frontend.ast.node.ASTNode;
import dev.conless.comet.frontend.utils.metadata.ExprInfo;

/**
 * The `ExprNode` class is an abstract class that extends `ASTNode` and includes a `BaseInfo` object.
 */
@lombok.experimental.SuperBuilder
@lombok.Getter
@lombok.Setter
@lombok.EqualsAndHashCode(callSuper = false)
public abstract class ASTExprNode extends ASTNode {
  private ExprInfo info;
}
