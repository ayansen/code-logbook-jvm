package datastructure.heap.problems;

import datastructure.heap.BinaryMaxHeap;
import datastructure.heap.BinaryMinHeap;
import datastructure.heap.Heap;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by aysen on 10/26/16.
 */
public class HeapProblems {

    public static List<Integer> sortListUsingHeap(List<Integer> numbers) {

        BinaryMaxHeap<Integer> maxHeap = new BinaryMaxHeap<>();
        numbers.forEach(maxHeap::insert);
        return numbers.stream().map(number -> maxHeap.ExtactHead()).collect(Collectors.toList());
    }

    /**
     * Find the median given a list of numbers
     *
     * @param numbers incoming numbers stream
     * @return median
     */
    public static Integer findMedian(List<Integer> numbers) {

        Heap<Integer> maxHeap = new BinaryMaxHeap<>();
        Heap<Integer> minHeap = new BinaryMinHeap<>();
        maxHeap.insert(numbers.get(0));
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) <= maxHeap.getHead()) {
                maxHeap.insert(numbers.get(i));
                if ((maxHeap.size() - minHeap.size()) == 2) {
                    minHeap.insert(maxHeap.ExtactHead());
                }
            } else {
                minHeap.insert(numbers.get(i));
                if ((minHeap.size() - maxHeap.size()) == 2) {
                    maxHeap.insert(minHeap.ExtactHead());
                }
            }

        }
        if (minHeap.size() == maxHeap.size()) {
            return (minHeap.getHead() + maxHeap.getHead()) / 2;
        } else if (minHeap.size() > maxHeap.size()) {
            return minHeap.getHead();
        } else {
            return maxHeap.getHead();
        }
    }
}


