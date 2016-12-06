package algorithms.dp;

import java.util.*;
import java.util.stream.Collectors;


public class LowestTravelCost {

    private int findLowestCostRecursive(int[] daysOfTravel, int currentValidity, int currentIndex, Map<Integer, Integer> costValidityMap, Integer[] memo) {

        if (currentValidity >= 30 || currentIndex == daysOfTravel.length) {
            return 0;
        }

        int dayOfMonth = daysOfTravel[currentIndex];

        int minimumCost;
        if (dayOfMonth > currentValidity) {
            minimumCost = Collections.min(costValidityMap.entrySet().stream().map(tuple -> findLowestCostRecursive(daysOfTravel, currentValidity, currentIndex + 1, costValidityMap, memo)).collect(Collectors.toList()));

        } else {
            if (memo[dayOfMonth] != null) {
                return memo[dayOfMonth];
            }
            List<Integer> minimumCosts = new ArrayList<>();
            costValidityMap.entrySet().forEach(tuple -> {
                minimumCosts.add(findLowestCostRecursive(daysOfTravel, dayOfMonth + tuple.getValue(), currentIndex + 1, costValidityMap, memo) + tuple.getKey());
            });
            minimumCost = Collections.min(minimumCosts);
        }

        memo[dayOfMonth] = minimumCost;
        return minimumCost;
    }


    public int findLowestTravelCost(int[] daysOfTravel) {
        Map<Integer, Integer> costValidityMap = new HashMap<>();
        costValidityMap.entrySet();
        Integer[] memo = new Integer[31];
        costValidityMap.put(2, 1);
        costValidityMap.put(7, 7);
        costValidityMap.put(25, 30);
        return findLowestCostRecursive(daysOfTravel, daysOfTravel[0], 0, costValidityMap, memo);
    }
}
