package datastructure.graphs;

/**
 * Created by aysen on 10/18/16.
 */
public class Edge<T> {
    private final T weight;
    private final int vertexId;

    public Edge(T weight, int vertexId) {
        this.weight = weight;
        this.vertexId = vertexId;
    }

    public T getWeight() {
        return weight;
    }

    public int getVertexId() {
        return vertexId;
    }
}
