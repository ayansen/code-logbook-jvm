package algorithm.greedy;

import algorithm.graphtraversal.Edge;
import algorithm.graphtraversal.EdgeWeightedGraph;

public class MinimumSpanningTree {

    /**
     * given a graph, this function returns a minimum spanning tree
     * A minimum spanning tree (MST) or minimum weight spanning tree is a subset of the edges of a connected,
     * edge-weighted undirected graph that connects all the vertices together, without any cycles and with the minimum possible total edge weight.
     *
     * @param graph - input graph
     * @return - minimum spanning tree
     */
    public EdgeWeightedGraph<Integer> createMinimumSpanningTree(Integer[][] graph) {
        EdgeWeightedGraph<Integer> minimumSpanningTree = new EdgeWeightedGraph<>(graph.length);

        for (int i = 0; i < graph.length; i++) {
            int indexOfMinimumEdgeWeight = 0;
            for (int j = 1; j < graph[i].length; j++) {
                if (graph[i][j] != null && graph[i][j] < graph[i][indexOfMinimumEdgeWeight]) {
                    indexOfMinimumEdgeWeight = j;
                }
            }
            if (minimumSpanningTree.getVertex(i).getEdges().isEmpty()) {
                minimumSpanningTree.addEdge(i, new Edge<>(graph[i][indexOfMinimumEdgeWeight], indexOfMinimumEdgeWeight));
                minimumSpanningTree.addEdge(indexOfMinimumEdgeWeight, new Edge<>(graph[i][indexOfMinimumEdgeWeight], i));
            }
        }
        return minimumSpanningTree;
    }
}
