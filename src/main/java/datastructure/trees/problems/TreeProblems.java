package datastructure.trees.problems;

import datastructure.trees.BinaryTreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by aysen on 10/16/16.
 */
public class TreeProblems {

    public static Integer findSecondLargestElementOfBST(BinaryTreeNode<Integer> node) {
        BinaryTreeNode<Integer> maxNodeInBST = findMaxNodeInBST(node);
        return findInOrderPredecessorOfNode(maxNodeInBST).getData();

    }

    private static BinaryTreeNode<Integer> findInOrderPredecessorOfNode(BinaryTreeNode<Integer> node) {
        if (node.getLeft() != null) {
            return findMaxNodeInBST(node.getLeft());
        } else return (BinaryTreeNode<Integer>) node.getParent();
    }

    private static BinaryTreeNode<Integer> findMaxNodeInBST(BinaryTreeNode<Integer> node) {

        if (node.getRight() != null) {
            return findMaxNodeInBST(node.getRight());
        } else {
            return node;
        }
    }

    public static BinaryTreeNode<Integer> mirrorBinaryTree(BinaryTreeNode<Integer> root) {
        if (root == null || root.isLeaf()) {
            return root;
        }
        mirrorBinaryTree(root.getLeft());
        mirrorBinaryTree(root.getRight());

        BinaryTreeNode<Integer> swapNode = root.getLeft();
        root.setLeft(root.getRight());
        root.setRight(swapNode);
        return root;
    }

    public static List<Integer> diameterOfTree(BinaryTreeNode<Integer> root) {


        List<Integer> diameter = null;
        if (root != null) {
            diameter = new ArrayList();
            diameter.addAll(maxHeightOfTree(root.getLeft()));
            diameter.add(root.getData());
            diameter.addAll(maxHeightOfTree(root.getRight()));
        }
        return diameter;
    }


    private static List<Integer> maxHeightOfTree(BinaryTreeNode<Integer> node) {
        List<Integer> height = new ArrayList();
        if (node != null) {
            List<Integer> maxHeightOfLeftSubtree = maxHeightOfTree(node.getLeft());
            List<Integer> maxHeightOfRightSubtree = maxHeightOfTree(node.getRight());
            if (maxHeightOfLeftSubtree.size() > maxHeightOfRightSubtree.size()) {
                height.addAll(maxHeightOfLeftSubtree);
            } else {
                height.addAll(maxHeightOfRightSubtree);
            }
            height.add(node.getData());
        }
        return height;
    }

    public static long FindMaxWidthOfBinaryTree(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        Queue<BinaryTreeNode<Integer>> children = new ArrayDeque<>();
        children.add(root);

        return findWidthOfTreeAtEachLevel(children);
    }

    private static long findWidthOfTreeAtEachLevel(Queue<BinaryTreeNode<Integer>> children) {
        if (children.isEmpty()) {
            return 0;
        }
        for (int i = 0; i < children.size(); i++) {
            BinaryTreeNode<Integer> node = children.poll();
            if (node.getLeft() != null) {
                children.add(node.getLeft());
            }
            if (node.getRight() != null) {
                children.add(node.getRight());
            }
        }

        return Math.max(children.size(), findWidthOfTreeAtEachLevel(children));
    }

    public static int findSizeOfBinaryTree(BinaryTreeNode<Integer> node) {
        if (node == null) {
            return 0;
        } else return 1 + findSizeOfBinaryTree(node.getLeft()) + findSizeOfBinaryTree(node.getRight());
    }

    /*
     public static int maxWidthOfBinaryTree(BinaryTreeNode<Integer> root){

        int maxWidth = 0;
         findWidthOfTreeAtEachLevel(root,maxWidth);
    }

    private static void findWidthOfTreeAtEachLevel(BinaryTreeNode<Integer> root, int widthAtEachLevel) {

    }

    public static int findSizeOfBinaryTree(BinaryTreeNode<Integer> node) {
        if (node == null) {
            return 0;
        } else return 1 + findSizeOfBinaryTree(node.getLeft()) + findSizeOfBinaryTree(node.getRight());
    }
     */


}
