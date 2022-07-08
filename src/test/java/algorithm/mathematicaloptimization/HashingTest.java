package algorithm.mathematicaloptimization;

import algorithm.mathematicaloptimizations.HashProblems;
import algorithm.mathematicaloptimizations.lists.Pair;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by aysen on 10/25/16.
 */
public class HashingTest {
    @Test
    public void testFindPairForSum() {
        int[] arr = {10, 15, 24, 45, 33, 0};
        Assert.assertEquals(HashProblems.findPairForSum(arr, 60).get(), new Pair<>(45, 15));
    }
}
