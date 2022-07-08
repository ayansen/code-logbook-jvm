package algorithm.bruteforce;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by aysen on 11/23/16.
 */
public class FindLongestPathInMatrixTest {

    @Test
    public void TestlongestPathIncreasingInMatrix() {

        Integer[] actualLongestPath = new Integer[]{1, 3, 4, 7,9};
        Integer[][] matrix = new Integer[][]{
                {1, 2, 3},
                {3, 4, 7},
                {2, 2, 9}
        };

        List<Integer> longestPath = FindLongestPathInMatrix.longestPathIncreasingInMatrix(matrix);
        Assert.assertArrayEquals(actualLongestPath, longestPath.toArray());
    }
}
