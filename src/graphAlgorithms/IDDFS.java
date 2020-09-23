package graphAlgorithms;

import java.util.Deque;
import java.util.LinkedList;

public class IDDFS {

    private Node targetVertex;
    private volatile boolean isTargetFound;

    public IDDFS(Node targetVertex) {
        this.targetVertex = targetVertex;
    }

    public void runDeepeningSearch(Node root) {
        int depth = 0;
        while (!isTargetFound) {
            System.out.println();
            dfs(root, depth);
            depth++;
        }
    }

    private void dfs(Node sourceVertex, int depthLevel) {
        Deque<Node> stack = new LinkedList<>();
        sourceVertex.setDepthLevel(0);
        stack.push(sourceVertex);
        while (!stack.isEmpty()) {
            Node actualNode = stack.pop();
            System.out.print(actualNode + " ");
            if (actualNode.getName().equals(this.targetVertex.getName())) {
                System.out.println("Node has been found...");
                this.isTargetFound = true;
                return;
            }
            if (actualNode.getDepthLevel() >= depthLevel) {
                continue;
            }
            for (Node node : actualNode.getNeighboursList()) {
                node.setDepthLevel(actualNode.getDepthLevel() + 1);
                stack.push(node);
            }
        }
    }
}
