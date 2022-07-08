package algorithm.dp;

import org.junit.Test;

/**
 * Created by aysen on 11/1/16.
 */
public class LowestTravelCostTest {

    @Test
    public void testLowestTravelCost() {
        LowestTravelCost lowestTravelCost = new LowestTravelCost();

        int[] travelDays = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21, 22, 23, 24, 25, 26,27,28,29,30};
        System.out.println(lowestTravelCost.findLowestTravelCost(travelDays));
    }

}
