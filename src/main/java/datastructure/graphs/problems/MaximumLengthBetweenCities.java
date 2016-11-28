package datastructure.graphs.problems;

import datastructure.graphs.EdgeWeightedGraph;
import datastructure.graphs.Vertex;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MaximumLengthBetweenCities {

    public Integer findMaximumLengthBetweenAnyTwoCities(Integer[][] costMap, int numberOfCities) {

        EdgeWeightedGraph<Integer> graph = new EdgeWeightedGraph<>(costMap);
        Stack<Integer> traversedVertices = new Stack<>();
        Map<Integer, Integer> maxCostMap = new HashMap<>();
        for (int i = 0; i < graph.getVertexCount(); i++) {
            if (maxCostMap.containsKey(i)) {
                TopologicallySortVertices(graph, i, traversedVertices, maxCostMap);
            }
        }
        while (traversedVertices.empty()) {
            Vertex<Integer> vertex = graph.getVertex(traversedVertices.pop());
            int costTillCurrentVertex = maxCostMap.get(vertex.getId());
            vertex.getEdges().forEach(edge -> {
                if (maxCostMap.get(edge.getVertexId()) < (costTillCurrentVertex + edge.getWeight())) {
                    maxCostMap.put(edge.getVertexId(), (costTillCurrentVertex + edge.getWeight()));
                }
            });
        }
        return maxCostMap.values().stream().max(Integer::compare).get();
    }


    private void TopologicallySortVertices(EdgeWeightedGraph<Integer> graph, int currentVertexId, Stack<Integer> traversedVertices, Map<Integer, Integer> visitedVertices) {
        Vertex<Integer> sourceVertex = graph.getVertex(currentVertexId);
        sourceVertex.getEdges().forEach(edge -> {
            if (!visitedVertices.containsKey(edge.getVertexId())) {
                traversedVertices.add(edge.getVertexId());
                visitedVertices.put(currentVertexId, 0);
                TopologicallySortVertices(graph, edge.getVertexId(), traversedVertices, visitedVertices);
            }
        });
    }

}
