package dev.conless.comet.frontend.ir.node.stmt;

import dev.conless.comet.frontend.ir.entity.IRLiteral;
import dev.conless.comet.frontend.ir.node.inst.IRBranchNode;
import dev.conless.comet.frontend.ir.node.inst.IRJumpNode;
import dev.conless.comet.frontend.ir.node.utils.IRLabelNode;
import dev.conless.comet.frontend.utils.scope.GlobalScope;

public class IRLoopStmtNode extends IRStmtNode {
  public static int count = 0;

  public static int addCount() {
    return ++count;
  }

  public IRLoopStmtNode(int num, IRStmtNode init, IRStmtNode cond, IRStmtNode update, IRStmtNode body) {
    super();
    var condTag = new IRLabelNode("loop." + String.valueOf(num) + ".cond");
    var updateTag = new IRLabelNode("loop." + String.valueOf(num) + ".update");
    var bodyTag = new IRLabelNode("loop." + String.valueOf(num) + ".body");
    var endTag = new IRLabelNode("loop." + String.valueOf(num) + ".end");
    if (init != null) {
      appendNodes(init);
    }
    addNode(new IRJumpNode(condTag.getName()));
    addNode(condTag);
    if (cond != null) {
      appendNodes(cond);
      addNode(new IRBranchNode(cond.getDest(), bodyTag.getName(), endTag.getName()));
    } else {
      addNode(new IRBranchNode(new IRLiteral(GlobalScope.irBoolType, 1), bodyTag.getName(), endTag.getName()));
    }
    addNode(bodyTag);
    appendNodes(body);
    addNode(new IRJumpNode(updateTag.getName()));
    addNode(updateTag);
    if (update != null) {
      appendNodes(update);
    }
    addNode(new IRJumpNode(condTag.getName()));
    addNode(endTag);
  }
}
