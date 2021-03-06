package graphAlgorithms.AStarSearh;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import static graphAlgorithms.AStarSearh.Constants.*;

public class AStarSearch {

    private Node[][] searchSpace;
    private Node startNode;
    private Node finalNode;
    private List<Node> closedSet;
    private Queue<Node> openSet;

    public AStarSearch() {
        this.searchSpace = new Node[NUM_ROWS][NUM_COLS];
        this.openSet = new PriorityQueue<>(new NodeComparator());
        this.closedSet = new ArrayList<>();
        initializeSearchSpace();
    }

    private void initializeSearchSpace() {
        for (int rowIndex = 0; rowIndex < NUM_ROWS; rowIndex++) {
            for (int colIndex = 0; colIndex < NUM_COLS; colIndex++) {
                Node node = new Node(rowIndex, colIndex);
                this.searchSpace[rowIndex][colIndex] = node;
            }
        }

        this.searchSpace[1][7].setBlock(true);
        this.searchSpace[2][3].setBlock(true);
        this.searchSpace[2][4].setBlock(true);
        this.searchSpace[2][5].setBlock(true);
        this.searchSpace[2][6].setBlock(true);
        this.searchSpace[2][7].setBlock(true);

        this.startNode = this.searchSpace[3][3];
        this.finalNode = this.searchSpace[1][6];

    }

    public void search() {
        startNode.setH(manhattanHeuristic(startNode, finalNode));
        openSet.add(startNode);

        while (!openSet.isEmpty()) {
            Node currentNode = openSet.poll();
            System.out.println(currentNode + " Predecessor is:" + currentNode.getPredecessor());

            if (currentNode.equals(finalNode)) return;

            openSet.remove(currentNode);
            closedSet.add(currentNode);

            for (Node neighbor : getAllNeighbors(currentNode)) {
                if (closedSet.contains(neighbor)) continue;
                if (!openSet.contains(neighbor)) openSet.add(neighbor);
                neighbor.setPredecessor(currentNode);
            }
        }
    }

    public List<Node> getAllNeighbors(Node node) {
        List<Node> neighbors = new ArrayList<>();
        int row = node.getRowIndex();
        int col = node.getColIndex();
        if (row - 1 >= 0 && !this.searchSpace[row - 1][col].isBlock()) {
            searchSpace[row - 1][col].setG(node.getG() + HORIZONTAL_VERTICAL_COST);
            searchSpace[row - 1][col].setH(manhattanHeuristic(searchSpace[row - 1][col], finalNode));
            neighbors.add(this.searchSpace[row - 1][col]);
        }
        if (row + 1 < NUM_ROWS && !this.searchSpace[row + 1][col].isBlock()) {
            searchSpace[row + 1][col].setG(node.getG() + HORIZONTAL_VERTICAL_COST);
            searchSpace[row + 1][col].setH(manhattanHeuristic(searchSpace[row + 1][col], finalNode));
            neighbors.add(this.searchSpace[row + 1][col]);
        }
        if (col - 1 >= 0 && !this.searchSpace[row][col - 1].isBlock()) {
            searchSpace[row][col - 1].setG(node.getG() + HORIZONTAL_VERTICAL_COST);
            searchSpace[row][col - 1].setH(manhattanHeuristic(searchSpace[row][col - 1], finalNode));
            neighbors.add(this.searchSpace[row][col - 1]);
        }
        if (col + 1 < NUM_COLS && !this.searchSpace[row][col + 1].isBlock()) {
            searchSpace[row][col + 1].setG(node.getG() + HORIZONTAL_VERTICAL_COST);
            searchSpace[row][col + 1].setH(manhattanHeuristic(searchSpace[row][col + 1], finalNode));
            neighbors.add(this.searchSpace[row][col + 1]);
        }
        return neighbors;
    }

    public int manhattanHeuristic(Node node1, Node node2) {
        return (Math.abs(node1.getRowIndex() - node2.getRowIndex()) + Math.abs(node1.getColIndex() - node2.getColIndex())) * 10;
    }

    public void showPath() {
        System.out.println("SHORTEST PATH WITH A* SEARCH:");
        Node node = this.finalNode;
        while (node != null) {
            System.out.println(node);
            node = node.getPredecessor();
        }
    }
}