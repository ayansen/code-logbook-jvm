package algorithm.mathematicaloptimizations.lists.problems;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by aysen on 10/12/16.
 */
public class MergeSortedLinkedLists {

    public static <T extends Comparable> List<T> mergeSortedLinkedLists(List<T> firstList, List<T> secondList) {
        ListIterator<T> firstListIterator = firstList.listIterator();
        ListIterator<T> secondListIterator = secondList.listIterator();

        List<T> mergedList = new LinkedList<>();
        while (firstListIterator.hasNext() && secondListIterator.hasNext()) {
            T tailOfFirstList = firstListIterator.next();
            T tailOfSecondList = secondListIterator.next();
            if (tailOfFirstList.compareTo(tailOfSecondList) <= 0) {
                mergedList.add(tailOfFirstList);
                secondListIterator.previous();
            } else {
                mergedList.add(tailOfSecondList);
                firstListIterator.previous();
            }
        }
        while (firstListIterator.hasNext()) {
            mergedList.add(firstListIterator.next());
        }
        while (secondListIterator.hasNext()) {
            mergedList.add(secondListIterator.next());
        }
        return mergedList;
    }

    public static <T extends Comparable> List<T> mergeSortedLinkedListsInSpace(List<T> firstList, List<T> secondList) {
        ListIterator<T> firstListIterator = firstList.listIterator();

        while (firstListIterator.hasNext()) {
            ListIterator<T> secondListIterator = secondList.listIterator();
            T data = firstListIterator.next();
            while (secondListIterator.hasNext() && secondListIterator.next().compareTo(data) < 0) {
            }
            secondListIterator.previous();
            secondListIterator.add(data);
        }
        return secondList;
    }
}
