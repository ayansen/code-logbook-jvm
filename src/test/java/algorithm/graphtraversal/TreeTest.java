package algorithm.graphtraversal;

import algorithm.mathematicaloptimizations.HashProblems;
import algorithm.graphtraversal.trees.BinarySearchTree;
import algorithm.graphtraversal.trees.BinaryTreeNode;
import algorithm.graphtraversal.trees.TreeTraversals;
import algorithm.graphtraversal.trees.problems.TreeProblems;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by aysen on 10/2/16.
 */


public class TreeTest {
    @Test
    public void testInorderTraversal() {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>(10);
        binarySearchTree.add(123);
        binarySearchTree.add(15);
        binarySearchTree.add(3);
        TreeTraversals.traversePreorder(binarySearchTree.getHead()).stream().forEach(System.out::println);
    }

    @Test
    public void testPreorderTraversal() {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>(10);
        binarySearchTree.add(123);
        binarySearchTree.add(15);
        binarySearchTree.add(3);
        TreeTraversals.traversePreorder(binarySearchTree.getHead()).stream().forEach(System.out::println);
    }

    @Test
    public void testSecondLargestElementOfBST() {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>(10);
        binarySearchTree.add(123);
        binarySearchTree.add(15);
        binarySearchTree.add(35);
        binarySearchTree.add(25);
        Assert.assertEquals(35L, TreeProblems.findSecondLargestElementOfBST(binarySearchTree.getHead()).longValue());

    }

    @Test
    public void testLevelOrderTraversalInBST() {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>(10);
        binarySearchTree.add(123);
        binarySearchTree.add(7);
        binarySearchTree.add(35);
        binarySearchTree.add(125);
        binarySearchTree.add(3);
        TreeTraversals.traverseLeverOrder(binarySearchTree.getHead()).stream().forEach(System.out::println);

    }

    @Test
    public void testHeightOfBinaryTree() {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>(10);
        binarySearchTree.add(123);
        binarySearchTree.add(7);
        binarySearchTree.add(35);
        binarySearchTree.add(125);
        binarySearchTree.add(3);
        TreeTraversals.traverseLeverOrder(binarySearchTree.getHead()).stream().forEach(System.out::println);

//        Assert.assertEquals(3L, Bina.height().longValue());
    }


    @Test
    public void testMirrorBinaryTree() {
        BinaryTreeNode<Integer> root = createNode(10);
        root.setLeft(createNode(15));
        root.setRight(createNode(12));
        root.getLeft().setLeft(createNode(25));
        TreeProblems.diameterOfTree(root).stream().forEach(System.out::println);



    }

    @Test
    public void testSizeOfBinaryTree() {
        BinaryTreeNode<Integer> root = createNode(10);
        root.setLeft(createNode(15));
        root.setRight(createNode(12));
        root.getLeft().setLeft(createNode(25));
        root.getLeft().setRight(createNode(9));

        Assert.assertEquals(5L, TreeProblems.findSizeOfBinaryTree(root));

    }


    @Test
    public void testMaxWidthOfBinaryTree() {
        BinaryTreeNode<Integer> root = createNode(10);
        root.setLeft(createNode(15));
        root.setRight(createNode(12));
        root.getLeft().setLeft(createNode(25));
        root.getLeft().setRight(createNode(223));
        root.getRight().setRight(createNode(24));

        Assert.assertEquals(3L, TreeProblems.FindMaxWidthOfBinaryTree(root));

    }

    @Test
    public void testPrintTreeInVerticalOrder() {
        BinaryTreeNode<Integer> root = createNode(10);
        root.setLeft(createNode(15));
        root.setRight(createNode(12));
        root.getLeft().setLeft(createNode(25));
        root.getLeft().getLeft().setRight(createNode(29));
        root.getLeft().setRight(createNode(223));
        root.getRight().setLeft(createNode(24));

        HashProblems.printTreeInVerticalOrder(root).values().stream().forEach(System.out::println);
    }


    private BinaryTreeNode<Integer> createNode(Integer data) {
        return new BinaryTreeNode<>(data);
    }


}
