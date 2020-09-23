package graphAlgorithms;

import java.util.Deque;
import java.util.LinkedList;

public class DFS {

    public <T> void dfsIterative(Vertex<T> root) {
        Deque<Vertex<T>> queue = new LinkedList<>();
        queue.push(root);
        root.setVisited(true);
        while (!queue.isEmpty()) {
            Vertex<T> actualVertex = queue.pop();
            System.out.println(actualVertex);
            for (Vertex<T> v : actualVertex.getNeighbourList()) {
                if (!v.isVisited()) {
                    v.setVisited(true);
                    queue.push(v);
                }
            }
        }
    }

    public <T> void dfsRecursive(Vertex<T> vertex) {
        vertex.setVisited(true);
        System.out.println(vertex);
        for (Vertex<T> v : vertex.getNeighbourList()) {
            if (!v.isVisited()) {
                dfsRecursive(v);
            }
        }
    }
}
