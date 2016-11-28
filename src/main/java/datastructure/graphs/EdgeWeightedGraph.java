package datastructure.graphs;

import java.util.HashMap;
import java.util.Map;

public class EdgeWeightedGraph<T> {

    private final Map<Integer, Vertex<T>> vertices;


    public EdgeWeightedGraph(int numberOfVertices) {
        vertices = new HashMap<>(numberOfVertices);
        for (int id = 0; id < numberOfVertices; id++) {
            vertices.put(id, new Vertex<>(id));
        }
    }

    public EdgeWeightedGraph(T[][] weights) {
        this(weights.length);
        if (weights.length != weights[0].length) {
            throw new RuntimeException("invalid matrix");
        }

        for (int i = 0; i < weights.length; i++) {
            for (int j = 0; j < weights[i].length; j++) {
                if (weights[i][j] != null) {
                    this.addEdge(i, new Edge<>(weights[i][j], j));
                }
            }
        }
    }

    public Vertex<T> getVertex(int id) {
        return vertices.get(id);
    }

    public int getVertexCount(){
       return vertices.size();
    }


    public void addEdge(int id, Edge<T> edge) {
        vertices.get(id).addEdge(edge);
    }
}
