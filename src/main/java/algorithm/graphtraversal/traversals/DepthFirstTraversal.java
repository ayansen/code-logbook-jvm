package algorithm.graphtraversal.traversals;

import algorithm.graphtraversal.Edge;
import algorithm.graphtraversal.EdgeWeightedGraph;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by aysen on 11/27/16.
 */
public class DepthFirstTraversal {

    public static <T> List<T> depthFirstTraversal(EdgeWeightedGraph<T> graph, int vertexId) {
        Set<Edge<T>> traversedEdges = new HashSet<>();
        Set<Integer> traversedVertices = new HashSet<>();
        traversedVertices.add(vertexId);
        depthFirstTraversalRecursive(graph, vertexId, traversedEdges, traversedVertices);
        return traversedEdges.stream().map(Edge::getWeight).collect(Collectors.toList());
    }


    private static <T> void depthFirstTraversalRecursive(EdgeWeightedGraph<T> graph, int vertexId, Set<Edge<T>> traversedEdges, Set<Integer> visitedVertices) {
        graph.getVertex(vertexId).getEdges().forEach(adjacentEdge -> {
            if (!visitedVertices.contains(adjacentEdge.getVertexId())) {
                traversedEdges.add(adjacentEdge);
                visitedVertices.add(adjacentEdge.getVertexId());
                depthFirstTraversalRecursive(graph, adjacentEdge.getVertexId(), traversedEdges, visitedVertices);
            }
        });
    }
}
