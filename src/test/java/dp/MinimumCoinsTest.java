package dp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by aysen on 10/2/16.
 */
public class MinimumCoinsTest {

    @Test
    public void testMinimumCoins() {
        MinimumCoins minimumCoins = new MinimumCoins();
        List<Integer> availableCoins = new ArrayList<>();
        availableCoins.add(2);
        availableCoins.add(5);
        availableCoins.add(1);

        System.out.println(minimumCoins.findMinimumCoinsToMakeSum(3, availableCoins));
    }



}
