package datastructure.hashing.problems;

import datastructure.trees.BinaryTreeNode;
import javafx.util.Pair;

import java.util.*;

/**
 * Created by aysen on 10/18/16.
 */
public class HashProblems {

    /**
     * Print a Binary Tree in Vertical Order
     *
     * @param root - root of the binary tree
     * @return map of vertical-level and list data-nodes at that level
     */
    public static Map<Integer, List<Integer>> printTreeInVerticalOrder(BinaryTreeNode<Integer> root) {
        Map<Integer, List<Integer>> verticalIndexMap = new HashMap<>();
        addNodesToVerticalIndex(root, 0, verticalIndexMap);
        return verticalIndexMap;
    }

    //

    /**
     * Given an array A[] and a number x, check for pair in A[] with sum as x
     *
     * @param numbers - numbers
     * @param sum     - given sum
     * @return pair which adds up to the sum
     */

    public static Optional<Pair<Integer, Integer>> findPairForSum(int[] numbers, int sum) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int number : numbers) {
            if (number < sum) {
                if (map.containsKey(number)) {
                    return Optional.of(new Pair<>(number, sum - number));
                } else {
                    map.put(sum - number, true);
                }
            }
        }

        return Optional.empty();
    }


    // Private Methods

    private static void addNodesToVerticalIndex(BinaryTreeNode<Integer> node, int index, Map<Integer, List<Integer>> verticalIndexMap) {
        if (node == null) {
            return;
        }
        if (!verticalIndexMap.containsKey(index)) {
            verticalIndexMap.put(index, new ArrayList<>());
        }
        verticalIndexMap.get(index).add(node.getData());
        addNodesToVerticalIndex(node.getLeft(), index - 1, verticalIndexMap);
        addNodesToVerticalIndex(node.getRight(), index + 1, verticalIndexMap);
    }

}
