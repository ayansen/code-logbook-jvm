package datastructure;

import datastructure.graphs.EdgeWeightedGraph;
import datastructure.graphs.GraphTraversals;
import datastructure.graphs.problems.FindLongestPathInMatrics;
import datastructure.graphs.problems.GraphProblems;
import datastructure.graphs.problems.ResolveWildcardCharacter;
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
        graph.depthFirstTraversal(0).stream().forEach(System.out::println);
        graph.breadthFirstTraversal(0).stream().forEach(System.out::println);
    }

    @Test
    public void TestFindStringInDictionary() {
        Integer[][] matrix = new Integer[][]{
                {1, 2, 3},
                {3, 4, 7},
                {2, 9, 2}
        };

        FindLongestPathInMatrics.longestPathIncreasingInMatrix(matrix).stream().forEach(System.out::println);
    }

    @Test
    public void TestResolveWildcardCharacter() {
        String wildcardString = "01?01";
        ResolveWildcardCharacter resolveWildcardCharacter = new ResolveWildcardCharacter();
        Assert.assertEquals(resolveWildcardCharacter.resolveWildcards(wildcardString).size(), 2);
    }

    @Test
    public void TestCyclicGraph() {
        Integer[][] matrix = new Integer[][]{
                {null, 3, 8},
                {null, null, 8},
                {null, null, null}
        };

        Assert.assertTrue(GraphProblems.detectCycleInGraph(matrix));
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
        GraphTraversals.topologicalSort(new EdgeWeightedGraph<>(matrix), 0).stream().forEach(System.out::println);

    }


}
