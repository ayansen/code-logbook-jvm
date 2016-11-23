package dp;

import org.junit.Test;

/**
 * Created by aysen on 11/1/16.
 */
public class MaxSubArrayTest {

    @Test
    public void testMaxSubMatrix() {
        int[][] matrix = new int[][]{
                {-1, 3, -5},
                {1, -1, 0},
                {2, 5, 2}
        };
        System.out.println(MaxSubMatrix.findSubMatrixWithHighestSum(matrix));
    }

}
