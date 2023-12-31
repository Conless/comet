package dev.conless.comet.frontend.ir.node.stmt;

import dev.conless.comet.frontend.ir.entity.IRVariable;
import dev.conless.comet.frontend.ir.node.inst.IRBranchNode;
import dev.conless.comet.frontend.ir.node.inst.IRJumpNode;
import dev.conless.comet.frontend.ir.node.inst.IRStoreNode;
import dev.conless.comet.frontend.ir.node.utils.IRLabelNode;

@lombok.Setter
@lombok.Getter
public class IRIfStmtNode extends IRStmtNode {
  public static int count = 0;
  private String condLabel, bodyLabel, elseLabel;

  public static int addCount() {
    return ++count;
  }

  public IRIfStmtNode(int num, IRStmtNode cond, IRStmtNode body, IRStmtNode elseBody) {
    super();
    var condLabel = new IRLabelNode("if." + String.valueOf(num) + ".cond");
    var bodyLabel = new IRLabelNode("if." + String.valueOf(num) + ".body");
    var elseLabel = new IRLabelNode("if." + String.valueOf(num) + ".else");
    var endLabel = new IRLabelNode("if." + String.valueOf(num) + ".end");
    addInst(new IRJumpNode(condLabel.getName()));
    cond.addFront(condLabel);
    appendInsts(cond);
    this.condLabel = cond.getLastLabel();
    addInst(
        new IRBranchNode(cond.getDest(), body == null ? endLabel.getName() : bodyLabel.getName(),
            elseBody == null ? endLabel.getName() : elseLabel.getName()));
    if (body != null) {
      body.addFront(bodyLabel);
      this.bodyLabel = body.getLastLabel();
      appendInsts(body);
      addInst(new IRJumpNode(endLabel.getName()));
    }
    if (elseBody != null) {
      elseBody.addFront(elseLabel);
      this.elseLabel = elseBody.getLastLabel();
      appendInsts(elseBody);
      addInst(new IRJumpNode(endLabel.getName()));
    }
    addInst(endLabel);
  }
}
