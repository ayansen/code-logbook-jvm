package algorithm.greedy;

import algorithm.graphtraversal.EdgeWeightedGraph;

import java.util.HashMap;
import java.util.Map;

public class ShortestPathInGraph {

    /**
     * Find shortest path from given vertex to all other vertices using Dijkstra’s algorithm
     *
     * @param graph          - given edgeweighted graph
     * @param sourceVertexId - source vertex
     * @return - Map of vertices and cost from source vertex to vertex in the shortest path
     */
    public Map<Integer, Integer> findShortestPathFromSourceVertex(EdgeWeightedGraph<Integer> graph, Integer sourceVertexId) {
        Map<Integer, Integer> leastCostMap = new HashMap<>();
        Map<Integer, Integer> costMap = new HashMap<>();
        for (int i = 0; i < graph.getVertexCount(); i++) {
            costMap.put(i, Integer.MAX_VALUE);
        }
        costMap.put(sourceVertexId, 0);
        while (leastCostMap.size() != graph.getVertexCount()) {
            Integer index = findLeastValueInCostMap(costMap);
            Integer value = costMap.get(index);
            leastCostMap.put(index, value);
            graph.getVertex(index).getEdges().forEach(edge -> {
                if (costMap.get(edge.getVertexId()) > (value + edge.getWeight())) {
                    costMap.put(edge.getVertexId(), (value + edge.getWeight()));
                }
            });
        }
        return leastCostMap;
    }

    private Integer findLeastValueInCostMap(Map<Integer, Integer> costMap) {
        int leastCostIndex = 0;
        int leastCostValue = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry : costMap.entrySet()) {
            if (entry.getValue() < leastCostValue) {
                leastCostIndex = entry.getKey();
                leastCostValue = entry.getValue();
            }
        }
        return leastCostIndex;
    }
}
