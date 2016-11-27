package datastructure;

import datastructure.graphs.EdgeWeightedGraph;
import datastructure.graphs.problems.DetectCylesInAGraph;
import datastructure.graphs.traversals.BreadthFirstTraversal;
import datastructure.graphs.traversals.DepthFirstTraversal;
import datastructure.graphs.problems.TopologicalSort;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by aysen on 10/18/16.
 */
public class GraphTest {


    @Test
    public void TestTraversal() {
        Integer[][] matrix = new Integer[][]{
                {null, 3, 1},
                {1, null, 5},
                {2, 5, null}
        };

        EdgeWeightedGraph<Integer> graph = new EdgeWeightedGraph<>(matrix);
        DepthFirstTraversal.depthFirstTraversal(graph, 0).stream().forEach(System.out::println);
        BreadthFirstTraversal.breadthFirstTraversal(graph, 0).stream().forEach(System.out::println);
    }


    @Test
    public void TestCyclicGraph() {
        Integer[][] matrix = new Integer[][]{
                {null, 3, 8},
                {null, null, 8},
                {null, null, null}
        };

        Assert.assertTrue(DetectCylesInAGraph.detectCycleInGraph(matrix));
    }

    @Test
    public void TestTopologicalSort() {
        Integer[][] matrix = new Integer[][]{
                {null, 12, 13, null, null},
                {null, null, null, 24, null},
                {null, null, null, 34, 35},
                {null, null, null, null, 45},
                {null, null, null, null, null}
        };
        TopologicalSort.topologicalSort(new EdgeWeightedGraph<>(matrix), 0).stream().forEach(System.out::println);

    }


}
