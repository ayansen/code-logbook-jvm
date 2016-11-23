package datastructure;

import com.sun.tools.javac.util.Pair;
import datastructure.lists.problems.LargestAndSmallestNumber;
import datastructure.lists.problems.ListProblems;
import datastructure.lists.problems.MergeSortedLinkedLists;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aysen on 10/12/16.
 */
public class ListTest {

    @Test
    public void testMergingOfSortedLists() {
        List<Integer> firstList = new ArrayList<>(10);
        firstList.add(3);
        firstList.add(15);
        firstList.add(123);


        List<Integer> secondList = new ArrayList<>();
        secondList.add(1);
        secondList.add(12);
        secondList.add(17);
        secondList.add(320);


        MergeSortedLinkedLists.mergeSortedLinkedLists(firstList, secondList).stream().forEach(System.out::println);
        MergeSortedLinkedLists.mergeSortedLinkedListsInSpace(firstList, secondList).stream().forEach(System.out::println);

    }

    @Test
    public void FindMinMaxInAList() {
        List<Integer> firstList = new ArrayList<>();
        firstList.add(3);
        firstList.add(15);
        firstList.add(123);
        firstList.add(120);
        firstList.add(15);
        firstList.add(5);
        firstList.add(1);


        Pair<Integer, Integer> pair = LargestAndSmallestNumber.findLargestAndSmallestNumberInList(firstList);
        Assert.assertEquals(pair.fst.longValue(), 1L);
        Assert.assertEquals(pair.snd.longValue(), 123L);

    }

    @Test
    public void FindMaxProductInAnArrayTest() {
        Integer[] array = {2, 4, 5, -10, 7, 2, -1, -6, 2, 5};

        Assert.assertEquals(ListProblems.maximumProductOfSubarray(array).longValue(), 5600);


    }

    @Test
    public void FindEquilibriumTest() {
        int numbers[] = {-1, 3, -4, 5, 1, -6, 2, 1};
        Assert.assertEquals(ListProblems.findEquilibrium(numbers), 1);
    }


}
