package algorithms.dp;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by aysen on 10/2/16.
 */
public class MinimumCoins {

    private int findMinStepsRecursive(int sum, List<Integer> availableCoins, int iteration, Integer[] memo) {
        if (sum == 0) {
            return iteration;
        }

        if (sum < Collections.min(availableCoins)) {
            return Integer.MAX_VALUE;
        }

        if (memo[sum - 1] != null) {
            return memo[sum - 1];
        }
        return Collections.min(availableCoins.stream().map(value -> findMinStepsRecursive(sum - value, availableCoins, iteration + 1, memo)).collect(Collectors.toList()));

    }


    public int findMinimumCoinsToMakeSum(int sum, List<Integer> availableCoins) {
        Integer[] memo = new Integer[sum];
        return findMinStepsRecursive(sum, availableCoins, 0, memo);
    }
}
