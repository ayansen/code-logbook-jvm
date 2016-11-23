package datastructure.lists.problems;

/**
 * Created by aysen on 10/27/16.
 */
public class ListProblems {

    public static int findEquilibrium(int[] numbers) {
        double totalSum = 0;

        for (int number : numbers) {
            totalSum = totalSum + number;
        }


        int partialSum = 0;

        for (int index = 0; index < numbers.length; index++) {
            double half = (totalSum - numbers[index]) / 2.0;
            if (partialSum == half) {
                return index;
            }
            partialSum = partialSum + numbers[index];
        }
        return -1;
    }

    /**
     * Maximum product Sum of an Array.
     *
     * @param array input array
     * @return maximum product
     */
    public static Integer maximumProductOfSubarray(Integer[] array) {
        {
            int maxProduct = 1;
            int runningMin = 1;
            int runningMax = 1;
            for (int i = 0; i < array.length; i++) {
                Integer currentNumber = array[i];
                if (currentNumber > 0) {
                    runningMax = Math.max(currentNumber, runningMax * currentNumber);
                    runningMin = Math.min(runningMin, runningMin * currentNumber);
                }
                if (currentNumber < 0) {
                    Integer min = Math.min(1, runningMax * currentNumber);
                    runningMax = Math.max(1, runningMin * currentNumber);
                    runningMin = min;
                }
                if (currentNumber == 0) {
                    runningMin = 1;
                    runningMax = 1;
                }
                maxProduct = Math.max(runningMax, maxProduct);
            }
            return maxProduct;
        }
    }


}
