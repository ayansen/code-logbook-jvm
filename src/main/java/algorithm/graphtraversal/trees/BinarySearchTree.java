package algorithm.graphtraversal.trees;

import java.util.Optional;

/**
 * Created by aysen on 10/1/16.
 */
public class BinarySearchTree<T extends Comparable> {

    private final BinaryTreeNode<T> head;

    public BinarySearchTree(T data) {
        head = new BinaryTreeNode<>(data);
    }

    public void add(T data) {
        addDataRecursive(data, head);
    }

    public boolean remove(T data) {
        return findNodeRecursive(data, head).map(this::deleteNode).orElse(false);
    }


    public Integer height() {
        return heightOfSubTree(head);
    }

    private int heightOfSubTree(BinaryTreeNode<T> root) {
        if (root == null) {
            return 0;
        } else return 1 + Math.max(heightOfSubTree(root.getLeft()), heightOfSubTree(root.getRight()));
    }

    public BinaryTreeNode<T> getHead() {
        return head;
    }

    private void addDataRecursive(T data, BinaryTreeNode<T> node) {
        switch (node.getData().compareTo(data)) {
            case -1:
                if (node.getRight() == null) {
                    node.setRight(new BinaryTreeNode<>(data, node));
                } else {
                    addDataRecursive(data, node.getRight());
                }
                break;
            default:
                if (node.getLeft() == null) {
                    node.setLeft(new BinaryTreeNode<>(data, node));
                } else {
                    addDataRecursive(data, node.getLeft());
                }
                break;
        }
    }


    private boolean deleteNode(BinaryTreeNode<T> treeNode) {
        if (treeNode.getLeft() == null) {
            BinaryTreeNode<T> parent = (BinaryTreeNode<T>) treeNode.getParent();
            if (parent.getLeft().equals(treeNode)) {
            }
        }
        return true;
    }

    private Optional<BinaryTreeNode<T>> findNodeRecursive(T data, BinaryTreeNode<T> node) {
        switch (node.getData().compareTo(data)) {
            case 0:
                return Optional.of(node);
            case -1:
                if (node.getRight() == null) {
                    return Optional.empty();
                } else {
                    return findNodeRecursive(data, node.getRight());
                }
            default:
                if (node.getLeft() == null) {
                    return Optional.empty();
                } else {
                    return findNodeRecursive(data, node.getLeft());
                }
        }
    }

}


