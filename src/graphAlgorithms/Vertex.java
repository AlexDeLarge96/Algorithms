package graphAlgorithms;

import java.util.ArrayList;
import java.util.List;

public class Vertex<T> {
    private T data;
    private boolean visited;
    private List<Vertex<T>> neighbourList;

    public Vertex(T data) {
        this.data = data;
        this.neighbourList = new ArrayList<>();
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<Vertex<T>> getNeighbourList() {
        return neighbourList;
    }

    public void setNeighbourList(List<Vertex<T>> neighbourList) {
        this.neighbourList = neighbourList;
    }

    @Override
    public String toString() {
        return this.data.toString();
    }
}
