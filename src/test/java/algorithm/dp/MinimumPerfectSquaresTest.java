package algorithm.dp;

import org.junit.Assert;
import org.junit.Test;

public class MinimumPerfectSquaresTest {
    @Test
    public void findMinimumPerfectSquaresAddingToSumTest() {
        MinimumPerfectSquares minimumPerfectSquares = new MinimumPerfectSquares();
        Assert.assertEquals(minimumPerfectSquares.findMinimumPerfectSquaresAddingToSum(81),1);
        Assert.assertEquals(minimumPerfectSquares.findMinimumPerfectSquaresAddingToSum(82),2);
        Assert.assertEquals(minimumPerfectSquares.findMinimumPerfectSquaresAddingToSum(50),2);
        Assert.assertEquals(minimumPerfectSquares.findMinimumPerfectSquaresAddingToSum(53),2);
        Assert.assertEquals(minimumPerfectSquares.findMinimumPerfectSquaresAddingToSum(51),3);
    }
}
