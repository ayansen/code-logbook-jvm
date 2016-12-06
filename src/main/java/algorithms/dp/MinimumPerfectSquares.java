package algorithms.dp;

public class MinimumPerfectSquares {
    /**
     * Given a number, find the minimum number of perfect squares adding upto that number
     *
     * @param n
     * @return
     */
    public int findMinimumPerfectSquaresAddingToSum(final int n) {
        Integer[] memo = new Integer[n + 1];

        return findMinimumPerfectSquaresAddingToSumRecursively(n, memo);
    }

    private int findMinimumPerfectSquaresAddingToSumRecursively(final int n, Integer[] memo) {
        if (n == 0) {
            return 0;
        } else if (memo[n] != null) {
            return memo[n];
        } else {
            int absoluteMin = n;
            for (int i = 1; (i * i) <= n; i++) {
                int currentMin = 1 + findMinimumPerfectSquaresAddingToSumRecursively(n - (i * i), memo);
                if (currentMin < absoluteMin) {
                    absoluteMin = currentMin;
                }
            }
            memo[n] = absoluteMin;
            return absoluteMin;
        }
    }
}
