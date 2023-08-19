package dev.conless.comet.frontend.ir.node.stmt;

import dev.conless.comet.frontend.ir.node.inst.IRBranchNode;
import dev.conless.comet.frontend.ir.node.inst.IRJumpNode;
import dev.conless.comet.frontend.ir.node.utils.IRLabelNode;

public class IRLoopStmtNode extends IRStmtNode {
  public static int count = 0;

  public static int IncreaseCount() {
    return ++count;
  }

  public IRLoopStmtNode(int num, IRStmtNode init, IRStmtNode cond, IRStmtNode update, IRStmtNode body) {
    super();
    var condTag = new IRLabelNode("loop." + String.valueOf(num) + ".cond");
    var bodyTag = new IRLabelNode("loop." + String.valueOf(num) + ".body");
    var endTag = new IRLabelNode("loop." + String.valueOf(num) + ".end");
    if (init != null) {
      appendNodes(init);
    }
    if (cond != null) {
      addNode(new IRJumpNode(condTag.getName()));
      addNode(condTag);
      appendNodes(cond);
      addNode(new IRBranchNode(cond.getDest(), bodyTag.getName(), endTag.getName()));
    } else {
      addNode(new IRJumpNode(bodyTag.getName()));
    }
    addNode(bodyTag);
    appendNodes(body);
    if (update != null) {
      appendNodes(update);
    }
    if (cond != null) {
      addNode(new IRJumpNode(condTag.getName()));
    } else {
      addNode(new IRJumpNode(bodyTag.getName()));
    }
    addNode(endTag);
  }
}
