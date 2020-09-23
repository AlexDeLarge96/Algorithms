package graphAlgorithms;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

public class App {
    public static void main(String[] args) {

        BFS bfs = new BFS();
        System.out.println("BFS");
        bfs.bfs(getRootVertex());

        DFS dfs = new DFS();
        System.out.println("DFS Iterative");
        dfs.dfsIterative(getRootVertex());
        System.out.println("DFS Recursive");
        dfs.dfsRecursive(getRootVertex());

        System.out.println("IDDFS");
        Node vertex0 = new Node("A");
        Node vertex1 = new Node("B");
        Node vertex2 = new Node("C");
        Node vertex3 = new Node("D");
        Node vertex4 = new Node("E");
        vertex0.setNeighboursList(asList(vertex1, vertex2));
        vertex1.setNeighboursList(singletonList(vertex3));
        vertex3.setNeighboursList(singletonList(vertex4));

        IDDFS iddfs = new IDDFS(vertex4);
        iddfs.runDeepeningSearch(vertex0);
    }

    private static Vertex<Integer> getRootVertex() {
        Vertex<Integer> vertex1 = new Vertex<>(1);
        Vertex<Integer> vertex2 = new Vertex<>(2);
        Vertex<Integer> vertex3 = new Vertex<>(3);
        Vertex<Integer> vertex4 = new Vertex<>(4);
        Vertex<Integer> vertex5 = new Vertex<>(5);
        Vertex<Integer> vertex6 = new Vertex<>(6);
        Vertex<Integer> vertex7 = new Vertex<>(7);

        vertex1.setNeighbourList(asList(vertex2, vertex5));
        vertex2.setNeighbourList(singletonList(vertex3));
        vertex3.setNeighbourList(singletonList(vertex4));
        vertex5.setNeighbourList(singletonList(vertex6));
        vertex6.setNeighbourList(singletonList(vertex7));
        return vertex1;
    }
}
