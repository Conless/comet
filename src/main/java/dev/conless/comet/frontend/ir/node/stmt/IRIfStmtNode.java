package dev.conless.comet.frontend.ir.node.stmt;

import dev.conless.comet.frontend.ir.entity.IRVariable;
import dev.conless.comet.frontend.ir.node.inst.IRBranchNode;
import dev.conless.comet.frontend.ir.node.inst.IRJumpNode;
import dev.conless.comet.frontend.ir.node.inst.IRStoreNode;
import dev.conless.comet.frontend.ir.node.utils.IRLabelNode;

public class IRIfStmtNode extends IRStmtNode {
  public static int count = 0;

  public IRIfStmtNode(IRStmtNode cond, IRStmtNode body, IRStmtNode elseBody) {
    super();
    count++;
    var bodyTag = new IRLabelNode("if." + String.valueOf(count) + ".body");
    var elseTag = new IRLabelNode("if." + String.valueOf(count) + ".else");
    var endTag = new IRLabelNode("if." + String.valueOf(count) + ".end");
    appendNodes(cond);
    addNode(
        new IRBranchNode(cond.getDest(), bodyTag.getName(), elseBody == null ? endTag.getName() : elseTag.getName()));
    addNode(bodyTag);
    appendNodes(body);
    addNode(new IRJumpNode(endTag.getName()));
    if (elseBody != null) {
      addNode(elseTag);
      appendNodes(elseBody);
      addNode(new IRJumpNode(endTag.getName()));
    }
    addNode(endTag);
  }
  
  public IRIfStmtNode(IRStmtNode cond, IRStmtNode body, IRStmtNode elseBody, IRVariable destAddr) {
    super();
    count++;
    var bodyTag = new IRLabelNode("if." + String.valueOf(count) + ".body");
    var elseTag = new IRLabelNode("if." + String.valueOf(count) + ".else");
    var endTag = new IRLabelNode("if." + String.valueOf(count) + ".end");
    appendNodes(cond);
    addNode(
        new IRBranchNode(cond.getDest(), bodyTag.getName(), elseBody == null ? endTag.getName() : elseTag.getName()));
    addNode(bodyTag);
    appendNodes(body);
    addNode(new IRStoreNode(destAddr, body.getDest()));
    addNode(new IRJumpNode(endTag.getName()));
    if (elseBody != null) {
      addNode(elseTag);
      appendNodes(elseBody);
      addNode(new IRStoreNode(destAddr, elseBody.getDest()));
      addNode(new IRJumpNode(endTag.getName()));
    }
    addNode(endTag);
  }
}
