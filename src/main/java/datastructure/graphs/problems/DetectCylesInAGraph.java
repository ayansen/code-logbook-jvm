package datastructure.graphs.problems;

import datastructure.graphs.Edge;
import datastructure.graphs.EdgeWeightedGraph;

import java.util.ArrayList;
import java.util.List;

public class DetectCylesInAGraph {
    /**
     * Detecting cycle in a graph
     *
     * @param graphMatrix - graph represented in the form of an Array
     * @return true if graph contains a cycle else false
     */
    public static boolean detectCycleInGraph(Integer[][] graphMatrix) {
        EdgeWeightedGraph<Integer> graph = new EdgeWeightedGraph<>(graphMatrix);
        List<Integer> visitedVertices = new ArrayList<>();
        List<Integer> visitedVerticesInCurrentRecursion = new ArrayList<>();
        visitedVertices.add(0);
        return traverseGraphDepthFirstToDetectCycles(0, graph, visitedVertices, visitedVerticesInCurrentRecursion);
    }

    private static Boolean traverseGraphDepthFirstToDetectCycles(int currentVertex, EdgeWeightedGraph<Integer> graph, List<Integer> visitedVertices, List<Integer> visitedVerticesInCurrentRecursion) {

        visitedVerticesInCurrentRecursion.add(currentVertex);
        for (Edge<Integer> edge : graph.getVertex(currentVertex).getEdges()) {
            if (visitedVerticesInCurrentRecursion.contains(edge.getVertexId())) {
                return true;
            } else {
                visitedVerticesInCurrentRecursion.add(currentVertex);
                visitedVertices.add(edge.getVertexId());
                traverseGraphDepthFirstToDetectCycles(edge.getVertexId(), graph, visitedVertices, visitedVerticesInCurrentRecursion);
            }
        }
        visitedVerticesInCurrentRecursion.remove(currentVertex);

        return false;

    }
}
