package dev.conless.comet.frontend.ir.node.stmt;

import dev.conless.comet.frontend.ir.entity.IRVariable;
import dev.conless.comet.frontend.ir.node.inst.IRBranchNode;
import dev.conless.comet.frontend.ir.node.inst.IRJumpNode;
import dev.conless.comet.frontend.ir.node.inst.IRStoreNode;
import dev.conless.comet.frontend.ir.node.utils.IRLabelNode;

public class IRIfStmtNode extends IRStmtsNode {
  public static int count = 0;

  public static int addCount() {
    return ++count;
  }

  public IRIfStmtNode(int num, IRStmtsNode cond, IRStmtsNode body, IRStmtsNode elseBody) {
    super();
    var bodyTag = new IRLabelNode("if." + String.valueOf(num) + ".body");
    var elseTag = new IRLabelNode("if." + String.valueOf(num) + ".else");
    var endTag = new IRLabelNode("if." + String.valueOf(num) + ".end");
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
  
  public IRIfStmtNode(int num, IRStmtsNode cond, IRStmtsNode body, IRStmtsNode elseBody, IRVariable destAddr) {
    super();
    var bodyTag = new IRLabelNode("if." + String.valueOf(num) + ".body");
    var elseTag = new IRLabelNode("if." + String.valueOf(num) + ".else");
    var endTag = new IRLabelNode("if." + String.valueOf(num) + ".end");
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
