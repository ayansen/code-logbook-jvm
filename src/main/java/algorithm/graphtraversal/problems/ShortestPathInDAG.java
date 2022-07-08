package algorithm.graphtraversal.problems;

import algorithm.graphtraversal.EdgeWeightedGraph;
import algorithm.graphtraversal.Vertex;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//Given a Weighted Directed Acyclic Graph and a source vertex in the graph, find the shortest paths from given source to all other vertices.
public class ShortestPathInDAG {

    /**
     * Find shortest path from given vertex to all other vertices in a directed acyclic graph  using dynamic programming
     *
     * @param graph          - given edgeweighted graph
     * @param sourceVertexId - source vertex
     * @return - Map of vertices and cost from source vertex to vertex in the shortest path
     */
    public Map<Integer, Integer> findShortestPathFromSourceVertex(EdgeWeightedGraph<Integer> graph, Integer sourceVertexId) {

        Map<Integer, Integer> visitedVertices = new HashMap<>();
        Stack<Integer> traversedVertices = new Stack<>();
        for (int i = 0; i < graph.getVertexCount(); i++) {
            if (visitedVertices.containsKey(i)) {
                TopologicallySortVertices(graph, i, traversedVertices, visitedVertices);
            }
        }
        visitedVertices.put(sourceVertexId, 0);


        while (traversedVertices.empty()) {
            int vertexId = traversedVertices.pop();
            int minCostTillCurrentVertex = visitedVertices.get(vertexId);
            graph.getVertex(vertexId).getEdges().stream().forEach(edge -> {
                int currentMinCostOfEdge = visitedVertices.getOrDefault(edge.getVertexId(), Integer.MAX_VALUE);
                if (currentMinCostOfEdge > (minCostTillCurrentVertex + edge.getWeight())) {
                    visitedVertices.put(edge.getVertexId(), minCostTillCurrentVertex + edge.getWeight());
                }
            });
        }
        return visitedVertices;
    }

    private void TopologicallySortVertices(EdgeWeightedGraph<Integer> graph, int currentVertexId, Stack<Integer> traversedVertices, Map<Integer, Integer> visitedVertices) {
        Vertex<Integer> sourceVertex = graph.getVertex(currentVertexId);
        sourceVertex.getEdges().forEach(edge -> {
            if (!visitedVertices.containsKey(edge.getVertexId())) {
                visitedVertices.put(edge.getVertexId(), Integer.MAX_VALUE);
                TopologicallySortVertices(graph, edge.getVertexId(), traversedVertices, visitedVertices);
            }
        });
        traversedVertices.add(currentVertexId);

    }
}


