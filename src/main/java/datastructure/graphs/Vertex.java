package datastructure.graphs;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * Created by aysen on 10/18/16.
 */
public class Vertex<T> {

    private final int id;
    private final Queue<Edge<T>> edges;

    public Vertex(int id) {
        this.id = id;
        edges = new ArrayDeque<>();
    }


    public void addEdge(Edge<T> edge) {
        edges.add(edge);
    }


    public Queue<Edge<T>> getEdges() {
        return edges;
    }

    public int getId() {
        return id;
    }
}
