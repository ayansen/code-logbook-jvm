package datastructure.lists.problems;

/**
 * Created by aysen on 10/16/16.
 */

import com.sun.tools.javac.util.Pair;

import java.util.List;

/**
 * Find the largest and smallest number in a list.
 * The list is stored as two sections, one in ascending order and the other in descending order.
 * input [ 2 3 4 5 6 7 10 9 8 7] smallest : 2 Largest 10
 */
public class LargestAndSmallestNumber {

    public static Pair<Integer, Integer> findLargestAndSmallestNumberInList(List<Integer> list) {
        int smallest = list.get(0) < list.get(list.size() - 1) ? list.get(0) : list.get(list.size() - 1);
        int largest = getMax(list, 0, list.size());
        return Pair.of(smallest, largest);

    }

    private static int getMax(List<Integer> list, int startingIndex, int endingIndex) {
        if (startingIndex == endingIndex) {
            return list.get(startingIndex);
        }
        int middleIndex = (endingIndex + startingIndex) / 2;
        int middle = list.get(middleIndex);
        int middlePrevious = list.get(middleIndex - 1);
        int middleNext = list.get(middleIndex + 1);
        if (middle >= middlePrevious)
            if (middle >= middleNext) {
                return middle;
            } else {
                return getMax(list, middleIndex, endingIndex);
            }
        else {
            return getMax(list, startingIndex, middleIndex);
        }
    }
}


