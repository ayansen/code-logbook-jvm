package algorithm.graphtraversal.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by aysen on 10/28/16.
 */
public class TreeTraversals {

    public static <T> List<T> traverseInorder(BinaryTreeNode<T> root) {
        return traverseInorderRecursively(root, new ArrayList<>());
    }

    public static <T> List<T> traversePreorder(BinaryTreeNode<T> root) {
        return traversePreorderRecursively(root, new ArrayList<>());
    }


    public static <T> List<T> traverseLeverOrder(BinaryTreeNode<T> root) {
        Queue<BinaryTreeNode<T>> nodesAtSameDepth = new ArrayDeque<>();
        nodesAtSameDepth.add(root);
        return traverseLeverOrderRecursive(nodesAtSameDepth, new ArrayList<>());
    }


    private static <T> List<T> traversePreorderRecursively(BinaryTreeNode<T> node, List<T> list) {
        list.add(node.getData());
        if (node.getLeft() != null) {
            traversePreorderRecursively(node.getLeft(), list);
        }
        if (node.getRight() != null) {
            traversePreorderRecursively(node.getRight(), list);
        }
        return list;
    }

    private static <T> List<T> traverseInorderRecursively(BinaryTreeNode<T> node, List<T> sortedList) {
        if (node.getLeft() != null) {
            traverseInorderRecursively(node.getLeft(), sortedList);
        }
        sortedList.add(node.getData());
        if (node.getRight() != null) {
            traverseInorderRecursively(node.getRight(), sortedList);
        }
        return sortedList;
    }


    private static <T> List<T> traverseLeverOrderRecursive(Queue<BinaryTreeNode<T>> nodesAtSameDepth, List<T> list) {
        if (nodesAtSameDepth.isEmpty())
            return list;

        for (int i = 0; i < nodesAtSameDepth.size(); i++) {
            BinaryTreeNode<T> node = nodesAtSameDepth.poll();
            if (node.getLeft() != null) {
                nodesAtSameDepth.add(node.getLeft());
            }
            if (node.getRight() != null) {
                nodesAtSameDepth.add(node.getRight());
            }
        }
        return traverseLeverOrderRecursive(nodesAtSameDepth, list);
    }

}
