package datastructure.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * Created by aysen on 10/28/16.
 */
public class GraphTraversals {

    public static <T> List<T> topologicalSort(EdgeWeightedGraph<T> graph, int vertexId) {
        List<Integer> visitedVertices = new ArrayList<>();
        Stack<Edge<T>> traversedEdges = new Stack<>();
        traverseGraphRecursively(vertexId, graph, visitedVertices, traversedEdges);
        List<T> edges = new ArrayList<>();
        while (traversedEdges.size() > 0) {
            edges.add(traversedEdges.pop().getWeight());
        }

        return edges;
    }

    private static <T> void traverseGraphRecursively(int vertexId, EdgeWeightedGraph<T> graph, List<Integer> visitedVertices, Stack<Edge<T>> traversedEdges) {
        if (!visitedVertices.contains(vertexId)) {
            visitedVertices.add(vertexId);
            Vertex<T> vertex = graph.getVertex(vertexId);
            for (Edge<T> edge : vertex.getEdges()) {
                traverseGraphRecursively(edge.getVertexId(), graph, visitedVertices, traversedEdges);
                traversedEdges.push(edge);
            }

        }
    }

}
