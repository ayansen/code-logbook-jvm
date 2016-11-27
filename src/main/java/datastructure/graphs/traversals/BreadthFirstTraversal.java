package datastructure.graphs.traversals;

import datastructure.graphs.Edge;
import datastructure.graphs.EdgeWeightedGraph;
import datastructure.graphs.Vertex;

import java.util.*;
import java.util.stream.Collectors;

public class BreadthFirstTraversal {

    public static <T> List<T> breadthFirstTraversal(EdgeWeightedGraph<T> graph, int vertexId) {
        Queue<Edge<T>> traversedEdges = new ArrayDeque<>();
        Set<Integer> traversedVertices = new HashSet<>();
        Queue<Integer> verticesAtSameLevel = new ArrayDeque<>();
        verticesAtSameLevel.add(vertexId);
        BreadthFirstTraversalRecursive(graph, verticesAtSameLevel, traversedEdges, traversedVertices);
        return traversedEdges.stream().map(Edge::getWeight).collect(Collectors.toList());
    }

    private static <T> void BreadthFirstTraversalRecursive(EdgeWeightedGraph<T> graph, Queue<Integer> verticesAtSameLevel, Queue<Edge<T>> traversedEdges, Set<Integer> visitedVertices) {

        if (!verticesAtSameLevel.isEmpty()) {
            for (int i = 0; i < verticesAtSameLevel.size(); i++) {

                Vertex<T> vertex = graph.getVertex(verticesAtSameLevel.poll());

                if (!visitedVertices.contains(vertex.getId())) {
                    visitedVertices.add(vertex.getId());
                    vertex.getEdges().forEach(edge -> {
                        traversedEdges.add(edge);
                        verticesAtSameLevel.add(edge.getVertexId());

                    });
                }
            }
            BreadthFirstTraversalRecursive(graph, verticesAtSameLevel, traversedEdges, visitedVertices);
        }
    }
}
