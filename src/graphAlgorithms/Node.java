package graphAlgorithms;

import java.util.ArrayList;
import java.util.List;

public class Node {

    private String name;
    private int depthLevel = 0;
    private List<Node> neighboursList;

    public Node(String name) {
        this.name = name;
        this.neighboursList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getDepthLevel() {
        return depthLevel;
    }

    public void setDepthLevel(int depthLevel) {
        this.depthLevel = depthLevel;
    }

    public void addNeighbour(Node node) {
        this.neighboursList.add(node);
    }

    public List<Node> getNeighboursList() {
        return neighboursList;
    }

    public void setNeighboursList(List<Node> neighboursList) {
        this.neighboursList = neighboursList;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
