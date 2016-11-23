package datastructure;

import com.sun.tools.javac.util.Pair;
import datastructure.heap.problems.HeapProblems;
import datastructure.lists.problems.LargestAndSmallestNumber;
import datastructure.lists.problems.ListProblems;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aysen on 10/26/16.
 */
public class HeapTest {

    @Test
    public void SortListUsingHeap() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(3);
        numbers.add(15);
        numbers.add(123);
        numbers.add(120);
        numbers.add(15);
        numbers.add(5);
        numbers.add(1);
        HeapProblems.sortListUsingHeap(numbers).stream().forEach(System.out::println);

    }

    @Test
    public void testMedianOfNumbers() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(3);
        numbers.add(2);
        numbers.add(123);
        numbers.add(120);
        numbers.add(9);
        numbers.add(5);
        numbers.add(1);
        Assert.assertEquals(HeapProblems.findMedian(numbers).longValue(), 5l);

    }
}
