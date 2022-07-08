package algorithm.greedy;

import org.junit.Test;

/**
 * Created by aysen on 11/23/16.
 */
public class MinimumSpanningTreeTest {

    @Test
    public void TestMinimumSpanningTree() {
        MinimumSpanningTree minimumSpanningTree = new MinimumSpanningTree();

        Integer[][] matrix = new Integer[][]{
                {1000, 3, 1},
                {1, null, 5},
                {2, 5, null}
        };
        minimumSpanningTree.createMinimumSpanningTree(matrix);
    }


}
