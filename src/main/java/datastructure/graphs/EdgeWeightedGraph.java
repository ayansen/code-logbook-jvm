package datastructure.graphs;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by aysen on 10/18/16.
 */
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


    public void addEdge(int id, Edge<T> edge) {
        vertices.get(id).addEdge(edge);
    }

    public List<T> depthFirstTraversal(int vertexId) {
        Set<Edge<T>> traversedEdges = new HashSet<>();
        Set<Integer> traversedVertices = new HashSet<>();
        traversedVertices.add(vertexId);
        depthFirstTraversalRecursive(vertexId, traversedEdges, traversedVertices);
        return traversedEdges.stream().map(Edge::getWeight).collect(Collectors.toList());
    }

    public List<T> breadthFirstTraversal(int vertexId) {
        Queue<Edge<T>> traversedEdges = new ArrayDeque<>();
        Set<Integer> traversedVertices = new HashSet<>();
        Queue<Integer> verticesAtSameLevel = new ArrayDeque<>();
        verticesAtSameLevel.add(vertexId);
        BreadthFirstTraversalRecursive(verticesAtSameLevel, traversedEdges, traversedVertices);
        return traversedEdges.stream().map(Edge::getWeight).collect(Collectors.toList());
    }

    private void BreadthFirstTraversalRecursive(Queue<Integer> verticesAtSameLevel, Queue<Edge<T>> traversedEdges, Set<Integer> visitedVertices) {

        if (!verticesAtSameLevel.isEmpty()) {
            for (int i = 0; i < verticesAtSameLevel.size(); i++) {

                Vertex<T> vertex = vertices.get(verticesAtSameLevel.poll());

                if (!visitedVertices.contains(vertex.getId())) {
                    visitedVertices.add(vertex.getId());
                    vertex.getEdges().forEach(edge -> {
                        traversedEdges.add(edge);
                        verticesAtSameLevel.add(edge.getVertexId());

                    });
                }

            }
            BreadthFirstTraversalRecursive(verticesAtSameLevel, traversedEdges, visitedVertices);
        }
    }


    private void depthFirstTraversalRecursive(int vertexId, Set<Edge<T>> traversedEdges, Set<Integer> visitedVertices) {
        vertices.get(vertexId).getEdges().forEach(adjacentEdge -> {
            if (!visitedVertices.contains(adjacentEdge.getVertexId())) {
                traversedEdges.add(adjacentEdge);
                visitedVertices.add(adjacentEdge.getVertexId());
                depthFirstTraversalRecursive(adjacentEdge.getVertexId(), traversedEdges, visitedVertices);
            }
        });
    }
}
