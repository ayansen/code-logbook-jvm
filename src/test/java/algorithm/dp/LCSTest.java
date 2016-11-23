package algorithm.dp;

import algorithms.dp.LongestCommonSubsequence;
import org.junit.Test;

/**
 * Created by aysen on 10/2/16.
 */
public class LCSTest {

    @Test
    public void testLcs() {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        System.out.println(lcs.longestCommonSubsequence("thanksa", "halkoa"));
    }
}
