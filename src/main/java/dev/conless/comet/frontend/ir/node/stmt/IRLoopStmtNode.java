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
      appendInsts(init);
    }
    addInst(new IRJumpNode(condTag.getName()));
    addInst(condTag);
    if (cond != null) {
      appendInsts(cond);
      addInst(new IRBranchNode(cond.getDest(), bodyTag.getName(), endTag.getName()));
    } else {
      addInst(new IRBranchNode(new IRLiteral(GlobalScope.irBoolType, 1), bodyTag.getName(), endTag.getName()));
    }
    addInst(bodyTag);
    appendInsts(body);
    addInst(new IRJumpNode(updateTag.getName()));
    addInst(updateTag);
    if (update != null) {
      appendInsts(update);
    }
    addInst(new IRJumpNode(condTag.getName()));
    addInst(endTag);
  }
}
